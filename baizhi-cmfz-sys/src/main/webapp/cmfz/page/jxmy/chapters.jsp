<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName"/>
<script>
    var $chapter,$addChapter,$edit;

    $(function () {
        $chapter=$("#chapter");
        $addChapter=$("#addChapter");
        $edit=$("#edit");
        $chapter.datagrid({
            url:"${appName}/chapter/queryByAlbumId",
            queryParams:{"id":"${param.id}"},
            method:"post",
            pagination:true,
            pageNumber:1,
            pageList:[6,8,10],
            pageSize:6,
            fitColumns:true,
            columns:[[
                {field:"id",title:"编号",width:220},
                {field:"oldName",title:"原文件名",width:120},
                {field:"newName",title:"新文件名",width:120},
                {field:"filePath",title:"文件路径",width:250},
                {field:"fileSize",title:"大小",width:80},
                {field:"contentType",title:"文件类型",width:80},
                {field:"o",title:"操作",width:100,
                    formatter:function (value,row,index) {
                        var id=row.id;
                        return "<a class='del' onClick=\"drop('"+ id +"')\" href='javascript:;'>[删除]</a>"
                    }
                }
            ]],
            toolbar: [{
                iconCls: 'icon-cd_add',
                handler: function(){
                    $addChapter.dialog({
                        title: '添加章节',
                        width: 400,
                        height: 200,
                        href: '${appName}/cmfz/page/jxmy/addChapter.jsp?id=${param.id}',
                        buttons:[{
                            text:'保存',
                            plain:true,
                            iconCls:'icon-save',
                            handler:function(){
                                $("#fjxmy").form('submit',{
                                    url:'${appName}/chapter/upload',
                                    success:function (msg) {
                                        $chapter.datagrid('reload');
                                        $addChapter.dialog('close',true);
                                        $.messager.show({
                                            title:"提示",
                                            msg:msg,
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
                                $addChapter.dialog('close',true);
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
    function drop(id){
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                //发送异步请求删除数据
                $.get('${appName}/chapter/drop?id='+id,function (result) {
                    $.messager.alert({
                        title:"删除提示",
                        msg:result,
                    });
                },'json');
                $chapter.datagrid('reload');
            }
        });
    }
</script>
<table id="chapter"></table>
<div id="addChapter"></div>
<div id="edit"></div>
