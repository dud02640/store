<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%-- <%
request.setCharacterEncoding("utf-8");
%>
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>	
		function gogo(){
			var frm = document.getElementById('detail');
			var id=document.detail.id.value.trim();
			var pw=document.detail.pw.value.trim();
			var name=document.detail.name.value.trim();
			var phone=document.detail.phone.value.trim();
			var address=document.detail.address.value.trim();
				if(id=="")
					alert("아이디를 입력하시오");
				else if(pw=="")
					alert("비밀번호를 입력하시오");
				else if(name=="")
					alert("이름를 입력하시오");	
				else if(phone=="")
					alert("폰번호를 입력하시오");
				else if(address=="")
					alert("주소를 입력하시오");
				else{
					frm.action ="insert.do";
					frm.submit();
				}
		}
		function fn_gohome(){
			var frm = document.getElementById('detail');
				frm.action ="home.do";
				frm.submit();
		}	
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원가입 페이지</title>
</head>
<body>

<form name="detail" id="detail" method="post">
<h2>회원가입</h2>
<table border=1 cellpadding=10>
		<tr>
		<td>아이디:   <input type="text" name="id"/><br><br>
			비밀번호: <input type="password" name="pw"/><br><br>
			이름: <input type="text" name="name"/><br><br>
			전화번호: <input type="text" name="phone"/><br><br>
			주소: <input type="text" name="address"/></td>
			<span>모든내용은 빠짐없이 다 작성 해야됨</span>
			<input type="hidden" name="point" value="10000"/>
		</tr>
</table>
<!-- <button>가입</button> -->
<!-- <a herf="#" value="가입" onclick="gogo()">가입</a> -->
<input type="button" name="btn" onclick="gogo()" value="가입">
<input type="button" name="btn" onclick="fn_gohome()" value="홈으로">
</form>
</body>
</html>