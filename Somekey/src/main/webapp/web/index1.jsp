<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页</title>
<style type="text/css">
    td{text-align: center;}
    .td2{text-align: right;}
    .table1{
            border:1px solid #ddd;
            width:900px;            
        }
        thead{
            background-color:lightblue;
        }
</style>
</head>
<body>
  结果！<a href="login.do">返回</a>
    <br>
    <hr>
    <c:if test="${empty requestScope.list}">
        没有任何用户信息！
    </c:if>
    <c:if test="${!empty requestScope.list}">
        <table border="1" cellpadding="10" cellspacing="0" class="table1">
        <thead>
            <tr>
                <td>住院号</td>
                <td>住院时间</td>
                <td>身份证</td>
                <td>姓名</td>
                <td>性别</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            </thead>
            <c:forEach items="${requestScope.list}" var="u">
                <tr>
                    <th>${u.number }</th>
                    <th>${u.date }</th>
                    <th>${u.id }</th>
                    <th>${u.name }</th>
                    <th>${u.sex }</th>
                    <th><a href="add.do?number=${u.number}">Edit</a></th>
                    <th><a href="delete.do?number=${u.number}" onclick="return confirm('确定要删除吗')">Delete</a></th>
                </tr>
            </c:forEach>        
        </table>    
    </c:if>

<table  border="0" cellspacing="0" cellpadding="0"  width="900px">
</table>
</body>
</html>