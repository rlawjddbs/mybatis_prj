package kr.co.sist.exam.dao;

import java.util.List;import javax.servlet.FilterRegistration.Dynamic;

import org.apache.ibatis.session.SqlSession;

import kr.co.sist.exam.domain.Car;
import kr.co.sist.exam.domain.CarDomain;
import kr.co.sist.exam.domain.CarModel;
import kr.co.sist.exam.domain.Demp;
import kr.co.sist.exam.domain.DiaryList;
import kr.co.sist.exam.domain.DynamicIf;
import kr.co.sist.exam.domain.Emp;
import kr.co.sist.exam.domain.EmpJoin;
import kr.co.sist.exam.domain.Union;
import kr.co.sist.exam.domain.Zipcode;
import kr.co.sist.exam.vo.CarVO;
import kr.co.sist.exam.vo.DeptnoVO;
import kr.co.sist.exam.vo.DiaryListParamVO;
import kr.co.sist.exam.vo.EmpVO;
import kr.co.sist.exam.vo.TnameVO;

public class CarDAO {

	public List<String> selectMaker(String country){
		List<String> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list = ss.selectList("selectCarCountry", country);
		
		return list;
	} // selectMaker
	
	public List<String> selectModel(String maker){
		List<String> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list = ss.selectList("selectCarMaker", maker);
		
		return list;
	} // selectMaker
	
	public List<CarModel> selectDetailModel(String model){
		List<CarModel> list = null;
		
		SqlSession ss = MyBatisDAO.getInstance().getSessionFactory().openSession();
		
		list = ss.selectList("selectCarModel", model);
		
		return list;
	} // selectMaker
	
	public static void main(String[] args) {
		CarDAO md = new CarDAO();
		md.selectDetailModel("╬ф╧щев");
	} // main 
	
} // class
