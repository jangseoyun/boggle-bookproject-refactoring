<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <script src="${pageContext.request.contextPath}/asset/js/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath}/asset/bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/all_css.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/write.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/modal.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/source.css">
	
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    
    <!-- font(수정 전) -->
    <link href="https://hangeul.pstatic.net/hangeul_static/css/maru-buri.css" rel="stylesheet">
	<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-pen.css" rel="stylesheet">
	<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-gothic-eco.css" rel="stylesheet">
	<link href="https://hangeul.pstatic.net/hangeul_static/css/nanum-myeongjo.css" rel="stylesheet">	
</head>
<body>

    <div id="wrap">
		<div id="container">
			
			<!-- 헤더 -->
            <c:import url="/WEB-INF/views/include/header.jsp"></c:import>
            
            <!-- userNo -->
            <input class="userNo" type="hidden" name="userNo" value="${sessionScope.authUser.userNo }">

			<!-- progress bar -->
			<div id="progress_bar">
                <div class="progressbar-wrapper">
                    <ul class="progressbar">
                        <li>책 선택</li>
                        <li>감정 태그</li>
                        <li>스타일</li>
                        <li>서평 쓰기</li>
                    </ul>
                </div>
            </div>
            <!-- /progress bar -->
           

			<!-- 책 선택하기 -->
			
			<div id="contents" class="clearfix selectbook-header">
				<div id="book_select">
					<h1>책 선택하기</h1>
				</div>
			</div>
			
			<div class="jumbotron" data-toggle="modal" data-target="#modal_searchbook">
				<div id="select_box">
					<div class="button">
						<button class="btn_circle">+</button>
					</div>
					<p>읽은 책을 검색해주세요</p>
				</div>
			</div>
			

            <!-- 책 선택 완료(selectBookOk) -->
            <!-- 
            <div id="contents" class="clearfix selectedbook">
				<div id="select_box">
					<div id="bookVo">
						<img id="book_img" src="../img/book/book2.jpeg" alt="..." class="img-thumbnail">
						<div id="book_detail">
							<h1>자유로부터의 도피</h1>
							<h3>저자 에리히 프롬(Erich Fromm)</h3>
							<div id="book_review">
								<span class="review_count">서평 수 </span><span class="review_num">163+</span>
							</div>
						</div>
						<button id="btn_delete" type="button" class="btn btn-light">삭제</button>
						<button id="btn_modify" type="button" class="btn btn-light">수정</button>
					</div>
				</div>
			</div>
			-->		
	
			<!-- 감정 태그 선택하기 -->
			<div id="contents" class="clearfix">
				<div id="mood_tag">
					<h1>감정 태그</h1>
				</div>
			</div>

			<div id="btn_mood">
				<!-- <button type="button" class="btn btn-primary">감정 태그</button> -->
			</div>
            <!-- /감정 태그 선택하기 -->


			<!-- 스타일 선택하기 -->
			<div id="contents" class="clearfix">
				<div id="style">
					<h1>스타일</h1>
				</div>
			</div>

			<div id="select-style" class="clearfix">
				<div class="btn-group" role="group" aria-label="...">
					<!-- 
					<button class="btn_style btn-outline-secondary">폰트</button>
					-->
				</div>
			</div>
			<!-- /스타일 선택하기 -->
			

			<!-- 서평 쓰기 -->
			<div id="contents" class="clearfix">
				<div id="review_box">
					<!--  
                    <p>
                        “내 삶에서 불가피하게 직면해야 했던 시기가 있습니다.<br>바로 1958년의 여름, 나의 열일곱 살 무렵 말입니다. <br> 나는 그 시기를 사회·역사적으로 그려 내기를 바랐고,<br> 이를테면 오토픽션의 방법으로 『그들의 말 혹은 침묵』을 썼습니다.” <br> -아니 에르노					
                    </p>
                    -->
                    
                    <textarea id="review_textarea" rows="1" placeholder="글자를 입력하세요" spellcheck="false"></textarea>
				</div>
			</div>
            <p id="limit-text" >
                0/200
            </p>
            <!-- /서평 쓰기 -->

			<!-- 플레이리스트에 추가 -->
			<!--  
            <div id="contents" class="clearfix">
				<div id="add_playlist">
					<h1>플레이리스트에 추가</h1>
				</div>
			</div>
			<div class="jumbotron" data-toggle="modal" data-target="#modal_playlist">
				<div id="select_box">
					<div class="button">
						<button class="btn_circle">+</button>
					</div>
					<p>플레이리스트</p>
				</div>
			</div>			 
			-->
			<!-- 모달창 -->
			<c:import url="/WEB-INF/views/include/modal.jsp"></c:import>

			<!-- 플리 추가 질문 모달 -->
			<div class="modal_question unstaged">
				<p>저장되었습니다. 플레이리스트에 추가하시겠습니까?</p>
				<button class="yes mqBtn">예</button>
				<button class="no mqBtn">아니오</button>
			</div>
			
			<div class="msg_modal unstaged" style="top: 15%">
				<p>저장되었습니다</p>
			</div>
			
			<div class="modal_myply unstaged">
				<div class="modal_ply_header">
					<p>My 플레이리스트</p>
					<button class="modal_myply_btn">내 서평 보러가기</button>
				</div>
				<div class="modal_ply_content">
					<ul class="modal_ply_ul">
					</ul>
				</div>
			</div>

		</div>
        <!-- /container -->
    

        <!-- 기록하기 버튼 -->
        <div class="btn">
            <button id="btn_admit" class="btn btn-primary btn-block" type="button">기록하기</button>
        </div>
        <!-- /기록하기 버튼 -->


        <!-- 취소 버튼 -->
        <div class="btn">
            <button id="btn_cancle" class="btn btn-light btn-block" type="button">취소</button>
        </div>
        <!-- /취소 버튼 -->   


		<!-- footer -->
            <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
            
        <!-- /footer -->
        
        <!-- modal창 -->
        <c:import url="/WEB-INF/views/include/modal.jsp"></c:import>


	</div>
    <!-- /wrap -->

    
