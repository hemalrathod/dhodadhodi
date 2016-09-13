<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../Actor/Header.jsp"></jsp:include>
<form method="POST" action="${pageContext.request.contextPath }/File/Upload" enctype="multipart/form-data">
	<div class="form-group">
		<label class="control-label col-sm-4">File</label>
		<div class="col-sm-8">
			<input type=file name=file class=form-control />
		</div>
	</div>
	
	<div class="form-group">
		
		<div class="col-sm-12 col-sm-offset-5">
		<input type=submit value=Save class="btn btn-primary" />
		</div>
	</div>
</form>
<jsp:include page="../Actor/Footer.jsp"></jsp:include>