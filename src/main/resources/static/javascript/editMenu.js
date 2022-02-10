//Checks if a checkbox has changed since loading the page
$().ready(function() {
    let checkbox = document.getElementsByClassName('available');
    for (let i = 0; i < checkbox.length; i++) {
        let input = checkbox[i];
        input.addEventListener('change', checkboxChanged)
    }
});

function checkboxChanged(event) {
    let input = event.target;
    console.log("changed.")

}