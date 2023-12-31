package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.SharpenInterface;

public class Sharpen implements SingleValueParameterizableEffect{
    private float amount;
    public float getAmount(){
        return this.amount;
    }
    public void setParameterValue(float amount) throws IllegalParameterException{
        if (amount < 0 || amount > 100) throw new IllegalParameterException("Illegal parameters. Parameters must be in the range 0 to 100");
        this.amount = amount;
    }
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Sharpen", Float.toString(amount));
        return SharpenInterface.applySharpen(image, amount);
    }
}