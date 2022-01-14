package com.revature.repository;

import com.revature.model.Reimbursements_Alli;
import com.revature.model.Reimbursements_Ben;
import com.revature.model.Reimbursements_Sam;
import com.revature.util.HibernateSessionFactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManagerRepositoryImpl implements ManagerRepository {

  @Override
  public Reimbursements_Alli getAlliPendingOrPast(int id) {

    Reimbursements_Alli reimburse = null;
    Session session = null;
    Transaction transaction = null;

    try {
      session = HibernateSessionFactory.getSession();
      transaction = session.beginTransaction();

      reimburse = session.get(Reimbursements_Alli.class, id);
      transaction.commit();

    } catch (HibernateException e) {

      transaction.rollback();
      e.printStackTrace();

    } finally {
      session.close();
    }
    return reimburse;
  }

  @Override
  public Reimbursements_Ben getBenPendingOrPast(int id) {

    Reimbursements_Ben reimburse = null;
    Session session = null;
    Transaction transaction = null;

    try {
      session = HibernateSessionFactory.getSession();
      transaction = session.beginTransaction();

      reimburse = session.get(Reimbursements_Ben.class, id);
      transaction.commit();

    } catch (HibernateException e) {

      transaction.rollback();
      e.printStackTrace();

    } finally {
      session.close();
    }
    return reimburse;
  }

  @Override
  public Reimbursements_Sam getSamPendingOrPast(int id) {
    Reimbursements_Sam reimburse = null;
    Session session = null;
    Transaction transaction = null;

    try {
      session = HibernateSessionFactory.getSession();
      transaction = session.beginTransaction();

      reimburse = session.get(Reimbursements_Sam.class, id);
      transaction.commit();

    } catch (HibernateException e) {

      transaction.rollback();
      e.printStackTrace();

    } finally {
      session.close();
    }
    return reimburse;
  }

  @Override
  public void updateAlliApproveOrNotApprove(Reimbursements_Alli reimbursements_Alli) {
    Session session = null;
    Transaction transaction = null;

    try {
      session = HibernateSessionFactory.getSession();
      transaction = session.beginTransaction();

      session.update(reimbursements_Alli);
      transaction.commit();

    } catch (HibernateException e) {

      transaction.rollback();
      e.printStackTrace();

    } finally {
      session.close();
    }
  }

  @Override
  public void updateBenApproveOrNotApprove(Reimbursements_Ben reimbursements_Ben) {
    Session session = null;
    Transaction transaction = null;

    try {
      session = HibernateSessionFactory.getSession();
      transaction = session.beginTransaction();

      session.update(reimbursements_Ben);
      transaction.commit();

    } catch (HibernateException e) {

      transaction.rollback();
      e.printStackTrace();

    } finally {
      session.close();
    }

  }

  @Override
  public void updateSamApproveOrNotApprove(Reimbursements_Sam reimbursements_Sam) {
    Session session = null;
    Transaction transaction = null;

    try {
      session = HibernateSessionFactory.getSession();
      transaction = session.beginTransaction();

      session.update(reimbursements_Sam);
      transaction.commit();

    } catch (HibernateException e) {

      transaction.rollback();
      e.printStackTrace();

    } finally {
      session.close();
    }

  }

  // @Override
  // public List<Reimbursements> findAllReimburse() {

  // List<Reimbursements> reimbursements = new ArrayList<>();

  // Session session = null;
  // Transaction transaction = null;

  // try {
  // session = HibernateSessionFactory.getSession();
  // transaction = session.beginTransaction();

  // reimbursements = session.createQuery("FROM Reimbursements",
  // Reimbursements.class).getResultList();
  // transaction.commit();
  // } catch (HibernateException e) {
  // transaction.rollback();
  // e.printStackTrace();
  // } finally {
  // session.close();
  // }

  // return reimbursements;
  // }

  // @Override
  // public List<Reimbursements> retrievePending() {

  // List<Reimbursements> pending = new ArrayList<>();

  // Session session = null;
  // Transaction transaction = null;

  // try {
  // session = HibernateSessionFactory.getSession();
  // transaction = session.beginTransaction();

  // pending = session.createQuery("FROM Reimbursements",
  // Reimbursements.class).getResultList();
  // transaction.commit();
  // } catch (HibernateException e) {
  // transaction.rollback();
  // e.printStackTrace();
  // } finally {
  // session.close();
  // }

  // return pending;
}

// @Override
// public void setPendingToPast(String pastPending, int id) {

// final String SQL = "update reimbursements set reimbursed_past_pending = ?
// where reimbursed_invoice_num = ?";
// Connection conn = null;
// PreparedStatement stmt = null;
// // no resultset is needed

// try {

// conn = ConnectionFactory.getConnection();
// stmt = conn.prepareStatement(SQL);
// stmt.setString(1, pastPending);
// stmt.setInt(2, id);
// stmt.execute();
// } catch (SQLException e) {
// e.printStackTrace();
// } finally {
// ConnectionClosers.closeConnection(conn);
// ConnectionClosers.closeStatement(stmt);
// }
// }

// @Override
// public void setApproveNotApprove(String approveNotApprove, int id) {
// final String SQL = "update reimbursements set reimbursed_approval = ? where
// reimbursed_invoice_num = ?";
// Connection conn = null;
// PreparedStatement stmt = null;

// // no resultset is needed

// try {

// conn = ConnectionFactory.getConnection();
// stmt = conn.prepareStatement(SQL);
// stmt.setString(1, approveNotApprove);
// stmt.setInt(2, id);
// stmt.execute();
// } catch (SQLException e) {
// e.printStackTrace();
// } finally {
// ConnectionClosers.closeConnection(conn);
// ConnectionClosers.closeStatement(stmt);
// }
// }
// }
