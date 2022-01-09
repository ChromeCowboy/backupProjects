package com.revature.repository;

import com.revature.model.Reimbursements;

public interface EmployeeRepository {

    Reimbursements findReimburseByName(String employeeName);

    void submitReimbursement(Reimbursements reimbursements);

}
