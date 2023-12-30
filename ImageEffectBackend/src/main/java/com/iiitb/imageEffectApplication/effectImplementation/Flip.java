package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.FlipInterface;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class Flip implements DiscreteEffect{
    private int h,v;
    private String s="";

    public void selectOptionValue(String opt, int val) throws IllegalParameterException{
        if(val<0 || val>1) throw new IllegalParameterException("Not allowed");
        if(opt.equals("H"))this.h=val;
        else this.v=val;
    }

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        if(this.h!=0 && this.v!=0) s="Horizontal and Vertical";
        else if(this.h!=0) s="Horizontal";
        else if(this.v!=0) s="Vertical";

        loggingService.addLog(fileName, "Flip", s);
        return FlipInterface.applyFlip(image, h, v);
    }
}