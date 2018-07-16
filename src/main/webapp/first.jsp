<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ktv</title>




<style type="text/css">
*{padding:0px 0px 0px 0px;}
.content{width:1000px;height:700px;border:0px solid #cdcdcd;margin:0px auto;}
.top{height:60px;width:100%;line-height:60px;text-align:center;color:#000016; font-family:SimSun; font-size:30px;background-image:url(img/b1g2.png);}
.frameleft{box-sizing:border-box;
-moz-box-sizing:border-box; /* Firefox */
-webkit-box-sizing:border-box; /* Safari */
/* position:relative;
margin-left:100px; */
float:left;width:500px;height:450px;}


.frameright{width:495px;height:450px;box-sizing:border-box;
-moz-box-sizing:border-box; /* Firefox */
-webkit-box-sizing:border-box; /* Safari */
width:495px;
height:450px;
margin-left:5px;
float:left;}

.search{
box-sizing:border-box;
-moz-box-sizing:border-box; /* Firefox */
-webkit-box-sizing:border-box; /* Safari */
display:block;
height:50px;
width:100%;


text-align:center;
position:relative;
}





.middle{display:inline-block;}

.bottom{display:block;text-align:center;}

.select{width:120px;height:90px;float:left;text-align:center;vertical-align:middle;
}

.select .showpic{margin-top:10px;width:50px;height:50px;display:inline-block;}

.select .showpic img{width:100%;height:100%;}

.smid{position:absolute;z-index:1;top:10px;left:400px;}
.show{position:absolute;z-index:3;}
</style>
<jsp:directive.page import="com.kb.*"/>  
<%SelectAction.ClearSong();
  PalyedServlet.ClearSong();
 %>

<script type="text/javascript" src="js/html5media.min.js"></script>
 <link href="css/templatemo_style2.css" rel="stylesheet" type="text/css" /> 
<link href="css/video-js.css" rel="stylesheet">	
</head>
<body>
<div class="content">
<!-- 头部 -->
<div class="top">欢迎使用javaweb点歌系统</div>

<!-- 中间左边 -->
<div class="frameleft">

 <iframe src="welcome.html"  scrolling="auto"  height="100%;" width="100%;" frameborder="0" id="iframe_a" name="iframe_a" allowfullscreen="true" allowtransparency="true"></iframe> 

</div>
<!-- 中间祐边 -->
<div class="frameright">
<iframe src="video-play1.jsp"  scrolling="no" height="100%;" width="100%;" frameborder="0" name="iframe_B" allowfullscreen="true" allowtransparency="true"></iframe>

</div>
<!-- 搜索 -->
<div style="clear:both"></div>
<div class="search" id="s">
<script type="text/javascript">
function formSubmit()
  {
  document.getElementById("for1").submit();
   document.getElementById("formtext").submit();  
  }

</script>
<div class="smid show ">
  <form action="Query.action" method="post" name="for1" target="iframe_a" id="for1">
     <input type="text" onchange="formSubmit()" name="song_name" id="formtext">
     <input type="submit" value="搜索" >
  </form>
</div>
<div class="smid ">

</div>
<div class="smid ">

</div>
<div class="smid ">
 
</div>
<div class="smid ">
 
</div>
<div class="smid">
 
</div>

</div>
<!-- 低部 -->
<div class="bottom">
 <div class="middle" id="middle">

 <!--   <div class="select">
           <div class="showpic"><img src="img/mkf.jpg"></div>
           <p>数字点歌</p>
   </div> -->
   <div class="select">
           <div class="showpic"><img src="img/mkf.png"></div>
           <p>明星点歌</p>
   </div>
   <!--  <div class="select">
           <div class="showpic"><img src="img/mkf.jpg"></div>
           <p>拼音点歌</p>
    </div> -->
    <div class="select">
           <div class="showpic"><img src="img/mkf.png"></div>
           <p>歌名点歌</p>
    </div>
    <div class="select">
           <div class="showpic"><img src="img/mkf.png"></div>
           <p>选择点歌</p>
    </div>
    <div class="select">
           <div class="showpic"><img src="img/mkf.png"></div>
           <p>播放点歌</p>
    </div>

  </div>

</div>




</div>
</body>
  <script src="js/video.min.js"></script>	
  <script src="js/jquery.min.js"></script>	
		  <script type="text/javascript">
		 
		  	var sb = document.getElementById("middle");
		  	var bsb = document.getElementById("s");
		    var select1 = sb.children; 
		    var bsb1 = bsb.children;
		  
		    
		    for(var i = 0;i<select1.length;i++){
            var e = i;

            select1[i].index = i;
            select1[i].onmouseover = function(){
             //this.className="check";
 

           for(o=0;o<select1.length;o++){
           
 
           select1[o].children[0].style.width="50px";
           select1[o].children[0].style.height="50px";
           select1[o].children[0].style.marginTop="10px";
           select1[o].children[1].style.fontSize="13px";
           
           if(this.index==o){
           var gg = this.children;
           gg[0].style.marginTop="0px";
           gg[0].style.width="70px";
           gg[0].style.height="70px";
           gg[1].style.fontSize="15px";
          
          
         }
    
          }}}
		    
		    
		    
		    
		    
		    

		    
		    
		    
		       for(var i = 0;i<select1.length;i++){
   var e1 = i;

   select1[i].index = i;
   select1[i].onclick = function(){
  //this.className="check";
 
            if(this.index==0){window.open('明星点歌.jsp','iframe_a');}
          /*   if(this.index==0){window.open('数字点歌.html','iframe_a');} */
        /*     if(this.index==2){window.open('拼音点歌.html','iframe_a');} */
            if(this.index==1){window.open('歌名点歌.jsp','iframe_a');}
            if(this.index==2){window.open('选择点歌.jsp','iframe_a');}
            if(this.index==3){window.open('播放点歌.jsp','iframe_a');}
  for(o=0;o<bsb1.length;o++){
  bsb1[o].classList.remove("show");
 
 
  if(this.index==o){
   bsb1[o].classList.add("show");

  
  }
    
    }}}
		    
		    
		    
		    
		    
		    
		    
		    
	
			var myPlayer = videojs('my-video');
			videojs("my-video").ready(function(){
				
				var myPlayer = this;			
			//	myPlayer.play();
				myPlayer.enterFullScreen();
			});
		 
		
		</script>
		
	<%-- 	<% 	
	request.setAttribute("l", SelectAction.getSonglist());
	
 %>

		<script language="javascript">

		var vList; // 初始化播放列表
		vList="<%= request.getAttribute("l") %>";
		alert(vList);	
		
</script>
		 --%>
		
		
		
		
		
		
		
		
		
</html>