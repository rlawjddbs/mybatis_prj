package kr.co.sist.exam.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.exam.domain.DeptInfo;
import kr.co.sist.exam.domain.Emp;

public class MyBatisDAO {

	private static MyBatisDAO mb_dao;
	private SqlSessionFactory ssf = null;
	
	private MyBatisDAO() {
	} // MyBatisDAO
	
	public static MyBatisDAO getInstance() {
		if(mb_dao == null) {
			mb_dao = new MyBatisDAO();
		} // end if
		return mb_dao;
	} // getInstance
	
	public synchronized SqlSessionFactory getSessionFactory() {
		if(ssf == null) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
			
			Reader reader = null;
			try {
				// 1. ������ xml �ε�
				reader = Resources.getResourceAsReader("kr/co/sist/exam/dao/mybatis_config.xml");
				// 2. MyBatis Framework ����
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				// 3. DB�� ������ ��ü �ޱ�
				ssf = ssfb.build(reader);
				if( reader != null ) {
					reader.close();
				} // end if
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end if
		return ssf;
	} // getSessionFactory
	
	public String singleColumn() {
		// MyBatis Handler�� ����Ͽ� Mapper(xml)�� �ִ� ID���� ã�� Parsing �Ͽ�
		// ��ȸ�� ����� ��´�.
		String dname="";
		SqlSession ss = getSessionFactory().openSession();
		dname = ss.selectOne("singleColumn");
		ss.close();
		return dname;
	} // singleColumn
	
	public DeptInfo multiColumn() {
		DeptInfo di = null;
		
//		MyBatisDAO mb_dao = MyBatisDAO.mb_dao;
		SqlSession ss = mb_dao.getSessionFactory().openSession();
		
		di=ss.selectOne("multiColumn");
		ss.close();
		
		return di;
	} // DeptInfo
	
	public List<Integer> MultiRow(){
		List<Integer> list = null;
		
		SqlSession ss = mb_dao.getSessionFactory().openSession();
		list = ss.selectList("multiRow");
		ss.close(); // ss�� �������� ������ memory ������ �߻��� �� �ִ�.
		
		return list;
	} // multiRow
	
	public List<Emp> multiColumnRow(int deptno){
		List<Emp> list = null;

		// 4. Handler ���
		SqlSession ss = getSessionFactory().openSession();
		
		// 5. mapper���� ������ �����ϴ� ID�� ã�� ����
		list = ss.selectList("multiColumnRow", deptno);
		
		ss.close();
		return list;
	} // multiColumnRow
	
	public static void main(String[] args) {
		MyBatisDAO mb_dao = MyBatisDAO.getInstance();
//		System.out.println(mb_dao.getSessionFactory());
//		System.out.println(mb_dao.singleColumn());
//		System.out.println(mb_dao.multiColumn());
		System.out.println(mb_dao.multiColumnRow(40));
	} // main
	
} // class
