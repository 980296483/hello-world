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
    欢迎你!
    <br>
    <hr>
    <a href="add.do"> 添加用户</a><br>
    <form action="list.do" method="get">
    	<input name="name"><input type="submit" value="搜索"/>
    </form>
    <c:if test="${empty requestScope.pagemsg}">
        没有任何用户信息！
    </c:if>
    <c:if test="${!empty requestScope.pagemsg}">
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
            <c:forEach items="${requestScope.pagemsg.lists}" var="u">
                <tr>
                    <th>${u.number }</th>
                    <th>${u.date }</th>
                    <th>${u.id }</th>
                    <th>${u.name }</th>
                    <th>${u.sex }</th>
                    <th><a href="update.do?number=${u.number}">Edit</a></th>
                    <th><a href="delete.do?number=${u.number}" onclick="return confirm('确定要删除吗')">Delete</a></th>
                </tr>
            </c:forEach>        
        </table>    
    </c:if>

<table  border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td class="td2">
   <span>第${requestScope.pagemsg.currPage }/ ${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp;
   <span>总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
   <span>
       <c:if test="${requestScope.pagemsg.currPage != 1}">
           <a href="${pageContext.request.contextPath }/main.do?currentPage=1">[首页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/main.do?currentPage=${requestScope.pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;
       </c:if>

       <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
           <a href="${pageContext.request.contextPath }/main.do?currentPage=${requestScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/main.do?currentPage=${requestScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
   </span>
</td>
</tr>
</table>
</body>
</html>