</body>

<script> 
	/* 
		- 책 선택 모달에서 마지막 버튼 비활성화 안했음
	*/
	var query
	var pageNo = 1
	
	var btnToggle = false
	var reviewNoQuery
	
	var userNo = $(".userNo").val()
	var bookNo
	var styleNo
	var reviewContent
	var bookTitle
	var author
	var bookURL
	var genreName
	var coverURL
	var genreNo

	let nickname
	
	/* 화면 로드되기 전, 감정태그 출력 */
	$("document").ready(function(){
		
		const urlObj = new URL(location.href)
		const urlParams = urlObj.searchParams
		const bookTitleQuery = urlParams.get("bookTitle")
		reviewNoQuery = urlParams.get("reviewNo")

		///////////////////////////////////
		// bookTitle > 책 상세 페이지 넘어올 때 
		///////////////////////////////////
		if(bookTitleQuery !== null) {
			/* bookNo로 db에서 책 정보불러와서 선택된 책 구역에 렌더 & 진행바*/
			//let url = urlObj.pathname.substring(0, 20) + "/getBookInfo?bookTitle="+bookTitleQuery
			let url = urlObj.pathname.substring(0, 19) + "/getBookInfo?bookTitle="+bookTitleQuery
		
			$.ajax({
				url: url,
				type: "post",
				contentType: "json",
				success: function(data){
					let item = data[0]

					console.log(item)
					
					/* 선택 섹션 화면에서 안보이게 & modal 닫기 */
					$(".jumbotron").css("display", "none")
					
					/* 화면 렌더 */
					renderSelectedBook(item.isbn13, item.cover, item.title, item.author, item.totalCnt)	
					
					/* 진행 바 */
					$(".progressbar li:nth-child(1)").addClass("active")
					
					/* 저장할 때 필요한 정보 저장*/
					bookNo = item.isbn13
					bookTitle = item.title
					author = item.author
					bookURL = item.link
					coverURL = item.cover
					genreNo = item.categoryId
					genreName = item.categoryName
				},
				error:  function(XHR, status, error){
					console.log(status + " : " + error);
				}
			})

		}
		
		//////////////////////////////
		// 감정버튼, 스타일 버튼 
		//////////////////////////////
		var url = location.href.substring(0, 34) + "/main/getemotion"
		
		$.ajax({
			url: url,
			type: "get",
			
			contentType: "json",
			success: function(data){
				
				/* 화면 출력 */
				for(let item of data) {
					renderEmotionBtn(item)
				}
				
				/* 이벤트 핸들러 넣기 */
				var btnlist = $("#btn_mood").children()
				
				for(var btn of btnlist) {
					btn.onclick = function(){
						
						/* 감정태그 토글 */
						btnToggle = true
						
						/* 하나만 선택 가능 */
						for(var tag of btnlist) {
							tag.classList.remove("active")
						}
						$(this).addClass("active")
						
						/* 진행 바 */
						if($(".progressbar li:nth-child(1)").hasClass("active")) {
							$(".progressbar li:nth-child(2)").addClass("active")
						}
						
						/* 스타일 옵션 출력 */
						$(".btn-group").children().remove()
						
						var emoNo = this.id
						
						renderAndEventStyleBtn(emoNo)
					}
				}
						
				
			},
			error:  function(XHR, status, error){
				console.log(status + " : " + error);
			}
			
		})
		
		//////////////////////////////////////////////
		// reviewNo > 서평 수정 페이지 넘어올 때 (수정하기)
		//////////////////////////////////////////////	
		if(reviewNoQuery !== null) {
			$("#btn_admit").text("수정하기")
			
			//let url = urlObj.pathname.substring(0, 20) + "/getPrevReviewInfo?reviewNo=" + reviewNoQuery
			let url = urlObj.pathname.substring(0, 19) + "/getPrevReviewInfo?reviewNo=" + reviewNoQuery
			
			$.ajax({
				url, url,
				type: "post",
				contentType: "json",
				success: function(data) {
					console.log(data)
					
					reviewContent = data["reviewContent"]
					author = data["author"]
					genreNo = data["categoryId"]
					genreName = data["categoryName"]
					emoNo = data["emoNo"]
					bookNo = data["isbn13"]
					bookURL = data["link"]
					coverURL = data["cover"]
					let styleName = data["styleName"]
					styleNo = data["styleNo"]
					bookTitle = data["title"]
					let totalCnt = data["totalCnt"]
					let background = data["imgURL"]

					// 1. 책 선택 
					renderSelectedBook(bookNo, coverURL, bookTitle, author, totalCnt)
					
					/* 선택 섹션 화면에서 안보이게 & modal 닫기 */
					$(".jumbotron").css("display", "none")
					
					// 2. 감정 버튼 선택 (emoNo)
					$("#"+emoNo).addClass("active")
					
					// 3. 스타일 버튼 나열
					renderAndEventStyleBtn(emoNo)

					// 4. textarea 글, 스타일 적용 (reviewContent)
					$("#review_textarea").val(reviewContent)
					$("#limit-text").text(reviewContent.length + "/200")	
					
					let arr = styleName.split(",")
					let backgroundColor = arr[0]
					let fontFamily = arr[1]
					
					if(background != null) {
						background = "url(" + urlObj.pathname.substring(0, 12) + "/asset/img/review_card/" + background + ") no-repeat"
						$("#review_box").css("background", background)						
					}
					

					$("#review_box").css("background-color", backgroundColor)
					$("#review_box>textarea").css("font-family", fontFamily)
					$("#review_box").css("background-size", "cover")

					// 5. 진행바
					$(".progressbar li:nth-child(1)").addClass("active")
					$(".progressbar li:nth-child(2)").addClass("active")
					$(".progressbar li:nth-child(3)").addClass("active")
					$(".progressbar li:nth-child(4)").addClass("active")
					
				},
				error:  function(XHR, status, error){
					console.log(status + " : " + error);
				}
			})
		}
	})
	
	/* 작성 취소 */
	$("#btn_cancle").on("click", function(){
		console.log("cancel btn")
		history.back(-1)
	})
	
	/* modal_add_playlist - closeBtn */
	$(".modal_myply_btn").on("click", function(){
		/*
		$(".modal_myply").removeClass("opaque")
		
		$(".modal_myply").one("transitionend", function(){

			$(".modal_myply").addClass("unstaged")
		})
		*/
		location.href = location.href.substring(0, 34) + nickname
	})
	
	
	/* 저장하시겠습니까 모달 - 예, 아니오 버튼 클릭 */
	$(".mqBtn").on("click", function(){
		$(".modal_question").removeClass("opaque")
		
		$(".modal_question").one("transitionend", function(){
			$(".modal_question").addClass("unstaged")
		})
		
		let answer = $(this).attr("class").split(/\s+/)[0]
		
		if(answer == "yes") {
			fetchMyPlaylist(userNo)
					
			$(".modal_myply").removeClass("unstaged")
			$(".modal_myply").addClass("opaque")
			
		} else {
			location.href = location.href.substring(0, 34) + nickname
		}
	})

	/* 기록하기 & 수정하기 */
	$("#btn_admit").on("click", function(){
		
		var obj = {
				bookNo: bookNo,
				bookTitle: bookTitle,
				author: author,
				bookURL: bookURL,
				genreNo: genreNo,
				coverURL: coverURL,
				
				userNo: userNo,
				styleNo: styleNo,
				reviewContent: reviewContent,
				
				genreName: genreName,
				
				reviewNo: reviewNoQuery
			}

		if(userNo == null || userNo == 0) {
			alert("로그인 후 이용해 주세요")
		} 
		else if($(".progressbar li:nth-child(4)").hasClass("active") == false) {
			alert("입력하지 않은 부분이 있습니다")
		}
		else {
			
			let mode = $(this).text()
			
			if(mode == "수정하기") {
				console.log("수정하기")
				var url = "${pageContext.request.contextPath}/review/modifyReview"	
			} else {
				console.log("저장하기")
				var url = "${pageContext.request.contextPath}/review/addReview"	
			}
				
			$.ajax({
				url: url,
				type: "post",
				contentType: 'application/json; charset=UTF-8',
				data: JSON.stringify(obj),

				dataType: "json",
				success: function(data){
					console.log(data)
					//console.log(location.href.substring(0, 34) + data.redirect)
					
					if(mode == "수정하기") {
						//location.href = location.href.substring(0, 34) + data.redirect
						nickname = data.redirect
						reviewNo = reviewNoQuery
						
						$(".modal_question>p").text("수정되었습니다. 플레이리스트에 추가하시겠습니까?")
						
					} else { // 저장하기
						nickname = data.redirect
						reviewNo = data.reviewNo // 저장한 서평 넘버
					}
					
					// 플리에 저장할거냐고 질문 모달 
					$(".modal_question").removeClass("unstaged")
					$(".modal_question").addClass("opaque")	
				},
				error:  function(XHR, status, error){
					console.log(status + " : " + error);
				}
			})			
		}
	})
	
	/* 서평쓰기 부분 이벤트 감지 */
	$("#review_textarea").on("keyup", function(){
		var length = $(this).val().length
		
		if(length > 200) {
			$(this).val($(this).val().substring(0, 200))
		}
		else if(length > 0) {
			/* 진행 바 */
			if($(".progressbar li:nth-child(1)").hasClass("active") && 
					$(".progressbar li:nth-child(2)").hasClass("active") &&
					$(".progressbar li:nth-child(3)").hasClass("active")) {

				$(".progressbar li:nth-child(4)").addClass("active")
			}
			
			$("#limit-text").text(length + "/200")
		}
		else if(length == 0) {
			/* 진행 바 */
			$(".progressbar li:nth-child(4)").removeClass("active")
		}
		
		reviewContent = $(this).val()
	})
	
	
	/* textarea 자동높이조절 */
	$("#review_textarea").on("propertychange change keyup paste input",function(){
       $(this)[0].style.height='auto';
       $(this).height( $(this).prop('scrollHeight'));     
    });
	
	/* 책 검색 API */
	$("#query-form").on("submit", function(e){
		e.preventDefault()

		let arr = $("#query-form").serializeArray()
		query = arr[0].value
		
		let obj = {
			query : query
		}

		sendRequest(obj)
	})
	
	/* 모달 > 페이징 링크 클릭시 */
	$(".pagination").on("click", ".page-item", function(e){
		e.preventDefault()
		var $this = $(this)
		var target = $this[0].innerText

		pageNo = parseInt(pageNo)
		
		if(target === '«') {
			console.log("previous or next btn")
			pageNo -= 1
			
		} 
		else if(target === '»') {
			console.log("previous or next btn")
			pageNo += 1
			
		} 
		else {
			pageNo = target
		}
		
		console.log(pageNo)
		
		var obj = {
			query: query,
			crtPage: pageNo
		}

		sendRequest(obj)
	})
	
	/* 모달 > 책 선택시 */
	$("#modal-playlist").on("click", ".list", function() {
		var $this = $(this)

		/* isbn, title, author, imgURL, link, category */
		bookNo = $this.data("isbn")
		coverURL = $this[0].children[0].children[0].currentSrc
		bookTitle = $this[0].children[1].children[0].innerText
		author = $this[0].children[1].children[1].innerText
		var totalCnt = $this[0].children[1].children[2].innerText
		bookURL = $this.data("url")					/* db에 저장할 때 필요한 책 정보 (!) */
		genreName = $this.data("category")
		genreNo = $this.data("categoryid")
		
		console.log("genreNo: " + genreNo)
		
		totalCnt = totalCnt.split(" ")[1]
		
		/* 선택 섹션 화면에서 안보이게 & modal 닫기 */
		$(".jumbotron").css("display", "none")
		$("#modal_searchbook").modal("hide")
		
		/* 모달 input, search result 다 지우기 (~~~~~~~~~~~ 추가 ~~~~~~~~~)*/
		$(".search_box").val("")
		//$("#modal-playlist").children().remove()		/*  에러 발생(모달이 안닫힘)  */
		
		/* 출력 전 선택된 책 삭제 (처음 책 선택하는 건데도 출력된다...?) */
		if($(".selected-book") !== null) {
			$(".selected-book").remove()			
		}
		
		/* 선택된 책 정보 섹션 출력 */
		renderSelectedBook(bookNo, coverURL, bookTitle, author, totalCnt)
		
		/* 진행 바 */
		$(".progressbar li:nth-child(1)").addClass("active")

		if(btnToggle === true) {
			$(".progressbar li:nth-child(2)").addClass("active")
		}
		if(styleNo != null) {
			$(".progressbar li:nth-child(3)").addClass("active")
		}
		if(reviewContent != null) {
			if(reviewContent.length > 0) {
				$(".progressbar li:nth-child(4)").addClass("active")
			}
		}
	})
	
