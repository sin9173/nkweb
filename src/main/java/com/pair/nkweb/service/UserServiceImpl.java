package com.pair.nkweb.service;

import com.pair.nkweb.mappers2.UsersMapper;
import com.pair.nkweb.requestvo.RequestVO;
import com.pair.nkweb.responsevo.BasicVO;
import com.pair.nkweb.responsevo.ResponseVO;
import com.pair.nkweb.vo.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    UsersMapper usersMapper;

    @Override
    public BasicVO registUser(RequestVO vo) {
        BasicVO basicVO = null;

        ArrayList<ResponseVO> list = new ArrayList<>();

        int count = 0;


        try {

            count += usersMapper.regUser(vo);



        } catch (Exception e){
            e.printStackTrace();

        }

        if(count>=1){
            basicVO = BasicVO.builder()
                    .result("00")
                    .message("등록")
                    .data(list)
                    .build();
        }else{
            basicVO = BasicVO.builder()
                    .result("99")
                    .message("에러")
                    .data(list)
                    .build();
        }

        return basicVO;

    }

    @Override
    public BasicVO modifyUser(RequestVO vo) {
        BasicVO basicVO = null;

        ArrayList<ResponseVO> list = new ArrayList<>();

        int count = 0;


        try {

            count += usersMapper.modUser(vo);



        } catch (Exception e){
            e.printStackTrace();

        }

        if(count>=1){
            basicVO = BasicVO.builder()
                    .result("00")
                    .message("정보수정")
                    .data(list)
                    .build();
        }else{
            basicVO = BasicVO.builder()
                    .result("99")
                    .message("에러")
                    .data(list)
                    .build();
        }

        return basicVO;
    }

    @Override
    public BasicVO loginUser(RequestVO vo) {
        BasicVO basicVO = null;

        ArrayList<ResponseVO> list = new ArrayList<>();


        try {

            UserVO uvo = usersMapper.loginUser(vo);

            if(uvo==null){
                basicVO = BasicVO.builder()
                        .result("01")
                        .message("아이디없음")
                        .data(list)
                        .build();

            }else{

                if(uvo.getUser_pw().equals(vo.getUser_pw())){
                    list.add(uvo);
                    basicVO = BasicVO.builder()
                            .result("00")
                            .message("로그인")
                            .data(list)
                            .build();
                }else{
                    basicVO = BasicVO.builder()
                            .result("02")
                            .message("비밀번호불일치")
                            .data(list)
                            .build();
                }
            }

        } catch (Exception e){
            e.printStackTrace();

            basicVO = BasicVO.builder()
                    .result("99")
                    .message("에러")
                    .data(list)
                    .build();

        }


        return basicVO;
    }

    @Override
    public BasicVO selectUser(RequestVO vo) {
        BasicVO basicVO = null;

        ArrayList<ResponseVO> list = new ArrayList<>();


        try {

            UserVO uvo = usersMapper.loginUser(vo);

            if(uvo==null){
                basicVO = BasicVO.builder()
                        .result("01")
                        .message("아이디없음")
                        .data(list)
                        .build();

            }else{

                list.add(uvo);

                basicVO = BasicVO.builder()
                        .result("00")
                        .message("유저정보")
                        .data(list)
                        .build();


            }

        } catch (Exception e){
            e.printStackTrace();

            basicVO = BasicVO.builder()
                    .result("99")
                    .message("에러")
                    .data(list)
                    .build();

        }


        return basicVO;
    }
}
