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
	private char isDel;
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
	// 작성일 출력방식 수정
	public String getRegisterDate() {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// SimpleDateFormat을 통해서 날짜 및 시간의 출력 서식을 변경
		return transFormat.format(registerDate);//날짜데이터를 return함
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
	// 작성일 출력 방식 수정 끝
	public Date getDelDate() {
		return delDate;
	}
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
	public char getIsDel() {
		return isDel;
	}
	public void setIsDel(char isDel) {
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
	// 파일
	public String getOriFile() {
		int index = file.indexOf("_");
		return file.substring(index+1);
	}
	

	
}
