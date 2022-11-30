const container = document.querySelector(".container");
const slideContainer = document.querySelector(".slide-container");
const upBtn = document.querySelector(".upBtn");
const downBtn = document.querySelector(".downBtn");
const autoModeBtn = document.querySelector(".autoModeBtn");
const closeBtn = document.querySelector(".close-btn");
const sideBar = document.querySelector(".sidebar");
const sidebarToggle = document.querySelector(".fa-bars");
let navLinks = document.querySelector(".links")
let sidebarBtn = document.querySelector(".sidebarBtn")
let bgmPrevBtn = document.querySelector(".prevArrow")
let bgmNextBtn = document.querySelector(".nextArrow")
let singer = document.querySelector(".singer")
let songTitle = document.querySelector(".song-title")
const playBtn = document.querySelector(".playBtn")
const audioEle = document.querySelector(".audioEle")
let bgmPagination = document.querySelector(".bgm-pagination")
let randomBtn = document.querySelector(".randomBtn")
let dim = document.querySelector(".dim")
const modalBackground = document.querySelector(".modal-background")
const reviewModalBackground = document.querySelector(".review-modal-background");
const modalCloseBtn = document.querySelector(".modal-closeBtn")
const addReviewModal = document.querySelector(".addReviewModal")
const modal = document.querySelector(".messageModal")
const addPlaylistForm = document.querySelector(".addPlaylist")
const addPlyInput = addPlaylistForm.querySelector(".addPly-input")
const emotionSelectBox = document.querySelector(".emotion-select-box")
let modalEmoTags
const emotionSelectUl = document.querySelector(".emotion-select-ul")
const plySubmitBtn = document.querySelector(".plySubmitBtn")

let slideIndex = 0
let slides
let interval
let timeout
let url
let urlPath

let bgmIndex = 0
let play = false
let clickCnt = 0

let autoMode = false

let musicList
let emoTags

let logStatus = document.querySelector(".login").getAttribute("data-logstatus")
let userNo
let reviewNo
let plyEmoNo
let reviewList

/* 화면 로드 후 첫 화면 (감정버튼, 서평리스트, 음악리스트 + [로그인] 나의 플레이리스트) */
window.addEventListener("DOMContentLoaded", function(){
	
	/************************************
	 디폴트 랜덤 리스트 + 음악 리스트 불러와서 출력
	*************************************/
	const urlObj = new URL(location.href)
	const urlParams = urlObj.searchParams
	const playlistNo = urlParams.get("playlistNo")

	if(playlistNo !== null) {
		urlPath = urlObj.pathname.substring(0, 17)
		
		loadReviewMusicList(playlistNo, "playlist")
	}
	else {
		urlPath = urlObj.pathname

		loadReviewMusicList(null, "emotion")
	}

	/****************************************
	********* 감정 태그 출력 & 이벤트 추가하기 *******
	*****************************************/
	url = urlPath + "/getemotion"

	fetch(url)
	.then(response => response.json())
	.then(data => {
		//////////////////////
		// modal 감정 태그
		//////////////////////
		renderModalEmoTag(data)
		
		/* modal 감정 태그 이벤트 추가 */
		modalEmoTags = document.querySelectorAll(".tag")
		
		for(let emoTag of modalEmoTags) {
			emoTag.onclick = function(){
				
				for(let tag of modalEmoTags) {
					tag.classList.remove("selected")
				}
				emoTag.classList.add("selected")
				
				//plyEmoNo
				plyEmoNo = this.getAttribute("data-emono")
			}
		}
		
		//////////////////////
		// sidebar 감정 태그
		//////////////////////
		renderEmoTag(data)
		
		/* 감정 태그 이벤트 리스너 추가 */
		emoTags = document.querySelectorAll(".emoTag")
		
		for(let emoTag of emoTags) {
			
			emoTag.onclick = function() {

				slideIndex = 0

				for(let tag of emoTags) {
					tag.classList.remove("checked")
				}
				emoTag.classList.add("checked")
				
				// 사이드 바 닫힘
			    sideBar.classList.remove("show-sidebar");
			    dim.classList.remove("show-dim")
			
			    dim.addEventListener("transitionend", function(){
			        this.classList.toggle("unstaged")
			        this.removeEventListener("transitionend", arguments.callee)
			    })
				// 감정태그에 해당하는 서평, 음악 리스트 불러오기 + 자동 전환 & 음악 재생
				loadReviewMusicList(emoTag.id, "emotion")
				afterLoadAutoMode()
				
				window.addEventListener("keydown", enterEventHandler)
				
				emoTag.blur()
				slideContainer.click()
			}
		}				
	})
		
	/***************************
	 사이드바 > 마이 플레이리스트 출력 
	****************************/	
	if(logStatus === "login") {
		
		url = urlPath + "/getMyPlaylist?userNo=" + userNo
	
		fetch(url)
		.then(response => response.json())
		.then(data => {
			
			renderPlaylist(data, "sidebar")
		})
	}		
})

