package kr.co.sist.exam.vo;

import java.util.List;

import kr.co.sist.exam.domain.EmpProcedure;

public class CursorVO {
	private int deptno; // 조회할 부서 번호 - 사용자가 입력하는 값
	private List<EmpProcedure> empnoList; // CURSOR로 조회한 값 - MyBatis가 입력한 값

	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public List<EmpProcedure> getEmpnoList() {
		return empnoList;
	}
	public void setEmpnoList(List<EmpProcedure> empnoList) {
		this.empnoList = empnoList;
	}
	
} // class
