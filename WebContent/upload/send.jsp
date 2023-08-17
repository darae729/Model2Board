<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
*{margin:3px;}
</style>
<script type="text/javascript">

//일반적인 폼이 아닌 바이너리 파일이 포함된 폼을 서버로 전송해보자 (업로드) - 절대로 GET방식으로는 불가능하다
function upload() {
	//폼을 서버로 전송하자
	form1.encoding="multipart/form-data"; //html에서는 enctype이다
	form1.submit();
}

</script>
</head>
<body>
<pre>
	<form name="form1" method="post" action="/board/upload">
	<input type="text" name="title" placeholder="제목을 입력">
	<input type="file" name="photo">
	<button onClick="upload()">업로드</button>
	</form>
</pre>
</body>
</html>