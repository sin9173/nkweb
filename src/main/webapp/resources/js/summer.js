function uploadSummernoteImageFile(file, editor) {

    data = new FormData();
    data.append("file", file);
    $.ajax({
        data : data,
        type : "POST",
        url : "/nkweb/uploadSummernoteImageFile",
        contentType : false,
        processData : false,
        success : function(data) {
            $(editor).summernote('insertImage', data.url);
        }
    });
}