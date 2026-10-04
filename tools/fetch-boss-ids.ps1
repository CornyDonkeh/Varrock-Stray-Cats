# Development-only cross-check against the wiki. No network code ships in the plugin.
$taskRoot = Split-Path $PSScriptRoot -Parent
$taskCatalogue = Get-Content -LiteralPath (Join-Path $PSScriptRoot 'appearance-catalogue.json') -Raw | ConvertFrom-Json
$taskNames = @($taskCatalogue | Where-Object section -Like 'Bosses:*' | Select-Object -ExpandProperty label)
$taskNames += 'Elven traitor', 'Black demon (The Grand Tree)', 'Bouncer (ghost)', 'Tarn Razorlor (monster)'
$taskResults = $taskNames | Sort-Object -Unique | ForEach-Object -ThrottleLimit 6 -Parallel {
    $taskName = $_
    $taskIds = @()
    try {
        $taskUrl = 'https://oldschool.runescape.wiki/w/' + [uri]::EscapeDataString($taskName.Replace(' ', '_')) + '?action=raw'
        $taskRaw = Invoke-RestMethod -Uri $taskUrl -TimeoutSec 15
        if ($taskRaw -match '(?i)^#redirect\s*\[\[([^\]]+)') {
            $taskUrl = 'https://oldschool.runescape.wiki/w/' + [uri]::EscapeDataString($Matches[1].Replace(' ', '_')) + '?action=raw'
            $taskRaw = Invoke-RestMethod -Uri $taskUrl -TimeoutSec 15
        }
        foreach ($taskMatch in [regex]::Matches($taskRaw, '(?m)^\|\s*id\d*\s*=\s*([^\n]+)')) {
            foreach ($taskNumber in [regex]::Matches($taskMatch.Groups[1].Value, '\b\d+\b')) {
                $taskIds += [int]$taskNumber.Value
            }
        }
    } catch { }
    [pscustomobject]@{Name=$taskName; Ids=$taskIds}
}
$taskOutput = @{}
foreach ($taskResult in $taskResults) { $taskOutput[$taskResult.Name] = @($taskResult.Ids) }
$taskOutput | ConvertTo-Json -Depth 4 | Set-Content -LiteralPath (Join-Path $PSScriptRoot 'wiki-boss-ids.json')
Write-Output ('Boss pages with IDs: ' + @($taskResults | Where-Object { $_.Ids.Count -gt 0 }).Count + '/' + $taskResults.Count)
