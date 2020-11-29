<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/25
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<div align="center" style="border: black solid 1px">
    <form method="post" action="/doupdate.do" enctype="multipart/form-data">
        <h2 align="center">修改标准信息</h2>
        <table align="center" style="border: black solid 1px">
                <input type="hidden" name="id"></td>
            <tr>
                <td align="right">标准号：</td>
                <td align="left"><input type="text" name="stdNum" value="${st.stdNum}" required></td>
            </tr>
            <tr>
                <td align="right">中文名称：</td>
                <td align="left"><input type="text" name="zhname" value="${st.zhname}" required></td>
            </tr>
            <tr>
                <td align="right">版本：</td>
                <td align="left"> <input type="text" name="version" value="${st.version}" required></td>
            </tr>
            <tr>
                <td align="right">关键字/词：</td>
                <td align="left"> <input type="text" name="keys" value="${st.keys}" required></td>
            </tr>
            <tr>
                <td align="right">发布日期（yyyy-MM--dd）：</td>
                <td align="left"><input type="text" name="releaseDate" value="${st.releaseDate}" required>
                </td>
            </tr>
            <tr>
                <td align="right">实施日期（yyyy-MM--dd）：</td>
                <td align="left"><input type="text" name="implDate" value="${st.implDate}" required>
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
<script src="jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
    function back(){
        window.location="stand.do";
    }
</script>
</html>
