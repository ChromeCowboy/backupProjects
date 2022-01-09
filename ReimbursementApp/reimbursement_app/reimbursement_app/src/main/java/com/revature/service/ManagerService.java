package com.revature.service;

import java.util.List;

import com.revature.model.Reimbursements;
import com.revature.repository.ManagerRepository;
import com.revature.repository.ManagerRepositoryImpl;

public class ManagerService {

  private ManagerRepository managerRepository = new ManagerRepositoryImpl();

  public List<Reimbursements> findAllReimburse() {
    return this.managerRepository.findAllReimburse();
  }

  public List<Reimbursements> retrievePending() {
    return this.managerRepository.retrievePending();
  }

  public void setPendingToPast(String pastPending, int id) {
    this.managerRepository.setPendingToPast(pastPending, id);
  }

  public void setApproveNotApprove(String approveNotApprove, int id) {
    this.managerRepository.setApproveNotApprove(approveNotApprove, id);
  }
}
