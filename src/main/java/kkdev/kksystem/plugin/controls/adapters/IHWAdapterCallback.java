/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.adapters;

/**
 *
 * @author blinov_is
 */
public interface IHWAdapterCallback {
    public void Control_Triggered(String ControlID);
    public void Control_SwitchOn(String ControlID);
    public void Control_SwitchOff(String ControlID);
    public void Control_ChangeState(String ControlID,int State);
}
