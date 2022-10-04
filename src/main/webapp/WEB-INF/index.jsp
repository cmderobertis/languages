<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Tacos</title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
  <script src="/webjars/jquery/jquery.min.js"></script>
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1 class="text-center">Check out these languages!</h1>
<div class="row justify-content-center">
  <div class="col-auto">
    <div class="card">
      <div class="card-body">
        <table class="table table-hover table-striped">
          <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Actions</th>
          </tr>
          <c:forEach var="language" items="${languages}">
            <tr>
              <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
              <td><c:out value="${language.creator}"/></td>
              <td><c:out value="${language.version}"/></td>
              <td>
                <a href="/languages/${language.id}/edit">Edit</a>
                <form action="/languages/${language.id}" method="post">
                  <input type="hidden" name="_method" value="delete">
                  <input type="submit" value="Delete" class="btn btn-danger">
                </form>
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </div>
</div>
<div class="row justify-content-center">
  <div class="col-auto">
    <div class="card">
      <div class="card-body">
        <%--@elvariable id="language" type=""--%>
        <form:form action="/languages" method="post" modelAttribute="language">
          <p class="form-control d-flex flex-column">
            <form:label path="name">Name</form:label>
            <form:errors path="name" cssClass="text-danger"/>
            <form:input path="name"/>
          </p>
          <p class="form-control d-flex flex-column">
            <form:label path="creator">Creator</form:label>
            <form:errors path="creator" cssClass="text-danger"/>
            <form:input path="creator"/>
          </p>
          <p class="form-control d-flex flex-column">
            <form:label path="version">Version</form:label>
            <form:errors path="version" cssClass="text-danger"/>
            <form:input path="version"/>
          </p>
          <input class="mt-3 btn btn-primary" type="submit" value="Submit">
        </form:form>
      </div>
    </div>
  </div>
</div>
</body>
</html>

