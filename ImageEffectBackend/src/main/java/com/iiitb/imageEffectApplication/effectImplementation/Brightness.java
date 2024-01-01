// Package declaration for the Brightness effect implementation.
package com.iiitb.imageEffectApplication.effectImplementation;

// Import statements for required libraries and classes.
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import libraryInterfaces.BrightnessInterface;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;

// Class definition for the Brightness effect implementing SingleValueParameterizableEffect.
public class Brightness implements SingleValueParameterizableEffect{
    // Private field to store the amount of brightness adjustment.
    private float amount;
    // Getter method to retrieve the current brightness adjustment amount.
    public float getAmount(){
        return this.amount;
    }
    // Setter method to set the brightness adjustment amount with validation.
    // Throws IllegalParameterException if the amount is outside the valid range [0, 200].
    public void setParameterValue(float amount) throws IllegalParameterException{
        if (amount < 0 || amount > 200) throw new IllegalParameterException("Illegal parameters. Parameters must be in the range 0 to 100");
        this.amount = amount;
    }
    // Implementation of the apply method from the SingleValueParameterizableEffect interface.
    // Applies the brightness adjustment to the given image, logs the action, and returns the modified image.
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        // Log the brightness adjustment action.
        loggingService.addLog(fileName,"Brightness",String.valueOf(amount));
        // Call the static applyBrightness method from the BrightnessInterface to apply the effect.
        return BrightnessInterface.applyBrightness(image, amount);
    }
}
