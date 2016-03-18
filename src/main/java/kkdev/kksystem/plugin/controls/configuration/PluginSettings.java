/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.configuration;

import kkdev.kksystem.base.classes.plugins.simple.SettingsManager;
import kkdev.kksystem.plugin.controls.ControlsPluginInfo;

/**
 *
 * @author blinov_is
 */
public abstract class PluginSettings {

   public static String HID_CONF;
   private static SettingsManager Settings;

    public static ControlsConfig MainConfiguration;

    public static void InitConfig(String GlobalConfigUID, String MyUID) {
        //
        HID_CONF=GlobalConfigUID+"_"+MyUID + ".json";
        //
        
        Settings=new SettingsManager(HID_CONF,ControlsConfig.class);
        
        
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
