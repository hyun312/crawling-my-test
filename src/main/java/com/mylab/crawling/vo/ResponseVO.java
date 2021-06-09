package com.mylab.crawling.vo;


public class ResponseVO {

	private String resCd;
	
	private String resMsg;
	
	private String retUrl;
	
	private Object data;
	
	public ResponseVO(){
		this.resCd = "999";
	}
	
	public ResponseVO ok(){
		this.resCd = "000";
		this.resMsg = "성공 하였습니다.";
		return this;
	}
	
	public ResponseVO error(String resCd, String resMsg){
		this.resCd = resCd;
		this.resMsg = resMsg;
		return this;
	}

	public String getResCd() {
		return resCd;
	}

	public void setResCd(String resCd) {
		this.resCd = resCd;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public String getRetUrl() {
		return retUrl;
	}

	public void setRetUrl(String retUrl) {
		this.retUrl = retUrl;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
