//Checks if a checkbox has changed since loading the page
$(document).ready(function() {
    /*$('.menu-group span').each(function() {
        //span.after('<span>' + span.text() + '</span>')
        if($('#menu-item span').text()== false) {
            document.getElementById("available").style.display= 'none';
        } else  {
            document.getElementById("unavailable").style.display= 'none';
        }
    });*/
});

function checkboxChanged(event) {
    let input = event.target;
    console.log("changed.")
}