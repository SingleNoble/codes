
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    var $dg,$daaa;
    $(function () {
        $dg=$("#dgArticle");
        $daaa=$("#dacArticle");
        $dg.datagrid({
            fit:true,
            toolbar:'#tbArticle',

            url:"${pageContext.request.contextPath}/article/queryAllByPage",
            columns:[[
                {field:'id',title:'ID',width:200,align:'center'},
                {field:'title',title:'标题',width:100,align:'center'},
                {field:'createdate',title:'创建时间',width:150,align:'center'},
                {field:'type',title:'类型',width:80,align:'center',formatter:function(value,row,index){
                    if(row.type=="Shangshi"){
                        return "上师言教";
                    }else{
                        return "显密法要";
                    }
                }},
                /*{field:'content',title:'内容',width:300,align:'center'},*/
                {field:'master',title:'作者',width:100,align:'center',formatter:function(value,row,index){
                    return "";
                }},
                {field:'options',title:'操作',width:200,align:'center',formatter:function(value,row,index){
                    return "<a class='del' onClick=\"delArticle('"+row.id+"')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                            "<a class='detailA' onClick=\"detailA('"+row.id+"')\" href='javascript:;'>查看详情</a>";
                }},

            ]],
            pagination:true,
            pageNumber:1,
            pageSize:3,
            pageList:[3,6,9,12],

            onLoadSuccess:function(data) {
                $(".del").linkbutton({
                    plain: true,
                    iconCls: 'icon-clear',
                });
                $(".detailA").linkbutton({
                    plain: true,
                    iconCls: 'icon-edit',
                });
            }
        });

    });
    function delArticle(id) {
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                $.post("${pageContext.request.contextPath}/article/drop",{"id":id},function(result){
                    $dg.datagrid('reload');
                    $.messager.show({
                        title:'提示',
                        msg:result.message,
                        timeout:2000,

                    });
                });
            }
        });

    }

    function detailA(id) {
        $daaa.dialog({
            title:"文章详情",
            iconCls:'icon-text_columns',
            resizable:true,
            width:700,
            height:500,
            href:'${pageContext.request.contextPath}/cmfz/page/article/detailArticle.jsp?id='+id,
            buttons:[{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDac,
            }
            ]
        });
    }
    function adda() {
        $daaa.dialog({
            iconCls:'icon-add',
            title:"添加信息",
            resizable:true,
            width:800,
            height:500,
            href:'${pageContext.request.contextPath}/cmfz/page/article/addArticle.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-save',
                handler:saveA,
            },{
                text:'重置',
                iconCls:'icon-clear',
                handler:clearA,
            },{
                text:'关闭',
                iconCls:'icon-cancel',
                handler:closeDac,
            }
            ]
        })
    }
    function saveA(){
        $("#ffArticle").form("submit",{
            url:'${pageContext.request.contextPath}/article/add',

            success:function(result){
                $daaa.dialog('close',true).html("");
                $dg.datagrid('reload');
                $.messager.show({
                    title:'提示',
                    msg:'添加成功~~~~',
                    timeout:1000,

                });
            }
        })
    }
    function clearA(){
        $("#ffArticle").form('reset');
    }
    function closeDac() {
        $daaa.dialog('close',true).html("");
    }
</script>

<table id="dgArticle">

</table>
<div id="tbArticle">
    <a href="#" onclick="adda()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
</div>
<div id="dacArticle"></div>




