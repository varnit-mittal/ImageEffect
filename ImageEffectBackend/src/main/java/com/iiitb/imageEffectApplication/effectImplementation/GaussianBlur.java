package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.GaussianBlurInterface;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class GaussianBlur implements SingleValueParameterizableEffect{
    private float amount;
    public float getAmount(){
        return this.amount;
    }
    public void setParameterValue(float amount) throws IllegalParameterException{
        if (amount < 0 || amount > 50) throw new IllegalParameterException("Illegal parameters. Parameters must be in the range 0 to 100");
        this.amount = amount;
    }
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Gaussian Blur", Float.toString(amount));
        return GaussianBlurInterface.applyGaussianBlur(image, amount);
    }
}