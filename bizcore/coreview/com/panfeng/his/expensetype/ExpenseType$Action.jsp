
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty expenseType}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ExpenseType" style="color: green">${userContext.localeMap['expense_type']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['expense_type.id']}</span> ${expenseType.id}</li>
<li><span>${userContext.localeMap['expense_type.name']}</span> ${expenseType.name}</li>
<li><span>${userContext.localeMap['expense_type.helper_chars']}</span> ${expenseType.helperChars}</li>
<li><span>${userContext.localeMap['expense_type.status']}</span> ${expenseType.status}</li>
<li><span>${userContext.localeMap['expense_type.description']}</span> ${expenseType.description}</li>

	
	</ul>
</div>



</c:if>


