<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html dir="ltr" lang="ko">

	<head>
		<meta charset="utf-8" />
		<!-- v20954 -->
		
		<title>문의 내용 리스트</title>
		
		<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/asset/css/help.css">
	
		<link href="https://hangeul.pstatic.net/hangeul_static/css/maru-buri.css" rel="stylesheet"> 
	</head>
	<body class="">
	
	
		<main role="main">
			<div class="container">
				<nav class="sub-nav">
					<ol class="breadcrumbs">
						<li title="보글 고객센터"><a href="${pageContext.request.contextPath}/help">보글 고객센터</a></li>
						<li title="문의 등록">고객 문의</li>
					</ol>
				</nav>
	
				<div class="section-container">
					<section class="section-content">
						<header class="page-header">
							<h1>고객 문의</h1>
						</header>
	
						<div id="helpListBox_list">
							<ul class="article-list">
								<c:forEach items="${helpList}" var="helpVo">
									<li class="article-list-item "><a href="${pageContext.request.contextPath}/help/read?&no=${helpVo.no}" class="article-list-link">${helpVo.title}</a></li>
								</c:forEach>
							</ul>
						</div>
	
					</section>
				</div>
			</div>
	
	
		</main>
	
		<footer class="footer">
			<div class="footer_wrapper">
				<div class="footer-left">
					<div class="footer-ridi-header">
						<ul class="info_contact">
							 <li class="request"><a href="${pageContext.request.contextPath}/help/writeForm">1:1 문의</a></li>
						</ul>
					</div>
					<div class="footer-ridi-info-contents">
						<div class="descripition-header">
							<div class="toggle">
								<h4>Boggle 만든 사람 |</h4><br>
								<small id="usName"> 김지연 이영림 장서윤 황인경 황희원</small>>
								
							</div>
						</div>
						<div class="corp_info">
							<ul class="info_link">
								<li><a class="link_prov" href="${pageContext.request.contextPath}/help/legal" target="_blank">이용약관</a></li>
								<li><a class="link_personal" href="${pageContext.request.contextPath}/help/privacy" target="_blank">개인정보처리방침</a></li>
								<li><a class="link_youth" href="${pageContext.request.contextPath}/help/youth" target="_blank">청소년보호정책</a></li>
							</ul>
							<p class="info_copyright">
								<a href="">&copy;2022 BOGGLE BOOKS</a>
							</p>
						</div>
					</div>
				</div>
			</div>	
		</footer>

	
		
	
	</body>

</html>
