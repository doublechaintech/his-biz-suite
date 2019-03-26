
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty expenseItem}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ExpenseItem" style="color: green">${userContext.localeMap['expense_item']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['expense_item.id']}</span> ${expenseItem.id}</li>
<li><span>${userContext.localeMap['expense_item.name']}</span> ${expenseItem.name}</li>
<li><span>${userContext.localeMap['expense_item.price']}</span> <fmt:formatNumber type="currency"  value="${expenseItem.price}" /></li>
<li><span>${userContext.localeMap['expense_item.update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${expenseItem.updateTime}" /></li>

	
	</ul>
</div>



</c:if>


