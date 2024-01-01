// Package declaration for the Contrast effect implementation.
package com.iiitb.imageEffectApplication.effectImplementation;

// Import statements for required libraries and classes.
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import libraryInterfaces.ContrastInterface;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;

// Class definition for the Contrast effect implementing SingleValueParameterizableEffect.
public class Contrast implements SingleValueParameterizableEffect {

    // Private field to store the amount of contrast adjustment.
    private float amount;

    // Getter method to retrieve the current contrast adjustment amount.
    public float getAmount() {
        return this.amount;
    }

    // Setter method to set the contrast adjustment amount with validation.
    // Throws IllegalParameterException if the amount is outside the valid range [0, 200].
    public void setParameterValue(float amt) throws IllegalParameterException {
        if (amt < 0 || amt > 200) {
            throw new IllegalParameterException("Illegal parameters. Parameters must be in the range 0 to 200");
        }
        this.amount = amt;
    }

    // Implementation of the apply method from the SingleValueParameterizableEffect interface.
    // Applies the contrast adjustment to the given image, logs the action, and returns the modified image.
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the contrast adjustment action.
        loggingService.addLog(fileName, "Contrast", Float.toString(amount));

        // Call the static applyContrast method from the ContrastInterface to apply the effect.
        return ContrastInterface.applyContrast(image, amount);
    }
}
