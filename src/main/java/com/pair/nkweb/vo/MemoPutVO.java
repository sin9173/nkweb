package com.pair.nkweb.vo;

import com.pair.nkweb.responsevo.ResponseVO;
import lombok.Data;

@Data
public class MemoPutVO extends ResponseVO {
    private String login_id;
    private String reg_id;
    private String mode_it;
    private String emp_cd;
    private String iv_no;
    private String iv_no_seq;
    private String memo_desc;
}
