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
					<li><a
						href="${pageContext.request.contextPath }/registrations">Home</a></li>
					<li>Registrations</li>
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
							<h3 class="block-title">Registrations List <c:out value="${registration.name}" /></h3>
							<div class="form-group button mb-0">
								<a class="btn me-4"
									href="${pageContext.request.contextPath }/registrations/new">New</a>
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
									<div class="col-lg-4 col-md-4 col-12">
										<p>Detail</p>
									</div>
									<div class="col-lg-2 col-md-2 col-12">
										<p>Student</p>
									</div>
									<div class="col-lg-2 col-md-2 col-12">
										<p>Course</p>
									</div>
									<div class="col-lg-2 col-md-2 col-12">
										<p>year</p>
									</div>
									<div class="col-lg-2 col-md-2 col-12 align-right">
										<p>Action</p>
									</div>
								</div>
							</div>
							
								<c:if test="${listRegistration.size() == 0}">
                                    <div class="alert alert-info">No record</div>
                                </c:if>
                                <div class="gl-alert-content" role="alert">
								<!-- <style>
* {
	box-sizing: border-box;
}

@media all {
	* {
		box-sizing: border-box;
		font-variant-ligatures: none;
	}
	main {
		display: block;
	}
}

#content-body {
	display: none;
}

@media all {
	#content-body {
		display: block;
	}
}

.container-fluid {
	width: 100%;
	padding-right: 15px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto;
}

@media all {
	.container-fluid {
		width: 100%;
		padding-right: 15px;
		padding-left: 15px;
		margin-right: auto;
		margin-left: auto;
	}
	.container-limited {
		max-width: 1280px;
	}
	.container-limited.limit-container-width {
		max-width: 990px;
	}
	.content-wrapper .container-fluid {
		padding: 0 16px;
	}
	.content-wrapper-margin {
		margin-top: var(- -header-height, 48px);
	}
	.content-wrapper {
		padding-bottom: 100px;
		width: 100%;
	}
	.page-initialised .content-wrapper {
		transition: padding 0.2s;
	}
}

@media ( min-width : 768px) {
	.page-with-contextual-sidebar {
		padding-left: 56px;
	}
}

@media ( min-width : 1200px) {
	.page-with-contextual-sidebar {
		padding-left: 256px;
	}
}

@media all {
	.page-with-contextual-sidebar {
		transition: padding-left 0.2s;
	}
}

body {
	margin: 0;
	font-family: var(- -default-regular-font, -apple-system),
		BlinkMacSystemFont, "Segoe UI", Roboto, "Noto Sans", Ubuntu, Cantarell,
		"Helvetica Neue", sans-serif, "Apple Color Emoji", "Segoe UI Emoji",
		"Segoe UI Symbol", "Noto Color Emoji";
	font-size: 0.875rem;
	font-weight: 400;
	line-height: 1.5;
	color: #333238;
	text-align: left;
	background-color: #fff;
}

@media all {
	body {
		margin: 0;
		font-family: var(- -default-regular-font, -apple-system),
			BlinkMacSystemFont, "Segoe UI", Roboto, "Noto Sans", Ubuntu,
			Cantarell, "Helvetica Neue", sans-serif, "Apple Color Emoji",
			"Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
		font-size: 0.875rem;
		font-weight: 400;
		line-height: 1.5;
		color: #333238;
		text-align: left;
		background-color: #fff;
		-webkit-text-shadow: rgba(255, 255, 255, 0.01) 0 0 1px;
	}
}

.tab-width-8 {
	tab-size: 8;
}

@media all {
	.tab-width-8 {
		tab-size: 8;
	}
}

html {
	font-family: sans-serif;
	line-height: 1.15;
	overflow-y: scroll;
}