/* 슬라이드 keyup, keydown */
window.addEventListener("keydown", function(e) {
    if(e.key == 'ArrowUp') {
		if(slideIndex == 0) {
			slideIndex = 0
		} else {
			slideIndex--;	
		}
        carousel();
    }
})

window.addEventListener("keydown", function(e) {
    if(e.key == 'ArrowDown') {
        slideIndex++;
        carousel();
    }
})


/* 슬라이드 위아래 버튼 */
upBtn.addEventListener("click", function(){
	
	if(slideIndex == 0) {
		slideIndex = 0
	} else {
		slideIndex--;	
	}

    carousel();
})

downBtn.addEventListener("click", function(){
    slideIndex++;
    carousel();
})

/* 슬라이드 Space 이벤트리스너 추가 */
window.addEventListener("keydown", enterEventHandler)

function enterEventHandler(e) {
	if(e.code === 'Space') {
        changeMode()
    }
}

addPlyInput.onclick = function() {
	emotionSelectBox.classList.add("show")
	addReviewModal.classList.add("move")
}

/* 모달 > 새 플레이리스트 submit */
plySubmitBtn.addEventListener("click", function(e){
	e.preventDefault()
	
	///////////////////////////
	// 새 플레이리스트 db 추가
	///////////////////////////
	let playlistTitle = addPlyInput.value
	
	if(playlistTitle == "") {
		alert("제목을 입력해주세요")
	}
	else {
		
		let obj = {
			userNo : userNo,
			playlistName : playlistTitle,
			emoNo: plyEmoNo
		}
		
		url = urlPath + "/addNewPlaylist"
		
		fetch(url, {
			method: "POST",
			headers: {
				"Content-Type" : "application/json"
			},
			body : JSON.stringify(obj)
		}).then(response => response.json())
		.then(data => {
			
			/////////////////////
			// 화면 업데이트
			/////////////////////
	
			/* 화면 플레이리스트 초기화 */
			document.querySelector(".playlist-box").querySelector("ul").innerHTML = ""
			document.querySelector(".playlist-list").innerHTML = ""
			
			/* 새 플레이리스트 불러오기 */
			userNo = document.querySelector(".login").getAttribute("data-userNo")
			reviewNo = slides[slideIndex].getAttribute("data-reviewno")
			
			url = urlPath + "/getMyPlaylistModal"
			
			let obj = { // userNo, reviewNo
				userNo: userNo,
				reviewNo: reviewNo
			}
			
			fetch(url, {
				method: "POST",
				headers: {
					"Content-Type" : "application/json"
				},
				body : JSON.stringify(obj)
			})
			.then(response => response.json())
			.then(data => {
				
				renderPlaylist(data, "modal")
				renderPlaylist(data, "sidebar")
			})
			
			/* 플리 추가 섹션 안보이도록 */
			emotionSelectBox.classList.remove("show")
			addReviewModal.classList.remove("move")
			
			/* 감정 태그 초기화 */
			for(let tag of modalEmoTags) {
				tag.classList.remove("selected")
			}
			
		})
		
		addPlyInput.value = null
	}
})

/* 모달 > 감정 태그 버큰 렌더 */
function renderModalEmoTag(data) {
	
	for(let emo of data) {
		const li = document.createElement("li")
		const div = document.createElement("div")
		
		div.classList.add("tag")
		div.textContent = emo.emoName
		div.setAttribute("data-emoNo", emo.emoNo)
		
		li.append(div)
		
		emotionSelectUl.append(li)
	}
}

