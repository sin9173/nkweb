package com.pair.nkweb.responsevo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BasicVO {

	public String result;
	public String message;

	public List<com.pair.nkweb.responsevo.ResponseVO> data;
	
}
