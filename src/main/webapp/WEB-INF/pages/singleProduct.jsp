<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Product">

    <div class=" container-fluid my-5  w-80">
    <div class="row mx-5 d-flex justify-content-center">

    </div>
          <div class="row mx-5 my-5 ">
              <div class="col image mx-5 my-5 d-flex justify-content-center">
                  <img src="${pageContext.request.contextPath}/ProductPhotos?id=${single_product.idProduct}" width="300" height="500"/>
              </div>

            <div class="col col-1 " style="width:0">
              <div class="vr" style="height: 100%; width: 3px"></div>
            </div>

            <div class="col">
                <div class="row">
                      <div class="col mx-5">
                              <div class="row row-0 ">
                                  <p class=" fs-1 fw-bold no-gutters" >${single_product.productName}</p>
                              </div>
                              <div class="hr px-5" style="height: 3px; width: 10px; background-color: black"></div>
                              <div class="row pt-5">
                                  <p class="fw-bold fs-5">Pret: ${single_product.price} lei</p>
                              </div>
                              <div class="row">
                                  <h4>Furnizor: ${single_product.provider}</h4>
                              </div>
                              <div class="row mt-4">
                                  <p>Descriere: ${single_product.description}</p>
                              </div>
                      </div>
                </div>
          </div>
      </div>

    </div>
</t:pageTemplate>


