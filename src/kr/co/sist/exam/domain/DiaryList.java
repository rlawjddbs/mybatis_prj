package kr.co.sist.exam.domain;

public class DiaryList {
	
	// 프레임웍이 생성해주는 클래스는 생성자를 굳이 만들지 않아도 프레임웍이 알아서 만들어주므로
	// 게터와 세터 method만 만들어준다.
	
	private int num;
	private String subject, writer, evt_date, w_date;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEvt_date() {
		return evt_date;
	}
	public void setEvt_date(String evt_date) {
		this.evt_date = evt_date;
	}
	public String getW_date() {
		return w_date;
	}
	public void setW_date(String w_date) {
		this.w_date = w_date;
	}
	
} // class
