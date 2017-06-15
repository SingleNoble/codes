<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="appName"/>
<script>
    var $ujf,$updateAlbumForm,$jImgpath;
    $(function () {
        $ujf=$("#ujf");
        $updateAlbumForm=$("#updateAlbumForm");
        $jImgpath=$("#jImgpath");
        $updateAlbumForm.form('load',"${appName}/album/queryById?id=${param.id}");
    });
    function photoUpload(){
        $ujf.form('submit',{
            url:"${appName}/picture/upload",
            success:function (result) {
                $jImgpath.val(result);
            }
        });
    }
</script>

<form id="ujf" method="post" enctype="multipart/form-data" style="text-align: center">
    <input onchange="photoUpload();" type="file" name="picture"><br/>
</form>
<form id="updateAlbumForm" method="post" style="text-align: center">
    <input id="id" type="hidden" name="id">
    名称：<input class="easyui-textbox" name="name"/><br/>
    作者：<input class="easyui-textbox" name="author"/><br/>
    播音：<input class="easyui-textbox" name="teller"/><br/>
    集数：<input class="easyui-textbox" name="num"/><br/>
    简介：<input class="easyui-textbox" name="content"/><br/>
    日期：<input class= "easyui-datebox" name="createdate"/><br/>
    评分：<input class="easyui-textbox" name="grade"/><br/>
    路径：<input id="jImgpath" type="text" name="imgpath"/>
</form>
