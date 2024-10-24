package org.example;

import org.imgscalr.Scalr;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer implements Runnable {
    private final String dstFolder;
    private final File[] images;
    private final long start;

    public ImageResizer(String dstFolder, File[] images, long start) {
        this.dstFolder = dstFolder;
        this.images = images;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            for (File image : images) {
                BufferedImage originalImage = ImageIO.read(image);
                if (originalImage == null) {
                    continue;
                }

                int width = (int) (originalImage.getWidth() * Math.random());
                int height = (int) (originalImage.getHeight() * Math.random());

                BufferedImage resizeImage = resizeImage(originalImage, width, height);
                File newImageFile = new File(dstFolder + "/" + image.getName());
                ImageIO.write(resizeImage, "jpg", newImageFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Finished after start: " + (System.currentTimeMillis() - start) + " ms.");
    }
    public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        return Scalr.resize(originalImage, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, targetWidth, targetHeight, Scalr.OP_ANTIALIAS);
    }
}