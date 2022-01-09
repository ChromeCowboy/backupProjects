let url = "http://localhost:8000/employee/name/Ben%20Employee";

console.log("javascript is working");

// find employee reimbursements by name
async function getFindReimburseByName() {
  let response_body = await fetch(url);
  let data = await response_body.json();
  console.log(data);
}

window.onload = (event) => {
  console.log("window onload working");
  getFindReimburseByName();
};
