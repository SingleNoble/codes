<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    var $uFile,$imgpath,$uf;
    $(function () {

        $.get('${pageContext.request.contextPath}/master/queryById?id=${param.id}',function (result) {
            $("#id").val(result.id);
            $("#realname").val(result.realname);
            $("#nickname").val(result.nickname);
            $("#uImgpath").val(result.imgpath);
        },'Json');
        $uFile=$("#uFile");
        $imgpath=$("#uImgpath");
        $uf=$("#uf");
    });
    function photoUpload(){
        $ff.form('submit',{
            url:"${pageContext.request.contextPath}/master/photoUpload",
            success:function (result) {
                $imgpath.val(result);
            }
        });
    }
</script>

<form id="uf" method="post" enctype="multipart/form-data" style="text-align: center">
    <input id="uFile" onchange="photoUpload();" type="file" name="photo"><br/>
</form>
<form id="updateMasterForm" method="post" style="text-align: center;margin-top: 10px;" >
    <input id="id" type="hidden" name="id">
    姓&nbsp;&nbsp;名：<input id="realname" type="text" name="realname" style="margin-top: 10px;"/><br/>
    法&nbsp;&nbsp;名：<input id="nickname" type="text" name="nickname" style="margin-top: 10px;"/><br/>
    路&nbsp;&nbsp;径：<input id="uImgpath" type="text" name="imgpath" style="margin-top: 10px;"/>
</form>
