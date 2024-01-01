package com.iiitb.imageEffectApplication.service;
import com.iiitb.imageEffectApplication.baseEffects.*;
import com.iiitb.imageEffectApplication.effectImplementation.*;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.utils.ProcessingUtils;
import libraryInterfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import com.iiitb.imageEffectApplication.effectImplementation.*;
// Import statements

  //Service class for applying various photo effects on images.
@Service
public class PhotoEffectService {

    @Autowired
    private ProcessingUtils processingUtils;

    // LoggingService is autowired here
    @Autowired
    private LoggingService loggingService = new LoggingService();

    /**
     * Apply Hue-Saturation effect on the input image.
     */
    public ResponseEntity<byte[]> applyHueSaturationEffect(float hueAmount, float saturationAmount, MultipartFile imageFile) {
        try {
            // Preprocess the image
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // Initialize HueSaturation effect
            ParameterizableEffect photo = new HueSaturation();
            photo.setParameter("H", hueAmount);
            photo.setParameter("S", saturationAmount);

            // Apply the effect and get the modified image
            Pixel[][] modifiedImage = photo.apply(inputImage, imageName, loggingService);

            // Post-process the modified image and return the result
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Apply Brightness effect on the input image.
     */
    public ResponseEntity<byte[]> applyBrightnessEffect(float amount, MultipartFile imageFile) {
        try {
            // Preprocess the image
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // Initialize Brightness effect
            SingleValueParameterizableEffect photo = new Brightness();
            photo.setParameterValue(amount);

            // Apply the effect and get the modified image
            Pixel[][] modifiedImage = photo.apply(inputImage, imageName, loggingService);

            // Post-process the modified image and return the result
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Apply Contrast effect on the input image.
     */
    public ResponseEntity<byte[]> applyContrastEffect(float amount, MultipartFile imageFile) {
        try {
            // Preprocess the image
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // Initialize Contrast effect
            SingleValueParameterizableEffect photo = new Contrast();
            photo.setParameterValue(amount);

            // Apply the effect and get the modified image
            Pixel[][] modifiedImage = photo.apply(inputImage, imageName, loggingService);

            // Post-process the modified image and return the result
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Apply Flip effect on the input image.
     */
    public ResponseEntity<byte[]> applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue) {
        try {
            // Preprocess the image
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // Initialize Flip effect
            DiscreteEffect photo = new Flip();
            photo.selectOptionValue("H", horizontalFlipValue);
            photo.selectOptionValue("V", verticalFlipValue);

            // Apply the effect and get the modified image
            Pixel[][] modifiedImage = photo.apply(inputImage, imageName, loggingService);

            // Post-process the modified image and return the result
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Apply Gaussian Blur effect on the input image.
     */
    public ResponseEntity<byte[]> applyGaussianBlurEffect(float radius, MultipartFile imageFile) {
        try {
            // Preprocess the image
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // Initialize Gaussian Blur effect
            SingleValueParameterizableEffect photo = new GaussianBlur();
            photo.setParameterValue(radius);

            // Apply the effect and get the modified image
            Pixel[][] modifiedImage = photo.apply(inputImage, imageName, loggingService);

            // Post-process the modified image and return the result
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Apply Grayscale effect on the input image.
     */
    public ResponseEntity<byte[]> applyGrayscaleEffect(MultipartFile imageFile) {
        try {
            // Preprocess the image
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // Initialize Grayscale effect
            PhotoEffect photo = new GrayScale();

            // Apply the effect and get the modified image
            Pixel[][] modifiedImage = photo.apply(inputImage, imageName, loggingService);

            // Post-process the modified image and return the result
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Apply Invert effect on the input image.
     */
    public ResponseEntity<byte[]> applyInvertEffect(MultipartFile imageFile) {
        try {
            // Preprocess the image
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // Initialize Invert effect
            PhotoEffect photo = new Invert();

            // Apply the effect and get the modified image
            Pixel[][] modifiedImage = photo.apply(inputImage, imageName, loggingService);

            // Post-process the modified image and return the result
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Apply Rotation effect on the input image.
     */
    public ResponseEntity<byte[]> applyRotationEffect(int value, MultipartFile imageFile) {
        try {
            // Preprocess the image
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // Initialize Rotation effect
            SingleValueDiscreteEffect photo = new Rotation();
            photo.setParameterValue(value);

            // Apply the effect and get the modified image
            Pixel[][] modifiedImage = photo.apply(inputImage, imageName, loggingService);

            // Post-process the modified image and return the result
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Apply Sepia effect on the input image.
     */
    public ResponseEntity<byte[]> applySepiaEffect(MultipartFile imageFile) {
        try {
            // Preprocess the image
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // Initialize Sepia effect
            PhotoEffect photo = new Sepia();

            // Apply the effect and get the modified image
            Pixel[][] modifiedImage = photo.apply(inputImage, imageName, loggingService);

            // Post-process the modified image and return the result
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Apply Sharpen effect on the input image.
     */
    public ResponseEntity<byte[]> applySharpenEffect(float amount, MultipartFile imageFile) {
        try {
            // Preprocess the image
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // Initialize Sharpen effect
            SingleValueParameterizableEffect photo = new Sharpen();
            photo.setParameterValue(amount);

            // Apply the effect and get the modified image
            Pixel[][] modifiedImage = photo.apply(inputImage, imageName, loggingService);

            // Post-process the modified image and return the result
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get the dominant color of the input image.
     */
    public ResponseEntity<byte[]> getDominantColour(MultipartFile imageFile) {
        try {
            // Preprocess the image
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // Initialize DominantColor effect
            PhotoEffect photo = new DominantColor();

            // Apply the effect and get the modified image
            Pixel[][] modifiedImage = photo.apply(inputImage, imageName, loggingService);

            // Post-process the modified image and return the result
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
