<%@page import="kr.co.sist.exam.domain.Union"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	MyBatisService1 mbs1 = new MyBatisService1();
	List<Union> list =  mbs1.union();
	pageContext.setAttribute("empList", list);
%>
<table style="border:1px solid #ccc; border-spacing: 0">
	<tr>
		<th width="60">사원번호</th>
		<th width="120">사원명</th>
		<th width="120">직무</th>
		<th width="80">연봉</th>
		<th width="150">입사일</th>
		<th width="100">부서번호</th>
		<th width="100">퇴사여부</th>
	</tr>
	<c:if test="${ empty empList }">
		<tr>
			<td align="center" colspan="7">사원이 존재하지 않습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="emp" items="${ empList }">
		<tr>
			<td align="center"><c:out value="${ emp.empno }" /></td>
			<td align="center"><c:out value="${ emp.ename }" /></td>
			<td align="center"><c:out value="${ emp.job }" /></td>
			<td align="center"><c:out value="${ emp.sal }" /></td>
			<td align="center"><c:out value="${ emp.hiredate }" /></td>
			<td align="center"><c:out value="${ emp.deptno }" /></td>
			<td align="center"><c:out value="${ emp.retired eq 'N'?'재작자':'퇴사자' }" /></td>
		</tr>
	</c:forEach> 
</table>