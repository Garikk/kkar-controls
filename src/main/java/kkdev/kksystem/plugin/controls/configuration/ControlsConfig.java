/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.configuration;

import kkdev.kksystem.base.classes.plugins.PluginConfiguration;

/**
 *
 * @author blinov_is
 */
public class ControlsConfig extends PluginConfiguration {
    public enum ControlType {
        Button,
        ButtonWithStates,
        Selector
    }
     public enum AdapterType {
        External_TaggedInt,
        RaspberryPI_B,
        RaspberryPI_B_PI4J_I2C,
        UniversalLinux_RS232,
        KKSmarthead,
        Debug
    }
     
     public Adapter[] Adapters;
     public Control[] Controls;
     
    
}
