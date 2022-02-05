<!--Function to check password the already set password is admin-->
function checkPass() {
    const confirmPassword = "admin";
    let password = document.getElementById("pass").value;
    if (password == confirmPassword) {
        window.location="waiter";
    }
    else{
        alert("Passwords do not match.");
    }
}