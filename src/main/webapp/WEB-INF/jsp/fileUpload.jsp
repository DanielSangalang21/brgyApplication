<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="base/TagLib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>File Upload test</h1>
	<form:form method="post" enctype="multipart/form-data" modelAttribute="applicant">
		<input type="file" id="imageFile" name="imageFile">
		<form:button>Upload</form:button>
	</form:form>
</body>
</html>