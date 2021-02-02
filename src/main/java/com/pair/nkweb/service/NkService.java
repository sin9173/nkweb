package com.pair.nkweb.service;


import com.pair.nkweb.requestvo.RequestVO;
import com.pair.nkweb.responsevo.BasicVO;
import com.pair.nkweb.vo.IvInfoVO;

import java.util.ArrayList;

public interface NkService {

    public BasicVO ivInfoList(RequestVO vo);
    public BasicVO memoList(RequestVO vo);
    public BasicVO insertMemo(ArrayList<RequestVO> vos);
    public BasicVO modifyMemo(RequestVO vo);

}
