<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<h3>${Message}</h3>
<c:if test="${By =='HR Softwares'}">
<h4>${By}</h4>
</c:if>
<c:if test="${By !='HR Softwares'}">
<h4>Not ${By}</h4>
</c:if>
<a href='<c:url value="Actor"></c:url>'>Actor</a>
<a href='<c:url value="File"></c:url>'>File</a>
</body>
</html>
