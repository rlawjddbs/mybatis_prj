package kr.co.sist.exam.vo;

import java.util.List;

import kr.co.sist.exam.domain.EmpProcedure;

public class CursorVO {
	private int deptno; // ��ȸ�� �μ� ��ȣ - ����ڰ� �Է��ϴ� ��
	private List<EmpProcedure> empnoList; // CURSOR�� ��ȸ�� �� - MyBatis�� �Է��� ��

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