function renderPlaylist(list, loca) {
	
	/****************************
	****** 사이드바 플레이리스트 ******* 
	*****************************/
	if(loca === "sidebar") { 
		
		//////////////////
		// 플레이리스트 렌더 
		//////////////////
		for(let item of list) {
			
			let li2 = document.createElement("li")
			let p2 = document.createElement("p")
			
			p2.innerText = item.playlistName
			
			li2.setAttribute("data-playlistNo", item.playlistNo)
			li2.classList.add("playlistBtn")
			
			li2.append(p2)
			document.querySelector(".playlist-list").append(li2)
		}
		
		//////////////////
		// 이벤트 리스너 넣기 
		//////////////////
		const playlistBtns = document.querySelectorAll(".playlistBtn")

		for(let plybtn of playlistBtns) {
			
			plybtn.onclick = function(e){

				// 클릭시 색 스타일 
				for(let plyBtn of playlistBtns) {
					plyBtn.classList.remove("selected")
				}
				this.classList.add("selected")
				
				let playlistNo = this.getAttribute("data-playlistno")

				// 현재 서평 + 음악 초기화
				slideIndex = 0
				
				// 사이드 바 닫힘
			    sideBar.classList.remove("show-sidebar");
			    dim.classList.remove("show-dim")
			
			    dim.addEventListener("transitionend", function(){
			        this.classList.toggle("unstaged")
			        this.removeEventListener("transitionend", arguments.callee)
			    })		
		
				// 클릭한 플레이리스트 서평 리스트 + 음악 목록 db에서 가져오기
				loadReviewMusicList(playlistNo, "playlist")
				//afterLoadAutoMode()
				
				// 자동 전환 carousel, 음악 재생
				interval = null
				timeout = null
				
				changeMode()
				
				window.addEventListener("keydown", enterEventHandler)
			}
		}
		
		
	} else { 
		/******************************** 
		********** 모달 플레이리스트 **********
		*********************************/
		
		//////////////////
		// 플레이리스트 렌더 
		//////////////////
		for(let item of list) {

			let li = document.createElement("li")
			let p = document.createElement("p")
			let btn = document.createElement("button")
			
			p.innerText = item.playlistName
			
			if(item.userNo == userNo) {
				if(item.cnt == 0) { // 지금 서평 플레이리스트에 추가 안했음
					btn.innerHTML = '<i class="fa-solid fa-plus"></i>'
				} else { // 추가했음
					btn.innerHTML = '<i class="fa-solid fa-check"></i>'
					li.classList.add("selected")
				}	
			}
			
			li.setAttribute("data-playlistNo", item.playlistNo)
			
			li.classList.add("playlist-li")
			btn.classList.add("reviewAddBtn")
			
			li.append(p, btn)
		
			document.querySelector(".playlist-box").querySelector("ul").append(li)
		}
		
		/////////////////////////////////////
		// 이벤트 리스너 넣기 (서평을 플리에 추가)
		/////////////////////////////////////
		const reviewAddBtns = addReviewModal.querySelectorAll(".reviewAddBtn")
		
		for(let addBtn of reviewAddBtns) {
		    addBtn.onclick = function(e){

				////// DB 변경 ///////
				let playlistNo = e.path[2].dataset.playlistno
				reviewNo = slides[slideIndex].getAttribute("data-reviewNo")
				let icon = e.path[0].classList[1]
				
				url = urlPath + "/toggleReviewToPly"
					
				let obj = {
					playlistNo: playlistNo,
					reviewNo : reviewNo,
					icon: icon
				}
				
				fetch(url, {
					method: "POST", 
					headers: {
						"Content-Type" : "application/json"
					},
					body : JSON.stringify(obj)
				}).then(response => response.json())
				.then(data => {
					console.log(data + "건 | 서평을 플리에 저장 또는 삭제")
				})
				
				////// 화면 ICON 변경 ///////	
		        if(icon == 'fa-plus') { // 저장할 때
		            addBtn.innerHTML = '<i class="fa-solid fa-check"></i>'
					this.parentNode.classList.add("selected")
		        } else { // 삭제할 때
		            addBtn.innerHTML = '<i class="fa-solid fa-plus"></i>'
					this.parentNode.classList.remove("selected")
		        }
		    }
		}
	}
}

