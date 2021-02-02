package com.pair.nkweb.service;

import com.pair.nkweb.requestvo.RequestVO;
import com.pair.nkweb.responsevo.BasicVO;

public interface UserService {

    public BasicVO registUser(RequestVO vo);
    public BasicVO modifyUser(RequestVO vo);

    public BasicVO loginUser(RequestVO vo);

    public BasicVO selectUser(RequestVO vo);

}
