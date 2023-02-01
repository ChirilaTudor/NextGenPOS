<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Notifications">

  <div class="container">

    <c:forEach var="notificaiton" items="${notifications}" varStatus="loop">
    <div class="accordion " id="accordionFlushExample">
      <div class="accordion-item mb-2 ">
        <h2 class="accordion-header  " id="flush-heading${loop.index.toString()} ">
          <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse${loop.index.toString()}" aria-expanded="false" aria-controls="flush-collapse${loop.index.toString()}">
              ${loop.index.toString()}: New notification from ${notificaiton.admin.username.toString()} in ${notificaiton.date.toString()}
          </button>
        </h2>
        <div id="flush-collapse${loop.index.toString()}" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
          <div class="accordion-body">
            <div class="row">
              <div class="col mb-5">
                  ${notificaiton.content}
                  ${notificaiton.link}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    </c:forEach>

</t:pageTemplate>