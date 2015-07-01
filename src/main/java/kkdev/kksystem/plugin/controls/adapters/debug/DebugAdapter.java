/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.adapters.debug;

import java.util.Timer;
import java.util.TimerTask;
import static kkdev.kksystem.base.classes.controls.PinControlData.DEF_BTN_ENTER;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapter;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapterCallback;
import kkdev.kksystem.plugin.controls.configuration.Control;

/**
 *
 * @author blinov_is
 */
public class DebugAdapter implements IHWAdapter {

    IHWAdapterCallback CB;
    Control CTL;
    boolean Active=false;
    
    @Override
    public void RegisterControl(Control Ctrl, IHWAdapterCallback Callback) {
        if (!Ctrl.ID.equals(DEF_BTN_ENTER))
            return;
        
        CB=Callback;
        CTL=Ctrl;
            
        Timer tmr=new Timer();
        tmr.schedule(new TimerTask(){
            @Override
            public void run() {
                if (Active)
                    CB.Control_Triggered(CTL);
            }
        },1,3000);
    }

    @Override
    public void SetActive() {
        Active=true;
    }

    @Override
    public void SetInactive() {
        Active=false;
    }
    
    

}
