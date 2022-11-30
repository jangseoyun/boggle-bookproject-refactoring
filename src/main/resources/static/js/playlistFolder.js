
//===============[플레이리스트 서평추가 모달]===============================
//변수선언
//- 모달 페이징 요청
var crtPage = 1;
var reviewChkBoxArr = [];

var playlistNo = $('#playlistLike').data('playlistno');
var userNo = $('#playlistLike').data('userno');
var nickname = $('#playlistLike').data('nickname');
//===============[플레이리스트 모달 ready/close]==========================
/*모달 ready*/
$('#playlist-add').on('click', function(){

	console.log('추가 클릭');
	
	$('#review-add').modal({backdrop: 'static', keyboard: false});
	$('#review-add').modal('show'); 

	/* 페이지 리스트 요청*/
	fetchList();
	console.log('리스트 요청');
	
	renderPaging();
	console.log('페이지 요청');

})

/*모달창 닫기*/
$('.modal-close').on('click', function(){
	
	$('#review-add').modal('hide');
	$('#reviewAll').empty();
	
	crtPage = 1;
	reviewChkBoxArr = [];

});

//===============[페이지 로딩]=========================================
$(document).ready(function(){
	console.log('페이지 로딩 성공');
	
	playlistLike();
	
})

//===============[데이터 요청]=========================================
//페이지 클릭 해당 버튼 리스트 요청
$('#addModal-pagination').on('click','.page-link',function(){
	
	console.log('클릭 페이지');
	crtPage = $(this).data('crtpage');
	console.log(crtPage);
	
	$('#reviewAll').empty();
	fetchList();
})
	

//데이터 요청(페이지,리스트)
function fetchList(){

	console.log("요청:"+crtPage);
	
	$.ajax({
		url : "modalListPage",
		type : "get",
		data : {crtPage: crtPage},
		
		dataType : "json",
		success : function(playlistMap){
		/*성공시 처리해야될 코드 작성*/
			console.log(playlistMap.modalList);
			
			renderPaging(playlistMap,crtPage);
			
			//객체 리스트 돌리기(화면 출력)
			for(var i = 0; i<playlistMap.modalList.length; i++){
				//그리기
				render(playlistMap.modalList[i]);
			}
		
		},
		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}
		
	});
	
	
}

//검색 내용 요청
function getSearch(){
	console.log('검색요청');
	
	var inputTxt = $('#reviewSearch').val();
	console.log('검색:'+inputTxt);
	
	$.ajax({
		url : "reviewSearch",
		type : "post",
		data : {SearchTxt: inputTxt},
		
		dataType : "json",
		success : function(searchResult){
			/*성공시 처리해야될 코드 작성*/
			
			console.log('검색결과:'+searchResult);
			
			//기존 데이터 지워짐(리스트,페이징)
			$('#reviewAll').empty();
			$('#addModal-pagination').html('');
			
			if(searchResult == ''){
				emptyResult();
			}else{
				//검색 결과 리스팅
				for(var i =0; i<searchResult.length; i++){
					render(searchResult[i]);
				}
			}

			$('#reviewSearch').val('');
			
		},
		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}
	});
	
	
}

//체크박스 등록 요청
function addCheck(reviewChkBoxArr){
	
	console.log('체크박스 등록 요청');
	console.log(reviewChkBoxArr);
	
	var playlistNo = $('#reviewAll').data('playlistno');
	console.log('folder:'+playlistNo);
	
	var userNo = $('#reviewAll').data('userno');
	console.log('userNo:'+userNo);

	console.log('요청전'+reviewChkBoxArr);
	
	$('#review-add').modal('hide');
	$('#reviewAll').empty();
	
	$.ajax({
		url : "addReviews",
		type : "post",
		//contentType : "application/json",
		data : {reviewChkBoxArr: reviewChkBoxArr,
				playlistNo: playlistNo,
				userNo: userNo},
		
		dataType : "json",
		success : function(result){
		/*성공시 처리해야될 코드 작성*/
			console.log('데이터 추가 성공');
			console.log(result);
			
			if(result == 1){
				location.href="folder?playlistNo="+playlistNo+"&userNo="+userNo+"&nickname="+nickname+"&crtPage=1";
			}else{
				alert('앗! 다시 시도해주세요! :-)')
			}
			
		},
		
		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}
	});
	
}

