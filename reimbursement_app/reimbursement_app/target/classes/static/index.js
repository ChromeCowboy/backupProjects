// Employee
let reimbursementsAlliURL = "http://localhost:8000/employee/findAll/Alli";
let reimbursementsBenURL = "http://localhost:8000/employee/findAll/Ben";
let reimbursementsSamURL = "http://localhost:8000/employee/findAll/Sam";

// Manager
let getPendingOrPastAlli_byID = "http://localhost:8000/manager/Alli/";
let getPendingOrPastBen_byID = "http://localhost:8000/manager/Ben/";
let getPendingOrPastSam_byID = "http://localhost:8000/manager/Sam/335";

let updateAlliApprovalURL = "http://localhost:8000/manager/AlliApproval";
let updateBenApprovalURL = "http://localhost:8000/manager/BenApproval";
let updateSamApprovalURL = "http://localhost:8000/manager/SamApproval";

console.log("javascript is working");

// ==============================================
// ==============================================
// LOGIN Employees/Manager
// ==============================================
// ==============================================

let getEmployeesLogin = "http://localhost:8000/employee/login";
let getManagerLogin = "http://localhost:8000/manager/login";

let welcome = document.querySelector(".welcome");

let loginForm = document.getElementsByName("loginForm")[0];

let loginButton = document.getElementById("login-submission");

const grabLogin = async (getEmployeesTableURL) => {
  const getEmployees = async (getEmployeesTableURL) => {
    let response_body = await fetch(getEmployeesTableURL);
    let loginData = await response_body.json();

    return loginData;
  };

  let employee_name = [];
  let employee_password = [];

  const loginData = await getEmployees(getEmployeesTableURL);
  console.log(loginData);

  let username = document.getElementById("username").value;
  let password = document.getElementById("password").value;

  console.log(username);

  employee_name;
  employee_password;

  for (let i = 0; i < loginData.length; i++) {
    name = loginData[i].employee_login_name;
    employee_name.push(name);
    pass = loginData[i].employee_login_password;
    employee_password.push(pass);
  }

  switch ((username, password)) {
    case (employee_name[0], employee_password[0]):
      setTimeout(() => {
        location.href = "employeeBen.html";
        sessionStorage.setItem("user", "Ben Employee");
      }, 2000);

      return (welcome.innerHTML = "Welcome " + employee_name[0]);

    case (employee_name[1], employee_password[1]):
      setTimeout(() => {
        location.href = "employeeAlli.html";
      }, 2000);

      return (welcome.innerHTML = "Welcome " + employee_name[1]);

    case (employee_name[2], employee_password[2]):
      setTimeout(() => {
        location.href = "employeeSam.html";
      }, 2000);

      return (welcome.innerHTML = "Welcome " + employee_name[2]);

    case (employee_name[3], employee_password[3]):
      setTimeout(() => {
        location.href = "manager.html";
      }, 2000);

      return (welcome.innerHTML = "Welcome " + employee_name[3]);

    default:
      return (welcome.innerHTML =
        "Sorry, username or password don't match. Please try again.");
      break;
  }
  return employeeName;
};

function getLogin() {
  grabLogin(getEmployeesLogin);
}

loginButton.addEventListener("click", () => {
  getLogin();
});

// ==============================================
// ==============================================
// GET ALL Reimbursements for employee
// ==============================================
// ==============================================

// let findAllReimburse =
//   "http://localhost:8000/employee/findAll/" + document.title;

// let getAllReimbursements = document.getElementById("getAllReimbursements");

// async function getAllReimbursementsFor(employeeURL) {
//   let response_body = await fetch(employeeURL);
//   let data = await response_body.json();
//   console.log(data);
// }

// function getReimbursements() {
//   getAllReimbursementsFor(findAllReimburse);
// }

// getAllReimbursements.addEventListener("click", () => {
//   getReimbursements();
//   console.log("click");
// });
// // ==============================================
// // ===============================================

// // GET Reimbursement by ID, and update

// // ==============================================
// // ==============================================
// let num = 335;
// let id_url = "http://localhost:8000/manager/Sam/" + num;

// let invoice = 0;
// let employee = "";
// let pastPend = "";
// let approval = "";
// let amount = 0;
// let reason = "";

// // function grabs JSON variables
// const grabsVariables = async (id_url) => {
//   const getReimbursementById = async (id_url) => {
//     let response_body = await fetch(id_url);
//     let idData = await response_body.json();

//     return idData;
//   };

//   const idData = await getReimbursementById(id_url);

//   invoice = idData.reimbursed_invoice_num;
//   employee = idData.reimbursed_employee;
//   pastPend = idData.reimbursed_past_pending;
//   approval = idData.reimbursed_approval;
//   amount = idData.reimbursed_amount;
//   reason = idData.reimbursed_reason;

//   return invoice, employee, pastPend, approval, amount, reason;
// };

// // ===============================================

// // Update Reimbursement's approval

// let updateReimbursement = {
//   reimbursed_invoice_num: invoice,
//   reimbursed_employee: employee,
//   reimbursed_past_pending: "pending",
//   reimbursed_approval: "not approved",
//   reimbursed_amount: amount,
//   reimbursed_reason: reason,
// };

// async function postData(approvalURL, updateReimbursement) {
//   const response = await fetch(approvalURL, {
//     method: "POST",
//     mode: "no-cors",
//     headers: {
//       Accept: "application/json",
//       "Content-Type": "application/json",
//     },
//     body: JSON.stringify(updateReimbursement),
//   })
//     .then((response) => {
//       return response.json();
//     })
//     .catch((err) => console.log(err));
// }

// ===============================================

// POST Reimbursement for employee

// async function postData(submissionURL, data) {
//   const response = await fetch(submissionURL, {
//     method: "POST",
//     mode: "no-cors",
//     headers: {
//       Accept: "application/json",
//       "Content-Type": "application/json",
//     },
//     body: JSON.stringify(data),
//   })
//     .then((response) => {
//       return response.json();
//     })
//     .catch((err) => console.log(err));
// }
// ===============================================

// Alli Reimbursements

// let alli_Submission = {
//   reimbursed_invoice_num: 1,
//   reimbursed_employee: "Alli",
//   reimbursed_past_pending: "pending",
//   reimbursed_approval: "not approved",
//   reimbursed_amount: 99999.99,
//   reimbursed_reason: "there's no reason yet",
// };

// // Ben Reimbursements

// let ben_Submission = {
//   reimbursed_invoice_num: 1,
//   reimbursed_employee: "Ben",
//   reimbursed_past_pending: "pending",
//   reimbursed_approval: "not approved",
//   reimbursed_amount: 9999.99,
//   reimbursed_reason: "there's no reason yet",
// };

// // Sam Reimbursements

// let sam_Submission = {
//   reimbursed_invoice_num: 1,
//   reimbursed_employee: "Sam",
//   reimbursed_past_pending: "pending",
//   reimbursed_approval: "not approved",
//   reimbursed_amount: 9999.99,
//   reimbursed_reason: "there's no reason yet",
// };

// ================================================

// Window Load

// window.onload = (event) => {
// console.log("window onload working");
// grabLogin(getEmployeesTableURL);
// getAllReimbursementsFor(reimbursementsAlliURL);
// getAllReimbursementsFor(reimbursementsBenURL);
// getAllReimbursementsFor(reimbursementsSamURL);
// postData("http://localhost:8000/employee/Alli_submit", alli_Submission);
// postData("http://localhost:8000/employee/Ben_submit", ben_Submission);
// postData("http://localhost:8000/employee/Sam_submit", sam_Submission);
// };