@media all {
	html {
		font-family: sans-serif;
		line-height: 1.15;
		-webkit-text-size-adjust: 100%;
		-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
		overflow-y: scroll;
	}
	:root { -
		-default-mono-font: 'JetBrains Mono', 'Menlo'; -
		-default-regular-font: 'GitLab Sans', -apple-system;
	}
	.gl-alert {
		font-size: 0.875rem;
		position: relative;
		padding-left: 3rem;
		padding-right: 3rem;
		padding-top: 1rem;
		padding-bottom: 1rem;
	}
	.gl-alert-success {
		background-color: #ecf4ee;
	}
	.gl-mt-3 {
		margin-top: 0.5rem;
	}
}

*, :before, :after {
	box-sizing: border-box;
}

@media all {
	*, :before, :after {
		box-sizing: border-box;
	}
}

svg {
	overflow: hidden;
	vertical-align: baseline;
	fill: currentColor;
}

@media all {
	svg {
		overflow: hidden;
		vertical-align: baseline;
		fill: currentColor;
	}
	.gl-alert-icon {
		position: absolute;
		top: 1rem;
		left: 1rem;
		width: 1rem;
		height: 1rem;
		fill: currentColor;
	}
	.gl-alert-icon-no-title {
		margin-top: 0.125rem;
	}
}

svg.s16 {
	width: 16px;
	height: 16px;
	vertical-align: -3px;
}

@media all {
	svg.s16 {
		width: 16px;
		height: 16px;
		vertical-align: -3px;
	}
	.gl-alert-success .gl-alert-icon {
		color: #217645;
	}
}

button {
	border-radius: 0;
	margin: 0;
	font-family: inherit;
	font-size: inherit;
	line-height: inherit;
	overflow: visible;
	text-transform: none;
}

@media all {
	button {
		border-radius: 0;
		margin: 0;
		font-family: inherit;
		font-size: inherit;
		line-height: inherit;
		overflow: visible;
		text-transform: none;
	}
}

.btn {
	display: inline-block;
	font-weight: 400;
	color: #333238;
	text-align: center;
	vertical-align: middle;
	-webkit-user-select: none;
	user-select: none;
	background-color: transparent;
	border: 1px solid transparent;
	padding: 0.375rem 0.75rem;
	font-size: 1rem;
	line-height: 20px;
	border-radius: 0.25rem;
}

.gl-button {
	display: inline-flex;
}

.btn {
	border-radius: 4px;
	font-size: 0.875rem;
	font-weight: 400;
	padding: 6px 10px;
	background-color: #fff;
	border-color: #dcdcde;
	color: #333238;
	white-space: nowrap;
}

@media all {
	button, [type="button"] {
		-webkit-appearance: button;
	}
	.btn {
		display: inline-block;
		font-weight: 400;
		color: #333238;
		text-align: center;
		vertical-align: middle;
		-webkit-user-select: none;
		user-select: none;
		background-color: transparent;
		border: 1px solid transparent;
		padding: 0.375rem 0.75rem;
		font-size: 1rem;
		line-height: 20px;
		border-radius: 0.25rem;
		transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out,
			border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
	}
	.btn-sm {
		padding: 0.25rem 0.5rem;
		font-size: 0.875rem;
		line-height: 1.5;
		border-radius: 0.2rem;
	}
	.gl-dismiss-btn {
		position: absolute;
		top: 0.75rem;
		right: 0.75rem;
	}
	.gl-button {
		display: inline-flex;
	}
	.btn {
		transition: background-color 100ms linear, border-color 100ms linear,
			color 100ms linear, box-shadow 100ms linear;
		border-radius: 4px;
		font-size: 0.875rem;
		font-weight: 400;
		padding: 6px 10px;
		background-color: #fff;
		border-color: #dcdcde;
		color: #333238;
		white-space: nowrap;
	}
}

button, [type="button"] {
	cursor: pointer;
}

@media all {
	button, [type="button"] {
		-webkit-appearance: inherit;
		cursor: pointer;
	}
}

