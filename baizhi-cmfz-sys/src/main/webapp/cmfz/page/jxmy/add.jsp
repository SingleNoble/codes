<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName"/>
<script>
    var $jxmyp,$imgpath,$fjxmy;
    $(function () {
        $jxmyp=$("#jxmyp");
        $imgpath=$("#imgpath");
        $fjxmy=$("#fjxmy");
    });
    function jpUpload(){
        $fjxmy.form('submit',{
             url:"${appName}/picture/upload",
            success:function (result) {
                $imgpath.textbox({
                    value:result,
                });
            }
         });
    }
</script>

<form id="fjxmy" method="post" enctype="multipart/form-data" style="text-align: center">
    <input id="jxmyp"  onchange="jpUpload();" type="file" name="picture" placeholder="请选择图片"><br/>
</form>

<form id="addAlbumForm" method="post" style="text-align: center">
    名称：<input class="easyui-textbox" name="name"/><br/>
    作者：<input class="easyui-textbox" name="author"/><br/>
    播音：<input class="easyui-textbox" name="teller"/><br/>
    集数：<input class="easyui-textbox" name="num"/><br/>
    简介：<input class="easyui-textbox" name="content"/><br/>
    日期：<input class= "easyui-datebox" name="createdate"/><br/>
    评分：<input class="easyui-textbox" name="grade"/><br/>
    路径：<input class="easyui-textbox" name="imgpath" id="imgpath" type="text"/>
</form>
