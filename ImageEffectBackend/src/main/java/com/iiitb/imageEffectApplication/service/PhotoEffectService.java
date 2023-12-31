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
@Service
public class PhotoEffectService {
    
    @Autowired
    private ProcessingUtils processingUtils;

    @Autowired
    private LoggingService loggingService=new LoggingService();

    public ResponseEntity<byte[]> applyHueSaturationEffect(float hueAmount, float saturationAmount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            ParameterizableEffect photo=new HueSaturation();
            photo.setParameter("H",hueAmount);
            photo.setParameter("S",saturationAmount);
            Pixel[][] modifiedImage = photo.apply(inputImage,imageName,loggingService);
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<byte[]> applyBrightnessEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            SingleValueParameterizableEffect photo=new Brightness();
            photo.setParameterValue(amount);
            Pixel[][] modifiedImage = photo.apply(inputImage,imageName,loggingService);
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyContrastEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            SingleValueParameterizableEffect photo=new Contrast();
            photo.setParameterValue(amount);
            Pixel[][] modifiedImage = photo.apply(inputImage,imageName,loggingService);
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            DiscreteEffect photo=new Flip();
            photo.selectOptionValue("H",horizontalFlipValue);
            photo.selectOptionValue("V",verticalFlipValue);
            Pixel[][] modifiedImage = photo.apply(inputImage,imageName,loggingService);
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGaussianBlurEffect(float radius, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            SingleValueParameterizableEffect photo=new GaussianBlur();
            photo.setParameterValue(radius);
            Pixel[][] modifiedImage = photo.apply(inputImage,imageName,loggingService);
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGrayscaleEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            PhotoEffect photo=new GrayScale();
            Pixel[][] modifiedImage = photo.apply(inputImage,imageName,loggingService);
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyInvertEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            PhotoEffect photo=new Invert();
            Pixel[][] modifiedImage = photo.apply(inputImage,imageName,loggingService);
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyRotationEffect(int value, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            SingleValueDiscreteEffect photo=new Rotation();
            photo.setParameterValue(value);
            Pixel[][] modifiedImage = photo.apply(inputImage,imageName,loggingService);
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySepiaEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            PhotoEffect photo=new Sepia();
            Pixel[][] modifiedImage = photo.apply(inputImage,imageName,loggingService);
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySharpenEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            SingleValueParameterizableEffect photo=new Sharpen();
            photo.setParameterValue(amount);
            Pixel[][] modifiedImage = photo.apply(inputImage,imageName,loggingService);
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<byte[]> getDominantColour(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            PhotoEffect photo=new DominantColor();
            Pixel[][] modifiedImage = photo.apply(inputImage,imageName,loggingService);
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
