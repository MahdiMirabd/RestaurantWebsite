/*body.onload = function() {
    $("#name").prop("disabled",true);
    $("#cardnumber").prop("disabled",true);
    $("#month").prop("disabled",true);
    $("#year").prop("disabled",true);
    $("#securitycode").prop("disabled",true);
    $("#total").hide();
}*/

function showForm(){
    let total = [[${total}]];
    let table = [[${table}]];
    document.getElementById("payment").innerHTML = `
            <h3 id="total" th=:inline="text">Total Price: ${total}</h3>
            <label>Accepted Cards</label>
            <div class="icon-container">
                <i class="fa fa-cc-visa" style="color:navy;"></i>
                <i class="fa fa-cc-amex" style="color:blue;"></i>
                <i class="fa fa-cc-mastercard" style="color:red;"></i>
                <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>

            <form action="#" th:action="@{payment/complete}" method="PUT">
                <input type="hidden" th:value="${table}" name="id"/>
                <div class="row">
                    <div class="col-50">
                        <label for="name">Name</label>
                        <input id="name" maxlength="20" type="text">
                    </div>
                </div>
                <div class="row">
                    <div class="col-50">
                        <label for="cardnumber">Card Number</label>
                        <input id="cardnumber" type="text" pattern="[0-9]*" inputmode="numeric">
                    </div>
                </div>

                <div class="row">
                    <div class="col-50">
                        <!--<label for="expirationdate">Expiration (mm/yy)</label>
                        <input id="expirationdate" type="text" pattern="[0-9]*" inputmode="numeric"> -->
                        <div class="form-group" id="expiration-date">
                            <label>Expiration Date</label>
                            <select id="month">
                                <option value="01">01</option>
                                <option value="02">02</option>
                                <option value="03">03</option>
                                <option value="04">04</option>
                                <option value="05">05</option>
                                <option value="06">06</option>
                                <option value="07">07</option>
                                <option value="08">08</option>
                                <option value="09">09</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>
                            <select id="year">
                                <option value="22"> 2022</option>
                                <option value="23"> 2023</option>
                                <option value="24"> 2024</option>
                                <option value="24"> 2025</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-50">
                        <label for="securitycode">Security Code</label>
                        <input id="securitycode" type="text" pattern="[0-9]*" inputmode="numeric">
                    </div>
                </div>

                <input type="submit" class="table-btn" value="pay"/>
            </form>`;
    /*$("#name").prop("disabled",false);
    $("#cardnumber").prop("disabled",false);
    $("#month").prop("disabled",false);
    $("#year").prop("disabled",false);
    $("#securitycode").prop("disabled",false);
    $("#total").show();*/
}