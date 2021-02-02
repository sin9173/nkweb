package com.pair.nkweb.vo;

import com.pair.nkweb.responsevo.ResponseVO;
import lombok.Data;

@Data
public class UserVO extends ResponseVO {
    private String user_id;
    private String user_pw;
    private String trade_cd;
    private String trade_nm;
    private String tradesub_cd;
    private String tradesub_nm;
}
