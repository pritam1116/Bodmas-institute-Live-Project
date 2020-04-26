<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Storage</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

	<div id="wrapper">
	<div id="header">
		<h2>Bodmas Institute(Munna Boss ka)</h2>
	</div>
</div>

<div id="container">
	<div id="content">
		
		
		 
		
		<table>
			<tr>
				<th>Serial Number</th>
				<th>Description</th>
				<th>Videos</th>
				
			</tr>
			
	
			
			
			
			
			<c:forEach var="tempStorage" items="${STORAGE_LIST}">
				
				
				
				<tr>
					<td> ${tempStorage.id} </td>
					<td> ${tempStorage.details} </td>
					<td> ${tempStorage.s} </td>  
					<td>
					
					<video width="320" height="240" controls>
  					<source src="${tempStorage.s}" type="video/mp4">
  					<source src="movie.ogg" type="video/ogg" type="video/ogg">
  					Your browser does not support the video tag.
					</video>
					
					
					</td> 

						
				</tr>

			</c:forEach>

		</table>
		

					
					
					
					
					
		
		<iframe width="560" height="315" src="https://www.youtube.com/embed/i_yLpCLMaKk" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	</div>
</div>

</body>
</html>