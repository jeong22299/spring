<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보</title>
</head>
<body>
	<h2>회원정보</h2>

	<table border="1px">
		<thead>
			<tr>
				<th>#</th>
				<th>회원아이디</th>
				<th>회원명</th>
				<th>직업</th>
				<th>취미</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list}" varStatus="stat">
				<tr>
					<td>${stat.count}</td>
					<td>${list.memId}</a></td>
					<td>${list.memName}</td>
					<td>${list.memJob}</td>
					<td>${list. }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>