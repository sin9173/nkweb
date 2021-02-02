<%--
  Created by IntelliJ IDEA.
  User: PAIR
  Date: 2021-01-29
  Time: 오후 4:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- include libraries(jQuery, bootstrap) -->
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
    <!-- include summernote css/js-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
    <!-- include summernote-ko-KR -->
    <script src="/nkweb/resources/js/summernote-ko-KR.js"></script>
    <script src="/nkweb/resources/js/summer.js"></script>
</head>

<script src="/nkweb/resources/js/summernote-ko-KR.js"></script>


<body>

<!-- container -->
<div class="container">

    <div style="text-align:center;">

        <div>
            <h1>글쓰기</h1>
        </div>
    </div>


    <form action="/nkweb/notice" method="post">



        <div class="MidVw">
            <div>
                <input type="text" style="width:100%;" name="title" placeholder="제목을 입력해주세요.">
            </div>

            <div style="margin-top:20px;">
                <textarea rows="20" name="content" id="content">

                </textarea>
            </div>


            <input type="hidden" name="api" value="write">
            <input type="hidden" name="user_id" value="${sessionScope.user_id}">

            <div style="text-align:center; margin-top:20px;">
                <input type="submit" style="width:200px; height:40px;" value="등록">
            </div>

        </div>






    </form>



</div>

<!-- container END -->

</body>


<script type="text/javascript">

    $(document).ready(function() {
        $('#content').summernote({
            placeholder: 'content',
            minHeight: 370,
            maxHeight: null,
            focus: true,
            lang : 'ko-KR'
            callbacks: {
                onImageUpload : function(files) {
                  uploadSummernoteImageFile(files[0], this);
                },
                onPaste: function (e) {
                    var clipboardData = e.originalEvent.clipboardData;
                    if(clipboardData && clipboardData.items && clipboardData.items.length){
                        var item = clipboardData.items[0];
                        if(item.kind === 'file' && item.type.indexOf('imgae/') !== -1) {
                            e.preventDefault();
                        }
                    }
                }
            }
        });
    });

</script>
</html>
