<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<title>책 등록하기</title>
<script type="text/javascript">
$(function() {
	// 취소버튼 클릭 이벤트
	$("#btnCancel").on("click", function() {
		// EL 태그 데이터를 JS변수에 저장
		let bookId = "${param.bookId}"
		location.href="/detail?bookId=" + bookId
// 		location.href="/detail?bookId=${data.bookId}"
	});
	
	// 목록 버튼 클릭 이벤트
	$("#btnList").on("click", function(){
		location.href="/list";
	});
});
</script>
</head>
<body>
<h1>책 수정</h1>
<!--  BookController에서 넘어온 데이터?
	BookVO data = this.bookservice.selectDetail(bookVO);
	mav.addObject("data", data);
 -->
<form action="/update" method="post">
	<input type="hidden" name="bookId" value="${data.bookId}">
	<p>제목 : <input type="text" name="title" value="${data.title}" required="required"></p>
	<p>카테고리 : <input type="text" name="category" value="${data.category}" required="required"></p>
	<p>가격 : <input type="text" name="price" value="${data.price}" required="required"></p>
	<p>
		<input type="submit" value="저장">
		<input type="button" value="취소" id="btnCancel">
		<button type="button" id="btnList">목록</button>
<!-- 	<button type="button" value="목록"> -->
	</p>
</form>
</body>
</html>