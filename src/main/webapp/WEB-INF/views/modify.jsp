<%--
  Created by IntelliJ IDEA.
  User: PAIR
  Date: 2021-01-04
  Time: 오전 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<script
        src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
<body>

<div class="mainContainer" align="center">
    <form action="modify" method="post">

    <div style="width:80%; padding:10px;">
        <div style="display:inline-block;">
            아이디
        </div>
        <div style="display:inline-block;">
            <input type="text" name="user_id" value="${user.user_id}">
        </div>
    </div>
    <div style="width:80%; padding:10px;">
        <div style="display:inline-block;">
            비밀번호
        </div>
        <div style="display:inline-block;">
            <input type="password" name="user_pw" value="${user.user_pw}">
        </div>
    </div>
    <div style="width:80%; padding:10px;">
        <div style="display:inline-block;">
            비밀번호확인
        </div>
        <div style="display:inline-block;">
            <input type="password" name="user_pw_ck">
        </div>
    </div>
    <div style="width:80%; padding:10px;">
        <div style="display:inline-block;">
            점소코드
        </div>
        <div style="display:inline-block;">
            <input type="text" name="trade_cd" value="${user.trade_cd}" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
        </div>
    </div>
    <div style="width:80%; padding:10px;">
        <div style="display:inline-block;">
            점소명
        </div>
        <div style="display:inline-block;">
            <input type="text" name="trade_nm" value="${user.trade_nm}">
        </div>
    </div>
    <div style="width:80%; padding:10px;">
        <div style="display:inline-block;">
            사원코드
        </div>
        <div style="display:inline-block;">
            <input type="text" name="tradesub_cd" value="${user.tradesub_cd}" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
        </div>
    </div>
    <div style="width:80%; padding:10px;">
        <div style="display:inline-block;">
            사원명
        </div>
        <div style="display:inline-block;">
            <input type="text" name="tradesub_nm" value="${user.tradesub_nm}">
        </div>
    </div>
    <div style="width:80%; padding:10px;">
        <div style="display:inline-block;">
            <input type="submit" value="변경">
        </div>
        <div style="display:inline-block;">
            <input type="button" value="취소" onclick="location.href='loginForm'">
        </div>
    </div>
    </form>
</div>

<script>
    $(document).ready(function(){

        $("input[type='submit']").on("click", function(){

            var user_id = $("input[name='user_id']").val();
            var user_pw = $("input[name='user_pw']").val();
            var user_pw_ck = $("input[name='user_pw_ck']").val();
            var trade_cd = $("input[name='trade_cd']").val();
            var trade_nm = $("input[name='trade_nm']").val();
            var tradesub_cd = $("input[name='tradesub_cd']").val();
            var tradesub_nm = $("input[name='tradesub_nm']").val();


            if(user_id==null || user_id==''){
                alert("아이디를 입력하세요.");
                $("input[name='user_id']").focus();

                return false;
            }

            if(user_pw==null || user_pw==''){
                alert("비밀번호를 입력하세요.");
                $("input[name='user_pw']").focus();

                return false;
            }
            if(user_pw_ck==null || user_pw_ck==''){
                alert("비밀번호확인을 입력하세요.");
                $("input[name='user_pw_ck']").focus();

                return false;
            }
            if(trade_cd==null || trade_cd==''){
                alert("점소코드를 입력하세요.");
                $("input[name='trade_cd']").focus();

                return false;
            }
            if(trade_nm==null ||trade_nm==''){
                alert("점소명을 입력하세요.");
                $("input[name='trade_nm']").focus();

                return false;
            }
            if(tradesub_cd==null ||tradesub_cd==''){
                alert("사원코드를 입력하세요.");
                $("input[name='tradesub_cd']").focus();

                return false;
            }
            if(tradesub_nm==null ||tradesub_nm==''){
                alert("사원명을 입력하세요.");
                $("input[name='tradesub_nm']").focus();

                return false;
            }

            if(user_pw!=user_pw_ck){
                alert("비밀번호가 다릅니다");
                $("input[name='user_pw']").focus();

                return false;
            }

        });
    });

</script>


</body>
</html>
