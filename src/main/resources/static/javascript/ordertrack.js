window.onload = function() {
    openForm()
    setTime()
  };
var minutesLabel = document.getElementById("minutes");
var secondsLabel = document.getElementById("seconds");
var totalSeconds = 0;
setInterval(setTime, 1000);
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
  function setTime() {
    ++totalSeconds;
    secondsLabel.innerHTML = pad(totalSeconds % 60);
    minutesLabel.innerHTML = pad(parseInt(totalSeconds / 60));
    if(totalSeconds==300){
      document.getElementById("minutes").style.color = 'red';
      document.getElementById("seconds").style.color = 'red';
    }
  }
  var sec = 0;
  function pad ( val ) { return val > 9 ? val : "0" + val; }
  setInterval( function(){
      $("#seconds").html(pad(++sec%60));
      $("#minutes").html(pad(parseInt(sec/60,10)));
  }, 1000);