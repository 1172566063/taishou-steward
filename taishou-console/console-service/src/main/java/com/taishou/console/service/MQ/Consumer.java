package com.taishou.console.service.MQ;

import com.taishou.console.common.constants.CommonalityProperty;
import com.taishou.console.common.constants.ResultBean;
import com.taishou.console.common.entity.FileInfo;
import com.taishou.console.common.utils.FileCorrelationUtil;
import com.taishou.console.service.Impl.BaseService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/6/8-10:07
 * @Version:
 */
@Component
public class Consumer extends BaseService {

    @JmsListener(destination = "${spring.activemq.topic-name}", containerFactory = "topicListener")
    public ResultBean pictureUpload(FileInfo file) {
        byte[] bytes = file.getFileBytes();
        String fileName = FileCorrelationUtil.getFileName(file.getFileName());
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        try {
            BufferedImage bi1 = ImageIO.read(bais);
            File w2 = new File(CommonalityProperty.PICTURE_PATH+fileName);//可以是jpg,png,gif格式
            ImageIO.write(bi1, "png", w2);//不管输出什么格式图片，此处不需改动
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bais.close();
            }catch (IOException e){
                getFailResult();
            }
        }
        return getFailResult(fileName);
    }
}
