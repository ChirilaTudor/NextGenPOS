<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<t:pageTemplate pageTitle="Return">



    <div class=" min-vw-100 min-vh-100 container-fluid login-overflow ">
        <div class="container-fluid py-5 h-100 ">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div>
                        <div class="text-center">

                            <div class="pb-5">
                                <p class="lead fw-normal mb-1 fs-1">Item return</p>
                                <p class="mb-5">Please enter the ID of the item sale and the quantity</p>

                                <form  class="form-signin" method="POST" action="${pageContext.request.contextPath}/Return">
                                    <div class="form-outline form-white mb-4">
                                        <label for="itemSale_id" class="sr-only">ID of item sale</label>
                                        <input type="text" id="itemSale_id" class="form-control form-control-lg cashier-item-box" placeholder="ID of item sale" required/>
                                    </div>

                                    <div class="form-outline form-white mb-4">
                                        <label for="quantity" class="sr-only ">Quantity</label>
                                        <input type="text" id="quantity" class="form-control form-control-lg cashier-item-box" placeholder="Quantity" required/>
                                    </div>
                                    <button class="btn btn-outline-primary btn-lg px-5 mt-4" type="submit">Submit</button>

                                </form>


                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>