//로딩시 좋아요 데이터 요청
function playlistLike(){
	
	console.log('로딩시 좋아요 체크');
	
	var playlistNo = $('#playlistLike').data('playlistno');
	var userNo = $('#playlistLike').data('userno');
	
	console.log('플리'+playlistNo);
	console.log('유저'+userNo);
	
	$.ajax({
		url : "checkLike",
		type : "get",
		data : {playlistNo: playlistNo,
				userNo: userNo
				},
		
		dataType : "json",
		success : function(checkLike){
		/*성공시 처리해야될 코드 작성*/
			console.log('좋아요 체크:'+checkLike);

			//좋아요(화면 출력)
			if(checkLike == 0){
				$('#likeview').attr('class','glyphicon glyphicon-heart-empty');
			}else{
				$('#likeview').attr('class','glyphicon glyphicon-heart');
			}
		
		},
		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}
		
	});

}

/*좋아요 취소*/
function playlistUnlike(){
	
	console.log('좋아요 취소');
	
	var playlistNo = $('#playlistLike').data('playlistno');
	var userNo = $('#playlistLike').data('userno');
	
	console.log('플리'+playlistNo);
	console.log('유저'+userNo);
	
	$.ajax({
		url : "playlistUnlike",
		type : "post",
		data : {playlistNo: playlistNo,
				userNo: userNo
				},
		
		dataType : "json",
		success : function(unlike){
		/*성공시 처리해야될 코드 작성*/
			console.log('좋아요 취소:'+unlike);

			//좋아요(화면 출력)
			if(unlike == 1){
				$('#likeview').attr('class','glyphicon glyphicon-heart-empty');
			}else{
				$('#likeview').attr('class','glyphicon glyphicon-heart')
			}
		
		},
		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}
		
	});
	
}


/*좋아요 등록*/
function addplaylistLike(){
	
	console.log('좋아요 등록');
	
	console.log('플리'+playlistNo);
	console.log('유저'+userNo);
	
	$.ajax({
		url : "addplaylistLike",
		type : "post",
		data : {playlistNo: playlistNo,
				userNo: userNo
				},
		
		dataType : "json",
		success : function(like){
		/*성공시 처리해야될 코드 작성*/
			console.log('플리 좋아요:'+like);
			console.log(typeof like);

			//좋아요(화면 출력)
			if(like == 1){
				$('#likeview').attr('class','glyphicon glyphicon-heart')
			}else{
				$('#likeview').attr('class','glyphicon glyphicon-heart-empty');
			}
		
		},
		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}
		
	});
	
}

//서평 삭제
function reviewDelete(){
	
	console.log('서평삭제 요청');
	var reviewNo = $('#reviewDelete').data('reviewno');
	console.log(reviewNo);
	
	$.ajax({
		url : "reviewDelete",
		type : "post",
		data : {reviewNo: reviewNo},
		
		dataType : "json",
		success : function(deleteResult){
		/*성공시 처리해야될 코드 작성*/
			
			if(deleteResult == 1){
				location.href="folder?playlistNo="+playlistNo+"&userNo="+userNo+"&crtPage=1";
				alert('서평이 삭제되었습니다! :-)');
			}else{
				alert('다시 시도해 주세요! :-/');
			}
		
		},
		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}
	});
	
}


