<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    var $file,$imgpath,$ff;
    $(function () {
        $file=$("#file");
        $imgpath=$("#imgpath");
        $ff=$("#ff");
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

<form id="ff" method="post" enctype="multipart/form-data" style="text-align: center">
    <input id="file" onchange="photoUpload();" type="file" name="photo"><br/>
</form>
<form id="addMasterForm" method="post" style="text-align: center;margin-top: 10px;">
    姓&nbsp;&nbsp;名：<input type="text" name="realname" placeholder="请输入真实姓名" style="margin-top: 10px;"><br/>
    法&nbsp;&nbsp;名：<input type="text" name="nickname" placeholder="请输入法名" style="margin-top: 10px;"/><br/>
    路&nbsp;&nbsp;径：<input id="imgpath" type="text" name="imgpath" placeholder="展示头像路径" style="margin-top: 10px;"/>
</form>
