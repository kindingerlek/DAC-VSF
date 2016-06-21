
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="alerts">
    <c:forEach items="${messages}" var="message">
        <div class="alert alert-${message.type} alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <strong>${message.title}</strong> ${message.text}
        </div>
    </c:forEach>
    <c:remove var="messages" />
</div>