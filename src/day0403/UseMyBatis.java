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
		// 1. ȯ�漳�� xml�� stream ����
		Reader reader = Resources.getResourceAsReader("day0403/mybatis_config.xml");
		// 2. MyBatis Framework ����
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		// 3. MyBatis Framework�� DB������ ��ü ��� (��ü�� �ϳ��� ����)
		SqlSessionFactory ssf = ssfb.build(reader);
//		System.out.println( ssf );

		// ȯ�� ���� xml�� ����� stream ����
		if (reader != null) {
			reader.close();
		} // end if

		return ssf;
	} // getSessionFactory

	public void insertCpDept(DeptVO dv) throws IOException, SQLException {
		// 4. MyBatis Handler ���
		SqlSession ss = getSessionFactory().openSession();
		// 5. Handler�� ����Ͽ� DB�۾� ����
		int cnt = ss.insert("insertCpDept", dv);
		ss.commit();
		System.out.println("�߰� �۾�" + cnt);
	} // insertCpDept

	public void selectAllDept() throws IOException {
		// 4. MyBatis Handler ���
		SqlSession ss = getSessionFactory().openSession();
		// 5. Handler�� ����Ͽ� DB �۾� ����
		List<DeptDomain> list = ss.selectList("kr.co.sist.selectAllDept");
		DeptDomain dd = null;
		for (int i = 0; i < list.size(); i++) {
			dd = list.get(i);
			System.out.println(dd.getDeptno() + " / " + dd.getDname() + " / " + dd.getLoc());
		} // end for

		// 6. ����� ����� SqlSession�� �ݴ´�.
		ss.close();
	} // selectAllDept

	public void updateCpDept(DeptVO dv) throws IOException, SQLException {
		// 4. MyBatis Handler ���
		SqlSession ss = getSessionFactory().openSession();
		// 5. Handler�� ����Ͽ� DB �۾� ����
		int cnt = ss.update("updateCpDept", dv);
		ss.commit();
		System.out.println("���� ����" + cnt);
	} // updateCpDept

	public void deleteCpDept(int deptno) throws IOException, SQLException {
		// 4. MyBatis Handler ���
		SqlSession ss = getSessionFactory().openSession();
		// 5. Handler�� ����Ͽ� DB �۾� ����
		int cnt = ss.update("deleteCpDept", deptno);
		ss.commit();
		if (cnt == 1) {
			System.out.println(deptno + "�� �μ� ������ ���� �Ͽ����ϴ�.");
		} else {
			System.out.println(deptno + "�� �μ��� �������� �ʽ��ϴ�.");
		} // end else

	} // deleteCpDept

	public static void main(String[] args) {
		UseMyBatis umb = new UseMyBatis();
		try {
			DeptVO dv = new DeptVO(11, "SM����", "����");
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
