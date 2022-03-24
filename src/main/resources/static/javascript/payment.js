/**
 * Disables the submit button if the table number input field is null.
 */
function check() {
    if(document.getElementById("table-number").value===""){
        document.getElementById('submit-btn').disabled = true;
    } else {
        document.getElementById('submit-btn').disabled = false;
    }
}

/**
 * Disables the payment button if the selected input fields
 * have not been populated.
 */
function validate() {
    if(document.getElementById("name").value==="" ||
        document.getElementById("cardnumber").value==="" ||
        document.getElementById("securitycode").value==="" ||
        document.getElementById("table-num").value <= 0 ) {
        document.getElementById('submit').disabled = true;
    } else {
        document.getElementById('submit').disabled = false;
    }
}