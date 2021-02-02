
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>

<script
        src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>

<style>

    .searchInput{

        width:30%;
        height:80%;

        display:inline-block;
        padding: 2px;
        vertical-align: middle;


    }


</style>

<script>
    function notice(idx, title){
        var url = "/nkweb/notice?api=noticeRead&idx="+idx;
        var name = title;
        var option = "width=1000, height=800, top=200, left=200, location=no";

        window.open(url, name, option);
    }
</script>


<body>

    <div class="mainContainer" align="center" style="width:85%;">

        <div align="right" style="width:90%; padding:10px;">
            <input type="button" value="로그아웃" onclick="location.href='logout'">
            <input type="button" value="회원정보수정" onclick="location.href='modifyForm?user_id=${sessionScope.user_id}'">
        </div>

        <% if(session.getAttribute("noticeSW").equals("0")){ %>
        <c:forEach var="item" items="${noticeList}">
            <script>

                notice('${item.idx}', '${item.title}');
            </script>
        </c:forEach>
        <% } %>

        <%
            session.setAttribute("noticeSW", "1");
        %>
        <div style="border:1px solid darkblue; width:90%; height:100px; display:block;">
            <form action="ivList" method="post" onsubmit="return searchSubmit()">

            <div style="display:inline-block; width:80%; vertical-align:middle;">
                <div style="display:block; height:30%; padding:2px; width:90%; margin-left:8%;"  align="left">
                    접수일자
                    <input type="date" name="base_ymd_front" style="width:15%;" value="${frDate}">
                    ~
                    <input type="date" name="base_ymd_rear" style="width:15%;" value="${rrDate}">
                </div>
                <div style="display:block; height:30%; padding:2px;">

                    <div class="searchInput">
                        발송고객명<input name="pk_nm" type="text">
                    </div>
                    <div class="searchInput">
                        배송고객명<input name="dv_nm" type="text">
                    </div>
                    <div class="searchInput">

                    </div>


                </div>

                <div style="display:block; height:30%; padding:2px;">
                    <div class="searchInput">
                        송장번호<input name="iv_no" type="text" placeholder="-를 제외하고 입력">
                    </div>
                    <div class="searchInput">
                        배송상태
                        <select name="iv_st_cd" style="width:50%;">
                            <option value="" selected>전체</option>
                            <option value="900010">등록</option>
                            <option value="900420">배달준비</option>
                            <option value="900440">배달완료</option>
                        </select>
                    </div>
                    <div class="searchInput">
                        배송전화<input name="dv_tel1" type="text">
                    </div>


                </div>



            </div>

            <div style="display:inline-block; width:12%; vertical-align:middle;">
                <input type="submit" value="조회" style="width:80%; height:80%;">
            </div>

            </form>

        </div>

        <style>

            .ivItems{
                display:inline-block;
                padding-top:5px;
                padding-bottom:5px;

                margin-right: 1px;
                margin-bottom: 1px;





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

        <div style="width:90%; margin-top:20px;">
            <!-- 리스트 헤더 -->
            <div style="display:block;">
                <div class="ivHeader" style="width:5%;">
                    NO
                </div>
                <div class="ivHeader" style="width:12%;">
                    일자
                </div>
                <div class="ivHeader" style="width:20%;">
                    송장번호
                </div>
                <div class="ivHeader" style="width:10%;">
                    발송고객명
                </div>
                <div class="ivHeader" style="width:10%;">
                    배송고객명
                </div>
                <div class="ivHeader" style="width:12%;">
                    배송전화
                </div>
                <div class="ivHeader" style="width:8%;">
                    메모
                </div>
                <div class="ivHeader" style="width:15%;">
                    배송상태
                </div>

            </div>
            <!-- 리스트 헤더 END -->


            <!-- 리스트 바디 -->
            <c:set var="itemCount" value="1"/>
            <c:set var="itemColor" value="lightsteelblue"/>
            <c:forEach var="item" items="${ivList}">

                <div style="display:block;">
                    <div class="ivItems" style="width:5%; background-color:${itemColor};">
                        ${itemCount}
                    </div>
                    <div class="ivItems" style="width:12%; background-color:${itemColor};">
                        ${item.base_ymd}
                    </div>
                    <div class="ivItems" style="width:20%; background-color:${itemColor};" onclick="ivInfo('${item.iv_no}')">
                        ${fn:substring(item.iv_no, 0, 5)}-${fn:substring(item.iv_no, 5, 9)}-${fn:substring(item.iv_no, 9, 13)}
                    </div>
                    <div class="ivItems" style="width:10%; background-color:${itemColor};">
                        ${item.pk_nm}
                    </div>
                    <div class="ivItems" style="width:10%; background-color:${itemColor};">
                        ${item.dv_nm}
                    </div>
                    <div class="ivItems" style="width:12%; background-color:${itemColor};">
                        ${item.dv_tel1}
                    </div>
                    <div class="ivItems memoBtn" style="width:8%; background-color:${itemColor};" onclick="memoList('${item.iv_no}')">
                        메모
                    </div>
                    <div class="ivItems" style="width:15%; background-color:${itemColor};">
                        ${item.iv_st_nm}
                    </div>

                </div>
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

        <script>



            function memoList(iv_no){
                var url = "ivMemoList?iv_no="+iv_no;
                var name = "memo";
                var option = "width=1500, height=400, top=200, left=200, location=no";

                window.open(url, name, option);

            }



            function ivInfo(iv_no){
                var url = "http://nkls.co.kr/sub/Tracking.php?invoice="+iv_no;
                var name = "ivInfo";
                var option = "width=1000, height=800, top=200, left=200, location=no";

                window.open(url, name, option);
            }


            function searchSubmit(){

                var res = false;

                var pk_nm = $("input[name='pk_nm']").val();
                var dv_nm = $("input[name='dv_nm']").val();
                var iv_no = $("input[name='iv_no']").val();
                var iv_st_cd = $("select[name='iv_st_cd']").val();
                var dv_tel1 = $("input[name='dv_tel1']").val();


                if(pk_nm!=null && pk_nm!=''){
                    console.log("pk_nm : " + pk_nm);

                    res = true;
                }

                if(dv_nm!=null && dv_nm!=''){
                    console.log("dv_nm : " + dv_nm);
                    res = true;
                }

                if(iv_no!=null && iv_no!=''){
                    console.log("iv_no : " + iv_no);
                    res = true;
                }

                if(iv_st_cd!=null && iv_st_cd!=''){
                    console.log(iv_st_cd);
                    res = true;
                }

                if(dv_tel1!=null && dv_tel1!=''){
                    console.log(dv_tel1);
                    res = true;
                }



                if(res==false){
                    alert("검색조건을 입력해주세요.");
                }



                return res;



            }

        </script>




    </div>
</body>
</html>
