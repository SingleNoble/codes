<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName"/>
<script>
    var $fjxmy;
    $(function () {
        $fjxmy=$("#fjxmy");
    });
</script>

<form id="fjxmy" method="post" enctype="multipart/form-data" style="text-align: center">
    <input type="file" name="audio" placeholder="请选择图片">
    <input type="hidden" name="id" value="${param.id}"/>
</form>
