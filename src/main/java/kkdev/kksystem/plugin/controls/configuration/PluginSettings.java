/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.configuration;

import kkdev.kksystem.base.classes.plugins.simple.SettingsManager;

/**
 *
 * @author blinov_is
 */
public abstract class PluginSettings {

   public static final String HID_CONF = "kk_plugin_controls.json";
   private static SettingsManager Settings;

    public static ControlsConfig MainConfiguration;

    public static void InitConfig() {
        Settings=new SettingsManager(HID_CONF,ControlsConfig.class);
        
        
        System.out.println("[HID][CONFIG] Load configuration");
        MainConfiguration=(ControlsConfig)Settings.LoadConfig();

        if (MainConfiguration == null) {
            System.out.println("[HID][CONFIG] Error Load configuration, try create default config");
            Settings.SaveConfig(kk_DefaultConfig.MakeDefaultConfig());
            MainConfiguration=(ControlsConfig)Settings.LoadConfig();
        }
        if (MainConfiguration == null) {
            System.out.println("[HID][CONFIG] Load configuration, fatal");
            return;
        }
        //
    }
}
