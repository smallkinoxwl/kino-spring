package kino.spring.test.model;

import java.io.Serializable;

/**
 * 
 * 魔术师<br/>
 *
 * @author 肖晓峰
 * @date: 2016年4月27日 上午10:27:16
 * @version 1.0
 * @since JDK 1.7
 */
public class Magician implements Serializable{
	
	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */  
	private static final long serialVersionUID = -3565514355245089791L;

	/**
	 * 魔术盒
	 */
	private MagicBox magicBox;
	
	/**
	 * 魔法咒语
	 */
	private String magicWords = "bilibili BOOM!";
	
	public void execute(){
		System.out.println(magicWords);
		System.out.println("The Maxbox contains ....");
		System.out.println(magicBox.getContext());
	}

	public MagicBox getMagicBox() {
		return magicBox;
	}

	public void setMagicBox(MagicBox magicBox) {
		this.magicBox = magicBox;
	}

	public String getMagicWords() {
		return magicWords;
	}

	public void setMagicWords(String magicWords) {
		this.magicWords = magicWords;
	}
	
}
