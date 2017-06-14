<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@include file="/cmfz/page/util/util.jsp"%>
<script>
    var $buser;
    $(function () {
        $buser=$("#buser");
        $buser.datagrid({
            url:"${pageContext.request.contextPath}/cmfz/page/json/users.json",
            method:"post",
            pagination:true,
            pageNumber:1,
            pageList:[2,4,6,8],
            pageSize:2,
            fitColumns:true,
            columns:[[
                {field:"id",title:"编号",width:80},
                {field:"realname",title:"姓名",width:80},
                {field:"nickname",title:"法名",width:80},
                {field:"sex",title:"性别",width:80},
                {field:"description",title:"编号",width:80},
                {field:"phone",title:"编号",width:80},
                {field:"m",title:"师傅",width:80,
                    formatter:function (value,row,index) {
                       return row.master.nickname;
                    }
                },
                {field:"p",title:"省",width:80,
                    formatter:function (value,row,index) {
                        return row.province.name;
                    }
                },
                {field:"c",title:"市",width:80,
                    formatter:function (value,row,index) {
                        return row.city.name;
                    }
                },
                {field:"o",title:"操作",width:80,
                    formatter:function (value,row,index) {
                        var id=row.id;
                        return "<a class='del' onClick=\"drop('"+ id +"')\" href='javascript:;'>[删除]</a>&nbsp;&nbsp;<a class='change' href=''>[编辑]</a>";
                    }
                }
            ]],
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $('#addEmp').dialog({
                        title: 'add Emp',
                        width: 300,
                        height: 200,
                        href: '${pageContext.request.contextPath}/easyui/page/addEmp.jsp',
                        buttons:[{
                            text:'保存',
                            plain:true,
                            iconCls:'icon-save',
                            handler:function(){
                                $("#addEmpForm").form('submit',{
                                    url:'${pageContext.request.contextPath}/emp/add',
                                    success:function () {
                                        $emps.datagrid('reload');
                                        $addEmp.dialog('close',true);
                                    }
                                });
                            },
                        },{
                            text:'关闭',
                            plain:true,
                            iconCls:'icon-cancel',
                            handler:function(){
                                $addEmp.dialog('close',true);
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
</script>
<table id="buser"></table>
<div id=""></div>
