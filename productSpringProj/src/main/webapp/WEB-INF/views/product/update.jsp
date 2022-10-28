<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<title>상품 수정하기</title>
<script type="text/javascript">
$(function() {
	// 취소버튼 클릭 이벤트
	$("#btnCancel").on("click", function() {
		// EL 태그 데이터를 JS변수에 저장
		let productId = "${param.productId}"
		location.href="/product?productId=" + productId
	});
	
	// 목록 버튼 클릭 이벤트
	$("#btnList").on("click", function(){
		location.href="/products";
	});
	
});


</script>
</head>
<body>
<jsp:include page="menu.jsp" />
 	<div class="jumbotron">
 		<!-- 내용드루와 -->
 		<div class="container">
 			<h1 class="display-3">상품 수정</h1>
 		</div>
 	</div>
 	<div class="container"> 	
		<form action="/update" method="post">
			<input type="hidden" name="productId" value="${data.productId}">
<!--   			<div class="form-group row"> -->
<!--  			  	<label class="col-sm-2">상품 코드</label> -->
<!--  			  	<div class="col-sm-3"> -->
<%--  			  		<input type="text" id="productId" name="productId" value="${data.productId}" class="form-control"> --%>
<!--  			  	</div> -->
<!--  			</div> -->
 			  <div class="form-group row">
 			  	<label class="col-sm-2">상품명</label>
 			  	<div class="col-sm-3">
 			  		<input type="text" id="pname" name="pname" value="${data.pname}" class="form-control">
 			  	</div>
 			  </div>
 			  <div class="form-group row">
 			  	<label class="col-sm-2">상품 가격</label>
 			  	<div class="col-sm-3">
 			  		<input type="text" id="unitPrice" name="unitPrice"  value="${data.unitPrice}" class="form-control">
 			  	</div>
 			  </div>
 			  <div class="form-group row">
 			  	<label class="col-sm-2">상품 설명</label>
 			  	<div class="col-sm-3">
 			  		<textarea  name="description" id="description"  rows="2" cols="50" class="form-control">${data.description}</textarea>
 			  	</div>
 			  </div>
 			  <div class="form-group row">
 			  	<label class="col-sm-2">제조사</label>
 			  	<div class="col-sm-3">
 			  		<input type="text" id="manufacturer" name="manufacturer" value="${data.manufacturer}" class="form-control">
 			  	</div>
 			  </div>
			<div class="form-group row">
				<label class="col-sm-2">분류</label>
				<div class="col-sm-3">
					<input type="text" id="category" name="category" value="${data.category}" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">재고 수</label>
				<div class="col-sm-3">
					<input type="text" id="unitsInStock" name="unitsInStock" value="${data.unitsInStock}" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상태</label>
				<div class="col-sm-5">
					<input type="radio" id="condition1" name="condition" value="New" 
						<c:if test="${data.condition == 'New'}">checked</c:if>>
						<label for="condition1">신규 상품</label> 				
					<input type="radio" id="condition2" name="condition" value="Old" 
						<c:if test="${data.condition == 'Old'}">checked</c:if>><label for="condition2">중고 상품</label>			
					<input type="radio" id="condition3" name="condition" value="Refurbished" 
						<c:if test="${data.condition == 'Refurbished'}">checked</c:if>><label for="condition3">재생상품</label>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">이미지</label>
				<div class="col-sm-5">
					<input type="file" id="filename" name="filename" class="form-control" value="${data.filename}">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="저장" class="btn btn-outline-primary">
					<input type="button" value="취소" id="btnCancel" class="btn btn-outline-primary">
					<button type="button" id="btnList" class="btn btn-outline-primary">목록</button>
				</div>
			</div>
	<jsp:include page="footer.jsp" />
</form>
 </div>
</body>
</html>