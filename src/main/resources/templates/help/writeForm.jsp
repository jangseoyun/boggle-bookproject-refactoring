<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

	<head>
		<meta charset="UTF-8">
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Boggle 고객센터</title>
		
		<script src="${pageContext.request.contextPath}/asset/js/jquery-1.12.4.js"></script>
		
		<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/asset/css/help.css">
	
		<link href="https://hangeul.pstatic.net/hangeul_static/css/maru-buri.css" rel="stylesheet"> 
	</head>
	<body class="">

		<main role="main">
			<div class="container">
				<nav class="sub-nav">
					<ol class="breadcrumbs">
	
						<li title="보글 고객센터"><a href="${pageContext.request.contextPath}/help">보글 고객센터</a></li>
						<li title="문의 등록">1:1 문의</li>
					</ol>
				</nav>
	
				<h1 id="form-title" class="new-request-form-title">문의 등록</h1>
	
	
				<div class="form">
					<form action="write" class="request-form" method="get">
						<input name="userNo" type="hidden" value="${authUser.userNo}" />
					
						<div class="form-field string  required  request_subject">
							<label id="request_subject_label" for="request_subject">제목</label>
							<input type="text" name="title" id="request_subject" value=""/>
						</div>
	
						<div class="form-field text  required  request_description">
							<label id="request_description_label" for="request_description">상세 설명</label>
							<textarea name="content" id="request_description"></textarea>
						</div>
	
				
						<button id="btn_submit_modifyForm" type="submit">제출</button>
						<a id="btn_delete_modifyForm" href="${pageContext.request.contextPath}/help/#">취소</a>
					
					</form>
				</div>
	
				<div class="suggestion_info">
					<img src="${pageContext.request.contextPath}/asset/img/help/writeForm.png">
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

	
	
	
		<!-- / -->
	
	</body>

</html>
