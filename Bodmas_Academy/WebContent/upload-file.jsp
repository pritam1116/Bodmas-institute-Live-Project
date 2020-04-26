<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--   <meta charset="ISO-8859-1">  -->
<title>Storage</title>
</head>
<body>
	<h2>Add your data</h2>
	<form action="StudentControllerServlet" method="post" enctype="multipart/form-data">
	<input type="hidden" name="command" value="FILES" /> 
		<div>
			Description of file:
			<textarea rows="8" cols="20" name="details"></textarea><br/><br/>
			Insert your file:
			<input type="file" name="file"  multiple/><br/><br/>
		    <input type="submit" value="Upload" />
		</div>

	</form>

</body>
</html>