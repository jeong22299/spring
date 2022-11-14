<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="/resources/js/validation.js"></script>
<style type="text/css">
	.imgs_wrap{
		width: 100%;
		margin-top: 30px; 
	}
	.imgs_wrap img{
		width: 180px;
		height:180px;
		display: inline-block;
	}
</style>
<script type="text/javascript">
	$(function() {
		// 이미지 미리보기 시작/////////////////
		let sel_file = [];
		$("#pictureArray").on("change", handleImgFileSelect);
		// 파라미터 e : onchange 이벤트 객체
		function handleImgFileSelect(e){
			// 이벤트가 발생된 타겟 안에 이미지 파일들을 가져와보자 
			let files = e.target.files;
			// 이미지가 여러개 있을 수 있으므로 이미지를 분리하여 배열로 만듦
			let fileArr = Array.prototype.slice.call(files);
			// 파일 타입의 배열 반복. f : 파일 배열 안에 들어있는 각각의 이미지 파일 객체
			fileArr.forEach(function(f){
				// 이미지 파일이 아닌 경우 이미지 미리보기 실패로 처리
				if(!f.type.match("image.*")){
					alert("이미지 확장자만 가능합니다.");
					// 함수를 종료
					return;
				}
				// 이미지 객체를(f) 전역 배열타입 변수(sel_file)에 넣자
				sel_file.push(f);
				// 이미지 객체를 읽을 자바스크립트의 reader 객체 생성
				let reader = new FileReader();
				// e: reader가 이미지 객체를 읽는 이벤트
				reader.onload = function(e){
					// e.target : 이미지 객체
					// e.target.result : reader가 이미지를 다 읽은 결과
					let img_html = "<img src=\"" + e.target.result + "\" />";
					// 객체.append : 누적, .html : 새로고침, innerHTML : J/S
					$(".imgs_wrap").append(img_html);
				}
				// f : 이미지 파일 객체를 읽은 후 다음 이미지 파일(f)을 위해 초기화	
				reader.readAsDataURL(f);
			});
		}
			
		$("#btnDup").on("click", function(){
			let memId = $("#memId").val();
			
			if(memId==""){
				alert("아이디가 없습니다 아이디를 입력하세요");
				$("#memId").focus();
				return;
			}
			
			let data = {"memId": memId};
			// 아작났어유 피시다탔어
			$.ajax({
				url: "/board/chkDup",
				contentType: "application/json;charset=utf-8",
				data: JSON.stringify(data),
				type: "post",
				success: function(result){
					console.log("result : "+ JSON.stringify(result));
					console.log("result.result : "+ result.result);
					// 중복 시 1, 중복이 안되면 0
					let dupRslt = result.result;
					
					if(dupRslt>0){
						alert("사용중인 아이디입니다.");
						$("#memId").focus();
						// 등록버튼 비활성화
						$("#btnSubmit").attr("disabled", true);
// 						$("#btnSubmit").attr("disabled", "disabled");
					}else{// 중복이 안되면 
						$("#btnSubmit").attr("disabled", false);
// 						$("#btnSubmit").removeAttr("disabled");
						
					}
				}
			});
		});
		
	});
	
</script>


<div class="card shadow mb-4">
	<!-- Card Header - Accordion -->
	<a href="#collapseCardExample" class="d-block card-header py-3"
		data-toggle="collapse" role="button" aria-expanded="true"
		aria-controls="collapseCardExample">
		<h6 class="m-0 font-weight-bold text-primary">Collapsable Card
			Example</h6>
	</a>
	<!-- Card Content - Collapse -->
	<div class="collapse show" id="collapseCardExample">
		<div class="card-body">
			<!-- ================card body 시작================= -->
			<form id="frm" name="frm" action="/board/addBoard" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label d-inline">회원아이디</label>
					<input type="text" class="form-control" name="memId" id="memId"
						placeholder="memId" required />
						<button type="button" id="btnDup" class="btn btn-primary d-inline">
						<span class="text"> 아이디 중복 체크</span>
						</button>
				</div>
				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">이름</label>
					<input type="text" class="form-control" name="memName" id="memName"
						placeholder="memName" required />
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">직업</label>
					<input type="text" class="form-control" name="memJob" id="memJob"
						placeholder="memJob" required />
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">취미</label>
					<input type="text" class="form-control" name="memLike" id="memLike"
						placeholder="memLike" required />
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">전화번호</label>
					<input type="text" class="form-control" name="memHp" id="memHp"
						placeholder="memHp" required />
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">사진</label>
					<input class="form-control" type="file" id="pictureArray" name="pictureArray" multiple>
				</div>
				<div class="form-group row">
					<div class="imgs_wrap">
					</div>
				</div>
				<div class="mb-3">
					<button type="button" id="btnSubmit" onclick="CheckAddBoard()" class="btn btn-primary btn-icon-split" disabled> <span
						class="icon text-white-50"> <i class="fas fa-flag"></i>
					</span> <span class="text">등록</span>
					</button>
					<a href="/board/boardlist"   class="btn btn-secondary btn-icon-split" disabled > <span
						class="icon text-white-50"> <i class="fas fa-flag"></i>
					</span> <span class="text">취소</span>
					</a>
				</div>
			</form>
		</div>
	</div>
</div>