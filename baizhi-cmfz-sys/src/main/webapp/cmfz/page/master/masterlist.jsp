<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<script>
    var $master,$addMaster,$edit;
    $(function () {
        $master=$("#master");
        $addMaster=$("#addMaster");
        $edit=$("#edit");
        $master.datagrid({
            url:"${pageContext.request.contextPath}/master/queryAll",
            method:"post",
            pagination:true,
            pageNumber:1,
            pageList:[2,4,6,8],
            pageSize:2,
            fitColumns:true,
            columns:[[
                {field:"id",title:"编号",width:150,align:'center'},
                {field:"realname",title:"姓名",width:50,align:'center'},
                {field:"nickname",title:"法名",width:80,align:'center'},
                {field:"imgpath",title:"头像路径",width:150,align:'center'},
                {field:"o",title:"操作",width:80,
                    formatter:function (value,row,index) {
                        var id=row.id;
                        return "<a class='del' onClick=\"drop('"+ id +"')\" href='javascript:;'>[删除]</a>&nbsp;&nbsp;" +
                                "<a class='change' onclick=\"edit('"+ id +"')\" href='javascript:;'>[编辑]</a>";
                    }
                }
            ]],
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $addMaster.dialog({
                        title: '添加上师',
                        width: 400,
                        height: 250,
                        href: '${pageContext.request.contextPath}/cmfz/page/master/addMaster.jsp',
                        buttons:[{
                            text:'保存',
                            plain:true,
                            iconCls:'icon-save',
                            handler:function(){
                                $("#addMasterForm").form('submit',{
                                    url:'${pageContext.request.contextPath}/master/add',
                                    success:function () {
                                        $master.datagrid('reload');
                                        $addMaster.dialog('close',true);
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
                                $.get('${pageContext.request.contextPath}/master/photoDel?imgpath='+$imgpath.val(),function () {

                                },'JSON');
                                $addMaster.dialog('close',true);
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
                $(".change").linkbutton({
                    plain:true,
                    iconCls:'icon-edit',
                });
            }
        });
    });
    //删除
    function drop(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.get('${pageContext.request.contextPath}/master/drop?id='+id,function (result) {
                    $.messager.alert({
                        title:"删除提示",
                        msg:result.message,
                    });
                },'json');
                $master.datagrid('reload');
            }
        });
    }
    //编辑
    function edit(id) {
        $edit.dialog({
            title: '编辑',
            width: 400,
            height: 250,
            href: '${pageContext.request.contextPath}/cmfz/page/master/update.jsp?id='+id,
            buttons:[{
                text:'保存',
                plain:true,
                iconCls:'icon-save',
                handler:function(){
                    $("#updateMasterForm").form('submit',{
                        url:'${pageContext.request.contextPath}/master/change',
                        success:function () {
                            $master.datagrid('reload');
                            $addMaster.dialog('close',true);
                            $.messager.show({
                                title:"提示",
                                msg:"修改成功",
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
                    $edit.dialog('close',true);
                }
            }]
        });
    }
</script>
<table id="master"></table>
<div id="addMaster"></div>
<div id="edit"></div>