/* 랜덤 버튼 */
randomBtn.onclick = function() {
	console.log("random button click!")
	
	slideIndex = 0
	
	/* random number 생성 --> random emoNo 생성 */
	//let randomEmoNo = Math.ceil(Math.random() * emoTags.length)
	
	// 감정 태그 checked 다 제거
	for(let tag of emoTags) {
		tag.classList.remove("checked")
	}
	
	// 사이드 바 닫힘
    sideBar.classList.remove("show-sidebar");
    dim.classList.remove("show-dim")

    dim.addEventListener("transitionend", function(){
        this.classList.toggle("unstaged")
        this.removeEventListener("transitionend", arguments.callee)
    })
	
	loadReviewMusicList(null, "emotion")
	//afterLoadAutoMode()
	
	// 자동 전환 carousel, 음악 재생
	interval = null
	timeout = null
	
	changeMode()	
	
	/* 적용 안됨 */
	randomBtn.blur()
	window.focus()
	
	window.addEventListener("keydown", enterEventHandler)
}

/* 서평, 음악 리스트 로드 */
function loadReviewMusicList(no, sort) {
	
	userNo = document.querySelector(".login").getAttribute("data-userNo")

	if("emotion" === sort) {
		console.log("loadReviewMusicList > list sort by emotion")
		
		url = urlPath + "/reviewmusiclist?userNo="+ userNo +"&emoNo=" + no
			
	}
	else if("playlist" === sort) {
		console.log("loadReviewMusicList > sort by playlistNo")
		
		url = urlPath + "/reviewmusiclist?userNo="+ userNo +"&playlistNo=" + no
	}
	
	fetch(url)
	.then(response => response.json())
	.then(data => {
		
		reviewList = data.reviewList
		musicList = data.musicList
		
		let musicTotalCnt = musicList.length // 이거 왜 가져오지? musiclist length 하면 될텐데?

		// 먼저 현재 있던 슬라이드들 삭제
		slideContainer.innerHTML = ""

		// 서평이 없을 경우
		if(reviewList.length === 0) {
			console.log("저장된 서평이 없습니다.")
			
			modal.innerHTML = "<p>저장된 서평이 없습니다</p>"
			
			renderMsg()
		} else {
			// 위 화살표 아이콘 안보이게
			upBtn.style.display = "none";
			
			// 슬라이드 출력
			renderNewArray(reviewList)
			
			// 예전 paging 삭제
			bgmPagination.innerHTML = ""
			
			// bgm paging
			renderBgmPaging(musicTotalCnt)	
			
			// music 첫 번째 출력
			bgmIndex = 0
			
			updateBgm()
			/*
		    singer.textContent = musicList[bgmIndex].artist
		    songTitle.textContent = musicList[bgmIndex].musicTitle
		    audioEle.src = "/bookproject/asset/music/" + musicList[bgmIndex].musicPath + ".mp3"
			*/	
		}
	})
}

/* (슬라이드 렌더 후) 자동 전환 및 음악 재생 */
function afterLoadAutoMode(){
	// 자동 전환 carousel, 음악 재생
	interval = null
	timeout = null
	
	changeMode()

}

/* 감정태그 목록 렌더(모달) */
function renderEmoTag(arr) {

	for(let item of arr) { /* 서평 개수가 3개 이상인 경우만 렌더 */
		if(item.totalReviewCnt > 0) {
			let btn = document.createElement("button")
			btn.classList.add("emoTag")
			btn.id = item.emoNo
			btn.textContent = item.emoName
			
			document.querySelector(".tag-box").append(btn)	
		}
	}
}

// 노래 끝났을 때 자동으로 다음 노래로 넘어감
audioEle.addEventListener("ended", function(){
    console.log("music ended")

    moveNextBgm()
})

// audio play & pause
playBtn.onclick = function(){

    if(play === false) { // 음악 재생
		
        audioEle.play()

        playBtn.innerHTML = '<i class="fa-solid fa-pause"></i>'

        play = !play;
    } else {
        //bgmCurrentTime = audioEle.currentTime

        audioEle.pause()

        playBtn.innerHTML = '<i class="fa-solid fa-play"></i>'

        play = !play;
    }
    
}

