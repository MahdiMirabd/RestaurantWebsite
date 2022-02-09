<!--Function to check password the already set password is admin-->
function checkPass() {
    const confirmWaiterPassword = "admin";
    const confirmKitchenPassword = "pass";
    const confirmWaiter = "waiter";
    const confirmKitchen = "kitchen";

    let password = document.getElementById("pass").value;
    let department = document.getElementById("department").value;

    if (password == confirmWaiterPassword && department == confirmWaiter){
        window.location="waiter";
    }
    else if (password == confirmKitchenPassword && department == confirmKitchen){
        window.location="kitchen";
    }
    else{
        alert("Passwords do not match.");
    }
}