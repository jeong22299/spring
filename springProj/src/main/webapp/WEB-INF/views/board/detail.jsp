<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="/resources/js/validation.js"></script>

<div class="card shadow mb-4">
	<!-- Card Header - Accordion -->
	<a href="#collapseCardExample" class="d-block card-header py-3"
		data-toggle="collapse" role="button" aria-expanded="true"
		aria-controls="collapseCardExample">
		<h6 class="m-0 font-weight-bold text-primary">회원정보</h6>
	</a>
	<!-- Card Content - Collapse -->
	<div class="collapse show" id="collapseCardExample">
		<div class="card-body">
			<!-- ================card body 시작================= -->
			<form id="frm" name="frm" action="/board/addBoard" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label ">회원아이디</label>
					<input type="text" class="form-control" name="memId" id="memId"
						placeholder="memId" value="${memVO.memId}" readonly />
				</div>
				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">이름</label>
					<input type="text" class="form-control" name="memName" id="memName"
						placeholder="memName" value="${memVO.memName}" readonly />
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">직업</label>
					<input type="text" class="form-control" name="memJob" id="memJob"
						placeholder="memJob"  value="${memVO.memJob}"   readonly />
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">취미</label>
					<input type="text" class="form-control" name="memLike" id="memLike"
						placeholder="memLike" value="${memVO.memLike}" readonly />
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">전화번호</label>
					<input type="text" class="form-control" name="memHp" id="memHp"
						placeholder="memHp"  value="${memVO.memHp}" readonly />
				</div>
				<div class="mb-3">
					<label for="exampleFormControlInput1" class="form-label">사진</label>
					<input class="form-control" type="file" id="pictureArray" name="pictureArray" multiple style="display:none;">
				</div>
				<div class="mb-3">
					<div class="imgs_wrap">
					<!-- MemController 에서 직접옴 -->
						<c:forEach var="attachVO" items="${attachVOList}">
							<img  src="/resources/upload${attachVO.attachName }" style="width: 170px; height: 150px;">
						</c:forEach>
						<!-- memVO 객체의 멤버변수를 끄집어냄 -->
						<c:forEach var="attachVO" items="${memVO.attachVOList}">
							<img  src="/resources/upload${attachVO.attachName }"style="width: 170px; height: 150px;">
						</c:forEach>
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