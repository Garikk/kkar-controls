/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.configuration;

/**
 *
 * @author blinov_is
 */
public class HIDConfig {
    public enum ControlType {
        Button,
        ButtonWithStates,
        Selector
    }
     public enum AdapterType {
        RaspberryPI_B
    }
     public class Control
     {
         String Name;
         String ID;
         String AdapterID;
         String AdapterSource;
     
     }
     public class Adapter
     {
         String Name;
         String ID;
         AdapterType Type;
     }
     
     public Adapter[] Adapters;
     public Control[] Controls;
    
}
