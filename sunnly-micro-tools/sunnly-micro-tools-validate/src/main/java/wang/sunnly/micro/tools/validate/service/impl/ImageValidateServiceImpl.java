package wang.sunnly.micro.tools.validate.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.ServletWebRequest;
import wang.sunnly.micro.tools.validate.service.ImageValidateService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author Sunnly
 * @ClassName ImageValidateServiceImpl
 * @Date 2019/6/10 0010 21:52
 **/
public class ImageValidateServiceImpl implements ImageValidateService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public boolean sender(ServletWebRequest request, String code, int width, int height) {
        logger.info(String.format("生成验证码图片：%s",code));
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();
        Random random = new Random();

        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        for (int i = 0; i < code.length(); i++) {
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(code.substring(i,i+1), 13 * i + 6, height/2+5);
        }
        g.dispose();

        try {
            ImageIO.write(image,"JPEG",request.getResponse().getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 生成随机背景条纹
     *
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
