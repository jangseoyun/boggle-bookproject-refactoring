<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="ko">
    
    <head>
        <meta charset="UTF-8">
        <!-- 메타데이터 -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>책 상세페이지</title>
		
        <script src="${pageContext.request.contextPath}/asset/js/jquery-1.12.4.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/bootstrap/css/bootstrap.css">
        <script src="${pageContext.request.contextPath}/asset/bootstrap/js/bootstrap.js"></script>

        <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/source.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/all_css.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/book_detail.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/modal.css">
		<link href="https://hangeul.pstatic.net/hangeul_static/css/maru-buri.css" rel="stylesheet">
		
        <!-- kakao sdk 호출 -->
        <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    </head>

    <body>
        
        <div id="wrap">
            
			<!-- 헤더 -->
            <c:import url="/WEB-INF/views/include/header.jsp"></c:import>

            <div id="contents" class="clearfix">
                <div id="bookVo">
                    <img id="book_img" src="${requestScope.bookMap.bookVo.coverUrl}" alt="..." class="img-thumbnail">
                    <div id="book_detail">
                        <h1>${requestScope.bookMap.bookVo.bookTitle}</h1>
                        <h3>저자 ${requestScope.bookMap.bookVo.author}</h3>
                        <div id="book_review">
                            <span class="review_count">서평 수</span><span class="review_num">${requestScope.bookMap.bookReviewCount}+</span>
                        </div>
                        <div id="btn_review">
                            <button type="button" class="btn blue-2 font-color-w " onclick="window.open('${requestScope.bookMap.bookVo.bookUrl}')">알라딘 북스</button>

							<!-- 북마크 버튼 -->
							<div id="bookmark" data-userno="${authUser.userNo}" data-bookno="${bookMap.bookVo.bookNo}">
	                       		
                       		</div>
							<!-- 북마크 버튼 -->
							
                        </div>
                    </div>
                    <button id="btn_write" type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/review/write?bookTitle=${requestScope.bookMap.bookVo.bookTitle}';">이 책 서평 쓰기</button>
                </div>
            </div>

            <div class="reviewVo" class="clearfix">
                <div id="list" class="clearfix">
                    <ul id="listing" data-bookno="${bookMap.bookVo.bookNo}" data-userno="${authUser.userNo}">
                        <li><a id="latest-order" class=""><span>최신순</span></a></li>
                        <li><a id="best-order" class=""><span>인기순</span></a></li>
                    </ul>
                </div>

				<!-- 서평 리스트 vo-->
				<div id="reviewlistVo">

				</div>
                <!-- 서평 리스트 vo-->
               
            </div>

            <!-- 모달창 -->
            <div id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">공유하기</h4>
                        </div>
                        <div class="modal-body">
                            <p>BOGGLE의 서평을 SNS에 공유해 보세요 :)</p>
                            <a id="kakao-link-btn" href="javascript:kakaoShare()">
                                <img src="${pageContext.request.contextPath}/asset/img/share/kakao.jpg" />
                            </a>
                            <a id="facebook-link-btn" href="">
                                <img src="${pageContext.request.contextPath}/asset/img/share/facebook.jpg" />
                            </a>
                            <a id="twitter-link-btn" href="">
                                <img src="${pageContext.request.contextPath}/asset/img/share/twitter.png" />
                            </a>
                            <a id="kakaostory-link-btn" href="">
                                <img src="${pageContext.request.contextPath}/asset/img/share/kakaostory.png" />
                            </a>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!-- Modal -->

            <!-- 페이지네이션 -->
            <!-- <nav class="pageWrap">
                <ul class="pagination">
                  <li>
                    <a href="" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
                  <li class="active"><a href="">1 <span class="sr-only">(current)</span></a></li>
                  <li><a href="">2</a></li>
                  <li><a href="">3</a></li>
                  <li><a href="">4</a></li>
                  <li><a href="">5</a></li>
                  <li>
                    <a href="" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                    </a>
                  </li>
                </ul>
            </nav> -->

            <!-- footer -->
            <c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
            
            <!-- modal창 -->
            <c:import url="/WEB-INF/views/include/modal.jsp"></c:import>
            
        </div>
         
    </body>
    
	<script src="${pageContext.request.contextPath}/asset/js/bookdetail.js"></script>
    <script src="${pageContext.request.contextPath}/asset/js/more.js"></script>
	
</html>