<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
    <jsp:directive.page import="com.kb.*"/>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%  
   
  
    //获取该视频的播放位置
   String str=request.getParameter("a");
   
   	if(str==null)
  	{
  	System.out.println("空");
  	str="不再见";
  	}  
  	PalyedServlet.setSong(str);
   
%> 
<html>
<head>
<meta charset="utf-8">


  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		
	
	<script type="text/javascript" src="js/html5media.min.js"></script>
	<link href="css/templatemo_style2.css" rel="stylesheet" type="text/css" />
	<link href="css/test.css" rel="stylesheet" type="text/css" />
<title>Video.js 6.2.8</title>
	<link href="css/video-js.css" rel="stylesheet">	
	<style>
		body{background-color:#f5f5f5;/* width: 100%; */}
		.m{width:100%; height:100%; margin:0px auto; }
		.text{ width: 100%; height:30px; margin:0px auto;line-height:30px;font-size:20px; }
		.list .ni{box-sizing:border-box;
-moz-box-sizing:border-box; /* Firefox */
-webkit-box-sizing:border-box; /* Safari */width:100%;display:block;height:30px;line-height:18px;font-size:16px;margin:5px auto; }
		a{line-height:35px;text-decoration:none;}
		 .jian{height:20px;width:100%;line-height:20px;font-size:18px;color:#030303;}
		.ex{ width:100%;margin:3px auto;line-height:20px;font-size:15px;}
		#exnext{ margin-left: auto; margin-right: auto; margin-top: 5px;line-height:30px;font-size:20px;}
	   .other{box-sizing:border-box;
-moz-box-sizing:border-box; /* Firefox */
-webkit-box-sizing:border-box; /* Safari */width:100%;margin:3px auto;font-size:20px;line-height:25px;}
	
	</style>
</head>

<body >
  <div class="text" id="sname">歌曲名字:<%=str.trim() %> 
 <!--  <input type="button" onclick="playnext()" value="切歌">	 -->
  </div> 
	<div class="m">
	
	
	
		  <video id="my-video" onended="playnext()"  class="video-js"  controls autoplay  width="480px" height="350px"  poster="m.png" data-setup="{}" >
			
			<source src="video/<%=str.trim()%>.mp4" id="vs" type="video/mp4"></source>
			<p class="vjs-no-js">
			  To view this video please enable JavaScript, and consider upgrading to a web browser that
			  <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
			</p>
		  </video> 
		  
		  
		 <input type="button" onclick="playnext()" value="切歌"> 
	
		  
		  
		  
		</div>  
		  
		  <script src="js/video.min.js"></script>	


<% 	

	request.setAttribute("l", SelectAction.getSonglist());
	System.out.println(SelectAction.getSonglist().toString());
 %>


<script language="javascript">



var myPlayer = videojs('my-video');
			//p();
			function p(){
			videojs("my-video").ready(function(){
				var myPlayer = this;
				myPlayer.load();
				myPlayer.play();
				myPlayer.enterFullScreen();
			});
		
			}
			



	var myPlayer = videojs('my-video');
		
		var vList =new Array() ; // 初始化播放列表
		vList="<%= request.getAttribute("l") %>";
		//vList=vList.trim();
		vList=vList.substring(1,vList.length-1);
		vList=vList.split(", ");
	<%-- 	<%int curr=2; request.setAttribute("curr", curr);%> --%>
		//var curr=2;
		 var vLen = vList.length; // 播放列表的长度
		 
		 <%String strcurr=request.getParameter("curr");	
		 if(strcurr=="null"||strcurr==null)strcurr="1";
		 System.out.println("strcurr:"+strcurr);	 
		 %>
		 
		
		var curr =<%=strcurr.trim()%> ; // 当前播放的视频	
		//curr++;
	//document.getElementById("sname").innerText="curr:"+curr;				
		
		
		  function playnext() {
		//if(vList[curr]=="null"){curr++}
		
		myPlayer.pause();
		vList[curr]=vList[curr].trim();
		document.getElementById("vs").setAttribute("src","video/"+vList[curr]+".mp4"); 
		document.getElementById("my-video_html5_api").setAttribute("src","video/"+vList[curr]+".mp4"); 
		document.getElementById("sname").innerText="歌曲名字:"+vList[curr];
		/* .substring(6, vList[curr].indexOf('.')) */
		
                          p(); 
                            curr++;  
                            
                            if(curr >= vLen){  
                                curr = 0; //重新循环播放
                            }  
}
		/*
							if(vList[curr]=="null"){
							curr++
							}else {		
							myPlayer.src = "video/"+vList[curr]+".mp4";
							videojs("my-video").ready(function(){
				var myPlayer = this;
				myPlayer.load();
				myPlayer.play();
				myPlayer.enterFullScreen();
			});
							curr++;
							if(curr >= vLen){
								curr = 0; // 播放完了，重新播放
							}
						}
						} */ 
						
			function cut(){
			
			//$("#my-video").onended
			}			
						
						
						
						
</script>













	
	<!-- 视频列表 -->

</body>
</html>
