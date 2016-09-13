<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp"></jsp:include>
	<table class="table table-bordered table-hover table-striped">
		<thead class="FONTBOLD">
		<tr>
		<td>ID</td>
		<td>FIRSTNAME</td>
		<td>LASTNAME</td>
		<td>UPDATED ON</td>
		<td>COMMANDS</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${ACTORS}" var="ACTOR">
			<tr>
				<td>${ACTOR.actorId }</td>
				<td style="vertical-align:middle;cursor:pointer"><span class="label label-primary"  data-animation=true data-html=true data-toggle="popover" title="<span class='label label-success'>${ACTOR.firstName} ${ACTOR.lastName}</span>" data-content="A very fine actor <strong>${ACTOR.firstName} ${ACTOR.lastName}</strong> with ID <i>${ACTOR.actorId}</i> being updated on <span class='btn btn-danger btn-sm'>${ACTOR.lastUpdate}</span>">${ACTOR.firstName }</span></td>
				<td style="vertical-align:middle"><span class="label label-info">${ACTOR.lastName }</span></td>
				<td>${ACTOR.lastUpdate }</td>
				<td align=center>
					<a href="<c:url value='Actor/Edit/${ACTOR.actorId }' />" class="btn btn-primary btn-sm">EDIT</a>
					<a href="#" class="btn btn-danger btn-sm">DELETE</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
<jsp:include page="Footer.jsp"></jsp:include>