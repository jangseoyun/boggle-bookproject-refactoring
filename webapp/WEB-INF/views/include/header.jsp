<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- ------헤더------ -->
<div id="header">
	<a href="${pageContext.request.contextPath}/main"> 
		<img src="${pageContext.request.contextPath}/asset/img/logo/logo2.png">
	</a>

	<c:choose>
		<c:when test="${sessionScope.authUser eq null}">
			<!-- 로그인전 -->
			<ul class="list-unstyled">
				<li><a class="btn btn-link" role="button" href="${pageContext.request.contextPath}/review_write">회원가입</a></li>
				<li><a class="btn btn-link" role="button" href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
			</ul>
		</c:when>

		<c:otherwise>
			<!-- 로그인후 -->
			<div id="header-dropdown" class="dropdown ">
				<button id="dLabel" class="header-dLabe" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<img id="header-img-icon" src="${authUser.userProfile }" class="img-circle" onerror="this.src='${pageContext.request.contextPath}/asset/img/profile.png'"> 
					<span>${authUser.nickname}</span> 
					<span class="caret"></span>
				</button>

				<div id="header-dropdown-menu" class="dropdown-menu dropdown-menu-right txt-center" role="menu" aria-labelledby="dLabel">
					<div>
						<img id="header-menu-img" src="${authUser.userProfile }" onerror="this.src='${pageContext.request.contextPath}/asset/img/profile.png'">
						<div class="margin-tb-10">
							<div>${authUser.userName}</div>
							<div>${authUser.email}</div>
						</div>
						<div>
							<a id="btn-logout" href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
						</div>
					</div>
					
					<form action="/review_write" method="get">
						<div class="write-postion">
							<button onclick = "location.href = '${pageContext.request.contextPath}/${authUser.nickname}'" id="header-btn-write" type="button">내 서재</button>
							<button onclick = "location.href = '${pageContext.request.contextPath}/review/write'" id="header-btn-write" type="button">기록하기</button>
						</div>
					</form>
				</div>
			</div>
			
		</c:otherwise>
	</c:choose>
	

</div>
<!-- ------헤더------ -->