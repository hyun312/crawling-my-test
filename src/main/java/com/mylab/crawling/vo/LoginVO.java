package com.mylab.crawling.vo;

/**
 * 
 * <PRE>
 *  ClassName : UpdateRequestVO 
 * </PRE>
 * @version : 1.0
 * @date    : 2019. 6. 11. 오후 1:41:16
 * @author  : HJY
 * @brief   :
 */
public class LoginVO {
	
	private String id;
	
	private String pw;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "LoginVO [id=" + id + "]";
	}
	
	
}
