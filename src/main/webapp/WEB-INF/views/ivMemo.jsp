<%--
  Created by IntelliJ IDEA.
  User: PAIR
  Date: 2021-01-03
  Time: 오후 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<script
        src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
<body>

<div class="mainContainer" align="center" style="width:95%;">



    <style>

        .ivItems{
            display:inline-block;
            padding-top:5px;
            padding-bottom:5px;

            margin-right: 1px;
            margin-bottom: 1px;

            vertical-align: middle;


            min-height:200px;



        }

        .ivHeader{
            display:inline-block;
            padding-top:5px;
            padding-bottom:5px;

            margin-right: 1px;
            margin-bottom: 1px;

            background-color:steelblue;
        }
    </style>

    <div style="width:95%; margin-top:20px; " id="MemoList">
        <!-- 리스트 헤더 -->
        <div style="display:block;">
            <div class="ivHeader" style="width:5%;">
                NO
            </div>
            <div class="ivHeader" style="width:23%;">
                등록일시
            </div>
            <div class="ivHeader" style="width:15%;">
                등록점소
            </div>
            <div class="ivHeader" style="width:15%;">
                등록사원
            </div>
            <div class="ivHeader" style="width:30%;">
                메모내역
            </div>
            <div class="ivHeader" style="width:8%;">
                수정
            </div>

        </div>
        <!-- 리스트 헤더 END -->


        <!-- 리스트 바디 -->
        <c:set var="itemCount" value="1"/>
        <c:set var="itemColor" value="lightsteelblue"/>
        <c:forEach var="item" items="${ivMemo}">

            <form action="memoModify" method="POST" onsubmit="return submitCheck(this)">
                <input type="hidden" name="emp_cd" value="${item.emp_cd}">
                <input type="hidden" name="login_id" value="${sessionScope.user_id}">
                <input type="hidden" name="iv_no" value="${item.iv_no}">
                <input type="hidden" name="iv_no_seq" value="${item.iv_no_seq}">

            <div style="display:block;">

                <div class="ivItems" style="width:5%; background-color:${itemColor};">
                        ${itemCount}
                </div>
                <div class="ivItems" style="width:23%; background-color:${itemColor};">
                        ${item.reg_ymd}
                </div>
                <div class="ivItems" style="width:15%; background-color:${itemColor};">
                        ${item.trade_nm}
                </div>
                <div class="ivItems" style="width:15%; background-color:${itemColor};">
                        ${item.emp_nm}
                </div>
                <div class="ivItems" style="width:30%; background-color:${itemColor};">
<%--                        <input type="text" name="memo_desc" value="${item.memo_desc}" style="background-color:${itemColor}; width:100%; word-wrap:break-word; white-space:pre-line;">--%>
                    <textarea name="memo_desc" value="${item.memo_desc}" style="background-color:${itemColor}; width:100%; height:200px; word-break:break-all; white-space:pre-line;">${item.memo_desc}</textarea>

                </div>
                <div class="ivItems" style="width:8%; background-color:${itemColor};">
                    <input type="submit" value="수정">
                </div>

            </div>
            </form>
            <c:set var="itemCount" value="${itemCount + 1}"/>

            <c:if test="${itemCount%2==0}">
                <c:set var="itemColor" value="aliceblue"/>
            </c:if>

            <c:if test="${itemCount%2==1}">
                <c:set var="itemColor" value="lightsteelblue"/>
            </c:if>


        </c:forEach>



        <!-- 리스트 바디 END -->

    </div>

    <div style="width:90%; margin-top:20px;">
        <div style="width:80%; display:inline-block;">
<%--            <input type="text" id="addMemoInput" placeholder="메모를 입력하는 항목입니다." style="width:90%; height:30px; background-color:cornsilk;">--%>
            <textarea id="addMemoInput" placeholder="메모를 입력하는 항목입니다." style="width:90%; height:100px; background-color:cornsilk; word-break:break-all; white-space:pre-line;"></textarea>
        </div>
        <div style="width:10%; display:inline-block;">
            <input class="btn btn-info" id="addMemoBtn" type="button" value="추가">
        </div>
    </div>

    <div style="width:90%; margin-top:20px;">
        <div style="width:10%; display:inline-block;">
            <input class="btn btn-primary" id="saveMemoBtn" type="button" value="저장">
        </div>
        <div style="width:10%; display:inline-block;">
            <input class="btn btn-primary" type="button" value="닫기">
        </div>
    </div>

    <script>
        function submitCheck(form){

            if(form.emp_cd.value!='${sessionScope.tradesub_cd}'){
                alert("사원번호가 다릅니다.");

                return false;
            }

            return true;
        }
        $(document).ready(function(){

            var memoArray = new Array();

            arrayCount = 0;

            $("#addMemoBtn").on("click", function(){

                var user_id = "${sessionScope.user_id}";
                var trade_cd = "${sessionScope.trade_cd}";
                var trade_nm = "${sessionScope.trade_nm}";
                var tradesub_cd = "${sessionScope.tradesub_cd}";
                var tradesub_nm = "${sessionScope.tradesub_nm}";


                var iv_no = "${param.iv_no}";

                var memo_desc = $("#addMemoInput").val();

                var memoObject = {
                    "user_id":user_id,
                    "trade_cd":trade_cd,
                    "trade_nm":trade_nm,
                    "tradesub_cd":tradesub_cd,
                    "tradesub_nm":tradesub_nm,
                    "iv_no":iv_no,
                    "memo_desc":memo_desc
                }

                memoArray[arrayCount] = memoObject;

                arrayCount += 1;

                console.log(memoArray);

                var html = '<div style="display:block;">\n' +
                    '                <div class="ivItems" style="width:5%; background-color:lightpink;">\n' +
                    '                        -\n' +
                    '                </div>\n' +
                    '                <div class="ivItems" style="width:23%; background-color:lightpink;">\n' +
                    '                        -\n' +
                    '                </div>\n' +
                    '                <div class="ivItems" style="width:15%; background-color:lightpink;">\n' +
                    '                        '+trade_nm+'\n' +
                    '                </div>\n' +
                    '                <div class="ivItems" style="width:15%; background-color:lightpink;">\n' +
                    '                        '+tradesub_nm+'\n' +
                    '                </div>\n' +
                    '                <div class="ivItems" style="width:30%; background-color:lightpink;">\n' +
                    '                        '+memo_desc+'\n' +
                    '                </div>\n' +
                                     '<div class="ivItems" style="width:8%; background-color:lightpink;">\n' +
                        '                        -\n' +
                        '            </div>\n' +
                    '\n' +
                    '            </div>';


                $("#MemoList").append(html);

                $("#addMemoInput").val("");

            });

            $("#saveMemoBtn").on("click", function(){

                var jsonData = '{"api":"memoSave", "data":[';
                for(var i=0 ; i<arrayCount ; i++){

                    jsonData += '{' +
                        '"login_id":"'+ memoArray[i].user_id + '",' +
                        '"iv_no":"'+ memoArray[i].iv_no + '",' +
                        '"memo_desc":"'+ memoArray[i].memo_desc + '"' +
                        '}';
                    if(i<(arrayCount-1)){
                        jsonData += ',';
                    }
                }

                jsonData += ']}';

                console.log(jsonData);


                $.ajax({
                    url:"memoSave",
                    type:"POST",
                    dataType:"json",
                    contentType:"application/json",
                    data:jsonData,
                    success:function(data){

                        location.href='ivMemoList?iv_no=' + memoArray[0].iv_no;
                    },
                    error:function(){
                        alert("에러?");
                    }

                });
            });

        });
    </script>



</div>

</body>
</html>
