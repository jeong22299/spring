<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<title>도서 등록</title>
</head>
<body>
	<!-- 머리글에 해당하는 munu.jsp 파일의 내용을 포함하도록 include액션 태그 작성 -->
	<jsp:include page="menu2.jsp" />
	<div class="jumbotron">
		<!-- 내용넣기! -->
		<div class="container"> 
			<h1 class="display-3">도서 등록</h1>
		</div>
	</div>
	<!-- =========== 상품 상세 시작!============ -->
	<div class="container">
		<form name="newBook" action="/addBook"
 			  class="form-horizontal" method="post">
 			  <div class="form-group row">
 			  	<label class="col-sm-2">도서 아이디</label>
 			  	<div class="col-sm-3">
 			  		<input type="text" id="bookId" name="bookId" class="form-control">
 			  	</div>
 			  </div>
 			  <div class="form-group row">
 			  	<label class="col-sm-2">도서명</label>
 			  	<div class="col-sm-3">
 			  		<input type="text" id="name" name="name" class="form-control">
 			  	</div>
 			  </div>
 			  <div class="form-group row">
 			  	<label class="col-sm-2">가격</label>
 			  	<div class="col-sm-3">
 			  		<input type="text" id="unitPrice" name="unitPrice" class="form-control">
 			  	</div>
 			  </div>
 			  <div class="form-group row">
 			  	<label class="col-sm-2">저자</label>
 			  	<div class="col-sm-3">
 			  		<input type="text" name="author" class="form-control">
 			  	</div>
 			  </div>
 			  <div class="form-group row">
 			  	<label class="col-sm-2">상세 설명</label>
 			  	<div class="col-sm-3">
 			  		<textarea name="description" rows="2" cols="50" class="form-control"></textarea>
 			  	</div>
 			  </div>
			<div class="form-group row">
				<label class="col-sm-2">출판사</label>
				<div class="col-sm-3">
					<input type="text" name="publisher" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">분류</label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">재고 수</label>
				<div class="col-sm-3">
					<input type="text" id="unitsInStock" name="unitsInStock" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">총 페이지 수</label>
				<div class="col-sm-3">
					<input type="text" name="totalPages" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">출판일</label>
				<div class="col-sm-3">
					<input type="text" name="releaseDate" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상태</label>
				<div class="col-sm-5">
					<input type="radio" name="condition" value="New">신규 도서
					<input type="radio" name="condition" value="Old">중고 도서
					<input type="radio" name="condition" value="Refurbished">E-Book
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">책 이미지</label>
				<div class="col-sm-3">
					 <input type="file" name="filename" value="찾아보기...">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-primary" value="등록">
					<a href="/book" class="btn btn-secondary">상품목록</a>
				</div>
			</div>
		</form>

	</div>
	<!-- =========== 상품 상세 끝 ! =========== -->
	<jsp:include page="footer2.jsp" />
</body>
</html>
</html>