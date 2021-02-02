package com.pair.nkweb.vo;

import com.pair.nkweb.responsevo.ResponseVO;
import lombok.Data;

@Data
public class IvInfoVO extends ResponseVO {
    private String base_ymd;
    private String iv_no;
    private String pk_nm;
    private String dv_nm;
    private String dv_tel1;
    private String iv_st_cd;
    private String iv_st_nm;

}
