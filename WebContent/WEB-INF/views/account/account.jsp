<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비트 은행</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
	<h2>환영합니다</h2>
	<table border="1">
		<tr>
			<td>로그인</td>
			<td><input id="btn" type="button" value="LOGIN"/></td>
		</tr>
		<tr>
			<td>회원가입</td>
			<td><a id="a_join" href="#">바로가기</a></td>
		</tr>
	</table>
	
	
</div>
<script>
$('#btn').click(function(){
	alert('버튼클릭!!');
});
$('#a_join').click(function(){
	alert('회원가입 클릭');
	location.assign('<%=request.getContextPath()%>/member.do');
});
</script>

</body>
</html>