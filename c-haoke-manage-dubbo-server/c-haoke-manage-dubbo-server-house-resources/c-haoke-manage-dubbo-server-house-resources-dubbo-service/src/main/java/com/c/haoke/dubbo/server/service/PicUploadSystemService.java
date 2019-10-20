package com.c.haoke.dubbo.server.service;

import com.c.haoke.dubbo.server.vo.PicUploadResult;
import org.springframework.web.multipart.MultipartFile;

public interface PicUploadSystemService {

    public PicUploadResult uploadPic(MultipartFile img);

    public void printCJL();

}
