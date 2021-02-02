package com.pair.nkweb.comm;

import com.pair.nkweb.responsevo.BasicVO;
import com.pair.nkweb.responsevo.ResponseVO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

public class Utils {

    public static boolean checkNull(String check) {
        return StringUtils.isEmpty(check);
    }

    public static BasicVO basicBuilder(String result, String messege, ArrayList<ResponseVO> data){

        return BasicVO.builder()
                .result(result)
                .message(messege)
                .data(data)
                .build();
    }
}
