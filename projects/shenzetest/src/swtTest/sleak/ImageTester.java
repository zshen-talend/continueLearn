package swtTest.sleak;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

public class ImageTester {

    private static int size;

    private static final String imagePath = "D:/code/trunk1/shenzetest/src/swtTest/sleak/splash.bmp"; //$NON-NLS-1$

    /**
     * @param args
     */
    public static void main(String[] args) {
        size = 1000;
        ImageTester imageTester = new ImageTester();
        System.out.println("===========createByDescriptor=============");
        long start = System.currentTimeMillis();
        System.out.println("start : " + start);
        for (int i = 0; i < size; i++) {
            imageTester.createByDescriptor();
        }
        long end = System.currentTimeMillis();
        System.out.println("end : " + end);
        System.out.println("time : " + (end - start));

        // =================================================
        System.out.println("===========createByImageData=============");
        start = System.currentTimeMillis();
        System.out.println("start : " + start);
        for (int i = 0; i < size; i++) {
            imageTester.createByImageData();
        }
        end = System.currentTimeMillis();
        System.out.println("end : " + end);
        System.out.println("time : " + (end - start));

        // =================================================
        System.out.println("===========createByRegistry=============");
        start = System.currentTimeMillis();
        System.out.println("start : " + start);

        for (int i = 0; i < size; i++) {
            imageTester.createByRegistry();
        }
        end = System.currentTimeMillis();
        System.out.println("end : " + end);
        System.out.println("time : " + (end - start));

        // =================================================
        System.out.println("===========createByRegistryWrong=============");
        start = System.currentTimeMillis();
        System.out.println("start : " + start);
        for (int i = 0; i < size; i++) {
            imageTester.createByRegistryWrong();
        }
        end = System.currentTimeMillis();
        System.out.println("end : " + end);
        System.out.println("time : " + (end - start));
    }

    public Image createByDescriptor() {
        URL fullPathString = null;
        try {
            fullPathString = new File(imagePath).toURL();
        } catch (MalformedURLException e) {
            return null;
        }
        ImageDescriptor desc = ImageDescriptor.createFromURL(fullPathString);
        Image createImage = desc.createImage();
        return createImage;
    }

    public Image createByImageData() {
        Image image = new Image(Display.getCurrent(), new ImageData(imagePath));
        return image;
    }

    public Image createByRegistry() {

        ImageRegistry imageRegistry = JFaceResources.getImageRegistry();
        String key = "ImageTestter";
        Image image = imageRegistry.get(key);
        if (image == null) {
            URL fullPathString = null;
            try {
                fullPathString = new File(imagePath).toURL();
            } catch (MalformedURLException e) {
                return null;
            }
            ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(fullPathString);
            if (imageDescriptor != null) {
                imageRegistry.put(key, imageDescriptor);
                image = imageRegistry.get(key);
            }
        }
        return image;
    }

    public Image createByRegistryWrong() {
        ImageRegistry imageRegistry = JFaceResources.getImageRegistry();
        String key = "ImageTestter";
        ImageDescriptor descriptor = imageRegistry.getDescriptor(key);
        if (descriptor == null) {
            URL fullPathString = null;
            try {
                fullPathString = new File(imagePath).toURL();
            } catch (MalformedURLException e) {
                return null;
            }
            ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(fullPathString);
            if (imageDescriptor != null) {
                imageRegistry.put(key, imageDescriptor);
            }
        }
        descriptor = imageRegistry.getDescriptor(key);

        Image createImage = descriptor.createImage();
        return createImage;
    }
}