button:not(:disabled), [type="button"]:not(:disabled) {
	cursor: pointer;
}

.gl-button.gl-button {
	border-width: 0;
	padding-top: 0.5rem;
	padding-bottom: 0.5rem;
	padding-left: 0.75rem;
	padding-right: 0.75rem;
	background-color: transparent;
	line-height: 1rem;
	color: #333238;
	fill: currentColor;
	box-shadow: inset 0 0 0 1px #bfbfc3;
	justify-content: center;
	align-items: center;
	font-size: 0.875rem;
	border-radius: 0.25rem;
}

@media all {
	button:not(:disabled), [type="button"]:not(:disabled) {
		cursor: pointer;
	}
	.gl-button.gl-button {
		border-width: 0;
		padding-top: 0.5rem;
		padding-bottom: 0.5rem;
		padding-left: 0.75rem;
		padding-right: 0.75rem;
		background-color: transparent;
		line-height: 1rem;
		color: #333238;
		fill: currentColor;
		box-shadow: inset 0 0 0 1px #bfbfc3;
		justify-content: center;
		align-items: center;
		font-size: 0.875rem;
		border-radius: 0.25rem;
	}
	.btn.btn-sm {
		padding: 4px 10px;
		font-size: 13px;
		line-height: 18px;
	}
	.btn.btn-icon {
		color: #535158;
	}
}

.btn:not(:disabled):not(.disabled) {
	cursor: pointer;
}

.gl-button.gl-button.btn-default {
	background-color: #fff;
}

@media all {
	.btn:not(:disabled):not(.disabled) {
		cursor: pointer;
	}
	.gl-button.gl-button.btn-default {
		background-color: #fff;
	}
	.gl-button.gl-button.btn-default-tertiary {
		box-shadow: none;
		mix-blend-mode: multiply;
	}
	.gl-button.gl-button.btn-sm {
		padding-top: 0.25rem;
		padding-bottom: 0.25rem;
		padding-left: 0.5rem;
		padding-right: 0.5rem;
		line-height: 1rem;
		font-size: 0.875rem;
	}
	.gl-button.gl-button.btn-icon {
		padding: 0.5rem;
		line-height: 1rem;
	}
	.gl-button.gl-button.btn-default.btn-default-tertiary {
		background-color: transparent;
	}
	.gl-button.gl-button.btn-icon.btn-sm {
		padding: 0.25rem;
	}
	.btn:hover {
		color: #333238;
		text-decoration: none;
		background-color: #ececef;
		border-color: #dedee3;
	}
	.gl-button.gl-button.btn-default:hover {
		box-shadow: inset 0 0 0 2px #89888d, 0 2px 2px 0 rgba(0, 0, 0, 0.08);
		background: #ececef;
	}
	.gl-button.gl-button.btn-default-tertiary:hover {
		box-shadow: none;
	}
}

.btn svg {
	height: 15px;
	width: 15px;
}

@media all {
	.btn svg {
		height: 15px;
		width: 15px;
	}
	.gl-alert-body {
		line-height: 1.25rem;
	}
	.gl-alert-actions {
		display: flex;
		margin-top: 1rem;
	}
}

strong {
	font-weight: bold;
}

@media all {
	strong {
		font-weight: bold;
	}
	.gl-max-w-50p {
		max-width: 50%;
	}
	.gl-display-inline-flex {
		display: inline-flex;
	}
}

a {
	color: #1f75cb;
	text-decoration: none;
	background-color: transparent;
}

