package com.mattstansky.opticaltextrecognitionsystem;

import java.awt.image.BufferedImage;
import java.net.URL;

import net.sourceforge.tess4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;

@Service
public class OTRService {

    @Value("${datapath}")
    private String datapath;

    public String doOTR(String url) {
        try {
            URL imageurl = new URL(url);
//          URL imageurl = new URL("https://i.pinimg.com/736x/44/6c/24/446c2460684eecffcd0a91d94bebd45f.jpg");
            BufferedImage bufferedImage = ImageIO.read(imageurl);

            ITesseract instance = new Tesseract();
            instance.setDatapath(datapath);
            instance.setLanguage("pol");
            return instance.doOCR(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
