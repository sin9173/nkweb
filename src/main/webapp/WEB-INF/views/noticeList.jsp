<%--
  Created by IntelliJ IDEA.
  User: PAIR
  Date: 2021-02-01
  Time: 오전 11:44
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
        padding-left:200px;

    }

    .noticeHeader {
        width:70%;
        display:block;
        border-bottom: 1px solid silver;
        font-size:12px;
        background-color:#9a9a9a;
        height: 30px;
    }

    .noticeHeader div {
        display:inline-block;
    }

    .noticeBody {
        width:70%;
    }



    .noticeObject {
        display:block;
        border-bottom: 1px solid silver;
        font-size:12px;
        height:40px;
    }
    .noticeObject div {
        display:inline-block;
        vertical-align:middle;
    }
</style>
<body>
    <!-- container -->
    <div class="container">
        <div class="noticeHeader">
            <div style="width:5%;">
                No
            </div>
            <div style="width:50%;">
                제목
            </div>
            <div style="width:8%;">
                글쓴이
            </div>
            <div style="width:10%;">
                작성일
            </div>
            <div style="width:10%;">
                비고
            </div>
        </div>

        <div class="noticeBody">
            <c:forEach var="b" items="${basicVO.data}" >
                <div class="noticeObject">
                    <div style="width:5%;">
                        ${b.idx}
                    </div>
                    <div style="width:50%; cursor:pointer;" onClick="location.href='/nkweb/notice?api=noticeRead&idx=${b.idx}'">
                        ${b.title}
                    </div>
                    <div style="width:8%;">
                        ${b.user_id}
                    </div>
                    <div style="width:10%;">
                        ${b.update_date}
                    </div>
                    <div style="width:10%;">
                        <input type="button" value="삭제" onClick="location.href='/nkweb/notice?api=delete&idx=${b.idx}'">
                    </div>

                </div>
            </c:forEach>
        </div>
    </div>
    <!-- container END -->
</body>
</html>
