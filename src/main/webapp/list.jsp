<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.Iterator"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/test.css">

</head>
<body>
<jsp:directive.page import="com.kb.*"/>  
<jsp:directive.page import="java.util.List"/> 



<%     
	
   List<Song> songlist=(List<Song>) request.getAttribute("songlist1");  
   response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0); 
response.flushBuffer();
   
    %>
    
<p class="tit">搜索列表</p>
	 <% 
	 int i=1;
out.println("<div id='listbox'>");
for(Iterator<Song> iter=songlist.iterator();iter.hasNext();){
Song song=iter.next();		
out.println("<div class='list'>  ");
out.println(" <p >"+song.getSong_name()+"</p>");
out.println(" <div class='funbut'>");
out.println("  <a href='video-play1.jsp?a="+song.getSong_name()+"'  target='iframe_B'><img src='img/play.png' alt='' class='playico'></a> <a onclick='add(this)' id='aid"+i+"'><img src='img/add.png'  class='addico'></a></div></div>");
i++;
}	
out.println("</div>");
			
			
 %>
	
<!-- <input type=button value=后退 onclick="window.history.go(-1)" target='iframe_a'> -->
	
<form name="thisform"method="post" action="Q.action" >  
  
   <input type="text" name="name" id="hidd" style="display:none">  
  
   <input type="button" value="查询"onclick="sel()" style="display:none">  
  
</form>  	
	
	
<script type="text/javascript">
	var elname;
	function add(obj){
	
 var el= document.getElementById(obj.id);
 
 el=el.parentNode.parentNode;

	 elname=el.innerText;
	
	 //alert(elname); 
	
	document.getElementById("hidd").setAttribute("value", elname);
	
	sel();
}


function sel(){  
  
     document.thisform.submit();  
  
}  



</script>


 <%

String str=	request.getParameter("name");
if(str!=null)
{str = new String(str.getBytes("iso-8859-1"),"UTF-8");
 System.out.println(str); 
 SelectAction.setSong(str);
 }
 
 %>






</body>
</html>