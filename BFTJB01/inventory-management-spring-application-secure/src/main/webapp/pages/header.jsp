<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<header>
	<h1>Inventory Management Portal</h1>
	<hr />

	<nav>
		<a href="${pageContext.request.contextPath}/home">Home</a> <span>|</span>

		<c:choose>
			<c:when test="${unm!=null && role=='ADMIN'}">
				<a href="${pageContext.request.contextPath}/admin/list">Items
					List</a>
				<span>|</span>
				<a href="${pageContext.request.contextPath}/admin/newItem">Add
					New</a>
				<span>|</span>
				<a href="${pageContext.request.contextPath}/logout">Log Out</a>	
			</c:when>
			<c:when test="${unm!=null && role=='USER'}">
				<a href="${pageContext.request.contextPath}/user/list">Items
					List</a>
				<span>|</span>
				<a href="${pageContext.request.contextPath}/logout">Log Out</a>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/login">Log In</a>
				<span>|</span>
				<a href="${pageContext.request.contextPath}/register">New User</a>
			</c:otherwise>
		</c:choose>


	</nav>
	<hr />
</header>