/* bgm carousel 기능 */
bgmPrevBtn.addEventListener("click", function(){
    
    if(play === true) {
        clickCnt++

        if(clickCnt === 1 ) { // 처음부터 재생
            audioEle.currentTime = 0
    
        } else if(clickCnt === 2) { // 전으로 넘어가기
            clickCnt = 0
    
            if(bgmIndex > 0) {
                bgmIndex--
        
                updateBgm()
            } else {
                bgmIndex = musicList.length - 1
        
                updateBgm()
            }
        }
    } else {
        if(bgmIndex > 0) {
            bgmIndex--
    
            updateBgm()
        } else {
            bgmIndex = musicList.length - 1
    
            updateBgm()
        }
    }
})

bgmNextBtn.addEventListener("click", moveNextBgm)

function moveNextBgm(){
	
    if(bgmIndex < musicList.length - 1) {
        bgmIndex++

        updateBgm()        
    } else {
        bgmIndex = 0

        updateBgm() 
    }
}

modalCloseBtn.onclick = function(){
    modalBackground.classList.remove("show-modal")

	/* 모달 하단 집어넣기 */
	emotionSelectBox.classList.remove("show")
	addReviewModal.classList.remove("move")
	
	/* 감정 태그 초기화 */
	for(let tag of modalEmoTags) {
		tag.classList.remove("selected")
	}
	
	/* 삭제한 enter key event 리스너 다시 더하기 */
	window.addEventListener("keydown", enterEventHandler)
	
	/* input 값 초기화 */
	addPlyInput.value = null;
	
	/* 다시 자동 재생 */
	if(autoMode == true) {
		changeMode()
	}
}

/* 사이드 바 열기, 닫기 */
sidebarToggle.addEventListener("click", function() {
    sideBar.classList.add("show-sidebar");

    dim.classList.remove("unstaged")
    dim.classList.add("show-dim")

	window.removeEventListener("keydown", enterEventHandler)
})

closeBtn.addEventListener("click", function() {
    sideBar.classList.remove("show-sidebar");

    dim.classList.remove("show-dim")

    dim.addEventListener("transitionend", function(){
        this.classList.add("unstaged")
        this.removeEventListener("transitionend", arguments.callee)
    })

	window.addEventListener("keydown", enterEventHandler)
})

dim.onclick = function(){
    sideBar.classList.remove("show-sidebar");

    dim.classList.remove("show-dim")

    dim.addEventListener("transitionend", function(){
        this.classList.add("unstaged")
        this.removeEventListener("transitionend", arguments.callee)
    })

	window.addEventListener("keydown", enterEventHandler)
}

/* 전체 화면 버튼(자동 전환) > 슬라이드 전환 방식 변경 */
autoModeBtn.onclick = function(){
    changeMode()
}

function renderMsg(){
	
    clearTimeout(timeout)

    modal.classList.add("opaque")
    modal.classList.remove("unstaged")

    timeout = setTimeout(function(){
        modal.classList.remove("opaque")

        modal.addEventListener("transitionend", function(){
            this.classList.add("unstaged")

    		modal.innerHTML = "<p>슬라이드 전환 방식을 변경하고 싶으면 '스페이스바'를 눌러주세요</p>"

            this.removeEventListener("transitionend", arguments.callee)
        })
    }, 2000)
}

function audioPlay(){
	console.log("canplaythrough event trigger...")
	audioEle.play()
}

function changeMode(){

    renderMsg()

    if(autoMode === false) { // 자동 전환 모드
        console.log("auto true")
		
		if(musicupdated === true) { // 새로운 음악 파일이 로드됐다면 기다렸다가 재생
			console.log("music updated:" + musicupdated)
		
			audioEle.addEventListener("canplaythrough", audioPlay)

		}
		else {
			audioEle.play()
		}

		playBtn.innerHTML = '<i class="fa-solid fa-pause"></i>'
		play = true;

        autoCarousel()

        autoMode = true;
    } else {                // 수동 전환 모드
        console.log("auto false")

		if(musicupdated === true) {
			audioEle.removeEventListener("canplaythrough", audioPlay)
			
			musicupdated = false
			
			console.log("changeMode > removeEventListener > musicupdated: " + musicupdated)
		}
		

		audioEle.pause()
		playBtn.innerHTML = '<i class="fa-solid fa-play"></i>'
		play = false;

        clearInterval(interval)

        navLinks.style.visibility = 'visible'
        sidebarBtn.style.visibility = 'visible'
        autoModeBtn.style.display = 'block'

        autoMode = false

        carousel()
    }
}

