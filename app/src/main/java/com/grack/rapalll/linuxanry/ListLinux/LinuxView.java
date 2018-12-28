package com.grack.rapalll.linuxanry.ListLinux;

import com.grack.rapalll.linuxanry.model.ModelLinux;

import java.util.List;

public interface LinuxView {
    void showLoading();
    void hideLoading();
    void showListLinux(List<ModelLinux> listLinux);
}
