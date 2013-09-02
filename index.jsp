<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSDAY</title>
<link rel="stylesheet" href=css/ssday.css />
<script type="text/javascript">
function pucker(id){
	var article=document.getElementById("hidden"+id);
	if(article.className=="show"){
		article.className="hidden";
	}else{
		article.className="show";
	}
}
</script>
</head>
<body>
	<header>
		<hgroup>
			<h1>
				love notes
			</h1>
			<h4>
			</h4>
		</hgroup>
		<figure>
			<img alt="about header" src="res/header.jpg">
			<figcaption>
			</figcaption>
		</figure>
		<nav>
			<ul>
				<li>
				<a href=# >首页</a>
				</li>
				<li>
				<a href=#>学无海</a>
				</li>
				<li>
				<a href=#>易之道</a>
				</li>
				<li>
				<a href=#>关于我们</a>
				</li>
			</ul>
		</nav>
	</header>
	<aside>
		<nav>
			<ul>
				<li><a href="write.jsp">上传文件</a>
				</li>
			</ul>
		</nav>
	</aside>
	<section>
		<nav>
			<ul>
			<s:iterator id="articles" value="articles" status="s">
				<li>
					<article id="article<s:property value="#s.index" />">
						<h1>
							<a href="readAction.action?title=<s:property value="#articles.title" />"><s:property value="#articles.title" /></a>
						</h1>
						<small>
							<a href="#article<s:property value="#s.index" />" onclick=pucker(<s:property value="#s.index" />)>更多</a>
						</small>
						<div class="show" id="show<s:property value="#s.index" />">
							<s:iterator id="paragraphs" value="#articles.paragraphs">
								<s:if test="#paragraphs==paragraphs[0]">
									<p>
										<s:if test="%{#paragraphs.indexOf('[img]')>=0}">
											<img alt="not found"
												src="<s:property value="#paragraphs.substring(#paragraphs.indexOf('[img]')+5,#paragraphs.indexOf('[/img]'))" />" />
										</s:if>
										<s:else>
											<s:property value="#paragraphs" />
										</s:else>
									</p>
								</s:if>
							</s:iterator>
						</div>
						<div class="hidden" id="hidden<s:property value="#s.index" />">
							<s:iterator id="paragraphs" value="#articles.paragraphs">
								<s:if test="#paragraphs!=paragraphs[0]">
									<p>
										<s:if test="%{#paragraphs.indexOf('[img]')>=0}">
											<img alt="not found"
												src="<s:property value="#paragraphs.substring(#paragraphs.indexOf('[img]')+5,#paragraphs.indexOf('[/img]'))" />" />
										</s:if>
										<s:else>
											<s:property value="#paragraphs" />
										</s:else>
									</p>
								</s:if>
							</s:iterator>
						</div>
					</article>
				</li>
				<s:if test="#s.last==false">
				</s:if>
			</s:iterator>
			</ul>
			<s:if test="currentPage==1">
				<s:if test="totalPage!=1">
					<a href="indexAction.action?currentPage=
						<s:property value="%{currentPage+1}" />">下一页</a>
				</s:if>
			</s:if>
			<s:elseif test="currentPage==totalPage">
				<a href="indexAction.action?currentPage=
					<s:property value="%{currentPage-1}" />">上一页</a>
			</s:elseif>
			<s:else>
				<a href="indexAction.action?currentPage=
					<s:property value="%{currentPage-1}" />">上一页</a>
				<a href="indexAction.action?currentPage=
					<s:property value="%{currentPage+1}" />">下一页</a>
			</s:else>
		</nav>
	</section>
	<footer>
		<p align="center"><small><a href=#>
		<script type="text/javascript">
			var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
			document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Ff7ea9edea2b2a28d1c4faed667282619' type='text/javascript'%3E%3C/script%3E"));
		</script>
		</a></small></p>
	</footer>
</body>
</html>