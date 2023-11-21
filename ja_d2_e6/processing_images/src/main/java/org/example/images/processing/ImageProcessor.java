package org.example.images.processing;

import org.example.images.internals.ImageProcessorXYZImpl;

public sealed interface ImageProcessor permits ImageProcessorXYZImpl {

    void processImage();

    static ImageProcessor getImageProcessor() {
        return new ImageProcessorXYZImpl();
    }
}
