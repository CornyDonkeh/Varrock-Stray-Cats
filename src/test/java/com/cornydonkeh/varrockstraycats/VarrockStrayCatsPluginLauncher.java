package com.cornydonkeh.varrockstraycats;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class VarrockStrayCatsPluginLauncher
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(VarrockStrayCatsPlugin.class);
		RuneLite.main(args);
	}
}
