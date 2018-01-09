<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">	
<form action="${pageContext.request.contextPath}/upAndDown/upload" method="post" enctype="multipart/form-data">  
         文件1: <input type="file" name="myfiles"/><br/>     
          文件2: <input type="file" name="myfiles"/><br/>     
          文件3: <input type="file" name="myfiles"/><br/>     
        <input type="submit" value="上传">  
</form>