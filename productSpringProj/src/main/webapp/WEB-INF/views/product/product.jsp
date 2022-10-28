<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 
	BookController로부터 넘어오는 정보 2가지
	1) mav.addObject("data", data); => bookVO 객체
	2) mav.addObject("bookId", data.getBookId()); => 기본키 데이터(int 타입)
 -->
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<title>상품 상세</title>
<script type="text/javascript">
function addToCart() {
	console.log("왔다.");
	let result = confirm("상품을 장바구니에 추가하시겠습니까?");
	
	if(result){  // true
		console.log("true");
		document.addForm.submit();
	}else{	//false
		console.log("false");
		document.addForm.reset();  // 초기화
	}
}
</script>
</head>
<body>
<jsp:include page="menu.jsp" />
<!-- 
	JSTL(JSP Standard Tag Library) : 개발자가 자주 사용하는 패턴을 모아놓은 집합
	=> BookController에서 보내준 데이터를 View에 표현하도록 도와줌
	JSTL은 maven에서 설정되어 있음 => pom.xml => jstl
 -->
	<div class="jumbotron">
		<!-- container : 이 안에 내용있다 -->
		<div class="container">
			<h1 class="display-3">상품 상세</h1>
		</div>
	</div>
	<div class="container">
		<div class="row" align="left">
			<div class="col-md-4">
				<img src="/resources/images/${data.filename}"
				style="width:100%; height: 100%" alt="${data.pname}" title="${data.pname}" />
			</div>
			<div class="col-md-4">
				<h3>${data.pname}</h3>
				<p>${data.description}</p>
				<p><b>상품아이디 :</b> <span class="badge badge-danger">${data.productId}</span></p>
				<p><b>제조사 :</b> ${data.manufacturer}</p>
				<p><b>분류 :</b> ${data.category}</p>
				<p><b>재고수 : </b>${data.unitsInStock}</p>
				<p><b>상태 : </b>${data.condition}</p>
				<h4>상품 가격 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${data.unitPrice}"></fmt:formatNumber></h4>
			</div>
		</div>
		<br>
		<div class="form-group row" align="center">
			<div class="col-sm-offset-2 col-sm-10">
				<form action="/addCart" name="addForm" method="post" class="d-inline">
					<input type="hidden" name="productId" value="${data.productId}">
					<a href="/update?productId=${data.productId}" class="btn btn-success">수정폼</a>
					<a href="/products" class="btn btn-primary">목록으로이동</a>
					<a href="#" class="btn btn-info" onclick="addToCart()">상품주문</a>
					<a href="/cart" class="btn btn-outline-warning">장바구니</a>
				</form>
				<form action="/delete" method="post" class="d-inline">
					<input type="hidden" name="productId" value="${productId}">
					<input type="submit" value="삭제" class="btn btn-danger">
				</form>	
			</div>
		</div>
	</div>			

	<jsp:include page="footer.jsp" />
</body>
</html>