package kr.co.sist.exam.vo;

public class DiaryListParamVO {

	private int startNum, endNum;

	public DiaryListParamVO() {
		super();
	}

	public DiaryListParamVO(int startNum, int endNum) {
		super();
		this.startNum = startNum;
		this.endNum = endNum;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	
} // class
