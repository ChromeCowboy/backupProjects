// ==============================================
// ==============================================
// GET ALL Reimbursements for employee
// ==============================================
// ==============================================
let reimburseCards = document.querySelector(".reimburseCards");
let displayCard;
let inited = false;

let findAllReimburse =
  "http://localhost:8000/employee/findAll/" + document.title;

let getAllReimbursements = document.getElementById("getAllReimbursements");
let showFormButton = document.getElementById("showForm");

let showForm = document.getElementById("hide");

const getAll = async (employeeURL) => {
  const getAllReim = async (employeeURL) => {
    let response_body = await fetch(employeeURL);
    let data = await response_body.json();
    return data;
  };

  let allReimburse = await getAllReim(employeeURL);

  function displayAll(allReimburse) {
    displayCard = allReimburse.map(function (item) {
      return `<div class="card">
        <h2>Reimbursements</h2>
        <p class="cardText reimbursed_invoice_num">Invoice: ${item.reimbursed_invoice_num}</p>
        <p class="cardText reimbursed_employee">Employee: ${item.reimbursed_employee}</p>
        <p class="cardText reimbursed_past_pending">Status: ${item.reimbursed_past_pending}</p>
        <p class="cardText reimbursed_approval">Approval: ${item.reimbursed_approval}</p>
        <p class="cardText reimbursed_amount">Amount: $${item.reimbursed_amount}</p>  
        <p class="cardText reimbursed_reason">Reason: ${item.reimbursed_reason}</p>
        <p class="cardText reimbursed_manager_reason">Manager Reason: ${item.reimbursed_manager_reason}</p>
        </div>`;
    });

    displayCard = displayCard.join("");
    return displayCard;
  }

  displayAll(allReimburse);
  inited = true;
};

function display() {
  if (inited) {
    reimburseCards.innerHTML = displayCard;
  } else {
    setTimeout(display, 250);
  }
}

getAllReimbursements.addEventListener("click", () => {
  getAll(findAllReimburse);
  display();
});

// ==================================================
// Submit Reimbursement
// ==================================================
let submissionButton = document.getElementById("reimbursement-submission");
let submitReimbursementForm = document.getElementsByName("submissionForm")[0];

function showForms() {
  showForm.className = "show";
}

showFormButton.addEventListener("click", () => {
  showForms();
});

let submissionURL =
  "http://localhost:8000/employee/" + document.title + "_submit";

async function postData(submissionURL, employee_Submission) {
  const response = await fetch(submissionURL, {
    method: "POST",
    mode: "no-cors",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(employee_Submission),
  })
    .then((response) => {
      return response.json();
    })
    .catch((err) => console.log(err));
}

submissionButton.addEventListener("click", () => {
  let amountInput = document.getElementById("amount").value;
  let reasonInput = document.getElementById("reason").value;

  let employee_Submission = {
    reimbursed_invoice_num: 1,
    reimbursed_employee: document.title + " Employee",
    reimbursed_past_pending: "pending",
    reimbursed_approval: "not approved",
    reimbursed_amount: amountInput,
    reimbursed_reason: reasonInput,
    reimbursed_manager_reason: "awaiting reason",
  };

  postData(submissionURL, employee_Submission);

  showForm.className = "hide";
  submitReimbursementForm.reset();
});
