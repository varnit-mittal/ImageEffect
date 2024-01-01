// Package declaration for the Flip effect implementation.
package com.iiitb.imageEffectApplication.effectImplementation;

// Import statements for required libraries and classes.
import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.FlipInterface;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

// Class definition for the Flip effect implementing the DiscreteEffect interface.
public class Flip implements DiscreteEffect {

    // Private fields to store horizontal and vertical flip options.
    private int h;
    private int v;

    // Default constructor initializing flip options to 0 (no flip).
    public Flip() {
        this.h = 0;
        this.v = 0;
    }

    // Getter method to retrieve the current horizontal flip option.
    public int getHorizontalFlip() {
        return this.h;
    }

    // Getter method to retrieve the current vertical flip option.
    public int getVerticalFlip() {
        return this.v;
    }

    // Method to set the flip option based on user input, with validation.
    // Throws IllegalParameterException if the value is outside the valid range [0, 1].
    public void selectOptionValue(String opt, int val) throws IllegalParameterException {
        if (val < 0 || val > 1) {
            throw new IllegalParameterException("Not allowed");
        }
        if (opt.equals("H")) {
            this.h = val;
        } else {
            this.v = val;
        }
    }

    // Implementation of the apply method from the DiscreteEffect interface.
    // Applies the Flip effect to the given image, logs the action, and returns the modified image.
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Construct a log message based on the selected flip options.
        String flipDescription;
        if (this.h != 0 && this.v != 0) {
            flipDescription = "Horizontal and Vertical";
        } else if (this.h != 0) {
            flipDescription = "Horizontal";
        } else if (this.v != 0) {
            flipDescription = "Vertical";
        } else {
            flipDescription = "No";
        }

        // Log the Flip effect action.
        loggingService.addLog(fileName, "Flip", flipDescription + " Flip");

        // Call the static applyFlip method from the FlipInterface to apply the effect.
        return FlipInterface.applyFlip(image, h, v);
    }
}
