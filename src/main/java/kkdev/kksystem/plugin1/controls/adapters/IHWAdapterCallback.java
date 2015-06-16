/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin1.controls.adapters;

/**
 *
 * @author blinov_is
 */
public interface IHWAdapterCallback {
    public void Control_Triggered(String ControlID,boolean Global);
    public void Control_SwitchOn(String ControlID,boolean Global);
    public void Control_SwitchOff(String ControlID,boolean Global);
    public void Control_ChangeState(String ControlID,boolean Global, int State);
    public void Control_LongPress(String ControlID,boolean Global, int State);
}
