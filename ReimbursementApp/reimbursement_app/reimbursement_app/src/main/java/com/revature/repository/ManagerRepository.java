package com.revature.repository;

import java.util.List;

import com.revature.model.Reimbursements;

public interface ManagerRepository {

  List<Reimbursements> findAllReimburse();

  List<Reimbursements> retrievePending();

  void setPendingToPast(String pastPending, int id);

  void setApproveNotApprove(String approveNotApprove, int id);
}
