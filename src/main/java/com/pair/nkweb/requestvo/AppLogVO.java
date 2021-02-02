package com.pair.nkweb.requestvo;

import lombok.Data;

import java.util.List;

@Data
public class AppLogVO {

	public String phone;
	public String date;
	public List<AppReVO> data;
	
}
