<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="appName"/>
<script>
    var $album,$addAlbum,$edit;

    $(function () {
        $album=$("#album");
        $addAlbum=$("#addAlbum");
        $edit=$("#edit");


        $album.datagrid({
            url:'${appName}/album/queryAll',
            method:"post",
            pagination:true,
            pageNumber:1,
            pageList:[2,4,6,8],
            pageSize:2,
            columns:[[
                {field:"id",title:"编号",width:150},
                {field:"name",title:"专辑名",width:80},
                {field:"author",title:"作者",width:50},
                {field:"teller",title:"播音",width:50},
                {field:"num",title:"集数",width:30},
                {field:"content",title:"简介",width:100},
                {field:"createdate",title:"创建时间",width:100},
                {field:"grade",title:"评分",width:50},
                {field:"imgpath",title:"图片路径",width:180},
                {field:"o",title:"操作",width:220,
                    formatter:function (value,row,index) {
                        var id=row.id;
                        return "<a class='del' onClick=\"drop('"+ id +"')\" href='javascript:;'>[删除]</a>" +
                                "<a class='change' onclick=\"edit('"+ id +"')\" href='javascript:;'>[编辑]</a>" +
                                "<a class='change' onclick=\"chapter('"+ id +"')\" href='javascript:;'>[章节]</a>";
                    }
                }
            ]],
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $addAlbum.dialog({
                        title: '添加专辑',
                        width: 350,
                        height: 400,
                        href: '${appName}/cmfz/page/jxmy/add.jsp',
                        buttons:[{
                            text:'保存',
                            plain:true,
                            iconCls:'icon-save',
                            handler:function(){
                                $("#addAlbumForm").form('submit',{
                                    url:'<c:url value="/album/add"/>',
                                    success:function (msg) {
                                        console.log(msg);
                                        $album.datagrid('reload');
                                        $addAlbum.dialog('close',true);
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
                                $.get('${appName}/master/photoDel?imgpath='+$imgpath.val(),function () {

                                },'JSON');
                                $addAlbum.dialog('close',true);
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
                $.get('${appName}/album/drop?id='+id,function (result) {
                    $.messager.alert({
                        title:"删除提示",
                        msg:result,
                    });
                },'json');
                $album.datagrid('reload');
            }
        });
    }
    //编辑
    function edit(id) {
        $edit.dialog({
            title: '编辑',
            width: 450,
            height: 350,
            href: "${appName}/cmfz/page/jxmy/updateChapter.jsp?id="+id,
            buttons:[{
                text:'保存',
                plain:true,
                iconCls:'icon-save',
                handler:function(){
                    $("#updateAlbumForm").form('submit',{
                        url:'${appName}/album/change',
                        success:function (msg) {
                            $album.datagrid('reload');
                            $edit.dialog('close',true);
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
                    $.get('${appName}/picture/pictureDel?imgpath='+$("#jImgpath").val(),'JSON');
                    $edit.dialog('close',true);
                }
            }]
        });
    }
    //加载章节
    function chapter(id) {
        $("#chapters").dialog({
            title:'所有章节',
            width: 1000,
            height: 400,
            href: "${appName}/cmfz/page/jxmy/chapters.jsp?id="+id,
        })
    }
</script>
<table id="album"></table>
<div id="addAlbum"></div>
<div id="edit"></div>
<table id="chapters"></table>
