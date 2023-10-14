var sidebarOpen = false;
var sidebar = document.getElementById("sidebar");


function openSidebar() {
  if(!sidebarOpen) {
    sidebar.classList.add("sidebar-responsive");
    sidebarOpen = true;
  }
}

function closeSidebar() {
  if(sidebarOpen) {
    sidebar.classList.remove("sidebar-responsive");
    sidebarOpen = false;
  }
}

//change main content
function loadContent(page) {
  var contentPlaceholder = document.getElementById('main-content');

  // Create a new XMLHttpRequest object
  var xhr = new XMLHttpRequest();

  // Set up the request
  xhr.open('GET', page, true);

  // Set the response type
  xhr.responseType = 'text';

  // Send the request
  xhr.send();

  // Listen for the response
  xhr.onload = function() {
    if (xhr.status === 200) {
      // Success!
      contentPlaceholder.innerHTML = xhr.responseText;
    } else {
      // Error!
      console.log('Error loading content: ' + xhr.statusText);
    }
  };
}