@media all {
	a {
		color: #1f75cb;
		text-decoration: none;
		background-color: transparent;
		transition: background-color 100ms linear, color 100ms linear, border
			100ms linear;
	}
	.gl-button.gl-button.btn-confirm {
		color: #fff;
		background-color: #1f75cb;
		box-shadow: inset 0 0 0 1px #1068bf;
	}
	a:hover {
		color: #1f75cb;
		text-decoration: underline;
	}
	.gl-button.gl-button.btn-confirm:hover {
		box-shadow: inset 0 0 0 2px #064787, 0 2px 2px 0 rgba(0, 0, 0, 0.08);
		background: #1068bf;
	}
	.ref-name {
		font-family: var(- -default-mono-font, "Menlo"), "DejaVu Sans Mono",
			"Liberation Mono", "Consolas", "Ubuntu Mono", "Courier New",
			"andale mono", "lucida console", monospace;
		font-size: 95%;
	}
	.gl-text-truncate {
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
	}
}

.gl-button.gl-button .gl-button-text {
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	padding-top: 1px;
	padding-bottom: 1px;
	margin-top: -1px;
	margin-bottom: -1px;
}

@media all {
	.gl-button.gl-button .gl-button-text {
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
		padding-top: 1px;
		padding-bottom: 1px;
		margin-top: -1px;
		margin-bottom: -1px;
	}
}
</style>
								 -->
						<%-- <c:if test="${success}">
								<div class="gl-alert gl-mt-3 gl-alert-success snipcss-95cPx" role="alert">
							  <svg class="s16 gl-alert-icon gl-alert-icon-no-title" data-testid="check-circle-icon">
							    <use href="/assets/icons-59091572538c51f8183af996ae9cb69453ff0aa62491196dd071f1e34505509f.svg#check-circle">
							    </use>
							  </svg>
							  <button aria-label="Dismiss" class="btn gl-dismiss-btn btn-default btn-sm gl-button btn-default-tertiary btn-icon js-close js-close-banner" type="button">
							    <svg class="s16" data-testid="close-icon">
							      <use href="/assets/icons-59091572538c51f8183af996ae9cb69453ff0aa62491196dd071f1e34505509f.svg#close">
							      </use>
							    </svg>
							  </button>
							  <div class="gl-alert-content" role="alert">
							    <div class="gl-alert-body">
							      <span>
							        You pushed to
							      </span>
							      <strong class="gl-display-inline-flex gl-max-w-50p" data-toggle="tooltip" title="webrefont">
							        <a class="ref-name gl-text-truncate" href="/insoft-sas/sakina/-/commits/webrefont">
							          webrefont
							        </a>
							      </strong>
							      <time class="js-timeago" title="Mar 8, 2023 1:41pm UTC" datetime="2023-03-08T13:41:16Z" data-toggle="tooltip" data-placement="top" data-container="body">
							        2 minutes ago
							      </time>
							    </div>
							  </div>
							</div>

							</c:if> --%>

							<c:forEach var="registration" items="${listRegistration}">
								<div class="single-item-list">
									<div class="row align-items-center">
										<div class="col-lg-4 col-md-4 col-12">
											<p>
												<c:out value="${registration.detail}" />
											</p>
										</div>
										<div class="col-lg-2 col-md-4 col-12">
											<p>
												<c:out value="${registration.student}" />
											</p>
										</div>
										<div class="col-lg-2 col-md-4 col-12">
											<p>
												<c:out value="${registration.course}" />
											</p>
										</div>
										<div class="col-lg-2 col-md-4 col-12">
											<p>
												<c:out value="${registration.year}" />
											</p>
										</div>
										<div class="col-lg-2 col-md-4 col-12 align-right">
											<ul class="action-btn">
												<li><a
													href="registrations/edit?id=<c:out value='${registration.id}' />">
														<i class="lni lni-pencil"> </i>
												</a></li>
												<li><a href="#"> <i class="lni lni-eye"> </i>
												</a></li>
												<li><a href="#" onClick="if(!confirm('Etes vous surs?')) return false; document.getElementById('form-delete').submit()">
														<i class="lni lni-trash"> </i>
													<form id="form-delete" method="post" action="registrations/delete" class="d-inline d-none">
														<input type="hidden" name="id" value="<c:out value='${registration.id}'/>">
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