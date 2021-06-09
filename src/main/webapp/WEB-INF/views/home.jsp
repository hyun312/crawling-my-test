<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style>
		.button {
		  background-color: #4CAF50;
		  border: none;
		  color: white;
		  padding: 15px 25px;
		  margin: 4px;
		  width : 145px;
		  height : 48px;
		  text-align: center;
		  font-size: 16px;
		  cursor: pointer;
		}
		
		.button:hover {
		  background-color: green;
		}
	</style>
</head>
<body>
<h1>
	Hello world!  
</h1>

<button class="button" onclick="javascript:home.getNews('http://news.jtbc.joins.com', 'JTBC 뉴스 라인');">JTBC</button>
<button class="button" onclick="javascript:home.getNews('https://news.naver.com/', 'NAVER 뉴스');">NAVER</button>
<button class="button" onclick="javascript:home.getNews('https://media.daum.net/', 'DAUM 뉴스');">DAUM</button>
<button class="button" onclick="javascript:home.getNews('http://mbn.mk.co.kr/pages/news/index.html', 'MBN 뉴스');">MBN</button>
<button class="button" onclick="javascript:home.getNews('http://news.kbs.co.kr/common/main.html', 'KBS 뉴스');">KBS</button>
<button class="button" onclick="javascript:home.getNews('https://news.sbs.co.kr/news/newsMain.do', 'SBS 뉴스');">SBS</button>
<button class="button" onclick="javascript:home.getNews('https://www.yna.co.kr/', '연합뉴스');">Yonhap</button>
<button class="button" onclick="javascript:home.getNews('https://www.ytn.co.kr/', 'YTN NEWS');">YTN NEWS</button>
<button class="button" onclick="javascript:home.getNews('http://news.tvchosun.com/', 'TV 조선');">TV chosun</button>
<button class="button" onclick="javascript:home.getNews('https://www.bbc.com/', 'BBC');">BBC</button>

<h1 id="offerSite">
	<!-- JTBC 뉴스 라인 -->
</h1>

<div id="contents">  
	<%-- ${element} --%> 
<div>

<script src="http://code.jquery.com/jquery.min.js"></script>

<script type="text/javascript">
	$(function(){
    	home.init();
    });

	var home = (function(){
    	
    	var init = function(){
    		//none
    	};
    	
    	var reqUrl = "http://news.jtbc.joins.com";
    	
    	var getNews = function(reqUrl, offerSite){
    		$('#offerSite').html(offerSite);
    		console.log('ccㅇㅇㅇ....2000');
    		
     		$.ajax({
    		    url: '${pageContext.request.contextPath}/getNews?reqUrl=' + reqUrl, 
    		    type: 'get', 
    		    success: function(response) {
    		    	console.log(response);
    		    	console.log(response.data.elem); 
    		    	$("#contents").html(response.data.elem);
    		    },
    		    error: function(err) {
    		    	console.log(err);
    		    }
    		});
    	}; 
    	
    	
    	return {
    		init : init,
    		getNews : getNews
    	}
    })();
</script>

</body>
</html>
