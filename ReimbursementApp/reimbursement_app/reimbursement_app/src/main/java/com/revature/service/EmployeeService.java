package com.revature.service;

import com.revature.model.Reimbursements;
import com.revature.repository.EmployeeRepository;
import com.revature.repository.EmployeeRepositoryImpl;

public class EmployeeService {

  EmployeeRepository employee = new EmployeeRepositoryImpl();

  public Reimbursements findReimburseByName(String employeeName) {
    return this.employee.findReimburseByName(employeeName);
  }

  public void submitReimbursement(Reimbursements reimbursements) {
    this.employee.submitReimbursement(reimbursements);
  }

}
