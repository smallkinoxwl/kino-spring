package kino.spring.test.model;

import java.io.Serializable;

/**
 * 
 * Description: 接口返回规范容器<br/>
 *
 * @author 肖晓峰
 * @date: 2016年5月14日 下午10:43:35
 * @version 1.0
 * @since JDK 1.7
 */
public class DataResult implements Serializable {
	
	/** 
	 * serialVersionUID:序列化. 
	 */  
	private static final long serialVersionUID = -8776767076054198614L;

	/**
	 * true 成功 false 失败
	 */
	private Boolean success;
	
	/**
	 * 数据
	 */
	private Object data;
	
	/**
	 * 消息
	 */
	private String message;

	public DataResult(){};
	
	public DataResult(Boolean success, Object data, String message) {
		super();
		this.success = success;
		this.data = data;
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
