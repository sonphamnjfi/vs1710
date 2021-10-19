<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>QUAN LY SINH VIEN</title>
</head>
<body>
	<%
		String formtitle="QUẢN LÝ THÔNG TIN SINH VIÊN";
	%>
	<h4><%= formtitle%></h4>
	<FORM method="post" action='svqlsv'>
	Mã SV	<input type='text' name='parmasv' value=''><br> 
	Họ đệm SV:	<input type='text' name='parhodemsv' value=''><br> 
	Tên SV:	<input type='text' name='partensv' value=''><br> 
	Số điện thoại:<input type='text' name='partelsv' value=''><br>
	Email:<input type='text' name='paremailsv' value=''><br>
	<input type="submit" value='Lưu SV mới' name='btnSavesv'/>
	</FORM>
</body>
</html>