package kr.green.springz.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BoardVo {
	private int num;
	private String writer;
	private String title;
	private String content;
	private Date registerDate;
	private Date delDate;
	private String isDel;
	private int views;
	private int up;
	private String file;	
	
	
	//get&set
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegisterDate() {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return transFormat.format(registerDate);
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public void setRegisterDate(String registerDate) {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				this.registerDate = transFormat.parse(registerDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

	}
	public Date getDelDate() {
		return delDate;
	}
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	//tostring
	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", registerDate=" + registerDate + ", delDate=" + delDate + ", isDel=" + isDel + ", views=" + views
				+ ", up=" + up + ", file=" + file + "]";
	}
	

	
}
