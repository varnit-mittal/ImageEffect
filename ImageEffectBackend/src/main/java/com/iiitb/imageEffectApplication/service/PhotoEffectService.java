package com.iiitb.imageEffectApplication.service;
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
            Pixel[][] modifiedImage = HueSaturationInterface.applyHueSaturation(inputImage,saturationAmount,hueAmount);
            loggingService.addLog(imageName,"HueSaturation","Hue - "+String.valueOf(hueAmount)+" / Sat. - "+String.valueOf(saturationAmount));
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<byte[]> applyBrightnessEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            Pixel[][] modifiedImage = BrightnessInterface.applyBrightness(inputImage,amount);
            loggingService.addLog(imageName,"Brightness",String.valueOf(amount));
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyContrastEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            Pixel[][] modifiedImage = ContrastInterface.applyContrast(inputImage,amount);
            loggingService.addLog(imageName,"Contrast",String.valueOf(amount));
            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            Pixel[][] modifiedImage = FlipInterface.applyFlip(inputImage,horizontalFlipValue,verticalFlipValue);
            String lopvalue=" ";
            if(horizontalFlipValue==1 && verticalFlipValue==1)
            {
                lopvalue+="HFlip and VFlip ";
            }
            else if(horizontalFlipValue==1)
            {
                lopvalue+="HFlip ";
            }
            else if(verticalFlipValue==1)
            {
                lopvalue+="VFlip ";
            }
            else
            {
                lopvalue=" --- ";
            }
            loggingService.addLog(imageName,"Flip",lopvalue);
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGaussianBlurEffect(float radius, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            Pixel[][] modifiedImage = GaussianBlurInterface.applyGaussianBlur(inputImage,radius);
            loggingService.addLog(imageName,"GaussianBlur",String.valueOf(radius));
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGrayscaleEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            Pixel[][] modifiedImage = GrayscaleInterface.applyGrayscale(inputImage);
            loggingService.addLog(imageName,"Grayscale"," --- ");
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
            Pixel[][] modifiedImage = InvertInterface.applyInvert(inputImage);
            loggingService.addLog(imageName,"Invert"," --- ");
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
            Pixel[][] modifiedImage = RotationInterface.applyRotation(inputImage,value);
            String logvalue="";
            if(value==1)
            {
                logvalue="90";
            }
            else if(value==2)
            {
                logvalue="180";
            }
            else if(value==3)
            {
                logvalue="270";
            }
            else
            {
                logvalue=" --- ";
            }
            loggingService.addLog(imageName,"Rotation",logvalue);
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySepiaEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            Pixel[][] modifiedImage = SepiaInterface.applySepia(inputImage);
            loggingService.addLog(imageName,"Sepia"," --- ");
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
            Pixel[][] modifiedImage = SharpenInterface.applySharpen(inputImage,amount);
            loggingService.addLog(imageName,"Sharpen",String.valueOf(amount));
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<byte[]> getDominantColour(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            Pixel[][] modifiedImage = DominantColourInterface.applyDominantColour(inputImage);
            loggingService.addLog(imageName,"DominantColour"," --- ");
            return processingUtils.postProcessing(modifiedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
