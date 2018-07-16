<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<jsp:directive.page import="com.kb.*"/>  
<jsp:directive.page import="java.util.List"/> 
<%@page import="java.util.Iterator"%>
<link rel="stylesheet" type="text/css" href="css/test.css">



<body >
<p class="tit">歌名点歌</p>
<%     
	
   List<Song> songlist=QueryAll.getAllSong(request, response);  
   response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0); 
response.flushBuffer(); 
    %>
 
 <% 
out.println("<div id='listbox'>");
int i=1;
for(Iterator<Song> iter=songlist.iterator();iter.hasNext();){
Song song=iter.next();		
out.println("<div class='list'>  ");
out.println(" <p >"+song.getId()+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+song.getSong_name()+"</p>");
out.println(" <div class='funbut'>");
out.println("  <a href='video-play1.jsp?a="+song.getSong_name()+"'  target='iframe_B'><img src='img/play.png' alt='' class='playico'></a> <a onclick='add(this)' id='aid"+i+"'><img src='img/add.png'  class='addico'></a></div></div>");
i++;
}	
out.println(" </div>");


%>

<form name="thisform"method="post">  
  
   <input type="text" name="name" id="hidd" style="display:none">  
  
   <input type="button" value="查询"onclick="sel()" style="display:none">  
  
</form>  

<script type="text/javascript">
	var elname;
	function add(obj){
	
 var el= document.getElementById(obj.id);
 
 el=el.parentNode.parentNode;

	 elname=el.innerText;
	
	/* alert(elname); */
	
	document.getElementById("hidd").setAttribute("value", elname);
	
	sel();
}


function sel(){  
  
     document.thisform.submit();  
  
}  



</script>


 <%
String str=	request.getParameter("name");
if(str!=null){
str = new String(str.getBytes("iso-8859-1"),"UTF-8");
str=PalyedServlet.subhz(str);
System.out.println("sub later:"+str); 
}
 System.out.println("后："+str); 
 if(str!="null"&&str!=null){
 SelectAction.setSong(str);
 }
 
 %>





</body>
</html>