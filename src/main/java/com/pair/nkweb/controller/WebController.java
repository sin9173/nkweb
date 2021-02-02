package com.pair.nkweb.controller;

import com.pair.nkweb.requestvo.ApiVO;
import com.pair.nkweb.requestvo.RequestVO;
import com.pair.nkweb.responsevo.BasicVO;
import com.pair.nkweb.responsevo.ResponseVO;
import com.pair.nkweb.service.NkService;
import com.pair.nkweb.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class WebController {

    @Autowired
    NkService nkService;

    @Autowired
    NoticeService noticeService;

    @RequestMapping("/test")
    public ModelAndView test(){

        ModelAndView mav = new ModelAndView("test");


        return mav;
    }

    @RequestMapping("/ivList")
    public ModelAndView ivList(RequestVO vo){

        ModelAndView mav = new ModelAndView("ivList");

        BasicVO basicVO = nkService.ivInfoList(vo);

        List<ResponseVO> noticeList = noticeService.getNoticeList(vo).getData();

        mav.addObject("ivList", basicVO.getData());

        mav.addObject("noticeList", noticeList);
        if(vo.getBase_ymd_front() == null || vo.getBase_ymd_front().equals("") || vo.getBase_ymd_front().equals("9999-01-01")){

            Date dt = new Date();

            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

            String date = sf.format(dt);

            vo.setBase_ymd_front(date);
        }

        if(vo.getBase_ymd_rear() == null | vo.getBase_ymd_rear().equals("") || vo.getBase_ymd_rear().equals("9999-01-01")){
            Date dt = new Date();

            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

            String date = sf.format(dt);

            vo.setBase_ymd_rear(date);
        }

        mav.addObject("frDate", vo.getBase_ymd_front());
        mav.addObject("rrDate", vo.getBase_ymd_rear());

        return mav;
    }

    @RequestMapping("/ivMemoList")
    public ModelAndView ivMemoList(RequestVO vo){
        ModelAndView mav = new ModelAndView("ivMemo");

        BasicVO basicVO = nkService.memoList(vo);

        mav.addObject("ivMemo", basicVO.getData());



        return mav;
    }


    @RequestMapping("/memoSave")
    @ResponseBody
    public BasicVO memoSave(@RequestBody ApiVO apiVO){

        BasicVO basicVO = null;


        ArrayList<RequestVO> vos = new ArrayList<>(apiVO.getData());
        basicVO = nkService.insertMemo(vos);

        return basicVO;
    }

    @RequestMapping("/memoModify")
    public ModelAndView memoModify(RequestVO vo){

        ModelAndView mav = new ModelAndView("redirect:/ivMemoList?iv_no="+vo.getIv_no());

        BasicVO basicVO = null;

        basicVO = nkService.modifyMemo(vo);



        return mav;
    }



}
