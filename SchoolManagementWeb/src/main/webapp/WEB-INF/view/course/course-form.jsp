<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/includes/header.jsp" />
<div class="breadcrumbs">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6 col-md-6 col-12">
				<div class="breadcrumbs-content">
					<h1 class="page-title">Courses Management</h1>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-12">
				<ul class="breadcrumb-nav">
					<li><a href="${pageContext.request.contextPath }/registrations">Home</a></li>
					<li><a href="${pageContext.request.contextPath }/courses">Courses</a></li>
					<li>New</li>
				</ul>
			</div>
		</div>
	</div>
</div>

<section class="dashboard section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-9 col-md-12 col-12">
				<div class="main-content">
					<div class="dashboard-block mt-0">
						<h3 class="block-title">
							<c:if test="${course != null}">
                                    Edit Course
                                </c:if>
							<c:if test="${course == null}">
                                    Add New Course
                                </c:if>
						</h3>
						
						<div class="inner-block">
							<div class="post-ad-tab">
							<c:if test="${errors != null}">
						<div class="alert alert-danger"><c:out value="${errors }" escapeXml="false"></c:out></div>
						</c:if>
								<c:if test="${course != null}">
									<form class="default-form-style" method="post" action="update"
										method="post">
								</c:if>
								<c:if test="${course == null}">
									<form class="default-form-style" method="post" action="insert"
										method="post">
								</c:if>
								<c:if test="${course != null}">
									<input type="hidden" name="id"
										value="<c:out value='${course.id}' />" />
								</c:if>
								<div class="row">
									<div class="col-12">
										<div class="form-group">
											<label>Name*</label> <input name="name" type="text"
												placeholder="Enter Name"
												value="<c:out value='${course.name}' />" />
										</div>
									</div>
									<div class="col-12">
										<div class="form-group">
											<label>Group*</label> <input name="program" type="text"
												placeholder="Enter Group"
												value="<c:out value='${course.program}' />" />
										</div>
									</div>
									<div class="col-12">
										<div class="form-group button mb-0">
											<button type="submit" class="btn">
												<c:if test="${course != null}">
									Update
								</c:if>
												<c:if test="${course == null}">
									Create
								</c:if>
											</button>
										</div>
									</div>
								</div>
								</form>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>

</section>
<jsp:include page="/WEB-INF/includes/footer.jsp" />