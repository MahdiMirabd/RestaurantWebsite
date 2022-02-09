<!--Function to check password the already set password is admin-->
function checkPass() {
    const confirmPassword = "admin";
    const confirmWaiter = "waiter";

    let password = document.getElementById("pass").value;
    let department = document.getElementById("department").value;

    if (password == confirmPassword && department == confirmWaiter){
        window.location="waiter";
    }
    else{
        alert("Passwords do not match.");
    }
}