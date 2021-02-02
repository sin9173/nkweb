package com.pair.nkweb.vo;

import com.pair.nkweb.responsevo.ResponseVO;
import lombok.Data;

@Data
public class MemoVO extends ResponseVO {
    private String iv_no;
    private String iv_no_seq;
    private String reg_ymd;
    private String trade_nm;
    private String emp_cd;
    private String emp_nm;
    private String memo_desc;
    private byte[] memo_desc_bt;
}
