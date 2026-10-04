package com.cornydonkeh.varrockstraycats;

import net.runelite.client.config.ConfigManager;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ConfigMigrationTest
{
    @Test
    public void migratesFavoritesWithoutOverwritingNewSettings()
    {
        ConfigManager manager = mock(ConfigManager.class);
        when(manager.getConfiguration("healthydogs", "appearanceGrowncatHell")).thenReturn("true");
        when(manager.getConfiguration("varrockstraycats", "randomBreeds")).thenReturn("false");

        VarrockStrayCatsPlugin.migrateConfig(manager);

        verify(manager).setConfiguration("varrockstraycats", "appearanceGrowncatHell", "true");
        verify(manager, never()).getConfiguration("healthydogs", "randomBreeds");
        verify(manager, never()).setConfiguration(eq("varrockstraycats"), eq("randomBreeds"), any());
    }
}
