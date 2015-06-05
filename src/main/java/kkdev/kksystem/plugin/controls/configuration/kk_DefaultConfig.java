/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.configuration;

import kkdev.kksystem.plugin.controls.configuration.ControlsConfig.AdapterType;


/**
 *
 * @author blinov_is
 *

 */
public abstract class kk_DefaultConfig {
    public static ControlsConfig MakeDefaultConfig() {
        
        ControlsConfig DefConf = new ControlsConfig();
        
        DefConf.Adapters=new Adapter[1];
        
        DefConf.Adapters[0] = new Adapter();
        DefConf.Adapters[0].ID="RPI_Adapter";
        DefConf.Adapters[0].Name="Raspberry";
        DefConf.Adapters[0].Type=AdapterType.RaspberryPI_B;
        //
        DefConf.Controls=new Control[4];
        DefConf.Controls[0] = new Control();
        DefConf.Controls[1] = new Control();
        DefConf.Controls[2] = new Control();
        DefConf.Controls[3] = new Control();
        
        DefConf.Controls[0].ID="BTN_1";
        DefConf.Controls[1].ID="BTN_2";
        DefConf.Controls[2].ID="BTN_3";
        DefConf.Controls[3].ID="BTN_4";
        
        DefConf.Controls[0].Name="SelectUP";
        DefConf.Controls[1].Name="SelectDown";
        DefConf.Controls[2].Name="Enter";
        DefConf.Controls[3].Name="Back";
        
        DefConf.Controls[0].AdapterID="KK_RPI_Adapter";
        DefConf.Controls[1].AdapterID="KK_RPI_Adapter";
        DefConf.Controls[2].AdapterID="KK_RPI_Adapter";
        DefConf.Controls[3].AdapterID="KK_RPI_Adapter";
        
        DefConf.Controls[0].AdapterSource="1"; //Change this to real rpi pin numbers
        DefConf.Controls[1].AdapterSource="2";
        DefConf.Controls[2].AdapterSource="3";
        DefConf.Controls[3].AdapterSource="4";
        
        DefConf.Controls[0].Global=false;
        DefConf.Controls[1].Global=false;
        DefConf.Controls[2].Global=false;
        DefConf.Controls[3].Global=true;
        
        return DefConf;
    }
}
    
