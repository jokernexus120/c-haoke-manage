package com.c.haoke.dubbo.server.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.c.haoke.dubbo.server.api.ApiPicUploadFileSystemService;
import com.c.haoke.dubbo.server.api.vo.IdWorker;
import com.c.haoke.dubbo.server.api.vo.PicUploadResult;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

@Service
public class PicUploadFileSystemService {


    @Reference(version = "1.0.0")
    private ApiPicUploadFileSystemService apiPicUploadFileSystemService;




    @Autowired
    private IdWorker idWorker;

    @Value("${basicImgUrl}")
    private String basicImgUrl;
    // 允许上传的格式
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg",
            ".jpeg", ".gif", ".png"};

    public PicUploadResult uploadPic1(MultipartFile img){

        boolean isLegal = false;
        String imgName = img.getOriginalFilename();
        PicUploadResult picUploadResult = new PicUploadResult();

        for (String type:IMAGE_TYPE)
        {
                if (StringUtils.endsWithIgnoreCase(imgName,type));
            {
                isLegal = true;
                break;
            }


        }


        if (!isLegal)
        {
            picUploadResult.setStatus("error");
            picUploadResult.setUploadTime(new Date());
            picUploadResult.setStatus("error");
            return picUploadResult;
        }
        String filePath = getFilePath(imgName);
        String url = StringUtils.replace(filePath,"//",File.separator);
        File file = new File(filePath);

        try
        {
            img.transferTo(file);

        }catch (Exception e){
            picUploadResult.setStatus("error");
            picUploadResult.setUploadTime(new Date());
            picUploadResult.setUid(idWorker.nextId()+"");
        }

        picUploadResult.setStatus("success");
        picUploadResult.setUploadTime(new Date());
        picUploadResult.setUrl(url);
        picUploadResult.setName(url);

        return picUploadResult;
    }

    private String getFilePath( String sourceImgName){

        DateTime dateTime = new DateTime(new Date());
        String fileFolder = basicImgUrl + File.separator+dateTime.toString("yyyy")+
                File.separator+dateTime.toString("MM")+File.separator+dateTime.toString("dd");

        File file = new File(fileFolder);

        if (!file.exists())
        {
            file.mkdirs();
        }

        String fileName = idWorker.nextId() + "." +
                StringUtils.substringAfterLast(sourceImgName,".");

        String path = fileFolder + File.separator + fileName;


        return  path;
    }

/*
    public PicUploadResult uploadPic2(MultipartFile img){
        PicUploadResult result = apiPicUploadFileSystemService.uploadPic(img);

        return result;
    }
*/

    public void printCJL(){
        apiPicUploadFileSystemService.printCJL();;
    }



}
