package com.pair.nkweb.mappers;

import com.pair.nkweb.requestvo.RequestVO;
import com.pair.nkweb.vo.IvInfoVO;
import com.pair.nkweb.vo.MemoVO;

import java.util.ArrayList;

public interface NkMapper {
    public ArrayList<IvInfoVO> ivInfoList(RequestVO vo);
    public ArrayList<MemoVO> MemoInfoList(RequestVO vo);
    public int insertMemo(RequestVO vo);
    public int modifyMemo(RequestVO vo);
}
