/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.configuration;

import java.util.HashSet;
import static kkdev.kksystem.base.classes.controls.PinDataControl.*;
import kkdev.kksystem.plugin.controls.configuration.ControlsConfig.AdapterType;


/**
 *
 * @author blinov_is
 *

 */
public abstract class kk_DefaultConfig {
    public static ControlsConfig MakeDefaultConfig() {
        
        ControlsConfig DefConf = new ControlsConfig();
        
        DefConf.Adapters=new Adapter[4];
        
        DefConf.Adapters[0] = new Adapter();
        DefConf.Adapters[0].ID="KK_RPI_Adapter";
        DefConf.Adapters[0].Name="Raspberry";
        DefConf.Adapters[0].Type=AdapterType.RaspberryPI_B;
        
        DefConf.Adapters[1] = new Adapter();
        DefConf.Adapters[1].ID="DBG_Adapter";
        DefConf.Adapters[1].Name="Debug";
        DefConf.Adapters[1].Type=AdapterType.Debug;
        //
        DefConf.Adapters[2] = new Adapter();
        DefConf.Adapters[2].ID="RPI_I2C";
        DefConf.Adapters[2].Name="I2C_Buttons";
        DefConf.Adapters[2].Type=AdapterType.RaspberryPI_B_PI4J_I2C;
        DefConf.Adapters[2].BusID=1;
        DefConf.Adapters[2].DeviceID=0x2b;
        //
         //
        DefConf.Adapters[3] = new Adapter();
        DefConf.Adapters[3].ID="UNI_COM";
        DefConf.Adapters[3].Name="COM_Buttons";
        DefConf.Adapters[3].Type=AdapterType.UniversalLinux_RS232;
        DefConf.Adapters[3].BusID=1;
        DefConf.Adapters[3].DeviceID=0x2b;
        //
               //
        DefConf.Adapters[3] = new Adapter();
        DefConf.Adapters[3].ID="SMARTHEAD";
        DefConf.Adapters[3].Name="SMARTHEAD_Buttons";
        DefConf.Adapters[3].Type=AdapterType.KKSmarthead;
        DefConf.Adapters[3].UNILPort="SMARTHEAD";
        //
        // 
        DefConf.Controls=new Control[26];
        // RPI controls, for debug
        DefConf.Controls[0] = new Control();
        DefConf.Controls[1] = new Control();
        DefConf.Controls[2] = new Control();
        DefConf.Controls[3] = new Control();
        
        // Custom chrysler head REMOVE THIS IN PRODUCTION
        for (int i=4;i<DefConf.Controls.length;i++)
        {
            DefConf.Controls[i] = new Control();
        }
        for (int i=0;i<DefConf.Controls.length;i++)
        {
            DefConf.Controls[i].buttonID = new HashSet<>();
        }
        //RPI, debug pri gpio buttons
        DefConf.Controls[0].Name = "SelectUP";
        DefConf.Controls[0].buttonID.add(DEF_BTN_UP);
        DefConf.Controls[0].AdapterSource = "3"; //change to your rpi pin numbers
        //
        DefConf.Controls[1].Name = "SelectDown";
        DefConf.Controls[1].buttonID.add(DEF_BTN_DOWN);
        DefConf.Controls[1].AdapterSource = "12";
        //
        DefConf.Controls[2].Name = "Enter";
        DefConf.Controls[2].buttonID.add(DEF_BTN_ENTER);
        DefConf.Controls[2].AdapterSource = "13";
        //
        DefConf.Controls[3].Name = "Back";
        DefConf.Controls[3].buttonID.add(DEF_BTN_BACK);
        DefConf.Controls[3].AdapterSource="14";
        
        
        // Custom chrysler head REMOVE THIS IN PRODUCTION
        DefConf.Controls[4].Name="CUSTOM_CHRY_TRACK_1";
        DefConf.Controls[4].buttonID.add("CUSTOM_CHRY_TRACK_1");
        DefConf.Controls[4].AdapterSource="1";

        DefConf.Controls[5].Name="CUSTOM_CHRY_TRACK_2";
        DefConf.Controls[5].buttonID.add("CUSTOM_CHRY_TRACK_2");
        DefConf.Controls[5].AdapterSource="2"; 
        
        DefConf.Controls[6].Name="CUSTOM_CHRY_TRACK_3";
        DefConf.Controls[6].buttonID.add("CUSTOM_CHRY_TRACK_3");
        DefConf.Controls[6].AdapterSource="3"; 
       
        DefConf.Controls[7].Name="CUSTOM_CHRY_TRACK_4";
        DefConf.Controls[7].buttonID.add("CUSTOM_CHRY_TRACK_4");
        DefConf.Controls[7].AdapterSource="4"; 
        
        DefConf.Controls[8].Name="CUSTOM_CHRY_TRACK_5";
        DefConf.Controls[8].buttonID.add("CUSTOM_CHRY_TRACK_5");
        DefConf.Controls[8].AdapterSource="5"; 
        
        DefConf.Controls[9].Name="CUSTOM_CHRY_SEEK_UP";
        DefConf.Controls[9].buttonID.add("CUSTOM_CHRY_SEEK_UP");
        DefConf.Controls[9].buttonID.add(DEF_BTN_UP);
        DefConf.Controls[9].buttonID.add(DEF_BTN_SEEK_FF);
        DefConf.Controls[9].AdapterSource="U"; 
        
   
        DefConf.Controls[10].Name="CUSTOM_CHRY_SEEK_DOWN";
        DefConf.Controls[10].buttonID.add("CUSTOM_CHRY_SEEK_DOWN");
        DefConf.Controls[10].buttonID.add(DEF_BTN_DOWN);
        DefConf.Controls[10].buttonID.add(DEF_BTN_SEEK_RW);
        DefConf.Controls[10].AdapterSource="D"; 
        
        
        DefConf.Controls[11].Name="CUSTOM_CHRY_AMFM_AMFM";
        DefConf.Controls[11].buttonID.add("CUSTOM_CHRY_AMFM_AMFM");
        DefConf.Controls[11].buttonID.add(DEF_BTN_BACK);
        DefConf.Controls[11].AdapterSource="A"; 
        
        DefConf.Controls[12].Name="CUSTOM_CHRY_AMFM_SET";
        DefConf.Controls[12].buttonID.add("CUSTOM_CHRY_AMFM_SET");
        DefConf.Controls[12].buttonID.add(DEF_BTN_ENTER);
        DefConf.Controls[12].AdapterSource = "S";

        DefConf.Controls[13].Name = "CUSTOM_CHRY_CLOCK_H";
        DefConf.Controls[13].buttonID.add("CUSTOM_CHRY_CLOCK_H");
        DefConf.Controls[13].AdapterSource = "H";
        
        DefConf.Controls[14].Name = "CUSTOM_CHRY_CLOCK_M";
        DefConf.Controls[14].buttonID.add("CUSTOM_CHRY_CLOCK_M");
        DefConf.Controls[14].AdapterSource = "M";

        DefConf.Controls[15].Name = "CUSTOM_CHRY_TUNE_FF";
        DefConf.Controls[15].buttonID.add("CUSTOM_CHRY_TUNE_FF");
        DefConf.Controls[15].buttonID.add(DEF_BTN_NEXT_TRACK);
        DefConf.Controls[15].AdapterSource = "F";
        
        DefConf.Controls[16].Name = "CUSTOM_CHRY_TUNE_RW";
        DefConf.Controls[16].buttonID.add("CUSTOM_CHRY_TUNE_RW");
        DefConf.Controls[16].buttonID.add(DEF_BTN_PREV_TRACK);
        DefConf.Controls[16].AdapterSource = "R";

        DefConf.Controls[17].Name = "CUSTOM_CHRY_MODE";
        DefConf.Controls[17].buttonID.add("CUSTOM_CHRY_MODE");
        DefConf.Controls[17].AdapterSource = "O";

        DefConf.Controls[18].Name = "CUSTOM_CHRY_VOL_UP";
        DefConf.Controls[18].buttonID.add("CUSTOM_CHRY_VOL_UP");
        DefConf.Controls[18].buttonID.add(DEF_BTN_VOL_INC);
        DefConf.Controls[18].AdapterSource = "VU";
        
        DefConf.Controls[19].Name = "CUSTOM_CHRY_VOL_DOWN";
        DefConf.Controls[19].buttonID.add("CUSTOM_CHRY_VOL_DOWN");
        DefConf.Controls[19].buttonID.add(DEF_BTN_VOL_DEC);
        DefConf.Controls[19].AdapterSource = "VD";
        
        DefConf.Controls[20].Name = "CUSTOM_CHRY_BAL_L";
        DefConf.Controls[20].buttonID.add("CUSTOM_CHRY_BAL_L");
        DefConf.Controls[20].AdapterSource = "BL";
        
        DefConf.Controls[21].Name = "CUSTOM_CHRY_BAL_R";
        DefConf.Controls[21].buttonID.add("CUSTOM_CHRY_BAL_R");
        DefConf.Controls[21].AdapterSource = "BR";
                
        DefConf.Controls[22].Name = "CUSTOM_CHRY_FADE_R";
        DefConf.Controls[22].buttonID.add("CUSTOM_CHRY_FADE_R");
        DefConf.Controls[22].AdapterSource = "FR";
        
        DefConf.Controls[23].Name = "CUSTOM_CHRY_FADE_L";
        DefConf.Controls[23].buttonID.add("CUSTOM_CHRY_FADE_L");
        DefConf.Controls[23].AdapterSource = "FL";

        DefConf.Controls[24].Name = "CUSTOM_CHRY_BASS";
        DefConf.Controls[24].buttonID.add("CUSTOM_CHRY_BASS");
        DefConf.Controls[24].AdapterSource = "BS";
                
        DefConf.Controls[25].Name = "CUSTOM_CHRY_TREB";
        DefConf.Controls[25].buttonID.add("CUSTOM_CHRY_TREB");
        DefConf.Controls[25].AdapterSource = "TR";
        

        DefConf.Controls[0].AdapterID="DBG_Adapter";
        DefConf.Controls[1].AdapterID="DBG_Adapter";
        DefConf.Controls[2].AdapterID="DBG_Adapter";
        DefConf.Controls[3].AdapterID="DBG_Adapter";
        
        for (int i=4;i<DefConf.Controls.length;i++)
        {
             DefConf.Controls[i].AdapterID="SMARTHEAD";
        }
        

        
        DefConf.Controls[0].Global=false;
        DefConf.Controls[1].Global=false;
        DefConf.Controls[2].Global=false;
        DefConf.Controls[3].Global=true; //back button is global
      
        for (int i=4;i<DefConf.Controls.length;i++)
        {
            DefConf.Controls[i].Global=false;
        }
         DefConf.Controls[11].Global=true;
          DefConf.Controls[12].Global=true; //back button is global
        return DefConf;
    }
}
    
