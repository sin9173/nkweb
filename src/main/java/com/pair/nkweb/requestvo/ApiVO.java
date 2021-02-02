package com.pair.nkweb.requestvo;

import lombok.Data;

import java.util.List;

@Data
public class ApiVO {

	public String api;
	public List<RequestVO> data;
	
}
