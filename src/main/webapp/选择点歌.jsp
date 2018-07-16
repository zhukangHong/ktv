<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/test.css">
</head>
<jsp:directive.page import="com.kb.*"/>  
<jsp:directive.page import="java.util.List"/> 
<%@page import="java.util.Iterator"%>
<link rel="stylesheet" type="text/css" href="css/test.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<body>
<p class="tit">选择点歌</p>

<%
String str=	request.getParameter("name");
if(str!=null){
str = new String(str.getBytes("iso-8859-1"),"UTF-8");
 System.out.println("10"+str); 
 SelectAction.rmSong(str);
 request.setCharacterEncoding("UTF-8");
 response.setCharacterEncoding("UTF-8");
 }
 %>





<%     
	
   List<String> songlist=SelectAction.getSonglist();  
   response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0); 
response.flushBuffer(); 
    %>


<% 
out.println("<div id='listbox'>");
int i=1;
for(Iterator<String> iter=songlist.iterator();iter.hasNext();){
String song=iter.next();	
	if(song!=null){
out.println("<div class='list'>  ");
out.println(" <p >"+song+"</p>");
out.println(" <div class='funbut'>");
out.println("<a href='video-play1.jsp?a="+song+"&curr="+i+"'  target='iframe_B'><img src='img/play.png' alt='' class='playico'></a> <a onclick='sublist(this)' id='aid"+i+"'><img src='img/sub.png'  class='addico'></a></div></div>");
i++;
}




}	
out.println(" </div>");


%>


<form name="thisform"method="post">  
  
   <input type="text" name="name" id="hidd" style="display:none">  
  
   <input type="button" value="查询"onclick="sel()" style="display:none">  
  
</form>  


<script type="text/javascript">

function sublist(obj){
var el= document.getElementById(obj.id);
 elchild=el.parentNode.parentNode;
// alert(elchild.innerText); 
var  elname=elchild.innerText;
elchild.parentNode.removeChild(elchild);
document.getElementById("hidd").setAttribute("value", elname);
 sel();

}


function sel(){  
  
     document.thisform.submit();  
  
}  

</script>








</body>
</html>