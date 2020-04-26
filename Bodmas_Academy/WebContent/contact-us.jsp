<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Contact Us</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="contact-us/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="contact-us/css/style.css">
		<script>
		function show_alert() {
			
			
				if(document.getElementById("x1").value!="" && document.getElementById("x2").value!="" 
								&& document.getElementById("x3").value!=""){
					alert("Thank you for contacting! we will back to you soon.");
				}

				  	
			}
		</script>
	</head>

	<body>

		<div class="wrapper">
			<div class="inner">
				<form action="StudentControllerServlet" method="get">
				<input type="hidden" name="command" value="CONTACT">
					<h3>Contact Us</h3>
					<p>HAVE A QUESTION? WE HAVE</p> 
					<p> ANSWERS!</p>
					<label class="form-group">
						<input type="text" class="form-control" name="name" id="x1" required>
						<span>Your Name</span>
						<span class="border"></span>
					</label>
					<label class="form-group">
						<input type="email" class="form-control" name="email" id="x2" required>
						<span for="">Your Mail</span>
						<span class="border"></span>
					</label>
					<label class="form-group" >
						<textarea name="message" id="x3" class="form-control" required></textarea>
						<span for="">Your Message</span>
						<span class="border"></span>
					</label>
					<button onclick="show_alert();">
					Submit 
						<i class="zmdi zmdi-arrow-right"></i>
					</button>
					<div style="clear: both;"></div>
					<p>
					   <i class="zmdi zmdi-arrow-right"></i>
						<a href="home.jsp" style="color: aquamarine;">Back to Home</a>
					</p>
					</div>
				</form>
			</div>
		</div>
		
	</body>
</html>