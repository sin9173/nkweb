package com.pair.nkweb.service;

import com.pair.nkweb.log.SqlExceptionLog;
import com.pair.nkweb.mappers2.NoticeMapper;
import com.pair.nkweb.requestvo.RequestVO;
import com.pair.nkweb.responsevo.BasicVO;
import com.pair.nkweb.responsevo.ResponseVO;
import com.pair.nkweb.vo.CountVO;
import com.pair.nkweb.vo.NoticeVO;
import io.opencensus.stats.Aggregation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    NoticeMapper noticeMapper;

    @Override
    public BasicVO writeNotice(RequestVO vo) {

        BasicVO basicVO = null;

        ArrayList<ResponseVO> list = new ArrayList<>();

        int count = 0;
        int fail = 0;
        //ArrayList<String> fail_list = new ArrayList<>();

        try {

            count += noticeMapper.insertNotice(vo);


        } catch (Exception e) {
            e.printStackTrace();

            new SqlExceptionLog(e, vo);


            fail += 1;

            //fail_list.add(vo.getTitle());

        }

        CountVO cvo = new CountVO();

        cvo.setCount(count);
        cvo.setFail(fail);

        list.add(cvo);

        if(count>0){
            basicVO = BasicVO.builder()
                    .result("00")
                    .message("공지사항작성")
                    .data(list)
                    .build();
        }else {
            basicVO = BasicVO.builder()
                    .result("99")
                    .message("에러")
                    .data(list)
                    .build();
        }

        return basicVO;
    }

    @Override
    public BasicVO modifyNotice(RequestVO vo) {
        BasicVO basicVO = null;

        ArrayList<ResponseVO> list = new ArrayList<>();

        int count = 0;
        int fail = 0;
        //ArrayList<String> fail_list = new ArrayList<>();

        try {

            count += noticeMapper.updateNotice(vo);


        } catch (Exception e) {
            e.printStackTrace();

            new SqlExceptionLog(e, vo);


            fail += 1;

            //fail_list.add(vo.getTitle());

        }

        CountVO cvo = new CountVO();

        cvo.setCount(count);
        cvo.setFail(fail);

        list.add(cvo);

        if(count>0){
            basicVO = BasicVO.builder()
                    .result("00")
                    .message("공지사항수정")
                    .data(list)
                    .build();
        }else {
            basicVO = BasicVO.builder()
                    .result("99")
                    .message("에러")
                    .data(list)
                    .build();
        }

        return basicVO;
    }

    @Override
    public BasicVO deleteNotice(RequestVO vo) {
        BasicVO basicVO = null;

        ArrayList<ResponseVO> list = new ArrayList<>();

        int count = 0;
        int fail = 0;
        //ArrayList<String> fail_list = new ArrayList<>();

        try {

            count += noticeMapper.deleteNotice(vo);


        } catch (Exception e) {
            e.printStackTrace();

            new SqlExceptionLog(e, vo);


            fail += 1;

            //fail_list.add(vo.getTitle());

        }

        CountVO cvo = new CountVO();

        cvo.setCount(count);
        cvo.setFail(fail);

        list.add(cvo);

        if(count>0){
            basicVO = BasicVO.builder()
                    .result("00")
                    .message("공지사항삭제")
                    .data(list)
                    .build();
        }else {
            basicVO = BasicVO.builder()
                    .result("99")
                    .message("에러")
                    .data(list)
                    .build();
        }

        return basicVO;
    }


    @Override
    public BasicVO getNoticeList(RequestVO vo) {
        BasicVO basicVO = null;

        ArrayList<ResponseVO> list = new ArrayList<>();



        try {

           ArrayList<NoticeVO> noticeList = noticeMapper.getNoticeList();

           list.addAll(noticeList);


           basicVO = BasicVO.builder()
                   .result("00")
                   .message("공지사항리스트")
                   .data(list)
                   .build();


        } catch (Exception e) {
            e.printStackTrace();

            new SqlExceptionLog(e, vo);

            basicVO = BasicVO.builder()
                    .result("99")
                    .message("에러")
                    .data(list)
                    .build();
        }




        return basicVO;
    }

    @Override
    public BasicVO noticeRead(RequestVO vo) {
        BasicVO basicVO = null;

        ArrayList<ResponseVO> list = new ArrayList<>();



        try {

            NoticeVO notice = noticeMapper.noticeRead(vo);

            list.add(notice);


            basicVO = BasicVO.builder()
                    .result("00")
                    .message("공지사항읽기")
                    .data(list)
                    .build();


        } catch (Exception e) {
            e.printStackTrace();

            new SqlExceptionLog(e, vo);

            basicVO = BasicVO.builder()
                    .result("99")
                    .message("에러")
                    .data(list)
                    .build();
        }


        System.out.println(basicVO);


        return basicVO;
    }
}
