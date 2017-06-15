<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<script>
    var $maDa,$addma,$edit;
    $(function () {

        $maDa=$("#managerdata");
        $addma=$("#addManager");
        $edit=$("#editManager");

        $maDa.datagrid({
            url:'<c:url value="/manager/queryAll"/>',
            method:'post',
            fitColumns:true,
            pagination:true,
            pageNumber:1,
            pageSize:4,
            pageList:[2,4,6,8,10],
            columns:[[
                {title:"编号",field:"id",width:300,align:'center'},
                {title:"姓名",field:"name",width:100,align:'center'},
                {title:"手机号",field:"phone",width:150,align:'center'},
                {title:"操作",field:"options",width:100,align:'center',
                    formatter:function(value,row,index){
                        return  "<a class='del' onClick=\"del('"+ row.id +"')\" href='javascript:;'>删除</a>";
                    }
                }
            ]],
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $addma.dialog({
                        title: '添加',
                        width: 400,
                        height: 200,
                        href: ' <c:url value="/cmfz/page/master/add.jsp"/>',
                        buttons:[{
                            text:'保存',
                            plain:true,
                            iconCls:'icon-save',
                            handler:function(){
                                $("#addmanager").form('submit',{
                                    url:'<c:url value="/manager/regist"/>',
                                    success:function (result) {
                                        $maDa.datagrid('reload');
                                        $addma.dialog('close',true);
                                        $.messager.show({
                                            title:"提示",
                                            msg:"添加成功",
                                            timeout:2000,
                                        });
                                    }
                                });
                            },
                        },{
                            text:'关闭',
                            plain:true,
                            iconCls:'icon-cancel',
                            handler:function(){
                                $addma.dialog('close',true);
                            }
                        }]
                    });
                }
            }],
            onLoadSuccess:function (data) {
                $(".del").linkbutton({
                    plain:true,
                    iconCls:'icon-remove',
                });
            }
        });

    });
    //删除
    function del(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.get('<c:url value="/manager/delete"/>?id='+id,function (result) {

                },'json');
                $.messager.alert({
                    title:"删除提示",
                    msg:"删除成功"
                });
                $maDa.datagrid('reload');
            }
        });
    }
    
</script>


<table class="easyui-datagrid" id="managerdata"></table>
<%--添加管理员--%>
<div id="addManager"></div>

