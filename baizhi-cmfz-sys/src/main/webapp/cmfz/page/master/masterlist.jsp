<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<script>
    var $maDa;
    $(function () {

        $maDa=$("#masterdata");
        $maDa.datagrid({
            url:'<c:url value="/master/queryAll"/>',
            method:'post',
            fitColumns:true,
            pagination:true,
            pageNumber:1,
            pageSize:4,
            pageList:[2,4,6,8,10],
            columns:[[
                {title:"编号",field:"id",width:100,align:'center'},
                {title:"姓名",field:"realname",width:100,align:'center'},
                {title:"法号",field:"nickname",width:100,align:'center'},
                {title:"头像路径",field:"imgpath",width:200,align:'center'},
                {title:"操作",field:"options",width:200,align:'center',
                    formatter:function(value,row,index){
                        return  "<a class='del' onClick=\"del('"+ row.id +"')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                "<a class='edit' onClick=\"editRow('"+ row.id +"')\"  href='javascript:;'>编辑</a>";
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
            onLoadSuccess:function(data){
                $(".del").linkbutton({
                    plain:true,
                    iconCls:'icon-remove',

                });
                $(".edit").linkbutton({
                    plain:true,
                    iconCls:'icon-edit',
                });
            },
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


<table class="easyui-datagrid" id="masterdata">
    
</table>
