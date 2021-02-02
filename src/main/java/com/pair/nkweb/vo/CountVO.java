package com.pair.nkweb.vo;

import com.pair.nkweb.responsevo.ResponseVO;
import lombok.Data;

import java.util.ArrayList;

@Data
public class CountVO extends ResponseVO {

    int count;
    int fail;
    ArrayList<String> fail_list;
}
