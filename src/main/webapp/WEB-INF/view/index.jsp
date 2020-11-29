<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/23
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>信息显示列表</title>
</head>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<body>
<h1>标准信息列表</h1>
<table border="1px">
    <form action="/stand.do" method="post">
    <td colspan="7" align="right">
        <input type="text" name="stand" value="${stand}">
        <input type="submit" value="提交检索">
        <input type="button" onclick="add()" value="新增标准">
        <input type="button" onclick="del()" value="删除标准">
    </td>
    </tr>
    <tr align="center">
        <td><input type="checkbox" name="id"></td>
        <td>标准号</td>
        <td>中文名称</td>
        <td>版本</td>
        <td>发布日期</td>
        <td>实施日期</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="p">
        <tr align="center">
            <td><input type="checkbox" name="id" value="${p.id}"></td>
            <td>${p.stdNum}</td>
            <td>${p.zhname}</td>
            <td>${p.version}</td>
            <td><fmt:formatDate value="${p.releaseDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
            <td><fmt:formatDate value="${p.implDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
            <td><a href="/toDownload.do?filename=${p.packagePath}">下载</a> <a href="update.do?id=${p.id}">修改</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7" align="right">
            <a href="/stand.do?pageNum=${pageInfo.firstPage}">首页|</a>
            <c:if test="${pageInfo.hasPreviousPage}">
                <a href="/stand.do?pageNum=${pageInfo.prePage}">上一页|</a>
            </c:if>
            <c:if test="${pageInfo.hasNextPage}">
                <a href="/stand.do?pageNum=${pageInfo.nextPage}">下一页|</a>
            </c:if>
            <a href="/stand.do?pageNum=${pageInfo.lastPage}">末页|</a>
            第${pageInfo.pageNum}页/共${pageInfo.lastPage}页
        </td>
    </tr>
    </form>
</table>

</body>
<script type="text/javascript">
    $("tr:even").css("background-color","paleturquoise");
    $("tr:first").css("font-weight", "navy blue");
    function del(){
        if($("[type='checkbox']").is(":checked")==true){
            var flag=confirm("确认要删除吗?");
            var obj = document.getElementsByName("id");
            var checkVal="";//获取选中的id
            for(var k in obj){
                if(obj[k].checked){
                    checkVal=checkVal+","+obj[k].value;
                }
            }
            window.location="/del.do?checkVal="+checkVal;
        }else {
            alert("请选择数据")
        }
    }
    function add() {
        window.location="add.do";
    }
</script>
</html>
