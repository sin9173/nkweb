package com.pair.nkweb.service;


import com.pair.nkweb.requestvo.RequestVO;
import com.pair.nkweb.responsevo.BasicVO;

public interface NoticeService {
    public BasicVO writeNotice(RequestVO vo);
    public BasicVO modifyNotice(RequestVO vo);
    public BasicVO deleteNotice(RequestVO vo);


    public BasicVO getNoticeList(RequestVO vo);
    public BasicVO noticeRead(RequestVO vo);

}
