/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.configuration;

import static kkdev.kksystem.base.classes.controls.PinControlData.DEF_BTN_BACK;
import static kkdev.kksystem.base.classes.controls.PinControlData.DEF_BTN_DOWN;
import static kkdev.kksystem.base.classes.controls.PinControlData.DEF_BTN_ENTER;
import static kkdev.kksystem.base.classes.controls.PinControlData.DEF_BTN_UP;
import kkdev.kksystem.plugin.controls.configuration.ControlsConfig.AdapterType;


/**
 *
 * @author blinov_is
 *

 */
public abstract class kk_DefaultConfig {
    public static ControlsConfig MakeDefaultConfig() {
        
        ControlsConfig DefConf = new ControlsConfig();
        
        DefConf.Adapters=new Adapter[3];
        
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
        DefConf.Adapters[2].ID="External_TaggedInt_Adapter";
        DefConf.Adapters[2].Name="ExtTaggedInt";
        DefConf.Adapters[2].Type=AdapterType.External_TaggedInt;
        //
        // 
        DefConf.Controls=new Control[20];
        // RPI controls, for debug
        DefConf.Controls[0] = new Control();
        DefConf.Controls[1] = new Control();
        DefConf.Controls[2] = new Control();
        DefConf.Controls[3] = new Control();
        
        // Custom chrysler head REMOVE THIS IN PRODUCTION
        for (int i=4;i<4+24;i++)
        {
            DefConf.Controls[i] = new Control();
        }
        //RPI
        DefConf.Controls[0].ID=DEF_BTN_UP;
        DefConf.Controls[1].ID=DEF_BTN_DOWN;
        DefConf.Controls[2].ID=DEF_BTN_ENTER;
        DefConf.Controls[3].ID=DEF_BTN_BACK;
        
        // Custom chrysler head REMOVE THIS IN PRODUCTION
        DefConf.Controls[4].ID="CUSTOM_CHR_SEEKUP";
        DefConf.Controls[5].ID="CUSTOM_CHR_SEEKDOWN";
        DefConf.Controls[6].ID="CUSTOM_CHR_AMFM";
        DefConf.Controls[7].ID="CUSTOM_CHR_SET";
        DefConf.Controls[8].ID="CUSTOM_CHR_CLOCK_H";
        DefConf.Controls[9].ID="CUSTOM_CHR_CLOCK_M";
        DefConf.Controls[10].ID="CUSTOM_CHR_TUNE_FF";
        DefConf.Controls[11].ID="CUSTOM_CHR_TUNE_RW";
        DefConf.Controls[12].ID="CUSTOM_CHR_TRK_1";
        DefConf.Controls[13].ID="CUSTOM_CHR_TRK_2";
        DefConf.Controls[14].ID="CUSTOM_CHR_TRK_3";
        DefConf.Controls[15].ID="CUSTOM_CHR_TRK_4";
        DefConf.Controls[16].ID="CUSTOM_CHR_TRK_5";
        DefConf.Controls[17].ID="CUSTOM_CHR_CLOCK_TIME";
        DefConf.Controls[18].ID="CUSTOM_CHR_MODE";
        DefConf.Controls[19].ID="CUSTOM_CHR_EJECT";
        DefConf.Controls[20].ID="CUSTOM_CHR_POWER";
        DefConf.Controls[21].ID="CUSTOM_CHR_VOLUME";
        DefConf.Controls[22].ID="CUSTOM_CHR_BAL_L";
        DefConf.Controls[23].ID="CUSTOM_CHR_BAL_R";
        DefConf.Controls[24].ID="CUSTOM_CHR_FADER_L";
        DefConf.Controls[25].ID="CUSTOM_CHR_FADER_R";
        DefConf.Controls[26].ID="CUSTOM_CHR_BASS";
        DefConf.Controls[27].ID="CUSTOM_CHR_TREBLE";

        
        DefConf.Controls[0].Name="SelectUP";
        DefConf.Controls[1].Name="SelectDown";
        DefConf.Controls[2].Name="Enter";
        DefConf.Controls[3].Name="Back";
        
        DefConf.Controls[4].Name="CUSTOM_CHR_SEEKUP";
        DefConf.Controls[5].Name="CUSTOM_CHR_SEEKDOWN";
        DefConf.Controls[6].Name="CUSTOM_CHR_AMFM";
        DefConf.Controls[7].Name="CUSTOM_CHR_SET";
        DefConf.Controls[8].Name="CUSTOM_CHR_CLOCK_H";
        DefConf.Controls[9].Name="CUSTOM_CHR_CLOCK_M";
        DefConf.Controls[10].Name="CUSTOM_CHR_TUNE_FF";
        DefConf.Controls[11].Name="CUSTOM_CHR_TUNE_RW";
        DefConf.Controls[12].Name="CUSTOM_CHR_TRK_1";
        DefConf.Controls[13].Name="CUSTOM_CHR_TRK_2";
        DefConf.Controls[14].Name="CUSTOM_CHR_TRK_3";
        DefConf.Controls[15].Name="CUSTOM_CHR_TRK_4";
        DefConf.Controls[16].Name="CUSTOM_CHR_TRK_5";
        DefConf.Controls[17].Name="CUSTOM_CHR_CLOCK_TIME";
        DefConf.Controls[18].Name="CUSTOM_CHR_MODE";
        DefConf.Controls[19].Name="CUSTOM_CHR_EJECT";
        DefConf.Controls[20].Name="CUSTOM_CHR_POWER";
        DefConf.Controls[21].Name="CUSTOM_CHR_VOLUME";
        DefConf.Controls[22].Name="CUSTOM_CHR_BAL_L";
        DefConf.Controls[23].Name="CUSTOM_CHR_BAL_R";
        DefConf.Controls[24].Name="CUSTOM_CHR_FADER_L";
        DefConf.Controls[25].Name="CUSTOM_CHR_FADER_R";
        DefConf.Controls[26].Name="CUSTOM_CHR_BASS";
        DefConf.Controls[27].Name="CUSTOM_CHR_TREBLE";
        
        DefConf.Controls[0].AdapterID="DBG_Adapter";
        DefConf.Controls[1].AdapterID="DBG_Adapter";
        DefConf.Controls[2].AdapterID="DBG_Adapter";
        DefConf.Controls[3].AdapterID="DBG_Adapter";
        
        for (int i=4;i<4+24;i++)
        {
             DefConf.Controls[i].AdapterID="ExtTaggedInt";;
        }
        
        DefConf.Controls[0].AdapterSource="3"; //change to your rpi pin numbers
        DefConf.Controls[1].AdapterSource="12";
        DefConf.Controls[2].AdapterSource="13";
        DefConf.Controls[3].AdapterSource="14";
        
        DefConf.Controls[4].AdapterSource="CUSTOM_CHR_SEEKUP";
        DefConf.Controls[5].AdapterSource="CUSTOM_CHR_SEEKDOWN";
        DefConf.Controls[6].AdapterSource="CUSTOM_CHR_AMFM";
        DefConf.Controls[7].AdapterSource="CUSTOM_CHR_SET";
        DefConf.Controls[8].AdapterSource="CUSTOM_CHR_CLOCK_H";
        DefConf.Controls[9].AdapterSource="CUSTOM_CHR_CLOCK_M";
        DefConf.Controls[10].AdapterSource="CUSTOM_CHR_TUNE_FF";
        DefConf.Controls[11].AdapterSource="CUSTOM_CHR_TUNE_RW";
        DefConf.Controls[12].AdapterSource="1";
        DefConf.Controls[13].AdapterSource="2";
        DefConf.Controls[14].AdapterSource="3";
        DefConf.Controls[15].AdapterSource="4";
        DefConf.Controls[16].AdapterSource="5";
        DefConf.Controls[17].AdapterSource="CUSTOM_CHR_CLOCK_TIME";
        DefConf.Controls[18].AdapterSource="CUSTOM_CHR_MODE";
        DefConf.Controls[19].AdapterSource="CUSTOM_CHR_EJECT";
        DefConf.Controls[20].AdapterSource="CUSTOM_CHR_POWER";
        DefConf.Controls[21].AdapterSource="CUSTOM_CHR_VOLUME";
        DefConf.Controls[22].AdapterSource="CUSTOM_CHR_BAL_L";
        DefConf.Controls[23].AdapterSource="CUSTOM_CHR_BAL_R";
        DefConf.Controls[24].AdapterSource="CUSTOM_CHR_FADER_L";
        DefConf.Controls[25].AdapterSource="CUSTOM_CHR_FADER_R";
        DefConf.Controls[26].AdapterSource="CUSTOM_CHR_BASS";
        DefConf.Controls[27].AdapterSource="CUSTOM_CHR_TREBLE";
        
        
        
        DefConf.Controls[0].Global=false;
        DefConf.Controls[1].Global=false;
        DefConf.Controls[2].Global=false;
        DefConf.Controls[3].Global=true;
        
        return DefConf;
    }
}
    
