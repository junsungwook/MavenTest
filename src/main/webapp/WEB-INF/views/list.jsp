<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
<div class="container" id="results">

	<h1>회원목록보기</h1>
	<h3><a href="insert">회원가입</a></h3>
	<table class="table">
		<tr>
		<th>아이디</th>
		<th>성명</th>
		<th>주소</th>
		<th>메모</th>
		<th>삭제</th>
		</tr>
		<c:forEach items="${arr }" var="user">
		<tr>
		<td>${user.id }</td>
		<td><a href="detail?id=${user.id }">${user.name }</a></td>
		<td>${user.addr }</td>
		<td>${user.memo }</td>
		<td><a href="delete?id=${user.id }">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
	<form name="search" action="list">
		<div class="col-xs-2" id="sele">
		   <select id="field" class="form-control" name="field">
		      <option value="name"> 이름
		      <option value="addr"> 주소
		   </select>
		</div>
		<div class="col-xs-3">
		   <input type='text' id='word' name='word' size='10' class="form-control" placeholder="검색어입력">
		</div>
		   <input type='submit' class="btn btn-default" value="검색">
	</form>
    <div align="center">
        <!-- 이전 -->
        <c:if test="${startpage>blockpage }">
           <a href="list?pageNum=${startpage-blockpage }">[이전]</a>
        </c:if>
        <!-- 페이지출력 -->
        <c:forEach begin="${startpage }" end="${endpage }" var="i">
           <c:if test="${currentPage eq i}" >
              ${i }
           </c:if>
           <c:if test="${currentPage ne i}" >
              <a href="list?pageNum=${i }">${i }</a>
           </c:if>
        </c:forEach>
        <!-- 다음 -->
        <c:if test="${endpage<totpage }">
           <a href="list?pageNum=${endpage+1 }">[다음]</a>
        </c:if>
   </div>

</div>
</body>
</html>