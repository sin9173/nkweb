package com.pair.nkweb.vo;

import com.pair.nkweb.responsevo.ResponseVO;
import lombok.Data;

@Data
public class NoticeVO extends ResponseVO {
    private String idx;
    private String user_id;
    private String title;
    private String content;
    private String update_date;
    private String del_it;
}
