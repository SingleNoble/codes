<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@include file="/cmfz/page/util/util.jsp"%>
<html>
    <title>持名法州后台主页</title>
    <script>
        var $menus,$tabs,$user;
        $(function () {
            $menus=$("#menus");
            $tabs=$("#tabs");
            $user=$("#user");
            $.post("${appName}/menu/querryAll",function (menus) {
                $.each(menus,function (i,menu) {
                    var content = "<div style='text-align: center;'>";
                    $.each(menu.children,function (j,child) {
                        content +="<div onclick=\"addTabs('"+child.name+"','"+child.iconCls+"','"+child.href+"')\" class='easyui-linkbutton' data-options=\"plain:true,iconCls:'"+child.iconCls+"'\" style='border:1px solid green; width:90%;margin: 5 0 5 0 ;'>"+child.name+"</div>";
                    })
                    content+="</div>";
                    $menus.accordion('add',{
                        title:menu.name,
                        iconCls:menu.iconCls,
                        content:content,
                    });
                });
            },'JSON');
            $user.css("float","left");
        });
        //添加选项卡
        function  addTabs(title,iconCls,href){
            if(!$tabs.tabs('exists',title)){
                $tabs.tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    href:"${appName}/"+href,
                    closable:true,
                });
            }else{
                $tabs.tabs('select',title)
            }

        }
        function showuser() {
            $user.linkbutton({
                text:'张三'
            })
        }
    </script>
</head>
    <body>
    <div id="cc" class="easyui-layout" data-options="fit:true" style="width:600px;height:400px;">
        <div data-options="region:'north'" style="height:60px;">
            <a id="user" onclick="showuser()" class="easyui-linkbutton" data-options="plain:true"></a>
            <h1 style="text-align: center">持名法州后台管理系统</h1>
        </div>
        <div data-options="region:'south'" style="height:60px;"></div>
        <div data-options="region:'west',title:'导航'" style="width:260px;">
            <div id="menus" class="easyui-accordion" data-options="fit:true">

            </div>
        </div>
        <div data-options="region:'center',title:'home',iconCls:'icon-home'" style="padding:5px;background:#eee;">
            <div id="tabs" class="easyui-tabs" data-options="fit:true"></div>
        </div>
    </div>
    </body>
</html>