/* 			<li class="list">
				<div class="img-container">
					<img src="" alt="">
				</div>
				<div class="info-container">
					<button class="tagBtn">힘이 되는</button>
					<div class="playlist-title">별밤에 볼륨을 높이고 싶은가요</div>
					<div class="username">김지연</div>
				</div>
			</li>	 */
	
			
	function addReviewToPly(playlistno, reviewNo) {
		console.log(playlistno + ", " + reviewNo)
		
		$.ajax({
			url: "${pageContext.request.contextPath}/review/addReviewToPly?playlistNo=" + playlistno + "&reviewNo=" + reviewNo,
			method: "post",
			dataType: "json",
			success: function(){
				console.log("플리에 저장했습니다.")

				$(".msg_modal").removeClass("unstaged")
				$(".msg_modal").addClass("opaque")
				
				setTimeout(function(){
					$(".msg_modal").removeClass("opaque")
					
					$(".msg_modal").one("transitionend", function(){
						$(".msg_modal").addClass("unstaged")
					})
				}, 2000)
				

			},
			error:  function(XHR, status, error){
				console.log(status + " : " + error);
			}
		})
	}
	
	function renderMyPlaylist(list) {

		for(let item of list) {
			str = ""
			str += '<li class="list" data-playlistNo="'+ item.playlistNo +'">'
			str += '	<div class="info-container">'
			str += '		<button class="tagBtn">'+ item.emoName +'</button>'
			str += '		<div class="playlist-title">' + item.playlistName + '</div>'
			str += '		<div class="username">' + item.nickname + '</div>'
			str += '	</div>'
			str += '</li>'
			
			$(".modal_ply_ul").append(str)
		}
		
		$(".modal_ply_ul").on("click", ".list", function(){
			let playlistno = $(this).data("playlistno")
			
			addReviewToPly(playlistno, reviewNo)
			
			$(this).addClass("selected")
		})
	}
	
	function fetchMyPlaylist(userNo) {
		let url = "${pageContext.request.contextPath}/review/getMyPlaylist?userNo=" + userNo
		
		$.ajax({
			url: url,
			type: "post",
			dataType: "json",
			success: function(data){
				console.log(data)
				
				renderMyPlaylist(data)
			},
			error:  function(XHR, status, error){
				console.log(status + " : " + error);
			}
		})
	}
	
	function renderAndEventStyleBtn(emoNo) {
		var url = "${pageContext.request.contextPath}/review/getStyle?emoNo=" + emoNo
		
		$.ajax({
			url: url,
			type: "post",

			dataType: "json",
			success: function(data){

				/* 스타일 버튼 > 화면 렌더 */
				for(let item of data) {
					renderStyleBtn(item)	
				}
				
				/* 스타일 옵션 > 이벤트 추가 */
				var btnList = $(".btn_style")
				
				for(let btn of btnList) {
					
					btn.onclick =  function(){
						/* 진행 바 */
						if($(".progressbar li:nth-child(1)").hasClass("active") 
								&& $(".progressbar li:nth-child(2)").hasClass("active")) {
							$(".progressbar li:nth-child(3)").addClass("active")
							
							if(reviewContent != null) {
								if(reviewContent.length > 0) {
									$(".progressbar li:nth-child(4)").addClass("active")
								}
							}
						}
						/* 텍스트아리아 스타일 변경 */
						var background = $(this).css("background")
						var backgroundColor = $(this).css("background-color")
						var fontFamily = $(this).css("font-family")
						styleNo = $(this).data("styleno")

						$("#review_box").css("background-color", backgroundColor)
						$("#review_box").css("background", background)
						$("#review_textarea").css("font-family", fontFamily)
					}
				}
			},
			error:  function(XHR, status, error){
				console.log(status + " : " + error);
			}
		})
	}
	
	function renderStyleBtn(item) {

		var arr = item.styleName.split(",")

		var background = arr[0]
		var font = arr[1]

		if(item.imgurl == null){
			var str = '<button data-styleNo="'+ item.styleNo +'"class="btn_style btn-outline-secondary" style="background: '+background+'; font-family: '+ font +'">폰트</button>'	
		}else{
			var str = '<button data-styleNo="'+ item.styleNo +'"class="btn_style btn-outline-secondary" style="background: url(${pageContext.request.contextPath}/asset/img/review_card/'+item.imgurl+') no-repeat; background-size: cover; font-family: '+ font +'">폰트</button>'
		}
		
		
		$(".btn-group").append(str)
		
	}
	
	function renderEmotionBtn(item) { 
		var str = '<button type="button" class="btn btn-primary" id="'+ item.emoNo +'">'+ item.emoName +'</button>'
		
		$("#btn_mood").append(str)
	}
	
	function renderSelectedBook(isbn, imgURL, title, author, totalCnt) {
		
		var str = ''
		str += '<div id="contents" class="clearfix selected-book" data-isbn="'+ isbn +'">'
		str += '	<div id="select_box">'
		str += '		<div id="bookVo">'
		str += '			<img id="book_img" src="'+ imgURL +'" alt="..." class="img-thumbnail">'
		str += '			<div id="book_detail">'
		str += '				<h1>'+ title +'</h1>'
		str += '				<h3>저자 '+ author +'</h3>'
		str += '				<div id="book_review">'
		str += '					<span class="review_count">서평 수 </span><span class="review_num">'+ totalCnt +'</span>'
		str += '				</div>'
		str += '			</div>'
		str += '			<button id="btn_delete" type="button" class="btn btn-light">삭제</button>'
		str += '			<button id="btn_modify" type="button" class="btn btn-light">수정</button>'
		str += '		</div>'	
		str += '	</div>'
		str += '</div>'
		
		$(".selectbook-header").after(str)
		
		/* 취소, 수정 버튼 이벤트 핸들러 넣기 */
		$("#btn_delete").on("click", function(){ // 삭제
			$(".selected-book").remove()
			$(".jumbotron").css("display", "block")
			
			/* 진행 바 */
			$(".progressbar li").removeClass("active")
		})
		
		$("#btn_modify").on("click", function(){
			$("#modal_searchbook").modal("show")
		})
	}
	
	function sendRequest(obj) {
		$.ajax({
			url: "${pageContext.request.contextPath}/review/searchbook",
			type: "post",
			data: obj,
			
			dataType: "json",
			success: function(data){
				
				var startBtnNo = data.startBtnNo
				var endBtnNo = data.endBtnNo
				var array = data.list
				
				/* 응답 정보 출력 전, 현재 리스트 & 페이징 삭제 */
				$("#modal-playlist").children().remove()
				$(".pagination").children().remove()
				
				/* response 출력 */
				for(let item of array) {
					renderBook(item)
				}
				
				/* 페이징 출력 */
				renderPaging(startBtnNo, endBtnNo)
			},
			error:  function(XHR, status, error){
				console.log(status + " : " + error);
			}
		})
	}
	
	function renderPaging(startNo, endNo) {
		
		var str = ''
		if(pageNo == 1) {
			str += '<li class="page-item" style="pointer-events: none"><a class="page-link" href="" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>'	
		}
		else {
			str += '<li class="page-item"><a class="page-link" href="" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>'
		}
		
		for(var i = startNo; i <= endNo; i++) {
			if(i == pageNo) {
				str += '<li class="page-item active"><a class="page-link" href="">' + i + '</a></li>'
			}
			else {
				str += '<li class="page-item"><a class="page-link" href="">' + i + '</a></li>'	
			}
		}
		
		str += '<li class="page-item"><a class="page-link" href="" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>'
		
		$(".pagination").append(str)
	}
	
	function renderBook(item) {
		
		var str = ""
		str += '<li class="list" data-dismiss="modal" data-isbn="'+ item.isbn13 +'" data-url="'+ item.link +'" data-category="'+ item.categoryName +'" data-categoryId="'+ item.categoryId +'">'
		str += '	<div class="book-img-container">'
		str += '		<img src="'+ item.cover +'" alt="" class="img-thumbnail">'
		str += '	</div>'
		str += '	<div class="info-container">'
		str += '		<button class="book-title">'+ item.title +'</button>'
		str += '		<div class="book-author">'+ item.author +'</div>'
		str += '		<div class="review-count">서평수 '+ item.totalCnt +'</div>'
		str += '	</div>'
		str += '</li>'

		$("#modal-playlist").append(str)
	}
</script>

</html>