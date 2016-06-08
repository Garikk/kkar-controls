/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.adapters.smarthead;

import java.util.HashMap;
import java.util.Map;
import kkdev.kksystem.base.classes.base.PinBaseDataTaggedObj;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapter;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapterCallback;
import kkdev.kksystem.plugin.controls.configuration.Adapter;
import kkdev.kksystem.plugin.controls.configuration.Control;

/**
 *
 * @author blinov_is
 */
public class Smarthead implements IHWAdapter {

    final String SmartheadControlPFX = "$K_CTRL_";
    final String SmartheadControlEvt_PRESS = "$KPR_";
    final String SmartheadControlEvt_HOLD = "$KHL_";
    final String SmartheadControlEvt_RELEASE = "$KRL_";
    IHWAdapterCallback CB;
    Map<String, Control> Controls;
    boolean Active = false;
        Adapter Configuration;

    public Smarthead(Adapter MyConf) {
        Controls = new HashMap<>();
        Configuration=MyConf;
    }

    @Override
    public void RegisterControl(Control Ctrl, IHWAdapterCallback Callback) {

        CB = Callback;
        Controls.put(Ctrl.AdapterSource, Ctrl);
       
    }

    @Override
    public void SetActive() {
        Active = true;

    }

    @Override
    public void SetInactive() {
        Active = false;
    }

    @Override
    public void ReceiveObjPin(PinBaseDataTaggedObj ObjDat) {
        
        if (!ObjDat.tag.equals(Configuration.UNILPort)) {
            return;
        }
        CheckControl((String) ObjDat.value);

    }

    public void CheckControl(String SmartheadString) {
        if (!SmartheadString.startsWith(SmartheadControlPFX)) {
            return;
        }

        SmartheadString = SmartheadString.substring(SmartheadControlPFX.length());
        //

        if (SmartheadString.startsWith(SmartheadControlEvt_PRESS)) {
            SmartheadString = SmartheadString.substring(SmartheadControlEvt_PRESS.length());
            if (Controls.containsKey(SmartheadString)) {
                CB.Control_Triggered(Controls.get(SmartheadString));
            }
        }
        else if (SmartheadString.startsWith(SmartheadControlEvt_HOLD)) {
            SmartheadString = SmartheadString.substring(SmartheadControlEvt_HOLD.length());
            if (Controls.containsKey(SmartheadString)) {
                CB.Control_LongPress(Controls.get(SmartheadString),1);
            }
        }
    }

}
