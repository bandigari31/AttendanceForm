<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="EditServlet" method="post">
		<center>
			<img src="tick.jpg"></img>
			<h3>Submitted!</h3>
			<br>
			<p>Hello,</p>

			<p>Your response was submitted Successfully.</p>
			<p>Thank You..</p>

			<br> <br> <input type="submit" value="Edit Your Response">
			<input type="hidden" name="gin" value="${gin}"> <input
				type="hidden" name="name" value="${name}"> <input
				type="hidden" name="workingstatus" value="${workingstatus}">
			<input type="hidden" name="time" value="${time}">
		</center>
	</form>
</body>
</html>