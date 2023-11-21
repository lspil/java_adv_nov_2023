package org.example.managers;

import org.example.images.processing.ImageProcessor;

public class ImageExporter {

    public void export() {
        ImageProcessor i = ImageProcessor.getImageProcessor();

        i.processImage();
    }

//    class Xulescu implements ImageProcessor {
//        @Override
//        public void processImage() {
//
//        }
//    }
}
