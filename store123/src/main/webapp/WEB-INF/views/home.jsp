<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" %>
    <%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<script>	
		function fn_openBoardList(){
			var frm = document.getElementById('detail');
			frm.action ="booklist.do";
			frm.submit();
		}
		function fn_openSignup(){
			var frm = document.getElementById('detail');
			frm.action ="signup.do";
			frm.submit(); 
		}
</script>
<h1>
	codefarm 북스토어
</h1>
<form name="detail" id="detail" method="post">
<table border=1 cellpadding=10>

		<tr>
		<td>아이디:   <input type="text" name="id"><br><br>
			비밀번호: <input type="password" name="pw"></td>
		</tr>

</table>
		<a href="#" onclick="fn_openBoardList()">로그인</a>
		<a href="#" onclick="fn_openSignup()">회원가입</a>
</form>
</body>
</html>
