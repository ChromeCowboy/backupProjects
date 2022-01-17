// ==============================================
// ==============================================
// GET ALL Reimbursements for Employees
// ==============================================
// ==============================================

let reimburseCards = document.querySelector(".reimburseCards");
let displayCard;
let displayBen;
let displayAlli;
let displaySam;
let inited = false;

let switcher = false;

let index = 0;
let topAmount = 0;
let meanTotal = 0;

let findAllReimburse_Ben = "http://localhost:8000/employee/findAll/Ben";
let findAllReimburse_Alli = "http://localhost:8000/employee/findAll/Alli";
let findAllReimburse_Sam = "http://localhost:8000/employee/findAll/Sam";

let getAllUserReimbursement = document.getElementById(
  "getAllUserReimbursement"
);

let stats = document.getElementById("stats");

let getAllReimbursements_Ben = document.getElementById(
  "getAllReimbursements_Ben"
);
let getAllReimbursements_Alli = document.getElementById(
  "getAllReimbursements_Alli"
);
let getAllReimbursements_Sam = document.getElementById(
  "getAllReimbursements_Sam"
);

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
    inited = false;
  } else {
    setTimeout(display, 250);
  }
}

const getEveryoneReim = async (
  findAllReimburse_Ben,
  findAllReimburse_Alli,
  findAllReimburse_Sam
) => {
  const getAllBen = async (findAllReimburse_Ben) => {
    let response_body = await fetch(findAllReimburse_Ben);
    let dataBen = await response_body.json();
    return dataBen;
  };
  const getAllAlli = async (findAllReimburse_Alli) => {
    let response_body = await fetch(findAllReimburse_Alli);
    let dataAlli = await response_body.json();
    return dataAlli;
  };
  const getAllSam = async (findAllReimburse_Sam) => {
    let response_body = await fetch(findAllReimburse_Sam);
    let dataSam = await response_body.json();
    return dataSam;
  };

  let dataBen = await getAllBen(findAllReimburse_Ben);
  let dataAlli = await getAllAlli(findAllReimburse_Alli);
  let dataSam = await getAllSam(findAllReimburse_Sam);

  function displayBen(dataBen) {
    displayBen = dataBen.map(function (item) {
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
    displayBen = displayBen.join("");
    return displayBen;
  }
  function displayAlli(dataAlli) {
    displayAlli = dataAlli.map(function (item) {
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
    displayAlli = displayAlli.join("");
    return displayAlli;
  }
  function displaySam(dataSam) {
    displaySam = dataSam.map(function (item) {
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
    displaySam = displaySam.join("");
    return displaySam;
  }

  displayBen(dataBen);
  displayAlli(dataAlli);
  displaySam(dataSam);

  reimburseCards.innerHTML = displayBen + displayAlli + displaySam;
};

getAllUserReimbursement.addEventListener("click", () => {
  getEveryoneReim(
    findAllReimburse_Ben,
    findAllReimburse_Alli,
    findAllReimburse_Sam
  );
});
getAllReimbursements_Ben.addEventListener("click", () => {
  getAll(findAllReimburse_Ben);
  display();
});
getAllReimbursements_Alli.addEventListener("click", () => {
  getAll(findAllReimburse_Alli);
  display();
});
getAllReimbursements_Sam.addEventListener("click", () => {
  getAll(findAllReimburse_Sam);
  display();
});

//=================================================
//=================================================
// STATS
// ================================================
// ================================================

let topExpense = [];
let expenseName = [];
let completeExpense = [];

let benCount = [];
let alliCount = [];
let samCount = [];

const statistics = async (
  findAllReimburse_Ben,
  findAllReimburse_Alli,
  findAllReimburse_Sam
) => {
  const getAllBen = async (findAllReimburse_Ben) => {
    let response_body = await fetch(findAllReimburse_Ben);
    let dataBen = await response_body.json();
    return dataBen;
  };
  const getAllAlli = async (findAllReimburse_Alli) => {
    let response_body = await fetch(findAllReimburse_Alli);
    let dataAlli = await response_body.json();
    return dataAlli;
  };
  const getAllSam = async (findAllReimburse_Sam) => {
    let response_body = await fetch(findAllReimburse_Sam);
    let dataSam = await response_body.json();
    return dataSam;
  };

  let dataBen = await getAllBen(findAllReimburse_Ben);
  let dataAlli = await getAllAlli(findAllReimburse_Alli);
  let dataSam = await getAllSam(findAllReimburse_Sam);

  function displayBen(dataBen) {
    displayBen = dataBen.map(function (item) {
      topExpense.push(item.reimbursed_amount);
      expenseName.push(item.reimbursed_employee);
      completeExpense.push(item.reimbursed_past_pending);

      benCount.push(item.reimbursed_employee);
      return ``;
    });
    displayBen = displayBen.join("");
    return displayBen;
  }
  function displayAlli(dataAlli) {
    displayAlli = dataAlli.map(function (item) {
      topExpense.push(item.reimbursed_amount);
      expenseName.push(item.reimbursed_employee);
      completeExpense.push(item.reimbursed_past_pending);
      alliCount.push(item.reimbursed_employee);

      return ``;
    });
    displayAlli = displayAlli.join("");
    return displayAlli;
  }
  function displaySam(dataSam) {
    displaySam = dataSam.map(function (item) {
      topExpense.push(item.reimbursed_amount);
      expenseName.push(item.reimbursed_employee);
      completeExpense.push(item.reimbursed_past_pending);
      samCount.push(item.reimbursed_employee);

      return ``;
    });
    displaySam = displaySam.join("");
    return displaySam;
  }

  displayBen(dataBen);
  displayAlli(dataAlli);
  displaySam(dataSam);

  reimburseCards.innerHTML = displayBen + displayAlli + displaySam;
  switcher = true;
};

let noPending = [];

function checkStats() {
  if (switcher) {
    // = =========
    //  top spender and amount.
    // ===========

    grabTopSpender();

    // ===========
    // avg spent
    // ===========
    grabMeanSpent(topExpense);

    // ==========
    // amount of reimbursements per employee
    // =========

    // amountReimbursePerEmployee();

    reimburseCards.innerHTML = `
    <p> - - - - - - - - - - - </p>
    <div>
    <p>Top expense of completed reimbursement: ${topAmount} </p>
    <p>By:  ${expenseName[this.index]}</p>
    </div>
    <div>
    <p> - - - - - - - - - - - </p>
    <div>
    <p>Mean total of completed reimbursements: ${meanTotal}</p>
    </div>
    <p> - - - - - - - - - - - </p>
    <div>
    <p>Number of reimbursements per employee (completed and pending): </p>
    <p>Ben: ${benCount.length} </p>
    <p>Alli: ${alliCount.length}</p>
    <p>Sam: ${samCount.length}</p>
    `;

    topExpense = [];
    expenseName = [];
    completeExpense = [];

    benCount = [];
    alliCount = [];
    samCount = [];

    switcher = false;
  } else {
    setTimeout(checkStats, 200);
  }
}

// let count = [];
// function amountReimbursePerEmployee() {
//   let name = expenseName;
//   console.log(name);

//   let employeeOne = 0;
//   let employeeTwo = 0;
//   let employeeThree = 0;

//   // counts the dublicate names, inserts into count array.
//   name.forEach((i) => {
//     count[i] = (count[i] || 0) + 1;
//   });
//   count = count;
// }

function grabTopSpender() {
  let amounts = topExpense;
  let completed = completeExpense;
  let name = expenseName;

  console.log(amounts.length);

  this.index = amounts.indexOf(Math.max(...amounts));
  if (completeExpense[this.index] == "pending") {
    completed.splice([this.index], 1);
    name.splice([this.index], 1);
    amounts.splice([this.index], 1);

    grabTopSpender();
  }
  topAmount = Math.max(...amounts);

  amounts = [];
  completed = [];
  name = [];
}

function grabMeanSpent(topExpense) {
  let total = 0;
  let count = 0;
  let pendingIndexs = [];

  for (let i = 0; i < completeExpense.length; i++) {
    if (completeExpense[i] == "pending") {
      pendingIndexs.push(i);
    }
  }

  for (let i = 0; i < pendingIndexs.length; i++) {
    topExpense.splice(pendingIndexs[i], 1);
  }

  topExpense.forEach((item) => {
    total += item;
    count++;
  });

  meanTotal = (total / count).toFixed(2);

  return meanTotal;
}

stats.addEventListener("click", () => {
  statistics(findAllReimburse_Ben, findAllReimburse_Alli, findAllReimburse_Sam);

  checkStats();
});

// ==============================================
// ===============================================

// GET Reimbursement by ID, and Update

// ==============================================
// ==============================================
let approvalForm = document.getElementById("approval");
let invoiceButton = document.getElementById("approve-submission");

function showForms() {
  showForm.className = "show";
}
function showApprovalForm() {
  approvalForm.className = "show";
}

showFormButton.addEventListener("click", () => {
  showForms();
});

// function grabs JSON variables
let initCard = false;

let invoice = 0;
let employee = "";
let pastPend = "";
let approval = "";
let amount = 0;
let reason = "";
let managerReason = "";

const grabsVariables = async (id_url) => {
  const getReimbursementById = async (id_url) => {
    let response_body = await fetch(id_url);
    let idData = await response_body.json();

    return idData;
  };

  const idData = await getReimbursementById(id_url);

  this.invoice = idData.reimbursed_invoice_num;
  this.employee = idData.reimbursed_employee;
  this.pastPend = idData.reimbursed_past_pending;
  this.approval = idData.reimbursed_approval;
  this.amount = idData.reimbursed_amount;
  this.reason = idData.reimbursed_reason;
  this.managerReason = idData.reimbursed_manager_reason;

  function displayTheCard(idData) {
    displayCard = `<div class="card">
    <h2>Reimbursements</h2>
    <p class="cardText reimbursed_invoice_num">Invoice: ${idData.reimbursed_invoice_num}</p>
    <p class="cardText reimbursed_employee">Employee: ${idData.reimbursed_employee}</p>
    <p class="cardText reimbursed_past_pending">Status: ${idData.reimbursed_past_pending}</p>
    <p class="cardText reimbursed_approval">Approval: ${idData.reimbursed_approval}</p>
    <p class="cardText reimbursed_amount">Amount: $${idData.reimbursed_amount}</p>  
    <p class="cardText reimbursed_reason">Reason: ${idData.reimbursed_reason}</p>
    <p class="cardText reimbursed_manager_reason">Manager Reason: ${idData.reimbursed_manager_reason}</p>
    </div>`;
    return displayCard;
  }

  displayTheCard(idData);
  initCard = true;
};

function displayTheCard() {
  if (initCard) {
    reimburseCards.innerHTML = displayCard;
    initCard = false;
  } else {
    setTimeout(displayTheCard, 250);
  }
}

// ===============================================
// Update Reimbursement's approval

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

let invoiceLookup = document.getElementById("invoice-lookup");

invoiceLookup.addEventListener("click", () => {
  let name = document.getElementById("employeeName").value;
  let num = document.getElementById("invoiceNum").value;

  let id_url = "http://localhost:8000/manager/" + name + "/" + num;

  grabsVariables(id_url);

  showForm.className = "hide";

  displayTheCard();

  // show update form
  showApprovalForm();
});

let updateRecordForm = document.getElementsByName("approve-submissionForm")[0];
let updateRecordButton = document.getElementById("approve-submission");
let invoiceEmployeeForm = document.getElementsByName("invoiceEmployeeForm")[0];

updateRecordButton.addEventListener("click", () => {
  let statusInput = document.getElementById("status").value;
  let approvalInput = document.getElementById("approvals").value;
  let manReason = document.getElementById("managerReason").value;

  this.pastPend = statusInput;
  this.approval = approvalInput;
  this.managerReason = manReason;

  let updateReimbursement = {
    reimbursed_invoice_num: this.invoice,
    reimbursed_employee: this.employee,
    reimbursed_past_pending: this.pastPend,
    reimbursed_approval: this.approval,
    reimbursed_amount: this.amount,
    reimbursed_reason: this.reason,
    reimbursed_manager_reason: this.managerReason,
  };

  let noSpaceName = this.employee.replace(/\s/g, "%20");

  let approvalURL = "http://localhost:8000/manager/" + noSpaceName + "Approval";

  postData(approvalURL, updateReimbursement);

  updateRecordForm.reset();

  approvalForm.className = "hide";
  invoiceEmployeeForm.reset();

  this.invoice = "";
  this.employee = "";
  this.pastPend = "";
  this.approval = "";
  this.amount = 0;
  this.reason = "";
  this.managerReason = "";
});

window.addEventListener("load", () => {
  this.initedAllCards = true;
});
