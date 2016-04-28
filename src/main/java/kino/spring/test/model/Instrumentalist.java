package kino.spring.test.model;

import java.io.Serializable;

/**
 * 
 *演奏家<br/>
 *
 * @author 肖晓峰
 * @date: 2016年4月22日 下午4:03:34
 * @version 1.0
 * @since JDK 1.7
 */
public class Instrumentalist implements Serializable{

	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */  
	private static final long serialVersionUID = -731982754679974827L;
	
	/**
	 * 歌曲
	 */
	private String song;
	
	/**
	 * 演奏乐器
	 */
	private String instrument;

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

}
