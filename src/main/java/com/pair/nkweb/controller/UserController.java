package com.pair.nkweb.controller;


import com.pair.nkweb.requestvo.RequestVO;
import com.pair.nkweb.responsevo.BasicVO;
import com.pair.nkweb.service.UserService;
import com.pair.nkweb.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userService;


    //---------------------form------------------------------------
    @RequestMapping("/loginForm")
    public ModelAndView loginForm(){
        ModelAndView mav = new ModelAndView("login");

        return mav;
    }


    @RequestMapping("/joinForm")
    public ModelAndView joinForm(){
        ModelAndView mav = new ModelAndView("join");

        return mav;

    }

    @RequestMapping("/modifyForm")
    public ModelAndView modifyForm(RequestVO vo){
        ModelAndView mav = new ModelAndView("modify");

        BasicVO basicVO = userService.selectUser(vo);

        mav.addObject("message", basicVO.getMessage());
        mav.addObject("user", basicVO.getData().get(0));

        return mav;
    }


    //---------------------------process------------------------------------

    @RequestMapping("join")
    public ModelAndView join(RequestVO vo){
        ModelAndView mav = new ModelAndView("login");

        BasicVO basicVO = userService.registUser(vo);

        mav.addObject("message", basicVO.getMessage());

        return mav;
    }

    @RequestMapping("modify")
    public ModelAndView modify(RequestVO vo){
        ModelAndView mav = new ModelAndView("ivList");

        BasicVO basicVO = userService.modifyUser(vo);

        mav.addObject("message", basicVO.getMessage());

        return mav;
    }


    @RequestMapping("login")
    public ModelAndView login(RequestVO vo, HttpSession session){

        ModelAndView mav = new ModelAndView();

        BasicVO basicVO = userService.loginUser(vo);

        String resultCode = basicVO.getResult();


        if(resultCode.equals("00")){


            UserVO user = (UserVO)basicVO.getData().get(0);


            mav.setViewName("redirect:/ivList");


            session.setAttribute("user_id", user.getUser_id());
            session.setAttribute("trade_cd", user.getTrade_cd());
            session.setAttribute("trade_nm", user.getTrade_nm());
            session.setAttribute("tradesub_cd", user.getTradesub_cd());
            session.setAttribute("tradesub_nm", user.getTradesub_nm());

            session.setAttribute("noticeSW", "0");

        }else{
            mav.setViewName("login");
            mav.addObject("message", basicVO.getMessage());
        }



        return mav;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session){

        ModelAndView mav = new ModelAndView("login");


        session.removeAttribute("user_id");
        session.removeAttribute("trade_cd");
        session.removeAttribute("trade_nm");
        session.removeAttribute("tradesub_cd");
        session.removeAttribute("tradesub_nm");


        return mav;

    }



}
