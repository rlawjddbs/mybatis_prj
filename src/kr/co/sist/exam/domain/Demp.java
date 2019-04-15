package kr.co.sist.exam.domain;

/**
 *	테이블명이 동적으로 입력될 때 반환되는 조회 결과물 Demp(Dynamic Emp의 줄임말)
 * @author owner
 */
public class Demp {
	private int empno, sal;
	private String ename, hiredate;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	
}
