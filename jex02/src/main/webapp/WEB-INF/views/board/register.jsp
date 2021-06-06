<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../includes/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Board Register</h1>
	<p class="mb-4">게시판 새 글 작성 하기</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Board Register</h6>
		</div>
		<div class="card-body">
			<form role="form" action="/board/register" method="post">
				<div class="mb-3">
					<label for="inputTitle" class="form-label">Title</label> 
					<input type="text" name="title" class="form-control" id="inputTitle" placeholder="제목을 입력하세요." />
				</div>
				<div class="mb-3">
					<label for="inputContent" class="form-label">Content</label>					
					<textarea name="content" class="form-control" id="inputContent" rows="3"
						placeholder="글 내용을 입력하세요"></textarea>
				</div>
				<div class="mb-3">
					<label for="inputWriter" class="form-label">Writer</label>
					<input type="text" name="writer" class="form-control" id="inputWriter" placeholder="작성자를 입력하세요" />
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
				<button type="reset" class="btn btn-secondary">Reset</button>
			</form>
		</div>
	</div>

</div>
<%@ include file="../includes/footer.jsp"%>