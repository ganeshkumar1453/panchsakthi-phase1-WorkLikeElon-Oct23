const dataToStoreStart = { sharedTimerVariable: true };
const dataToStoreStop = { sharedTimerVariable: false };

document.getElementById("startTimer").addEventListener("click", function () {
  const timerDuration = parseFloat(document.getElementById("timerDuration").value);
  if (!isNaN(timerDuration) && timerDuration > 0) {
    chrome.alarms.create({ delayInMinutes: timerDuration });
    document.getElementById("status").innerText = "Timer started!";
    timerStatus = "Timer started!...";
    // Store the data using chrome.storage.local
    chrome.storage.local.set(dataToStoreStart, function () {
      console.log("Data stored successfully.");
    });
  } else {
    document.getElementById("status").innerText = "Please enter a valid duration.";
  }
});

document.getElementById("stopTimer").addEventListener("click", function () {

  // Store the data using chrome.storage.local
  chrome.storage.local.set(dataToStoreStop, function () {
    console.log("Data stored successfully.");
  });

});

window.onload = function() {
  // Set the initial window size (width and height)
  window.resizeTo(800, 1600); // Set the desired width and height
}

