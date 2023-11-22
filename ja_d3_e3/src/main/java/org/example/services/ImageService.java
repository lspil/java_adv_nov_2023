package org.example.services;

import org.example.processors.ImageProcessor;

public class ImageService {

    private ImageProcessor imageProcessor;

    public ImageService() {
        this.imageProcessor = ImageProcessor.getImageProcessor(ImageProcessor.Type.VECTOR);
    }


}
