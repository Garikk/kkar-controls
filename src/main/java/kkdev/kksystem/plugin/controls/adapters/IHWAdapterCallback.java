/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkdev.kksystem.plugin.controls.adapters;

import kkdev.kksystem.plugin.controls.configuration.Control;

/**
 *
 * @author blinov_is
 */
public interface IHWAdapterCallback {
    public void Control_Triggered(Control Ctrl);
    public void Control_SwitchOn(Control Ctrl);
    public void Control_SwitchOff(Control Ctrl);
    public void Control_ChangeState(Control Ctrl, int State);
    public void Control_LongPress(Control Ctrl, int State);
}
