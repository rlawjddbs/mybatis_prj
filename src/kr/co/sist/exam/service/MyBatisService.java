package kr.co.sist.exam.service;

import java.util.List;

import kr.co.sist.exam.dao.MyBatisDAO;
import kr.co.sist.exam.domain.DeptInfo;
import kr.co.sist.exam.domain.Emp;

public class MyBatisService {
	public String deptName() {
		MyBatisDAO mb_dao = MyBatisDAO.getInstance();
		String dname = mb_dao.singleColumn()+"부서";
		return dname;
	} // deptName
	/**
	 * 컬럼 여러개 레코드 하나
	 * @return
	 */
	public DeptInfo deptInfo() {
		MyBatisDAO mb_dao = MyBatisDAO.getInstance();
		DeptInfo di = mb_dao.multiColumn();
		return di;
	} // deptName
	public List<Integer> multiRow(){
		List<Integer> list = null;
		MyBatisDAO mb_dao = MyBatisDAO.getInstance();
		list = mb_dao.MultiRow(); 
		return list;
	} // multiRow
		
	public List<Emp> multiColumnRow(int deptno){
		List<Emp> list = null;
		
		MyBatisDAO mb_dao = MyBatisDAO.getInstance();
		
		list = mb_dao.multiColumnRow(deptno);
		
		return list;
	} // multiColumnRow
	
} // class
