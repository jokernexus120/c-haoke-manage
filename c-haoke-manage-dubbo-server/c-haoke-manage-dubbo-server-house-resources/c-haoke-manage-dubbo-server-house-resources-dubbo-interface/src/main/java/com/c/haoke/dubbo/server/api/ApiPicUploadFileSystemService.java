package com.c.haoke.dubbo.server.api;

import com.c.haoke.dubbo.server.pojo.PicUploadResult;
import org.springframework.web.multipart.MultipartFile;
public interface ApiPicUploadFileSystemService {

    public PicUploadResult uploadPic(MultipartFile img);

    public void printCJL();

}