//===============[화면 출력]===================================================
//해당 페이지 서평 리스트
function render(modalList){
	
	console.log(modalList);
	
	var str = '';
	str +='	<li> ';
	str +='		<div class="review-card"> ';
	str +=' 		<p class="bookname">'+modalList.bookTitle+'</p> ';
	str +=' 		<p class="review-content">'+modalList.reviewContent+'</p> ';
	str +=' 		<span class="tag">#'+modalList.emoName+'</span> ';
	str +=' 		<span class="glyphicon glyphicon-unchecked btn-check" aria-hidden="true" data-reviewno="'+modalList.reviewNo+'"></span> ';
	str +=' 	</div> ';
	str +=' </li> ';
	
	$('#reviewAll').append(str);

}

//플리 모달 페이징
function renderPaging(playlistMap,crtPage){
	
	console.log(playlistMap);
	console.log("checkpage:"+crtPage);
	
	var str = '';
	if(playlistMap.prev == true){
		str += ' <li class="page-item"> ';
		str += ' 	<a class="page-link" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a> ';
		str += ' </li> ';
	}
	
	for(var i = playlistMap.startPageBtnNo; i<=playlistMap.endPageBtnNo; i++){
		/*현재페이지는 active 버튼데이터(요청한 파라미터) == 받아온 페이지*/
		if(i == crtPage){
			str += ' <li class="page-item"><a class="page-link b-blue" data-crtpage="'+i+'">'+i+'</a></li> ';
		}else{
			str += ' <li class="page-item"><a class="page-link" data-crtpage="'+i+'">'+i+'</a></li> ';
		}
		
	}

	if(playlistMap.next == true){
		str += ' <li class="page-item"> ';
		str += ' 	<a class="page-link" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a> ';
		str += ' </li> ';
	}
	
	$('#addModal-pagination').html(str);
	
}

//검색 결과 없음
function emptyResult(){
	
	console.log('검색된 서평이 없습니다');
	
	var str = '';
	
	str += ' <li> ';
	str += ' 	<div class="review-card"> ';
	str += ' 		<h3 class="empty-box">검색된 서평이 없습니다 &#128531; </h3> ';
	str += ' 	</div> ';
	str += ' </li> ';
	
	$('#reviewAll').append(str);
	
}

//===============[event]==========================================================
//-------------------------------------------------------------
//모달 서평추가 체크박스 선택
$('#reviewAll').on('click','.glyphicon-unchecked', function(){
	console.log('unchecked 버튼 클릭');
	
	$(this).attr('class','glyphicon glyphicon-check btn-check');
})

//모달 서평 체크박스 취소
$('#reviewAll').on('click','.glyphicon-check', function(){
	console.log('check 버튼 클릭');
	
	$(this).attr('class','glyphicon glyphicon-unchecked btn-check')

})


//선택한 서평 해당 플리에 추가등록
$('.addReviewBtn').on('click', function(){
	
	console.log('선택 등록 버튼 클릭');
	var checkNo = $('.glyphicon-check');
	console.log(checkNo);
	
	for(let item of checkNo){
		var checkdata = item.dataset;
		reviewChkBoxArr.push(checkdata.reviewno);
	}
	
	console.log(reviewChkBoxArr);
	
	addCheck(reviewChkBoxArr);
})


//키워드 검색
$('#reviewSearch').keydown(function(keyNum){
	
	if(keyNum.keyCode == 13){
		
		console.log('엔터!');
		
		//검색 내용 요청
		getSearch();
		
	}
	
})

//플리 좋아요 버튼

$('#playlistLike').on('click','.glyphicon-heart',function(){
	console.log('플레이리스트 좋아요-> 취소 클릭');
	playlistUnlike();
})

$('#playlistLike').on('click','.glyphicon-heart-empty',function(){
	console.log('플레이리스트 좋아요-> 추가 클릭');
	addplaylistLike();
})	

//서평 삭제 버튼
$('#reviewDelete').on('click', function(){
	
	console.log('서평 삭제 클릭');
	
	reviewDelete();
})






