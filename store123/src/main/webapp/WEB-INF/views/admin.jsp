<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>괄리자 페이지</title>
</head>
<script>	
		function gogo(){
			var frm = document.getElementById('detail');
			var productname=document.detail.productname.value.trim();
			var price=document.detail.price.value.trim();
			var autor=document.detail.autor.value.trim();
			var publisher=document.detail.publisher.value.trim();

			if(productname=="")
				alert("상품명를 입력하시오");
			else if(price=="")
				alert("가격를 입력하시오");
			else if(autor=="")
				alert("저자를 입력하시오");	
			else if(publisher=="")
				alert("출판사를 입력하시오");
			else{
				frm.action ="insertproduct.do";
				frm.submit();
			}
		}		
		function fn_logout(){
			var frm = document.getElementById('detail');
				frm.action ="home.do";
				frm.submit();
		}	
</script>
<body>
<form name="detail" id="detail" method="post">
<h2>관리자가 책을 올리는 공간</h2>
	<table border=1 cellpadding=10>
		<tr>
		<td>
			책이름: <input type="text" name="productname"/><br><br>
			가격: <input type="text" name="price"/><br><br>
			저자: <input type="text" name="autor"/><br><br>
			출판사: <input type="text" name="publisher"/></td>
			<span>모든내용은 빠짐없이 다 작성 해야됨</span>
			<input type="hidden" name="point" value="10000"/>
		</tr>
</table>
<input type="button" name="btn" onclick="gogo()" value="올리기">
<input type="button" name="btn" onclick="fn_logout()" value="로그아웃">
</form>
</body>
</html>