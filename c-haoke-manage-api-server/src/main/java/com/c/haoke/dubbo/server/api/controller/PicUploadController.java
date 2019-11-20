package com.c.haoke.dubbo.server.api.controller;
import com.c.haoke.dubbo.server.api.vo.PicUploadResult;
import com.c.haoke.dubbo.server.api.service.PicUploadFileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RequestMapping("/pic/upload")
@RestController
public class PicUploadController {

    @Autowired
    private PicUploadFileSystemService picUploadFileSystemService;


/*
    @RequestMapping(value = "/images",method = RequestMethod.POST)
*/
    @PostMapping
    @ResponseBody
    public PicUploadResult uploadPic(@RequestParam("file") MultipartFile multipartFile){


        return  picUploadFileSystemService.uploadPic1(multipartFile);
    }

/*
    @RequestMapping(value = "/images2",method = RequestMethod.POST)
    public PicUploadResult uploadPic2(@RequestParam("file") MultipartFile multipartFile){


        return  picUploadFileSystemService.uploadPic2(multipartFile);
    }
*/



    @RequestMapping(value = "/print",method = RequestMethod.GET)
    public void printCJL(){
        picUploadFileSystemService.printCJL();;
    }


/*    @PostMapping("/images")
    @ResponseBody
    public PicUploadResult upload(@RequestParam("file") MultipartFile multipartFile) {

        System.out.println("a");

       return this.picUploadFileSystemService.uploadPic(multipartFile);
    }*/
}
