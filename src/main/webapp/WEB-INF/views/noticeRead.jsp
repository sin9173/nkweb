<%--
  Created by IntelliJ IDEA.
  User: PAIR
  Date: 2021-02-01
  Time: 오후 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
    .container {
        text-align:center;
        width: 100%;
        padding-left:300px;

    }

    .noticeHeader {
        width:60%;
        display:block;
        border-bottom: 1px solid silver;
        font-size:20px;
        background-color:#9a9a9a;
        min-height: 40px;
    }

    .noticeHeader div {
        display:inline-block;
        font-size:20px;
        font-weight:800;
        margin-right:30px;
    }

    .noticeBody {
        width:60%;
    }

    .noticeRead {
        text-align:left !important;
    }
</style>
<body>

<!-- container -->
<div class="container">
    <div class="noticeHeader">
        <div style="display:block;">
            제목 : ${basicVO.data[0].title}
        </div>
        <div>
            날짜 : ${basicVO.data[0].update_date}
        </div>
        <div>
            작성인 : ${basicVO.data[0].user_id}
        </div>
    </div>

    <div class="noticeBody">
        <div class="noticeRead">
            ${basicVO.data[0].content}
        </div>

        <div style="margin-top:20px;">
            <input type="button" value="수정" style="height:30px; width:80px;" onClick="location.href='/nkweb/notice?api=modifyForm&idx=${basicVO.data[0].idx}'">
        </div>
    </div>
</div>
<!-- container END -->

</body>
</html>
