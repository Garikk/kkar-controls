/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin1.controls.adapters.debug;

import java.util.Timer;
import java.util.TimerTask;
import kkdev.kksystem.plugin1.controls.adapters.IHWAdapter;
import kkdev.kksystem.plugin1.controls.adapters.IHWAdapterCallback;
import kkdev.kksystem.plugin1.controls.configuration.Control;

/**
 *
 * @author blinov_is
 */
public class DebugAdapter implements IHWAdapter {

    IHWAdapterCallback CB;
    Control CTL;
    boolean Active=false;
    
    @Override
    public void RegisterControl(String DevicePath, String Source, Control Ctrl, IHWAdapterCallback Callback) {
        CB=Callback;
        CTL=Ctrl;
        
        Timer tmr=new Timer();
        tmr.schedule(new TimerTask(){

            @Override
            public void run() {
                if (Active)
                    CB.Control_Triggered(CTL.ID, true);
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
