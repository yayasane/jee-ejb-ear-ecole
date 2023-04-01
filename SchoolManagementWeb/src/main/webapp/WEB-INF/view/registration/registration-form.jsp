<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/includes/header.jsp" />
<div class="breadcrumbs">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6 col-md-6 col-12">
				<div class="breadcrumbs-content">
					<h1 class="page-title">Registrations Management</h1>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-12">
				<ul class="breadcrumb-nav">
					<li><a href="${pageContext.request.contextPath }/registrations">Home</a></li>
					<li><a href="${pageContext.request.contextPath }/registrations">Registrations</a></li>
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
							<c:if test="${registration != null}">
                                    Edit Registration
                                </c:if>
							<c:if test="${registration == null}">
                                    Add New Registration
                                </c:if>
						</h3>
						
						<div class="inner-block">
							<div class="post-ad-tab">
							<c:if test="${errors != null}">
						<div class="alert alert-danger"><c:out value="${errors }" escapeXml="false"></c:out></div>
						</c:if>
								<c:if test="${registration != null}">
									<form class="default-form-style" method="post" action="update"
										method="post">
								</c:if>
								<c:if test="${registration == null}">
									<form class="default-form-style" method="post" action="insert"
										method="post">
								</c:if>
								<c:if test="${registration != null}">
									<input type="hidden" name="id"
										value="<c:out value='${registration.id}' />" />
								</c:if>
								<div class="row">
									<div class="col-12">
										<div class="form-group">
											<label>Detail*</label> <input name="detail" type="text"
												placeholder="Enter Name"
												value="<c:out value='${registration.detail}' />" />
										</div>
									</div>
									<div class="col-12">
										<div class="form-group">
											<label>Student*</label>
											<div class="selector-head">
												<span class="arrow"><i class="lni lni-chevron-down"></i></span>
												<select class="user-chosen-select" name="student">
													<option value="none">Select a Student</option>
													<c:forEach var="student" items="${students}">
														<option <c:if test = "${student.id == registration.student.id}">selected</c:if> value="<c:out value="${student.id }"></c:out>">
															<c:out value="${student }"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-12">
										<div class="form-group">
											<label>Registration*</label>
											<div class="selector-head">
												<span class="arrow"><i class="lni lni-chevron-down"></i></span>
												<select class="user-chosen-select" name="course">
													<option value="none">Select a Course</option>
													<c:forEach var="course" items="${courses}">>
														<option <c:if test = "${course.id == registration.course.id}">selected</c:if> value="<c:out value="${course.id }"></c:out>">
															<c:out value="${course}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<div class="col-12">
										<div class="form-group">
											<label>Year*</label>
											<div class="selector-head">
												<span class="arrow"><i class="lni lni-chevron-down"></i></span>
												<select class="user-chosen-select" name="year">
													<option value="none">Select a Year</option>
													<c:forEach var="year" items="${years}">
														<option <c:if test = "${year.id == registration.year.id}">selected</c:if> value="<c:out value="${year.id }"></c:out>">
															<c:out value="${year}"></c:out>
														</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>

									<div class="col-12">
										<div class="form-group button mb-0">
											<button type="submit" class="btn">
												<c:if test="${registration != null}">
									Update
								</c:if>
												<c:if test="${registration == null}">
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