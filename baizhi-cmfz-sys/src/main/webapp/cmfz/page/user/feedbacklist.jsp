<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%--<%@include file="/cmfz/page/util/util.jsp"%>--%>
<script>
    var $fb;
    $(function () {
        $fb=$("#feedback");

        $fb.datagrid({
            url:"${pageContext.request.contextPath}/feedback/queryAll",
            method:"post",
            pagination:true,
            pageNumber:1,
            pageList:[2,4,6,8],
            pageSize:2,
            fitColumns:true,
            columns:[[
                {field:"id",title:"编号",width:80,align:"center"},
                {field:"content",title:"反馈内容",width:80,align:"center"},
                {field:"o",title:"用户",width:80,align:"center",
                    formatter:function (value,row,index) {
                        var name=row.user.nickname;
                        return name;
                    }
                }
            ]],
        })
    });
</script>
<table id="feedback"></table>

