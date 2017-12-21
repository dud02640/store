<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 장바구니 페이지</title>
</head>
<body>
<script>
	function fn_room(price,productid){
		var frm = document.getElementById('detail1');
		document.detail.price.value=price;
		document.detail.productid.value=productid;
 		if(parseInt(document.detail.price.value)>parseInt(document.detail.point.value)){
			alert("포인트가 부족합니다.!!");
			frm.action ="room.do";
			frm.submit(); 
		}else{	 	
		frm.action ="updatepoint.do";
		frm.submit();
	 	} 
	}
	function fn_deletebasket(price,productid){
			var frm = document.getElementById('detail1');
			document.detail.price.value=price;
			document.detail.productid.value=productid;
			frm.action ="deletebasket.do";
			frm.submit();
		}
</script>
<h2>나의  장바구니</h2>
<form name="detail" id="detail1" method="post">
<div align="left">
${id}님 안녕하세요.<br>
남은 포인트: ${loginlist[0].point}
</div>
<table border=1>
        <tr>
            <th scope="col">번호</th>
            <th scope="col">구매자</th>
            <th scope="col">책이름</th>
            <th scope="col">가격</th>
            <th scope="col">저자</th>
            <th scope="col">출판사</th>
            <th scope="col">구매상태</th>
            <th scope="col">삭제여부</th>
        </tr>
		<c:forEach items="${purchaselist}" var="rw">
                    <tr>
                        <td>${rw.productid}</td>
                        <td>${id}</td>
                        <td>${rw.productname}</td>
                        <td>${rw.price}</td>
                        <td>${rw.autor}</td>
                        <td>${rw.publisher}</td>
	                        <c:if test="${rw.purchaseYN eq 'N'}" >
							<td><a href="#" onclick="fn_room('${rw.price}','${rw.productid}')">구매하기</a></td> 
							</c:if> 
							<c:if test="${rw.purchaseYN eq 'Y'}" >
							<td>구매완료</td>
							<td><a href="#" onclick="fn_deletebasket('${rw.price}','${rw.productid}')">삭제</a></td>
							</c:if>	
                    </tr>
		</c:forEach>
</table>
<input type="hidden" id="price" name="price">
<input type="hidden" id="productid" name="productid" />
<input type="hidden" id="point" name="point" value="${loginlist[0].point}">
<a href=booklist.do>게시글로</a>
</form>
</body>
</html>