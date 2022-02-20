// Function to check password the already set password is admin
function checkPass() {
    const confirmWaiterPassword = "admin";
    const confirmKitchenPassword = "pass";
    const confirmWaiter = "waiter";
    const confirmKitchen = "kitchen";

    let password = document.getElementById("pass").value;
    let usernameOptions = document.querySelectorAll("input[name='myUsername']");
    username = $("input[type='radio'][name='myUsername']:checked").val();

    if (password == confirmWaiterPassword && username == confirmWaiter){
        window.location="waiter";
    }
    else if (password == confirmKitchenPassword && username == confirmKitchen){
        window.location="kitchen";
    }
    else{
        alert("Passwords do not match.");
        window.location="";
    }
}

$(document).ready(function(){
    $('#department').on('change', function(){
    	var demovalue = $(this).val(); 
        $("div.myDefaultDiv").hide();
        $("div.myDiv").hide();
        $("#show"+demovalue).show();
    });
});