<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSDAY</title>
<link rel="stylesheet" href="css/ssday.css" />
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
				<a href=indexAction.action >首页</a>
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
		<article>
			<h1 align="center">
				<a href="#"><s:property value="title" />
				</a>
			</h1>
			<div class="show">
				<s:iterator id="paragraphs" value="paragraphs">
						<p>
							<s:property value="#paragraphs" />
						</p>
				</s:iterator>
			</div>
		</article>
	</section>
	<footer>
		<p align="center"><small><a href=#>流量统计</a></small></p>
	</footer>
</body>
</html>