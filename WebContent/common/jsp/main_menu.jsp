<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- SmartMenu 시작 -->
<link
	href="http://localhost:8080/mybatis_prj/common/smartmenu/css/sm-core-css.css"
	rel="stylesheet" type="text/css" />

<link
	href="http://localhost:8080/mybatis_prj/common/smartmenu/css/sm-simple/sm-simple.css"
	rel="stylesheet" type="text/css" />

<!-- jQuery -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->

<!-- SmartMenus jQuery plugin -->
<script type="text/javascript"
	src="http://localhost:8080/mybatis_prj/common/smartmenu/jquery.smartmenus.min.js"></script>

<!-- SmartMenus jQuery init -->
<script type="text/javascript">
	$(function() {
		$('#main-menu').smartmenus({
			subMenusSubOffsetX : 1,
			subMenusSubOffsetY : -8
		}); // smartmenus
	}); // ready 
</script>

<nav id="main-nav">
	<!-- Sample menu definition -->
	<ul id="main-menu" class="sm sm-simple">
		<li><a href="#void">홈으로</a></li>
		<li><a href="#void">쿼리실행</a>
			<ul>
				<li><a href="#void">1일차</a>
					<ul>
						<li><a href="main.jsp?page=day0404/single_column">컬럼 하나에 레코드 하나</a></li>
						<li><a href="main.jsp?page=day0404/multi_column">컬럼 여러개에 레코드 하나</a></li>
						<li><a href="main.jsp?page=day0404/multi_row">컬럼 하나에 레코드 여러개</a></li>
					</ul>
				</li>
				<li><a href="#void">2일차</a>
					<ul>
						<li><a href="main.jsp?page=day0405/multi_column_row">컬럼 여러개 레코드 여러개</a></li>
						<li><a href="main.jsp?page=day0405/multi_param">WHERE의 조건이 여러개</a></li>
						<li><a href="main.jsp?page=day0405/lessthan">&lt;의 비교</a></li>
						<li><a href="main.jsp?page=day0405/greaterthan">&gt;의 비교</a></li>
						<li><a href="main.jsp?page=day0405/like">LIKE</a></li>
					</ul>
				</li>
				<li><a href="#void">3일차</a>
					<ul>
						<li><a href="main.jsp?page=day0408/subquery">SUBQUERY</a></li>
						<li><a href="main.jsp?page=day0408/union">UNION</a></li>
						<li><a href="main.jsp?page=day0408/join">JOIN</a></li>
					</ul>
				</li>
				<li><a href="#void">4일차</a>
					<ul>
						<li><a href="main.jsp?page=day0409/join_subquery">JOIN+SUBQUERY</a></li>
						<li><a href="main.jsp?page=day0409/dynamic_table">테이블명이 동적일 때</a></li>
						<li><a href="main.jsp?page=day0409/dynamic_if">상황에 따른 다른 쿼리를 실행해야 할 때(dynamic-if)</a></li>
						<li><a href="main.jsp?page=day0409/work">숙제</a></li>
					</ul>
				</li>
				<li><a href="#void">5일차</a>
					<ul>
						<li><a href="main.jsp?page=day0410/dynamic_choose">Dynamic Choose</a></li>
						<li><a href="main.jsp?page=day0410/dynamic_foreach">Dynamic forEach</a></li>
						<li><a href="main.jsp?page=day0410/insert_procedure">Insert Procedure</a></li>
					</ul>
				</li>
				<li><a href="#void">6일차</a>
					<ul>
						<li><a href="main.jsp?page=day0411/select_procedure">select procedure</a></li>
					</ul>
				</li>
			</ul>
		</li>
		<li><a href="main.jsp?page=day0410/car">동기방식 차량조회</a></li>
	</ul>
</nav>
<!-- SmartMenu 끝 -->