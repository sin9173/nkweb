<%--
  Created by IntelliJ IDEA.
  User: PAIR
  Date: 2021-01-03
  Time: 오후 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${message!=null}">
    <script>
        alert("${message}");
    </script>
</c:if>



<div align="center" style="margin-top:15%;">
    <form action="login" method="post">
    <div style="padding:10px;">
        <div style="display:inline-block;">
            아이디
        </div>
        <div style="display:inline-block;">
            <input type="text" name="user_id">
        </div>

    </div>

    <div style="padding:10px;">
        <div style="display:inline-block;">
            비밀번호
        </div>
        <div style="display:inline-block;">
            <input type="password" name="user_pw">
        </div>

    </div>

    <div style="padding:10px;">
        <div style="display:inline-block;">
            <input type="submit" value="로그인">
        </div>
        <div style="display:inline-block;">
            <input type="button" value="등록" onClick="location.href='joinForm'">
        </div>

    </div>

    </form>

</div>

</body>
</html>
