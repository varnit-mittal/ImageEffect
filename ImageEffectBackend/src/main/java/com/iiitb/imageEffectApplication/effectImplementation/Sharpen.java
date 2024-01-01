// Package declaration for the Sharpen effect implementation.
package com.iiitb.imageEffectApplication.effectImplementation;

// Import statements for required libraries and classes.
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.SharpenInterface;

// Class definition for the Sharpen effect implementing SingleValueParameterizableEffect.
public class Sharpen implements SingleValueParameterizableEffect {

    // Private field to store the amount of sharpening adjustment.
    private float amount;

    // Getter method to retrieve the current sharpening adjustment amount.
    public float getAmount() {
        return this.amount;
    }

    // Setter method to set the sharpening adjustment amount with validation.
    // Throws IllegalParameterException if the amount is outside the valid range [0, 100].
    public void setParameterValue(float amount) throws IllegalParameterException {
        if (amount < 0 || amount > 100) {
            throw new IllegalParameterException("Illegal parameters. Parameters must be in the range 0 to 100");
        }
        this.amount = amount;
    }

    // Implementation of the apply method from the SingleValueParameterizableEffect interface.
    // Applies the sharpening effect to the given image, logs the action, and returns the modified image.
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the sharpening action.
        loggingService.addLog(fileName, "Sharpen", Float.toString(amount));

        // Call the static applySharpen method from the SharpenInterface to apply the effect.
        return SharpenInterface.applySharpen(image, amount);
    }
}
