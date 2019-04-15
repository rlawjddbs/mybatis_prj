package day0403;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UseMyBatis {

	public UseMyBatis() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	} // UseMyBatis

	public SqlSessionFactory getSessionFactory() throws IOException {
		// 1. 환경설정 xml에 stream 연결
		Reader reader = Resources.getResourceAsReader("day0403/mybatis_config.xml");
		// 2. MyBatis Framework 생성
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		// 3. MyBatis Framework과 DB연동한 객체 얻기 (객체를 하나로 관리)
		SqlSessionFactory ssf = ssfb.build(reader);
//		System.out.println( ssf );

		// 환경 설정 xml에 연결된 stream 끊기
		if (reader != null) {
			reader.close();
		} // end if

		return ssf;
	} // getSessionFactory

	public void insertCpDept(DeptVO dv) throws IOException, SQLException {
		// 4. MyBatis Handler 얻기
		SqlSession ss = getSessionFactory().openSession();
		// 5. Handler를 사용하여 DB작업 수행
		int cnt = ss.insert("insertCpDept", dv);
		ss.commit();
		System.out.println("추가 작업" + cnt);
	} // insertCpDept

	public void selectAllDept() throws IOException {
		// 4. MyBatis Handler 얻기
		SqlSession ss = getSessionFactory().openSession();
		// 5. Handler를 사용하여 DB 작업 수행
		List<DeptDomain> list = ss.selectList("kr.co.sist.selectAllDept");
		DeptDomain dd = null;
		for (int i = 0; i < list.size(); i++) {
			dd = list.get(i);
			System.out.println(dd.getDeptno() + " / " + dd.getDname() + " / " + dd.getLoc());
		} // end for

		// 6. 사용이 종료된 SqlSession을 닫는다.
		ss.close();
	} // selectAllDept

	public void updateCpDept(DeptVO dv) throws IOException, SQLException {
		// 4. MyBatis Handler 얻기
		SqlSession ss = getSessionFactory().openSession();
		// 5. Handler를 사용하여 DB 작업 수행
		int cnt = ss.update("updateCpDept", dv);
		ss.commit();
		System.out.println("변경 성공" + cnt);
	} // updateCpDept

	public void deleteCpDept(int deptno) throws IOException, SQLException {
		// 4. MyBatis Handler 얻기
		SqlSession ss = getSessionFactory().openSession();
		// 5. Handler를 사용하여 DB 작업 수행
		int cnt = ss.update("deleteCpDept", deptno);
		ss.commit();
		if (cnt == 1) {
			System.out.println(deptno + "번 부서 정보를 삭제 하였습니다.");
		} else {
			System.out.println(deptno + "번 부서는 존재하지 않습니다.");
		} // end else

	} // deleteCpDept

	public static void main(String[] args) {
		UseMyBatis umb = new UseMyBatis();
		try {
			DeptVO dv = new DeptVO(11, "SM개발", "원주");
//			umb.insertCpDept(dv);
//			umb.updateCpDept(dv);
			umb.deleteCpDept(11);
			umb.selectAllDept();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
	} // main

} // UseMyBatis
