package kino.spring.test.model;

import java.io.Serializable;

/**
 * 
 * 用户<br/>
 *
 * @author 肖晓峰
 * @date: 2016年4月19日 下午7:48:15
 * @version 1.0
 * @since JDK 1.7
 */
public class User implements Serializable{

	/** 
	 * 序列化. 
	 */  
	private static final long serialVersionUID = 2555885430222209701L;
	
	/**
	 * id
	 */
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 头像
	 */
	private String headImg;
	/**
	 * 背景图
	 */
	private String backgroundImg;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getBackgroundImg() {
		return backgroundImg;
	}
	public void setBackgroundImg(String backgroundImg) {
		this.backgroundImg = backgroundImg;
	}

}
