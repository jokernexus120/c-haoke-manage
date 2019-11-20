package com.c.haoke.dubbo.server.api;

import com.alibaba.dubbo.config.annotation.Service;

import com.c.haoke.dubbo.server.service.PicUploadSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@Service(version = "1.0.0")
public class ApiPicUploadFileSystemServiceImpl implements ApiPicUploadFileSystemService {

    @Autowired
    private PicUploadSystemService picUploadFileSystemService;

/*
    @Override
    public PicUploadResult uploadPic(MultipartFile img) {

        PicUploadResult result = picUploadFileSystemService.uploadPic(img);

        return result;
    }
*/

    @Override
    public void printCJL() {
        picUploadFileSystemService.printCJL();
    }
}
