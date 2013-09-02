<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSDAY</title>
<link rel="stylesheet" href="css/ssday.css" />
<style type="text/css">
form {
}
small {
	margin-left: 15%;
}
input {
	margin: 10px;
	width: 200px;
	height: 20px;
	
}
</style>
</head>
<body>
	<header>
		<hgroup>
			<h1>
				SSDAY
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
				<a href="indexAction.action" >首页</a>
				</li>
				<li>
				<a href=sstudy1.html>学无海</a>
				</li>
				<li>
				<a href=sstudy2.html>易之道</a>
				</li>
				<li>
				<a href=about.html>关于我们</a>
				</li>
			</ul>
		</nav>
	</header>
	<section>
		<h1 align="center">写日志(*号必填)</h1>
		<form action="writeAction.action" method="post">
			<small>*标题:</small><input type="text" id="title" name="title" placeholder="title" /><br />
			<small>*作者:</small><input type="text" id="author" name="author" placeholder="author" /><br />
			<small>关键字:</small><input type="text" id="keywords" name="keywords" placeholder="key words" /><br />
			<small>*内容:</small><br /><textarea id="content" name="content" style="width: 60%;height: 500px;margin-left: 18%;" ></textarea><br />
			<input type="submit" value="提交"  style="background: olive; width: 50px; height: 30px; margin-left: 70.7%;"/>
		</form>
	</section>
	<footer>
		<p align="center"><small><a href=#>流量统计</a></small></p>
	</footer>
</body>
</html>