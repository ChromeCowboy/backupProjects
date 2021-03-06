package com.revature.repository;

import com.revature.model.Reimbursements_Alli;
import com.revature.model.Reimbursements_Ben;
import com.revature.model.Reimbursements_Sam;

public interface ManagerRepository {

  // List<Reimbursements> findAllReimburse();

  // List<Reimbursements> retrievePending();

  Reimbursements_Alli getAlliPendingOrPast(int id);

  void updateAlliApproveOrNotApprove(Reimbursements_Alli reimbursements_Alli);

  Reimbursements_Ben getBenPendingOrPast(int id);

  void updateBenApproveOrNotApprove(Reimbursements_Ben reimbursements_Ben);

  Reimbursements_Sam getSamPendingOrPast(int id);

  void updateSamApproveOrNotApprove(Reimbursements_Sam reimbursements_Sam);
}
