<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../includes/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Board Modify Page</h1>
	<p class="mb-4">게시판 글 보기</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Board Modify Page</h6>
		</div>
		<div class="card-body">
			<form role="form" action="/board/modify" method="post">
				<div class="mb-3">
					<label for="inputBno" class="form-label">Bno</label> 
					<input type="text" name="bno" class="form-control" id="inputBno"
						value="<c:out value='${board.bno}' />" readonly />
				</div>
				<div class="mb-3">
					<label for="inputTitle" class="form-label">Title</label> 
					<input type="text" name="title" class="form-control" id="inputTitle"
						value="<c:out value='${board.title}' />" />
				</div>
				<div class="mb-3">
					<label for="inputContent" class="form-label">Content</label>					
					<textarea name="content" class="form-control" id="inputContent" rows="3"
						placeholder="글 내용 입력"><c:out value='${board.content}' /></textarea>
				</div>
				<div class="mb-3">
					<label for="inputWriter" class="form-label">Writer</label>
					<input type="text" name="writer" class="form-control" id="inputWriter" 
						value="<c:out value='${board.writer}' />" readonly />
				</div>
				<button type="submit" class="btn btn-success" data-oper="modify">Modify</button>				
				<button type="submit" class="btn btn-danger"  data-oper="remove">Remove</button>
				<a href="/board/list" class="btn btn-secondary" data-oper="list">List</a>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		var formObj = $('form');
		
		$('button').on('click', function(e){
			e.preventDefault();
			
			var operation = $(this).data('oper');
			
			console.log(operation);
			
			if(operation === 'remove') {
				formObj.attr('action', "/board/remove");
			} else if (operation === 'modify')  {
				formObj.attr('action', "/board/modify");
			}
			formObj.submit();
		});
	});
</script>
<%@ include file="../includes/footer.jsp"%>