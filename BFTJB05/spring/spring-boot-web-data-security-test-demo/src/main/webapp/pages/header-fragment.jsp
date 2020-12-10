<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="/home">LMP 
  	<c:if test="${auth.isAuthenticated() }">
  		${auth.name }
  	</c:if>
  </a>
  
  <ul class="navbar-nav">
    <li class="nav-item ">
      <a class="nav-link" href="/home">Home</a>
    </li>    
    
    <c:choose>
    	<c:when test="${auth.isAuthenticated() }">
		    <li class="nav-item ">
		      <a class="nav-link" href="/genres">Genres</a>
		    </li>    
		    <li class="nav-item ">
		      <a class="nav-link" href="/books">Books</a>
		    </li>
		    <li class="nav-item ">
		      <a class="nav-link" href="/books/new">New Book</a>
		    </li>
		    <li class="nav-item ">
		      <a class="nav-link" href="/logout">Log Out</a>
		    </li>	
    	</c:when>
    	<c:otherwise>
    	    <li class="nav-item ">
		      <a class="nav-link" href="/login">Sign In</a>
		    </li>
		    <li class="nav-item ">
		      <a class="nav-link" href="/register">New Member?</a>
		    </li>
    	</c:otherwise>
    </c:choose>    
        
  </ul>
</nav>