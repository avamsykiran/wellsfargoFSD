<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="/home">ADB</a>
  <ul class="navbar-nav">
    <li class="nav-item ">
      <a class="nav-link" href="/home">Home</a>
    </li>
    <c:choose>
    	<c:when test="${userName != null }">
		    <li class="nav-item ">
		      <a class="nav-link" href="/groups">Groups</a>
		    </li>    
		    <li class="nav-item ">
		      <a class="nav-link" href="/contacts">Contacts</a>
		    </li>
		    <c:if test="${role=='EMPLOYEE' }">
		    	<li class="nav-item ">
      				<a class="nav-link" href="/contacts/new">New Contacts</a>
    			</li>    
		    </c:if>    
		    <li class="nav-item ">		     		
		      <a class="nav-link" href="/logout"> <span>${userName }</span> Sign Out</a>
		    </li>		
    	</c:when>
    	<c:otherwise>
    		<li class="nav-item ">
      			<a class="nav-link" href="/login">Sign In </a>
    		</li>    
    		<li class="nav-item ">
      			<a class="nav-link" href="/register">Sign Up</a>
    		</li>    
    	</c:otherwise>
    </c:choose>
    
  </ul>
</nav>