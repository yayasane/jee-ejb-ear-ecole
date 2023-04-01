<!DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html class=no-js lang=zxx>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta charset=utf-8 />
<meta http-equiv=x-ua-compatible content="ie=edge" />
<title>School Management - A platform for school management</title>
<meta name=description content="" />
<meta name=viewport content="width=device-width, initial-scale=1" />
<link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/assets/images/favicon.svg"/>" />


<link href="https://fonts.googleapis.com/css2?family=Jost:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap" rel='stylesheet'>
<link href="https://fonts.googleapis.com/css2?family=Lato&amp;display=swap" rel="stylesheet">

<link rel=stylesheet href="<c:url value="/resources/assets/css/A.bootstrap.min.css+LineIcons.2.0.css+animate.css+tiny-slider.css+glightbox.min.css,Mcc.4RKRGkT2S5.css.pagespeed.cf.tPexlwcGLm.css"/>" />
<link rel=stylesheet href="<c:url value="/resources/assets/css/A.main.css.pagespeed.cf.65XS99l10B.css" />"/>
</head>

<body>
<header class="header navbar-area">
	<div class=container>
		<div class="row align-items-center">
			<div class=col-lg-12>
				<div class=nav-inner>
					<nav class="navbar navbar-expand-lg">
						<a class=navbar-brand href=index.html> <img
							src="<c:url value="/resources/assets/images/logo/logo.jpeg"/>" alt=Logo>
						</a>
						<button class="navbar-toggler mobile-menu-btn" type=button
							data-bs-toggle=collapse data-bs-target="#navbarSupportedContent"
							aria-controls=navbarSupportedContent aria-expanded=false
							aria-label="Toggle navigation">
							<span class=toggler-icon></span> <span class=toggler-icon></span>
							<span class=toggler-icon></span>
						</button>
						<div class="collapse navbar-collapse sub-menu-bar"
							id=navbarSupportedContent>
							<ul id=nav class="navbar-nav ms-auto">
								<li class=nav-item><a href="${pageContext.request.contextPath }/registrations"
									aria-label="Toggle navigation">Registrations</a></li>
									<li class=nav-item><a href="${pageContext.request.contextPath }/students"
									aria-label="Toggle navigation">Students</a></li>
									<li class=nav-item><a href="${pageContext.request.contextPath }/courses"
									aria-label="Toggle navigation">Courses</a></li>
									<li class=nav-item><a href="${pageContext.request.contextPath }/years"
									aria-label="Toggle navigation">Years</a></li>
							</ul>
						</div>
						
						<div class="button header-button">
							<a href="${pageContext.request.contextPath }/registrations/new" class=btn>Register Student</a>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</div>
</header>