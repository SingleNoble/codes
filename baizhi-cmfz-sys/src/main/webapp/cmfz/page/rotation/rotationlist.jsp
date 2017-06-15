<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%--<%@include file="/cmfz/page/util/util.jsp"%>--%>
<script>
    var $rtt,$addRtt,$editRtt;
    $(function () {
        $rtt=$("#rtt");
        $addRtt=$("#addRtt");
        $editRtt=$("#editRtt");

        $rtt.datagrid({
            url:"${pageContext.request.contextPath}/rotation/queryAll",
            method:"post",
            pagination:true,
            pageNumber:1,
            pageList:[2,4,6,8],
            pageSize:2,
            fitColumns:true,
            columns:[[
                {field:"id",title:"编号",width:100,align:'center'},
                {field:"description",title:"描述",width:80,align:'center'},
                {field:"filepath",title:"路径",width:150,align:'center'},
                {field:"o",title:"操作",width:50,align:'center',
                    formatter:function (value,row,index) {
                        var id=row.id;
                        return "<a class='del' onClick=\"drop('"+ id +"')\" href='javascript:;'>[删除]</a>";
                    }
                }
            ]],
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $addRtt.dialog({
                        title: '添加图片',
                        width: 400,
                        height: 200,
                        href: '${pageContext.request.contextPath}/cmfz/page/rotation/add.jsp',
                        buttons:[{
                            text:'保存',
                            plain:true,
                            iconCls:'icon-save',
                            handler:function(){
                                $("#addRttForm").form('submit',{
                                    url:'${pageContext.request.contextPath}/rotation/add',
                                    success:function (result) {
                                        $rtt.datagrid('reload');
                                        $addRtt.dialog('close',true);
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
                                $addRtt.dialog('close',true);
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
                $.get('${pageContext.request.contextPath}/rotation/drop?id='+id,function (result) {

                },'json');
                $.messager.alert({
                    title:"删除提示",
                    msg:"删除成功"
                });
                $rtt.datagrid('reload');
            }
        });
    }
</script>
<table id="rtt"></table>
<%--添加图片--%>
<div id="addRtt"></div>
<%--修改图片--%>
<div id="editRtt"></div>
