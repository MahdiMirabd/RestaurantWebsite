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