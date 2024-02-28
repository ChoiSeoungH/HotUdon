<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .container {
        height: 100vh;
        width: 100vw;
        margin: 0;
        padding: 0;
    	position: relative;
    }
    .main {
        height: 100%;
        width: 100%;
    }
    td, th {
        border: 1px solid black;
    }
    h3,h4{
    	margin-bottom: 30px;
    }
    .modal{
    	/* border: 1px solid black; */
    	border-radius: 10px;
    	width: 400px;
    	hight: 1000px;
    	margin: auto;
    	text-align: center;
    	background-color: #fff;
    	position: absolute;
    	top: 50%;
    	left: 50%;
    	transform: translate(-50%, -50%);
    	visibility: visible;
    	opacity: 1;
    	z-index: 2;
    }
    .hidden{
    	visibility: hidden;
    	opacity: 0;
    }
    .btn{
    	border: none;
    	width: 334px;
    	height: 48px;
    	border-radius: 5px;
    	margin: 10px auto;
    	display: flex;
    	justify-content: center;
    	align-items: center;
    	position: relative;
    }
    .naver svg{
    	color: #00C73C;
    }
    .btn svg{
    	vertical-align: middle;
    	margin-right: 10px;
    	position: absolute;
  		left: 50px;
    }
    .kakao:hover{
    	background-color: #FEE500;
    }
    .naver:hover{
    	background-color: #00C73C;
    	color: #fff;
    }
    .naver:hover path{
    	fill: #fff;
    }
    .google:hover{
    	background-color: #DB4437;
    	color: #fff;
    }
    .google:hover path{
    	fill: #fff;
    }
    .email:hover{
    	background-color: #FFF;
    }
    .overlay{
		background-color: #00000096;
		width: 100%;
 		height: 100%;
 		position: fixed;
 		top: 0;
 		left: 0;
 		z-index: 1;
 		/* opacity: 0; */
    }
    header{
    	display: flex;
    	justify-content: space-between;
    }
    p{
    	font-size: 0.8em;
    	margin: 20px 30px;
    }
    .logo img{
    	height: 60px;
    }
    .search{
    	align-items: center;
    }
    .userImg img{
    	height: 60px;
    	width: 60px;
    	border-radius: 50%;
    }
</style>
</head>
<body>

 	<header>
	<div class="logo" onclick=""><img src="./img/logo.png"> </div>
	<div class="search">
	<input type="text" name="search" width="400px" height="200px">
	
	</div>
	<div class="userImg"> <a onclick="clickLogin()"><img class="userImg" src="https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg" ></a></div>
 	</header>
 	
 	

<%@ include file="./LoginModal.jsp" %>