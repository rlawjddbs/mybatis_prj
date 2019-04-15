<%@page import="kr.co.sist.exam.domain.Car"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	MyBatisService1 mbs = new MyBatisService1();
	List<Car> list = mbs.joinSubquery();
	pageContext.setAttribute("carList", list);
%>
<table style="border:1px solid #ccc; border-spacing:0; margin:10px auto;">
	<tr style="border-bottom:1px solid #333">
		<th width="80">이미지</th>
		<th width="400">차량정보</th>
		<th width="150">등록일</th>
	</tr>
	<c:if test="${ empty carList }">
		<tr>
			<td colspan="3">차량정보가 존재하지 않습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="carList" items="${ carList }">
		<tr>
			<td align="center">
				<img src="http://localhost:8080/mybatis_prj/day0409/images/${carList.img}" style="width:80px; height:60px" />
			</td>
			<td style="padding:10px 40px; box-sizing:border-box">
				<div>
					<strong><c:out value="${ carList.maker }" />사 <c:out value="${ carList.model}" /></strong> 
				</div>
				<div>
					<c:out value="${ carList.carYear }" />년식 <c:out value="${ carList.price }" />만원
				</div>
				<div>
					<c:out value="${ carList.carOption }" />
				</div>
			</td>
			<td align="center"><c:out value="${ carList.hiredate}" /></td>
		</tr>
	</c:forEach>
</table>