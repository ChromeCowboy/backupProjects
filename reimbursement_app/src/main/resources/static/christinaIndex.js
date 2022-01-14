let button = document.getElementById("data-submission");

function sendCredentials() {
  let xhr = new XMLHttpRequest();
  let url = "http://localhost:9000/user/credentials";
  xhr.open("POST", url);

  let username = document.getElementById("username").value;
  let password = document.getElementById("password").value;

  let user = {
    name: username,
    password: password,
  };

  let json_string = JSON.stringify(user);

  xhr.send(json_string);
}

sendCredentials();

button.addEventListener("click", sendCredentials());
