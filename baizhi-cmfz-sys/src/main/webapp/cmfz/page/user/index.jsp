
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<script>
    var $dg, $df,$dfa;
    $(function () {
        $dg=$("#dgUser");
        $df=$("#dfUser");
        $dfa=$("#dfaUser");
        $dg.datagrid({
            fit:true,
            toolbar:'#tbUser',

            url:"${pageContext.request.contextPath}/user/queryAllByPage",
            columns:[[
                {field:'id',title:'ID',width:240,align:'center'},
                {field:'realname',title:'姓名',width:50,align:'center'},
                {field:'nickname',title:'法号',width:50,align:'center'},
                {field:'sex',title:'性别',width:30,align:'center'},
                {field:'description',title:'签名',width:150,align:'center'},
                {field:'phone',title:'电话',width:100,align:'center'},
                {field:'master',title:'师傅',width:100,align:'center',formatter:function(value,row,index){
                    return "";
                }},
                {field:'address',title:'住址',width:150,align:'center',formatter:function(value,row,index){
                    return "";
                }},

                {field:'options',title:'操作',width:200,align:'center',formatter:function(value,row,index){
                    return "<a class='del' onClick=\"del('"+row.id+"')\" href='javascript:;'>删除</a>";
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
                $(".edit").linkbutton({
                    plain: true,
                    iconCls: 'icon-edit',
                });
            }
        });

    });
    function del(id) {
        $.messager.confirm("提示","您确定要删除吗?",function(r){
            if(r){
                $.post("${pageContext.request.contextPath}/user/delete",{"id":id},function(){
                    $dg.datagrid('reload');
                    $.messager.show({
                        title:'提示',
                        msg:'删除成功~~~~',
                        timeout:2000,

                    });
                });
            }
        });

    }

</script>

        <table id="dgUser"></table>
        <div id="tbUser">
            <a href="${pageContext.request.contextPath}/poiExcel/download" class="easyui-linkbutton" data-options="iconCls:'icon-print',plain:true">导出Excel</a>

        </div>