function autoCarousel(){
    
    upBtn.style.display = "none";
    downBtn.style.display = "none";

	if(window.innerWidth < 495 || window.innerHeight < 420) {
		autoModeBtn.style.display = 'block';
	} else {
		autoModeBtn.style.display = 'none';	
	}

    navLinks.style.visibility = 'hidden'
    sidebarBtn.style.visibility = 'hidden'

    interval = setInterval(
        function(){
            slideIndex++
            carousel()
        },
        8000
    )
    
}

function carousel() {
    console.log("slideIndex: " + slideIndex)

    if(slideIndex == slides.length) { // 마지막 페이지일 때
        renderNewArray(reviewList);            // 마지막 슬라이드 일떄 ?????? (일단 돌리는 걸로)
		/*
		loadReviewMusicList(null, "emotion") // 새로운 리스트 불러오기
		
		autoMode = !autoMode
		
		changeMode()
		*/
    }

    if(autoMode === false) { // 수동모드 경우 -> index가 -1로 가지 못하도록
        if(slideIndex > 0) {
            upBtn.style.display = "block";
        } else {
            upBtn.style.display = "none";
        }
        downBtn.style.display = "block"        
    }

    slides.forEach(slide => {
        slide.style.transform = `translateY(-${slideIndex * 100}%)`;
    })
}

let musicupdated = false

function updateBgm() {

	//canplayToggle = !canplayToggle

    // 바로 재생되게 하기
    if(play === true) { // 재생되고 있는 음악 멈춤
        audioEle.pause() 
    }

    // audio 객체 업데이트 (음악 시작, 아이콘 업데이트)
    singer.textContent = musicList[bgmIndex].artist
    songTitle.textContent = musicList[bgmIndex].musicTitle
    audioEle.src = "/bookproject/asset/music/" + musicList[bgmIndex].musicPath + ".mp3"

	musicupdated = true

    // play 상태에서 next btn 누르면 play
    // pause 상태에서 next btn 누르면 pause 상태로 넘어감
    if(play === true) {
        audioEle.play()
        playBtn.innerHTML = '<i class="fa-solid fa-pause"></i>'
    }

    // 해당 페이지 위치를 페이징에 반영하기
    let dots = document.querySelectorAll(".dot");

    for(let dot of dots) {
        dot.classList.remove("active")
    }

    dots[bgmIndex].classList.add("active")
}

function renderBgmPaging(count) {

    let ul = document.createElement("ul")

    for(let index = 0; index < count; index++){
        let div = document.createElement("div")
        let li = document.createElement("li")

        div.classList.add("dot")
        if(index == bgmIndex) {
            div.classList.add("active")
        }

        li.append(div)
        ul.append(li)
    }

    bgmPagination.append(ul)
}

function renderNewArray(array) {
    for(let item of array) {
        render(item)
    }

    slides = document.querySelectorAll(".slide")
	
	/* 새로운 서평 슬라이드 추가하는 방식 바꾸기! */
    slides.forEach((slide, index) => {
        slide.style.top = `${index * 100}%`;
    })
}

