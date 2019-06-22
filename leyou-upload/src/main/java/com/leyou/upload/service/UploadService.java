package com.leyou.upload.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.List;
@Service
public class UploadService {
    private static final List<String> CONTENTYPE_TYPE= Arrays.asList("image/jpeg","image/png");
    private static final Logger LOGGER=LoggerFactory.getLogger(UploadService.class);
    public String uploadImage(MultipartFile file) {

        //判断后缀是不是图片
        String filename = file.getOriginalFilename();
        String contentType = file.getContentType();
        if(!CONTENTYPE_TYPE.contains(contentType)){
            LOGGER.info("文件类型不对"+filename);
            return null;
        }
        //判断内容是不是图片
        try{ BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if(bufferedImage==null){
                LOGGER.info("该内容不是图片"+filename);
                return null;
            }
            ///返回图片地址,并保存到服务器
            file.transferTo(new File("/Users/morenjie/Desktop/images/"+filename));
            return "http://image.leyou.com/"+filename;
        }catch (Exception e){
            LOGGER.info("服务器内部出错"+filename);
            e.printStackTrace();
        }
        return null;
    }
}
