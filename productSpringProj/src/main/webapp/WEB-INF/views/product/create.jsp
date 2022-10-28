<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<title>상품 등록</title>
<style type="text/css">
	.imgs_wrap{
		width: 100px;
		margin-top: 50px; 
	}
	.imgs_wrap img{
		max_width:100%;
	}
</style>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	// 이미지 미리보기 시작/////////////////
	let sel_file = [];
	
	// multiple
	$("#productImage").on("change", handleImgFileSelect);
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
	// 이미지 미리보기 끝  ////////////////
});
</script>

</head>
<body>
 	<div class="jumbotron">
 		<!-- 내용드루와 -->
 		<div class="container">
 			<h1 class="display-3">상품등록</h1>
 		</div>
 	</div>
 	<!-- =========== 상품 등록 시작 ============ -->
 	
 	<div class="container">
 		<form  action="/create" method="post" class="form-horizontal" enctype="multipart/form-data">
 			  <div class="form-group row">
 			  	<label class="col-sm-2">상품 코드</label>
 			  	<div class="col-sm-3">
 			  		<input type="text" id="productId" name="productId" class="form-control">
 			  	</div>
 			  </div>
 			  <div class="form-group row">
 			  	<label class="col-sm-2">상품명</label>
 			  	<div class="col-sm-3">
 			  		<input type="text" id="pname" name="pname" class="form-control">
 			  	</div>
 			  </div>
 			  <div class="form-group row">
 			  	<label class="col-sm-2">상품 가격</label>
 			  	<div class="col-sm-3">
 			  		<input type="text" id="unitPrice" name="unitPrice" class="form-control">
 			  	</div>
 			  </div>
 			  <div class="form-group row">
 			  	<label class="col-sm-2">상품 설명</label>
 			  	<div class="col-sm-3">
 			  		<textarea name="description" id="description" rows="2" cols="50" class="form-control"></textarea>
 			  	</div>
 			  </div>
 			  <div class="form-group row">
 			  	<label class="col-sm-2">제조사</label>
 			  	<div class="col-sm-3">
 			  		<input type="text" id="manufacturer" name="manufacturer" class="form-control">
 			  	</div>
 			  </div>
			<div class="form-group row">
				<label class="col-sm-2">분류</label>
				<div class="col-sm-3">
					<input type="text" id="category" name="category" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">재고 수</label>
				<div class="col-sm-3">
					<input type="text" id="unitsInStock" name="unitsInStock" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상태</label>
				<div class="col-sm-5">
					<input type="radio" id="condition1" name="condition" value="New" ><label for="condition1">신규 상품</label>		
					<input type="radio" id="condition2" name="condition" value="Old" ><label for="condition2">중고 상품</label>					
					<input type="radio" id="condition3" name="condition" value="Refurbished" ><label for="condition3">재생상품</label>	
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">이미지</label>
				<div class="col-sm-5">
					<input type="file" id="productImage" name="productImage" class="form-control" multiple>
				</div>
			</div>
			<div class="form-group row">
				<div class="imgs_wrap">
					
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<p>
						<input type="submit" value="저장" class="btn btn-primary">
						<button type="button" class="btn btn-secondary"  onclick="javascript:location.href='products'">목록</button>
					</p>
				</div>
			</div>
		</form>
 	</div>
 	<!-- =========== 상품 등록 끝 ============ -->
</body>
</html>








