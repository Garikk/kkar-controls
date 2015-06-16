/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.adapters.rpi;

import java.util.HashMap;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapter;
import kkdev.kksystem.plugin.controls.adapters.IHWAdapterCallback;
import kkdev.kksystem.plugin.controls.configuration.Control;

/**
 *
 * @author blinov_is
 */
public class RPIControlAdapter implements IHWAdapter {

    HashMap<String,ACtrl> Controls;

    @Override
    public void SetActive() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SetInactive() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    class ACtrl
    {
        IHWAdapterCallback Callback;
        Control Ctrl;
    }
    
    
    public RPIControlAdapter()
            {
                Controls=new HashMap<>();
            }
    
    
    @Override
    public void RegisterControl(String DevicePath, String Source, Control Ctrl, IHWAdapterCallback Callback) {
        
        ACtrl Add=new ACtrl();
        Add.Callback=Callback;
        Add.Ctrl=Ctrl;
        
        Controls.put(Ctrl.ID, Add);
        RegisterEvent(DevicePath,Source);
    }
    
    
    private void RegisterEvent(String DevPath, String Source)
    {
    }
    private void FireEvent(String FiredControl)
    {
        ACtrl A=Controls.get(FiredControl);
        A.Callback.Control_ChangeState(FiredControl,A.Ctrl.Global, 1);
    
    }
}
