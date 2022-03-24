window.onload = function() { //upon loading, open the form for entering a table number
    openForm()
  };
setInterval(setTime, 1000);
function openForm() {
  document.getElementById("myForm").style.display = "block";
}
