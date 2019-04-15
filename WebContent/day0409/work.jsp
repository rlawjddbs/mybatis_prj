<%@page import="kr.co.sist.exam.domain.CarDomain"%>
<%@page import="kr.co.sist.exam.vo.CarVO"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String country = request.getParameter("country");
	String maker = request.getParameter("maker");
	String model = request.getParameter("model");
	
	String brandCountry = "";
	if( country != null ){
		MyBatisService1 mbs = new MyBatisService1();
		
		brandCountry = "domestic".equals(country)?"국산":"수입";
		List<String> list = mbs.carCountry(brandCountry);
		pageContext.setAttribute("makerList", list);
		
	} // end if

	if( maker != null ){
		MyBatisService1 mbs = new MyBatisService1();
		
		List<String> list = mbs.carMaker(maker);
		
		pageContext.setAttribute("modelList", list);
	} // end if
	
	if( country != null && maker != null && model != null){
		MyBatisService1 mbs = new MyBatisService1();
		
		brandCountry = "domestic".equals(country)?"국산":"수입";
		List<CarDomain> list = mbs.carModel(new CarVO(brandCountry, maker, model));
		pageContext.setAttribute("carInform", list);
	} // end if
	
%>

<script type="text/javascript">
	window.onload = function(){
		var obj = document.frm;
		var country = obj.country;
		var maker = obj.maker;
		
		country.addEventListener("change", function(){
			var value = country.value;
			
			if(value == "domestic" || value == "income"){
				obj.submit();
			} // end if
		});
		
		maker.addEventListener("change", function(){
			obj.submit();
		});
		
	} // onload function
</script>
<form name="frm" method="get" action="main.jsp">
	<input type="hidden" name="page" value="day0409/work"/>
	<select name="country">
		<option value="domestic" ${ param.country eq 'domestic'?'selected="selectd"':'' }>국산</option>
		<option value="income" ${ param.country eq 'income'?'selected="selectd"':'' }>수입</option>
	</select>
	<select name="maker">
		<c:if test="${ empty country }">
			<option>---제조국을 선택하세요.---</option>
		</c:if>
		<c:forEach var="brand" items="${ makerList }">
			<option value="${ brand }" ${ brand eq param.maker?'selected="selectd"':'' }><c:out value="${ brand }" /></option>
		</c:forEach>
	</select>
	
	<select name="model">
		<c:if test="${ empty maker }">
			<option>---제조사를 선택하세요---</option>
		</c:if>
		<c:forEach var="model" items="${ modelList }">
			<option value="${ model }" ${ model eq param.model?'selected="selectd"':''}><c:out value="${ model }" /></option>
		</c:forEach>
	</select>
	<input type="submit" value="조회" />
</form>
<table border="1" cellspacing="0">
		<tr>
			<th width="120">이미지</th>	
			<th width="800">옵션</th>	
			<th width="120">연식</th>	
		</tr>	
		<c:if test="${ empty carInform }">
			<tr>
				<td colspan="3">조회되는 차량정보가 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="car" items="${ carInform }">
			<tr>
				<td><img src="http://localhost:8080/mybatis_prj/day0409/images/${ car.img }" style="width:100%" /></td>
				<td><c:out value="${ car.option }" /></td>
				<td><c:out value="${ car.year }" /></td>
			</tr>
		</c:forEach>
	</table>