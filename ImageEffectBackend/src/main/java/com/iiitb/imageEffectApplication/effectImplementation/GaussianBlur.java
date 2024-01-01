// Package declaration for the Gaussian Blur effect implementation.
package com.iiitb.imageEffectApplication.effectImplementation;

// Import statements for required libraries and classes.
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.GaussianBlurInterface;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

// Class definition for the Gaussian Blur effect implementing the SingleValueParameterizableEffect interface.
public class GaussianBlur implements SingleValueParameterizableEffect {

    // Private field to store the amount of blur.
    private float amount;

    // Getter method to retrieve the current amount of blur.
    public float getAmount() {
        return this.amount;
    }

    // Setter method to set the amount of blur with validation.
    // Throws IllegalParameterException if the value is outside the valid range [0, 50].
    public void setParameterValue(float amount) throws IllegalParameterException {
        if (amount < 0 || amount > 50) {
            throw new IllegalParameterException("Illegal parameters. Parameters must be in the range 0 to 50");
        }
        this.amount = amount;
    }

    // Implementation of the apply method from the SingleValueParameterizableEffect interface.
    // Applies the Gaussian Blur effect to the given image, logs the action, and returns the modified image.
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the Gaussian Blur effect action.
        loggingService.addLog(fileName, "Gaussian Blur", Float.toString(amount));

        // Call the static applyGaussianBlur method from the GaussianBlurInterface to apply the effect.
        return GaussianBlurInterface.applyGaussianBlur(image, amount);
    }
}
