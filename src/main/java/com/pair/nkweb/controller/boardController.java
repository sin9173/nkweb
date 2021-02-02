package com.pair.nkweb.controller;

import com.google.gson.JsonObject;
import com.pair.nkweb.requestvo.ApiVO;
import com.pair.nkweb.requestvo.RequestVO;
import com.pair.nkweb.responsevo.BasicVO;
import com.pair.nkweb.service.NoticeService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Controller
public class boardController {

    @Autowired
    NoticeService noticeService;

    @RequestMapping("/notice")
    public ModelAndView notice(RequestVO requestVO){

        ModelAndView mav = new ModelAndView();


        String api = requestVO.getApi();


        BasicVO basicVO = null;

        if(requestVO==null){
            basicVO = BasicVO.builder()
                    .result("02")
                    .message("데이터없음")
                    .build();
        }else {

            switch(api){

                case "writeForm" :

                    mav.setViewName("noticeWrite");
                    break;
                case "write" :
                    basicVO = noticeService.writeNotice(requestVO);
                    mav.addObject("basicVO", basicVO);
                    mav.setViewName("redirect:/notice?api=noticeList");
                    break;
                case "noticeList" :
                    basicVO = noticeService.getNoticeList(requestVO);
                    mav.addObject("basicVO", basicVO);
                    mav.setViewName("noticeList");
                    break;
                case "noticeRead" :
                    basicVO = noticeService.noticeRead(requestVO);
                    mav.addObject("basicVO", basicVO);
                    mav.setViewName("noticeRead");
                    break;
                case "delete" :
                    basicVO = noticeService.deleteNotice(requestVO);
                    mav.addObject("basicVO", basicVO);
                    mav.setViewName("redirect:/notice?api=noticeList");
                    break;
                case "modifyForm" :
                    basicVO = noticeService.noticeRead(requestVO);
                    mav.addObject("basicVO", basicVO);
                    mav.setViewName("noticeModify");
                    break;
                case "modify" :
                    basicVO = noticeService.modifyNotice(requestVO);
                    mav.addObject("basicVO", basicVO);
                    mav.setViewName("redirect:/notice?api=noticeList");
                    break;
                default :
                    basicVO = BasicVO.builder()
                            .result("01")
                            .message("api없음")
                            .build();
                    break;
            }
        }



        return mav;
    }


    @PostMapping(value="/uploadSummernoteImageFile", produces = "application/json")
    @ResponseBody
    public Map uploadSummernoteImageFile(@RequestParam("file")MultipartFile multipartFile){

        System.out.println("드루와 드루와!");
        //JsonObject jsonObject = new JsonObject();

        Map<String, Object> map = new HashMap<String, Object>();

        String fileRoot = "C:\\summernote_image\\";

        String originalFileName = multipartFile.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

        System.out.println(originalFileName);
        String savedFileName = UUID.randomUUID() + extension;

        File targetFile = new File(fileRoot + savedFileName);

        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);
            //jsonObject.addProperty("url", "/summernoteImage/"+savedFileName);
            //jsonObject.addProperty("responseCode", "success");
            map.put("url", "/nkweb/summernoteImage/"+savedFileName);
            map.put("responseCode", "success");

        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);
            //jsonObject.addProperty("responseCode", "error");
            map.put("responseCode", "error");

            e.printStackTrace();

        }

        System.out.println("리턴이야");




        return map;
    }
}
