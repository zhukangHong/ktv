<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:directive.page import="com.kb.*"/>  
<jsp:directive.page import="java.util.List"/> 
<%@page import="java.util.Iterator"%>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/test.css">

</head>
<body >
<p class="tit">明星点歌</p>
<%     
	request.setCharacterEncoding("UTF-8");
   List<Singer> singerlist=QuerySinger.getAllSinger(request, response);  
   response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0); 
	response.flushBuffer();
    %>
<% 
out.println("<div id='listbox'>");
int i=1;
for(Iterator<Singer> iter=singerlist.iterator();iter.hasNext();){
Singer singer=iter.next();		
out.println("<div class='list'>");
out.println("<a onclick='formSubmit(this)'  target='iframe_a' id='aid"+i+"'> <p id='s'>"+singer.getSinger_name()+"</p></a>");
out.println(" <div class='funbut'>");
out.println("</div></div>");
i++;
}	
out.println("</div>");

%><div class="smid show ">
  <form action="QuerySinger_Song.action" method="post" name="for1" target="iframe_a" id="for1">
     <input type="text" name="singer_name" id="formtext" style="display:none">
     <input type="submit" value="搜索" style="display:none">
  </form>
</div>
	
</body>

<script type="text/javascript">
function formSubmit(obj)
  {
 
  var el= document.getElementById(obj.id);
	var elname=el.innerText;
	//alert(obj.id);
	document.getElementById("formtext").setAttribute("value", elname);
	//alert(elname);
  document.getElementById("for1").submit();
  //document.getElementById("formtext").submit();  
  }
</script>


</html>