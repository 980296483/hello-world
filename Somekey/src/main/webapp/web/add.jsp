<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑页面</title>
<link href="css/easyui.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
 <script type="text/javascript" src="js/jquery.easyui.min.js"></script>

<style type="text/css">
    td{text-align: center;}
    .td2{text-align: right;}
    .table1{
            border:1px solid #ddd;
            width:500px;            
        }
    
</style>
</head>
<body>
    欢迎你!
    <a href="login.do">返回</a>
    <hr>
<%--         <form action="save.do" method="post">
        <input type="hidden" name="number" value="${returnUser}"/>
        时间:<input name="date" /><br>
        身份证:<input name="id" /><br>
        姓名:<input name="name" /><br>
        性别:<input name="sex" /><br>
            <input type="submit" value="提交"/>
    </form> --%>
    <form name="myform" action ="save.do" onsubmit="return validate_form(this);" method="post">
     <table class="table1" border = "1" align = "center">
        <tr>　　
            <td colspan="2"><input type="hidden" name="number" value="${requestScope.returnUser.number}"/></td>                   </tr>
         <tr>
             <td> 时间:</td>
             <td class="tdstyle2"><input type="text" id="date_input" name="date" value="${requestScope.returnUser.date}"/></td>    
         </tr>
         <tr>
            <td>身份证：</td>
            <td><input type="text" id="id1" class="id" name="id" onblur="checkxtid()" value="${requestScope.returnUser.id}"/><span id="nameDiv1" style="display:none">不能为空</span></td>            
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" id="name1" name="name" onblur="checktxt()" value="${requestScope.returnUser.name}"/><span id="nameDiv" style="display:none">不能为空</span></td>         
        </tr>
       <tr>
           <td>性 别:</td>
            <td>
               <input type="radio" id = "man" name="sex" value="男" checked="checked" />男
                <input type="radio" id = "woman"name="sex" value="女" />女
            </td>        
        </tr>
       <tr> <td colspan="2"><input type = "submit" value = "修改" /></td></tr>
   </table>
    </form>
    <script type="text/javascript">
     	$(document).ready(function(){
    		 $("#date_input").datebox();  
    	})  
    	function checkxtid(){
     		var a1=$("#id1").val();
     		if(a1==null || a1==""){
        		$("#nameDiv1").css("display","block");
        		$("#nameDiv1").css("color","red");
      			 } else {
        		$("#nameDiv1").css("display","none");
      		}
     	}
     	
    	function checktxt(){
    		var a=$("#name1").val();
    		
    		if(a==null || a==""){
    		$("#nameDiv").css("display","block");
    		$("#nameDiv").css("color","red");
  			 } else {
    		$("#nameDiv").css("display","none");
  		}
    		
	}
     	function validate_required(field,alerttxt)
     	{
     	with (field)
     	  {
     	  if (value==null||value=="")
     	    {alert(alerttxt);return false}
     	  else {return true}
     	  }
     	}

     	function validate_form(thisform)
     	{
     	with (thisform)
     	  {
     	  if (validate_required(name,"正确填写表单")==false||validate_required(id,"Email must be filled out!")==false)
     	    {name.focus();id.focus();return false}
     	  }
     	}
    </script>
</body>
</html>