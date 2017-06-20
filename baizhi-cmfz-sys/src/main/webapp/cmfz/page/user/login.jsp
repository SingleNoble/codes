<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@include file="/cmfz/page/util/util.jsp"%>
<html>
<head>
    <title>持名法州后台管理系统登录</title>
    <script>
        var $lbtn,$login;
        $(function () {
            $lbtn=$("#lbtn");
            $login=$("#login");

            $lbtn.linkbutton({
                text:'登录',
                width:100,
                height:30,
                plain:false,

            });
            function submit() {
                     console.log(11111);
                     $login.form('submit',{
                     url:'${appName}/cmfz/page/main/main.jsp',
                 });
             }
        });
    </script>
    <style>

    </style>
</head>
<body bgcolor="#b0c4de">
        <div style="font-family:宋体 ;margin-top: 10px;text-align: center;width: 100%;height: 16%">
            <h1>持明法洲后台管理系统</h1>
        </div>
        <hr/>
        <div style="text-align: center;">
            <form  action="${pageContext.request.contextPath}/manager/check" method="post">

                <div style="width: 20%;height: 10%">

                </div>
                <div style="margin: 20px 0px 10px 0px">
                    姓 名:<input class="easyui-textbox" type="text" name="name" data-options="required:true" />
                </div>
                <div style="margin: 10px 0px 5px 0px">
                    密 码:<input class="easyui-passwordbox" type="text" name="password" data-options="required:true" />
                </div>
                <div>
                    <input type="submit"  class="easyui-linkbutton" data-options="width:60,height:25" value="登陆"/>
                </div>

            </form>
        </div>
    </body>
</html>
