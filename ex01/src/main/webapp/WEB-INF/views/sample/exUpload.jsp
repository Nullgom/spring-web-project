<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">
	<div><input type="file" name="files" /></div>
	<div><input type="file" name="files" /></div>
	<div><input type="file" name="files" /></div>
	<div><input type="file" name="files" /></div>
	<div><input type="file" name="files" /></div>
	<div><input type="submit" value="파일전송" /></div>
</form>
</body>
</html>