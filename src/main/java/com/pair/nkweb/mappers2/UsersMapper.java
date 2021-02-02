package com.pair.nkweb.mappers2;

import com.pair.nkweb.requestvo.RequestVO;
import com.pair.nkweb.vo.UserVO;

public interface UsersMapper {
    public int regUser(RequestVO vo);
    public int modUser(RequestVO vo);

    public UserVO loginUser(RequestVO vo);
}
