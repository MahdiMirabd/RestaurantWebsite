/**
 * Redirects to the menu editing page.
 */
function editMenu() {
    window.location="editMenu";
}

/**
 * Shows and hides the content of the notification dropdown.
 */
function showNotifications() {
    document.getElementById("myDropdown").classList.toggle("show");
}

/**
 * Displays the content of the notification dropdown list.
 * @param event when the user clicks on the notification button.
 */
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

/**
 * Hides the notification badge when its value is 0.
 */
$(document).ready(function() {
    if($('#dropdown span').text() == 0) {
        document.getElementById("badge").style.display= 'none';
    }
});

/**
 * Hides the shopping cart on the page.
 */
$(document).ready(function() {
    $("#shop-cart").hide();
  });
