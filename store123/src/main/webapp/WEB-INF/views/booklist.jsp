<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>코드팜 북스토어</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
<script>
	function fn_room(productid){
		var frm = document.getElementById('detail1');
		document.detail.productid.value=productid;
		frm.action ="basket.do";
		frm.submit(); 
	}
	function fn_search(){
		var frm = document.getElementById('detail1');
		frm.action ="booklist.do";
		frm.submit(); 
	}
</script>
<form name="detail" id="detail1" method="post">
<h2>게시판 목록</h2>
<div>
<div align="left">
${id}님 안녕하세요.<br>
남은 포인트:${loginlist[0].point}
</div>
<div>
<span>
<select name="search">
<option value="1">전체</option>
<option value="2">번호</option>
<option value="3">책이름</option>
<option value="4">저자</option>
<option value="5">출판사</option>
</select>
<input type="text" name="searching" width="200"/>
<input type="button" value="검색" onclick="fn_search()"/>
</span>
<br><br>
<table border=1>
    <thead>
        <tr>
            <th scope="col">번호</th>
            <th scope="col">책이름</th>
            <th scope="col">가격</th>
            <th scope="col">저자</th>
            <th scope="col">출판사</th>
			<th scope="col">장바구니</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${fn:length(list) > 0}">
                <c:forEach items="${list}" var="row">
                    <tr>
                        <td>${row.productid}</td>
                        <td>${row.productname}</td>
                        <td>${row.price}</td>
                        <td>${row.autor}</td>
                        <td>${row.publisher}</td>
                        <td><a href="#" onclick="fn_room('${row.productid}');">담기</a></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="4">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>  
    </tbody>
</table>
<input type="hidden" id="productid" name="productid" value="rrrrr"/>
<a href=room.do>장바구니로</a>
<a href=home.do>로그아웃</a>

</div>
</div>
</form>

</body>
</html>
