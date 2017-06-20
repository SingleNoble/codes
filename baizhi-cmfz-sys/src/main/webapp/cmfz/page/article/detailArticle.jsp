
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>


    

    <script>
        $(function () {
            $.post("${pageContext.request.contextPath}/article/queryOne",{"id":"${param.id}"},function(result){
                $("#aaa").html(result.content);
            });

        })
    </script>



    <div id="aaa" style="text-align: center;width:100%;height: 100%">

    </div>
