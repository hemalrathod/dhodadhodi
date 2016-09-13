<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="Header.jsp"></jsp:include>
<form:form modelAttribute="ACTOR" class="form-horizontal" method="post" action="${pageContext.request.contextPath }/Actor/Update">
	<div class="form-group">
		<label for="inputActorid" class="col-sm-2 control-label">Actor Id</label>
		<div class="col-sm-10">
			<form:input path="actorId" type="text" class="form-control" id="inputActorid" 
				placeholder="Actor Id" />
		</div>
	</div>
	<div class="form-group">
		<label for="inputFirstname" class="col-sm-2 control-label">Actor Firstname</label>
		<div class="col-sm-10">
			<form:input path="firstName" autofocus="autofocus" type="text" class="form-control" id="inputFirstname" 
				placeholder="Enter firstname" />
		</div>
	</div>
	<div class="form-group">
		<label for="inputLastname" class="col-sm-2 control-label">Actor Lastname</label>
		<div class="col-sm-10">
			<form:input path="lastName" type="text" class="form-control" id="inputLastname" 
				placeholder="Enter lastname" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Update</button>
		</div>
	</div>
</form:form>
<jsp:include page="Footer.jsp"></jsp:include>