function render(item) {
	
	let styles = item.styleName.split(",")
	let color = styles[0]
	let fontFamily = styles[1]
	
    const slide = document.createElement("div");
    const review = document.createElement("p");
    const username = document.createElement("p");
    const btnContainer = document.createElement("div");
    const heartBtn = document.createElement("button");
    const addBtn = document.createElement("button");
	const a = document.createElement("a")
	
	let contentBox
	let video
	
	if(item.videourl != null) {
		console.log("video background")
		
		video = document.createElement("video")
		contentBox = document.createElement("div")

		video.classList.add("video")
		contentBox.classList.add("contentBox")
		
		video.src = urlPath.substring(0, 12) + "/asset/img/review_card/" + item.videourl
		video.setAttribute("muted", "muted")
		video.setAttribute("autoplay", "autoplay")		
		video.setAttribute("loop", "loop")
	} else {
		slide.style.backgroundColor = color
	}
	
	if(logStatus === "login") {

		a.setAttribute("href", urlPath.substring(0, 12) + "/bookdetail?bookNo=" + item.bookNo + "&userNo=" + userNo)		
	}
	
	a.classList.add("reviewLink")
	
    slide.classList.add("slide");
    btnContainer.classList.add("btn-container");
	review.classList.add("review");
    username.classList.add("username");
    btnContainer.classList.add("slideBtnContainer");
    heartBtn.classList.add("heartBtn");
    addBtn.classList.add("addBtn");

    review.textContent = item.reviewContent;
    username.textContent = item.nickname;
	review.style.fontFamily = fontFamily;
    addBtn.innerHTML = '플레이리스트<i class="fa-solid fa-plus"></i>';
	slide.setAttribute("data-reviewNo", item.reviewNo)

	/* 로그아웃 상태인 경우, 클릭시 로그인 페이지로 이동 */
	if(logStatus === "logout") { 
		heartBtn.innerHTML = '좋아요<i class="fa-regular fa-heart"></i>';

		heartBtn.onclick = function() {
			location.href = urlPath.substring(0, 12) + '/user/loginForm'
		}
		
		addBtn.onclick = function() {
			location.href = urlPath.substring(0, 12) + '/user/loginForm'
		}
		
		review.setAttribute("title", "로그인 후 이용 가능합니다.")
		heartBtn.setAttribute("title", "로그인 후 이용 가능합니다.")
		addBtn.setAttribute("title", "로그인 후 이용 가능합니다.")
	} else {
		
		username.onclick = function(){
			location.href = urlPath.substring(0, 12) + "/" + item.nickname
		}
		
		console.log("item.alreadyLikedCnt: " + item.alreadyLikedCnt)

		if(item.alreadyLikedCnt == 0) {
			heartBtn.innerHTML = '좋아요<i class="fa-regular fa-heart"></i>';
		} else {
			heartBtn.innerHTML = '좋아요<i class="fa-solid fa-heart"></i>';
		}
		
	    heartBtn.onclick = function(){
			
			console.log("좋아요 클릭")
			////////////////////
			// db
			////////////////////
			reviewNo = slides[slideIndex].getAttribute("data-reviewNo")
			userNo = document.querySelector(".login").getAttribute("data-userNo")

			let obj = {
				userNo : userNo,
				reviewNo : reviewNo
			}
			
			url = urlPath + "/toggleReviewLike"
			
			fetch(url, {
				method: "POST",
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(obj)
			}).then(response => response.json())
			.then(data => {
				////////////////////
				// 화면 
				////////////////////
		        if(data.result == "좋아요") {
		            heartBtn.innerHTML = '좋아요<i class="fa-solid fa-heart"></i>'
		        } else {
		            heartBtn.innerHTML = '좋아요<i class="fa-regular fa-heart"></i>'
		        }
			})
	    }
		
		/* 서평 플리에 추가 모달 버튼 (reviewNo, playlistNo, userNo)*/
	    addBtn.onclick = function(){
	
			if(autoMode == true) { 
				console.log("auto mode stop...")
				changeMode()
				/*
				autoMode = !autoMode
				play = !play	
				*/
			}

			userNo = document.querySelector(".login").getAttribute("data-userNo")
			reviewNo = slides[slideIndex].getAttribute("data-reviewno")

			url = urlPath + "/getMyPlaylistModal"
		
			let obj = {
				userNo: userNo,
				reviewNo: reviewNo
			}

			fetch(url, {
				method: "POST", 
				headers: {
					"Content-Type" : "application/json"
				},
				body : JSON.stringify(obj)})
			.then(response => response.json())
			.then(data => {
				
				/* 초기화 */
				document.querySelector(".playlist-box").querySelector("ul").innerHTML = ""
				
				renderPlaylist(data, "modal")
				
		        reviewModalBackground.classList.toggle("show-modal")

				/* 모달이 나오면 window가 Enter event 못 감지하도록 */
				window.removeEventListener("keydown", enterEventHandler)
			})
	    
		}
	}
	
    btnContainer.append(heartBtn, addBtn);
	a.append(review)
	
	if(item.videourl != null) {
		contentBox.append(a, username, btnContainer)
		slide.append(video, contentBox)
	} else {
		slide.append(a, username, btnContainer);
	}	
    slideContainer.append(slide)
    container.append(slideContainer);
}
