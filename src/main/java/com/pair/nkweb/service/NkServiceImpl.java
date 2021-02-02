package com.pair.nkweb.service;

import com.pair.nkweb.log.SqlExceptionLog;
import com.pair.nkweb.mappers.NkMapper;
import com.pair.nkweb.requestvo.RequestVO;
import com.pair.nkweb.responsevo.BasicVO;
import com.pair.nkweb.responsevo.ResponseVO;
import com.pair.nkweb.vo.IvInfoVO;
import com.pair.nkweb.vo.MemoVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
@AllArgsConstructor
public class NkServiceImpl implements NkService{

    NkMapper nkMapper;


    @Override
    public BasicVO ivInfoList(RequestVO vo) {
        BasicVO basicVO = null;

        ArrayList<ResponseVO> list = new ArrayList<>();




        try {



            if(vo.getBase_ymd_front()==null || vo.getBase_ymd_front().equals("")){

                vo.setBase_ymd_front("9999-01-01");

            }

            if(vo.getBase_ymd_rear()==null || vo.getBase_ymd_rear().equals("")){
//                Date isDate = new Date();
//
//                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//
//                String date = sf.format(isDate);
//
//                vo.setBase_ymd_rear(date);

                vo.setBase_ymd_rear("9999-01-01");
            }

            ArrayList<IvInfoVO> ivList = new ArrayList<>();


            ivList.addAll(nkMapper.ivInfoList(vo));

            for(IvInfoVO ivo : ivList){
                ivo.setDv_tel1(ivo.getDv_tel1().substring(0, 9) + "****");
                ivo.setDv_nm(ivo.getDv_nm().substring(0, 2) + "*");
                ivo.setPk_nm(ivo.getPk_nm().substring(0, 2) + "*");
            }

            list.addAll(ivList);

            basicVO = BasicVO.builder()
                    .result("00")
                    .message("송장정보")
                    .data(list)
                    .build();

        } catch (Exception e){

            basicVO = BasicVO.builder()
                    .result("99")
                    .message("에러")
                    .data(list)
                    .build();

            new SqlExceptionLog(e, vo).logging();
        }



        return basicVO;
    }

    @Override
    public BasicVO memoList(RequestVO vo) {
        BasicVO basicVO = null;

        ArrayList<ResponseVO> list = new ArrayList<>();

        try {

            ArrayList<MemoVO> memoList = nkMapper.MemoInfoList(vo);

            for(MemoVO memoVO : memoList){
                String memo_desc = new String(memoVO.getMemo_desc_bt());

                memoVO.setMemo_desc(memo_desc);
            }

            list.addAll(memoList);

            basicVO = BasicVO.builder()
                    .result("00")
                    .message("메모")
                    .data(list)
                    .build();

        } catch (Exception e){

            basicVO = BasicVO.builder()
                    .result("99")
                    .message("에러")
                    .data(list)
                    .build();

            new SqlExceptionLog(e).logging();
        }



        return basicVO;
    }

    @Override
    public BasicVO insertMemo(ArrayList<RequestVO> vos) {
        BasicVO basicVO = null;

        ArrayList<ResponseVO> list = new ArrayList<>();

        int count = 0;



        for(RequestVO vo : vos){
            try {

                count += nkMapper.insertMemo(vo);

            } catch (Exception e){
                e.printStackTrace();

                new SqlExceptionLog(e, vo).logging();

                return  BasicVO.builder()
                        .result("99")
                        .message("에러")
                        .data(list)
                        .build();


            }
        }


        if(count>=1){
            basicVO = BasicVO.builder()
                    .result("00")
                    .message("메모작성 count:"+count)
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
    public BasicVO modifyMemo(RequestVO vo) {
        BasicVO basicVO = null;

        ArrayList<ResponseVO> list = new ArrayList<>();

        int count = 0;

        try {

            count += nkMapper.modifyMemo(vo);

        } catch (Exception e){
            e.printStackTrace();
            new SqlExceptionLog(e, vo).logging();
        }

        if(count>=1){
            basicVO = BasicVO.builder()
                    .result("00")
                    .message("메모수정")
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

}
