package com.pair.nkweb.log;


import com.pair.nkweb.requestvo.RequestVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SqlExceptionLog {

	private Exception e;
	private RequestVO vo;
	
	public SqlExceptionLog(Exception e, RequestVO vo) {
		this.e = e;
		this.vo = vo;
	}
	
	
	public SqlExceptionLog(Exception e) {
		this.e = e;
	}
	
	public void logging() {
		log.error("Exception while executing method below - ");
		log.error("[" + e.toString() + "]");
		log.error("[" + vo.toString() + "]");
		log.error("Exception message - " + e.getMessage());
		log.error("Full stack trace logged further below");
		
	}
	
	
	public void loggingOne() {
		log.error("Exception while executing method below - ");
		log.error("[" + e.toString() + "]");
		log.error("Exception message - " + e.getMessage());
		log.error("Full stack trace logged further below");
	}
	
}
