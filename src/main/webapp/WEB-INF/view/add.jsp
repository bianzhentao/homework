<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/24
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>
</head>
<body>
<div align="center" style="border: black solid 1px">
    <form method="post" action="/doadd.do" enctype="multipart/form-data">

        <h2 align="center">增加标准信息</h2>
        <table align="center" style="border: black solid 1px">
            <tr>
                <td align="right">标准号：</td>
                <td align="left"><input type="text" name="stdNum" required></td>
            </tr>
            <tr>
                <td align="right">中文名称：</td>
                <td align="left"><input type="text" name="zhname" required></td>
            </tr>
            <tr>
                <td align="right">版本：</td>
                <td align="left"> <input type="text" name="version" required></td>
            </tr>
            <tr>
                <td align="right">关键字/词：</td>
                <td align="left"> <input type="text" name="keys" required></td>
            </tr>
            <tr>
                <td align="right">发布日期（yyyy-MM--dd）：</td>
                <td align="left"><input type="text" name="releaseDate" required>
                </td>
            </tr>
            <tr>
                <td align="right">实施日期（yyyy-MM--dd）：</td>
                <td align="left"><input type="text" name="implDate" required>
                </td>
            </tr>
            <tr>
                <td align="right">附件：</td>
                <td align="left"><input type="file" name="id_Pic" value="选择文件"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="保存" >
                    <input type="button" onclick="back()" value="取消"></td>
            </tr>
        </table>

    </form>
</div>
</body>
<script src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    function back(){
        window.location="stand.do";
    }
</script>
</html>
