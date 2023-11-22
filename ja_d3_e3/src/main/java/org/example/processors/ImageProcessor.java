package org.example.processors;

public interface ImageProcessor {

    void processImage();

    static ImageProcessor getImageProcessor(Type type) {
        return switch (type) {
            case VECTOR -> new VectorImageProcessor();
            case PIXEL -> new PixelImageProcessor();
        };
    }

    enum Type {
        VECTOR, PIXEL
    }
}
