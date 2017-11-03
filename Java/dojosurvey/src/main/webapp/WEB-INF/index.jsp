<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/submit">
	<label>Name: <input type="text" name="name"></label>
	<label>Dojo Location: 
		<select name="location">
			<option value="San Jose">San Jose</option>
			<option value="Washington, DC">Washington, DC</option>
			<option value="California">California</option>
		</select>
	</label>
	<label>Favorite Language: 
		<select name="language">
			<option value="Python">Python</option>
			<option value="Java">Java</option>
			<option value="Python">MEAN</option>
		</select>
	</label>
	<label>Comment (Optional): <input type="text" name="comment"></label>
	<input type="submit" value="Submit">
</form>
</body>
</html>