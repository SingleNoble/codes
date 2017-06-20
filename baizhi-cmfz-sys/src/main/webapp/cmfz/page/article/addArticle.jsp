
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>


    

    <script>
        $(function () {

            //富文本编辑器
                window.editor = KindEditor.create("#editor", {
                    themeType:"simple",//修改主题
                    height: "600px",
                    items: [
                        "source",  "preview","fullscreen","clearhtml","|",
                        "undo", "redo","|",
                        "copy", "paste","plainpaste", "wordpaste", "|",
                        "justifycenter", "justifyright",
                        "justifyfull", "insertorderedlist", "insertunorderedlist", "indent", "outdent",  "|",
                        "formatblock", "fontname", "fontsize",
                        "forecolor", "hilitecolor", "bold",
                        "italic", "underline", "strikethrough", "lineheight", "removeformat", "|", "image","table", "hr", "emoticons", "baidumap", "pagebreak",
                        "anchor", "link", "unlink"
                    ],
                    langType: 'zh_CN',
                    syncType: "form",
                    filterMode: false,
                    pagebreakHtml: '<hr class="pageBreak" \/>',
                    allowFileManager: true,
                    filePostName: "image",
                    fileManagerJson:"${pageContext.request.contextPath }/imgs/browser",
                    uploadJson:  "${pageContext.request.contextPath }/imgs/uploadImg",
                    extraFileUploadParams: {
                        token: getCookie("token")
                    },
                    afterChange: function() {
                        this.sync();
                    }
                });


            $('#cc').combobox({
                valueField: 'id',
                textField: 'nickname',
                url: '${pageContext.request.contextPath}/master/query',
                /*onSelect: function(rec){
                    var url = 'get_data2.php?id='+rec.id;
                    $('#cc2').combobox('reload', url);
                }*/
            });

        })

    </script>



    <div style="text-align: center;width:100%;height: 100%">
    <form id="ffArticle" method="post">
        <div style="margin-top:5px">
            标题:<input class="easyui-textbox" style="width:200px" name="title"/>
        </div>
        <div style="margin-top:5px">
            作者:<input id="cc" class="easyui-combobox" name="master.id"/>
        </div>
        <div style="margin-top:5px;margin-bottom: 20px">
            类型:<input  type="radio" value="Shangshi" name="type"/>上师言教
            <input  type="radio" value="fayao" name="type"/>显密法要<br/>
        </div>
        <div style="padding-left: 100px;text-align: center;">
            <textarea id="editor" class="editor" name="content" style="width:80%;height:30%">

            </textarea>
        </div>
    </form>
    </div>
