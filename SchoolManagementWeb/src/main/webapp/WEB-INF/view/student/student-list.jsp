<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/includes/header.jsp" />
<div class="breadcrumbs">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-lg-6 col-md-6 col-12">
				<div class="breadcrumbs-content">
					<h1 class="page-title">Students Management</h1>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-12">
				<ul class="breadcrumb-nav">
					<li><a
						href="${pageContext.request.contextPath }/registrations">Home</a></li>
					<li>Students</li>
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
						<div
							class="d-flex justify-content-between align-items-center w-100">
							<h3 class="block-title">Students List <c:out value="${student.name}" /></h3>
							<div class="form-group button mb-0">
								<a class="btn me-4"
									href="${pageContext.request.contextPath }/students/new">New</a>
							</div>
						</div>
						<!-- <nav class="list-nav">
							<ul>
								<li class="active"><a href="#">All Ads
										<span>42</span>
								</a></li>
								<li><a href="#">Published <span>88</span></a>
								</li>
								<li><a href="#">Featured <span>12</span></a>
								</li>
								<li><a href="#">Sold <span>02</span></a></li>
								<li><a href="#">Active <span>45</span></a>
								</li>
								<li><a href="#">Expired <span>55</span></a>
								</li>
							</ul>
						</nav> -->

						<div class="my-items">
							<div class="item-list-title">
								<div class="row align-items-center">
									<div class="col-lg-3 col-md-3 col-12">
										<p>First Name</p>
									</div>
									<div class="col-lg-2 col-md-2 col-12">
										<p>Last Name</p>
									</div>
									<div class="col-lg-3 col-md-3 col-12">
										<p>Phone</p>
									</div>
									<div class="col-lg-2 col-md-2 col-12">
										<p>Birth Date</p>
									</div>
									<div class="col-lg-2 col-md-2 col-12 align-right">
										<p>Action</p>
									</div>
								</div>
							</div>
							
								<c:if test="${listStudent.size() == 0}">
                                    <div class="alert alert-info">No record</div>
                                </c:if>
							

							<c:forEach var="student" items="${listStudent}">
								<div class="single-item-list">
									<div class="row align-items-center">
										<div class="col-lg-3 col-md-3 col-12">
											<p>
												<c:out value="${student.firstName}" />
											</p>
										</div>
										<div class="col-lg-2 col-md-2 col-12">
											<p>
												<c:out value="${student.lastName}" />
											</p>
										</div>
										<div class="col-lg-3 col-md-3 col-12">
											<p>
												<c:out value="${student.phone}" />
											</p>
										</div>
										<div class="col-lg-2 col-md-2 col-12">
											<p>
												<c:out value="${student.birthDate}" />
											</p>
										</div>
										<div class="col-lg-2 col-md-2 col-12 align-right">
											<ul class="action-btn">
												<li><a
													href="students/edit?id=<c:out value='${student.id}' />">
														<i class="lni lni-pencil"> </i>
												</a></li>
												<li><a href="#"> <i class="lni lni-eye"> </i>
												</a></li>
												<li><a href="#" onClick="if(!confirm('Etes vous surs?')) return false; document.getElementById('form-delete').submit()">
														<i class="lni lni-trash"> </i>
													<form id="form-delete" method="post" action="students/delete" class="d-inline d-none">
														<input type="hidden" name="id" value="<c:out value='${student.id}'/>">
														<button class="btn btn-outline">
														</button>
													
													</form>
												</a></li>
											</ul>
										</div>
									</div>
								</div>

							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>


<jsp:include page="/WEB-INF/includes/footer.jsp" />