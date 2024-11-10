<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		fieldset {
			background-color: #eeeeee;
		}

		input[type=text] {
			border: 2px solid darkslateblue;
			border-radius: 4px;
			width: 100%;
			padding: 12px 15px;
			margin: 8px 0;
			box-sizing: border-box;
		}
	</style>
</head>
<body>
<center>
<form action="updateservlet" method="post">
			<fieldset>
				<br><br>

				<h3 style="color: black;"> 1. GIN Number</h3>
				<br><br>
				<input type="text" name="gin" placeholder="please Enter your GIN number" size="130" value="${gin}">
				<br>
				<h3> 2. Name </h3>
				<input type="text" name="name" placeholder="Enter your name" value="${name}"><br>
				<h3 style="color: black;"> 3. Date</h3>
				<br><br>
				<input type="text" name="date" placeholder="Please input date(MM/DD/YYYY)" size="130" value="${date}">
				<br><br>
				<h3> 4. Working Status</h3>
				<label name="radio" name="radio" value="${workingstatus}"/> 
				<input type="radio" name="workingstatus" value="Working in Field" />Working in Field<br><br>
				<input type="radio" name="workingstatus" value="Work From Home" />Work From Home<br><br>
				<input type="radio" name="workingstatus" value="On Leave" />On Leave<br><br>

				<input type="radio" name="workingstatus" value="Public Holiday" />Public Holiday<br><br>

				<input type="radio" name="workingstatus" value="Work From Office" />Work From Office<br><br>

				<input type="radio" name="workingstatus" value="Under Training" />Under Training<br><br>


				<input type="radio" name="workingstatus" value="Half Day Leave" />Half Day Leave<br><br>
				<br>
				<input type="submit" value="submit">
			</fieldset>
		</form>
		</center>
</body>
</html>