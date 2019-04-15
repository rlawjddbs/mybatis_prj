package kr.co.sist.exam.dao;

import java.util.ArrayList;
import java.util.List;import javax.servlet.FilterRegistration.Dynamic;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.Car;
import kr.co.sist.exam.domain.CarDomain;
import kr.co.sist.exam.domain.Demp;
import kr.co.sist.exam.domain.DiaryList;
import kr.co.sist.exam.domain.DynamicIf;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.EmpJoin;
import kr.co.sist.exam.domain.EmpProcedure;
import kr.co.sist.exam.domain.Union;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.CarVO;
import kr.co.sist.exam.vo.CarVO1;
import kr.co.sist.exam.vo.CursorVO;
import kr.co.sist.exam.vo.DeptnoVO;
import kr.co.sist.exam.vo.DiaryListParamVO;
import kr.co.sist.exam.vo.EmpVO;
import kr.co.sist.exam.vo.TestProcVO;
import kr.co.sist.exam.vo.TnameVO;
import kr.co.sist.exam.vo.TransactionVO;

public class MyBatisDAO1 {

	public List<Emp> multiParam(EmpVO ev){
		List<Emp> list = null;
		
		// 4. Handler ¾ò±â
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list = ss.selectList("multiParam", ev);
		
		ss.close();
		return list;
	} // multiParam

	public List<Emp> lessThan(int sal){
		List<Emp> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("lessThan", sal);
		ss.close();
		return list;
	} // lessThan
	
	public List<Emp> greaterThan(int sal){
		List<Emp> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("greaterThan", sal);
		ss.close();
		return list;
	} // greaterThan
	
	public List<Zipcode> like(String dong){
		List<Zipcode> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("like", dong);
		ss.close();
		return list;
		
	} // like
	
	public int diaryTotalCount() {
		int cnt = 0;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		cnt = ss.selectOne("diaryCnt");
		
		return cnt;
	} // diaryTotalCount
	
	public List<DiaryList> subquery(DiaryListParamVO dlpvo){
		List<DiaryList> list = null;

		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("subquery", dlpvo);
		
		return list;
	} // subquery
	
	public List<Union> union(){
		List<Union> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("union");
		
		return list;
	} // union
	
	public List<EmpJoin> join(int mgr){
		List<EmpJoin> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("join", mgr);
		
		return list;
	} // join
	
	public List<Car> joinSubquery(){
		List<Car> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("joinSubquery");
		
		return list;
	} // joinSubQuery
	
	public List<Demp> dynamicTable(TnameVO tvo){
		List<Demp> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("dtable", tvo);
		
		return list;
	} // dynamicTable
	
	public List<DynamicIf> dynamicIf(DeptnoVO dvo){
		List<DynamicIf> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("dynamicIf", dvo);
		
		return list;
	} // dynamicIf
	
	public List<String> carCountry(String country){
		List<String> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("carCountry", country);
		
		return list;
	} // carCountry
	
	public List<String> carMaker(String maker){
		List<String> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("carMaker", maker);
		
		return list;
	} // carCountry

	public List<String> carModel(String model){
		List<String> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("carMaker", model);
		
		return list;
	} // carCountry
	
	public List<CarDomain> carModel(CarVO cvo){
		List<CarDomain> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("carInform", cvo);
		
		return list;
	} // carCountry

	public List<DynamicIf> dynamicChoose(DeptnoVO dvo){
		List<DynamicIf> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("kr.co.sist.exam2.dynamicChoose", dvo);
		
		return list;
	} // carCountry
	
	public List<Car> dynamicForeach(CarVO1 cv){
		List<Car> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		list = ss.selectList("kr.co.sist.exam2.dynamicForeach", cv);
		
		return list;
	} // dynamicIf
	
	public TestProcVO insertProc(TestProcVO tpvo) {
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		System.out.println(tpvo.getMsg());
		ss.selectOne("insertProcedure", tpvo);	
		System.out.println(tpvo.getMsg());
		return tpvo;
	} // insertProc
	
	
	public void selectProc(CursorVO cvo) {
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		ss.selectOne("selectProcedure", cvo);
	} // insertProc
	
	public int  insertTansaction(TransactionVO tvo) {
		int cnt=0, cnt1=0;
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		cnt = ss.insert("tr1", tvo);
		cnt1 = ss.insert("tr2", tvo);
		
		if(cnt + cnt1 == 2) {
			ss.commit();
		} // end if
		
		return cnt+cnt1;
	} // insertTransaction
	
	
	public static void main(String[] args) {
		MyBatisDAO1 md = new MyBatisDAO1();
//		md.multiParam(new EmpVO(30, "SALESMAN"));
//		md.lessThan(3000);
//		md.greaterThan(3000);
//		md.like("»óÀÎµ¿");
//		md.diaryTotalCount();
//		md.union();
//		md.join(7698);
//		md.joinSubquery();
//		md.dynamicTable(new TnameVO("emp"));
//		md.dynamicIf(new DeptnoVO(19));
//		md.carCountry("¼öÀÔ");
//		md.carMaker("Çö´ë");
//		md.carModel(new CarVO("±¹»ê", "Çö´ë", "¾Æ¹ÝÅ×"));
//		md.dynamicChoose(new DeptnoVO(11));
//		List<String> list = new ArrayList<String>();
//		list.add("Çö´ë");
//		list.add("±â¾Æ");
//		list.add("BMW");
//		list.add("»ï¼º");
//		md.dynamicForeach(new CarVO1(list));
//		TestProcVO tpvo = new TestProcVO(1111, 3000, 0, "±èÈñÃ¶", "´ë¸®", "");
//		md.insertProc(tpvo);
//		CursorVO c_vo = new CursorVO();
//		c_vo.setDeptno(10);
//		md.selectProc(c_vo);
//		System.out.println(c_vo.getEmpnoList());
		
		TransactionVO tv = new TransactionVO("¿À´ÃÀº ¾îÂ¾Áö ÁÁÀº ¸ñ¿äÀÏ", "±èÁ¤À±");
		
		System.out.println(md.insertTansaction(tv));
	} // main 
	
} // class
