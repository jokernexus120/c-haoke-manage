package com.c.haoke.dubbo.server.service;

import com.c.haoke.dubbo.server.pojo.PicUploadResult;
import org.springframework.web.multipart.MultipartFile;

public interface PicUploadFileSystemService {

    public PicUploadResult uploadPic(MultipartFile img);

    public void printCJL();

}
