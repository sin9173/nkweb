package com.pair.nkweb.requestvo;

import lombok.Data;

/**
 * request 정보 모두 모음
 */
@Data
public class RequestVO {

    private String api;

    private String base_ymd_front;
    private String base_ymd_rear;

    private String iv_no;
    private String pk_nm;
    private String dv_nm;
    private String dv_tel1;
    private String iv_st_cd;

    private String login_id;
    private String memo_desc;
    private String emp_cd;
    private String iv_no_seq;


    //user
    private String user_id;
    private String user_pw;
    private String trade_cd;
    private String trade_nm;
    private String tradesub_cd;
    private String tradesub_nm;



    //Board
    private String idx;
    private String title;
    private String content;


}
