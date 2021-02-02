package com.pair.nkweb.mappers2;

import com.pair.nkweb.requestvo.RequestVO;
import com.pair.nkweb.vo.NoticeVO;

import java.util.ArrayList;

public interface NoticeMapper {

    public int insertNotice(RequestVO vo);
    public int updateNotice(RequestVO vo);
    public int deleteNotice(RequestVO vo);

    public ArrayList<NoticeVO> getNoticeList();
    public NoticeVO noticeRead(RequestVO vo);
}
