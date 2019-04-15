<%@page import="kr.co.sist.exam.domain.Demp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.vo.TnameVO"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="main.jsp" method="get">
	<input type="hidden" name="page" value="day0409/dynamic_table" />
	<input type="radio" name="tname" value="cp_emp2" checked="checked" /> 한국본사
	<input type="radio" name="tname" value="emp" /> 미국지사
	<input type="submit" value="조회" class="btn" />
</form>
<%
	String tname=request.getParameter("tname");
	if( tname != null ){
		MyBatisService1 mbs = new MyBatisService1();
		List<Demp> list = mbs.dynamicTable(new TnameVO(tname));
		pageContext.setAttribute("empList", list);
	} // end if
%>

	<c:if test="${ not empty param.tname }">
		<table style="border:1px solid #ccc; border-spacing:0">
			<tr>
				<th colspan="4">
					[<c:out value="${ param.tname eq 'emp'?'미국지사':'한국본사'}" />]의 사원정보 조회 결과
				</th>
			</tr>
			<c:if test="${ empty empList }">
				<tr>
					<td colspan="4" style="text-align:center">
						사원이 존재하지 않습니다.
					</td>
				</tr>
			</c:if>
			<tr>
				<th width="80">사원번호</th>
				<th width="120">사원명</th>
				<th width="80">연봉</th>
				<th width="150">입사일</th>
			</tr>
			<c:forEach var="emp" items="${ empList }">
				<tr align="center">
					<td><c:out value="${ emp.empno }" /></td>
					<td><c:out value="${ emp.ename }" /></td>
					<td><c:out value="${ emp.sal }" /></td>
					<td><c:out value="${ emp.hiredate }" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>