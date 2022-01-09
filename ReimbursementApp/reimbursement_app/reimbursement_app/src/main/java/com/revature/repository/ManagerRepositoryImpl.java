package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursements;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class ManagerRepositoryImpl implements ManagerRepository {

  @Override
  public List<Reimbursements> findAllReimburse() {

    List<Reimbursements> reimbursements = new ArrayList<>();

    final String SQL = "select reimbursed_invoice_num, reimbursed_employee, reimbursed_past_pending, reimbursed_approval, reimbursed_amount, reimbursed_reason from reimbursements";
    Connection connection = null;
    Statement stmt = null;
    ResultSet set = null;

    try {

      connection = ConnectionFactory.getConnection();

      stmt = connection.createStatement();

      set = stmt.executeQuery(SQL);

      while (set.next()) {
        reimbursements.add(
            new Reimbursements(
                set.getInt(1),
                set.getString(2),
                set.getString(3),
                set.getString(4),
                set.getInt(5),
                set.getString(6)));

      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionClosers.closeConnection(connection);
      ConnectionClosers.closeResultSet(set);
      ConnectionClosers.closeStatement(stmt);
    }
    return reimbursements;
  }

  @Override
  public List<Reimbursements> retrievePending() {

    List<Reimbursements> pending = new ArrayList<>();

    final String SQL = "select * from reimbursements where reimbursed_past_pending = 'pending'";
    Connection conn = null;
    Statement stmt = null;
    ResultSet set = null;

    try {
      conn = ConnectionFactory.getConnection();
      stmt = conn.createStatement();
      set = stmt.executeQuery(SQL);

      while (set.next()) {
        pending.add(
            new Reimbursements(
                set.getInt(1),
                set.getString(2),
                set.getString(3),
                set.getString(4),
                set.getInt(5),
                set.getString(6)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionClosers.closeConnection(conn);
      ConnectionClosers.closeResultSet(set);
      ConnectionClosers.closeStatement(stmt);
    }

    return pending;
  }

  @Override
  public void setPendingToPast(String pastPending, int id) {
    // r/ make reimbursed past pending a question mark, so it can change back and
    // forth
    final String SQL = "update reimbursements set reimbursed_past_pending = ? where reimbursed_invoice_num = ?";
    Connection conn = null;
    PreparedStatement stmt = null;
    // no resultset is needed

    try {

      conn = ConnectionFactory.getConnection();
      stmt = conn.prepareStatement(SQL);
      stmt.setString(1, pastPending);
      stmt.setInt(2, id);
      stmt.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionClosers.closeConnection(conn);
      ConnectionClosers.closeStatement(stmt);
    }
  }

  @Override
  public void setApproveNotApprove(String approveNotApprove, int id) {
    final String SQL = "update reimbursements set reimbursed_approval = ? where reimbursed_invoice_num = ?";
    Connection conn = null;
    PreparedStatement stmt = null;

    // no resultset is needed

    try {

      conn = ConnectionFactory.getConnection();
      stmt = conn.prepareStatement(SQL);
      stmt.setString(1, approveNotApprove);
      stmt.setInt(2, id);
      stmt.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionClosers.closeConnection(conn);
      ConnectionClosers.closeStatement(stmt);
    }
  }
}
