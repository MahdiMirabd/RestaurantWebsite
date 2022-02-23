function editMenu() {
    window.location="editMenu";
}

function showNotifications() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function showWaiters() {
    document.getElementById("myWaiters").classList.toggle("show");
}

function showDelivered() {
    document.getElementById("myDelivered").classList.toggle("show");
}

window.onclick = function(event) {
    if (!event.target.matches('.dropbtn')) {
        let dropdowns = document.getElementsByClassName("dropdown-content");
        let i;
        for (i = 0; i < dropdowns.length; i++) {
            let openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}
