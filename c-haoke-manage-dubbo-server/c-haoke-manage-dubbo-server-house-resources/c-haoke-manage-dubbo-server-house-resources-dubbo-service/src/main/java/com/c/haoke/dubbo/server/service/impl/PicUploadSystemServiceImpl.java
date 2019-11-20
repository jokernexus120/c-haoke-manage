package com.c.haoke.dubbo.server.service.impl;

import com.c.haoke.dubbo.server.vo.IdWorker;
import com.c.haoke.dubbo.server.service.PicUploadSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PicUploadSystemServiceImpl implements PicUploadSystemService {

    @Autowired
    private IdWorker idWorker;

    @Value("${basicImgUrl}")
    private String basicImgUrl;
    // 允许上传的格式
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg",
            ".jpeg", ".gif", ".png"};

/*
    public PicUploadResult uploadPic(MultipartFile img){

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
        String url = filePath;
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
*/

    @Override
    public void printCJL() {
        System.out.println("-----CJLCJLCJLCJLCJLCJL-------------------------");
    }
}
