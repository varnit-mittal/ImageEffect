package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import libraryInterfaces.Pixel;
import libraryInterfaces.RotationInterface;

public class Rotation implements SingleValueDiscreteEffect{
    private int val;
    public void setParameterValue(int v)throws IllegalParameterException{
        if(v<0 || v>3) throw new IllegalParameterException("Not allowed");
        this.val=v;
    }

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        String s= (val) * 90 +"°";
        loggingService.addLog(fileName, "Rotation", s);
        return RotationInterface.applyRotation(image, val);
    }
}