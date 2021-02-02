package com.pair.nkweb.vo;

import com.pair.nkweb.responsevo.ResponseVO;
import lombok.Data;

@Data
public class BarcodeVO extends ResponseVO {
    private String iv_no;
    private String scan_ymd;
    private String scan_trade_nm;
    private String scan_emp_nm;
    private String scan_emp_tel;
    private String scan_nm;
}
