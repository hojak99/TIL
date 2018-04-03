<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="notice.do" method="post" onsubmit="return formCheck();">
		제목 : <input type="text" name="title" /><br>
		작성자 : <input type="text" name="writer" /><br>  
		내용 : <input type="text" name="body" /><br> 
		<input type="submit" />
	</form>
	
	<script type="text/javascript">
		function formCheck() {
			var title = document.forms[0].title.value;
			var writer = ocument.forms[0].writer.value;
			var body = ocument.forms[0].body.value;
			
			if((title == null) && (title == "")){
				alert('제목 입력 해주세요');
				document.forms[0].title.focus();
				return false;
			}
			
			if((writer == null) && (writer == "")){
				alert('작성자 입력 해주세요');
				document.forms[0].writer.focus();
				return false;
			}
			
			if((body == null) && (body == "")){
				alert('내용 입력 해주세요');
				document.forms[0].body.focus();
				return false;
			}
		}
	</script>
</body>
</html>