package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.model.Reimbursements;
import com.revature.util.ConnectionClosers;
import com.revature.util.ConnectionFactory;

public class EmployeeRepositoryImpl implements EmployeeRepository {

  @Override
  public Reimbursements findReimburseByName(String employeeName) {
    Reimbursements reimbursements = null;

    final String SQL = "select * from reimbursements where reimbursed_employee='" + employeeName + "';";
    Connection connection = null;
    Statement stmt = null;
    ResultSet set = null;

    try {

      connection = ConnectionFactory.getConnection();

      stmt = connection.createStatement();

      set = stmt.executeQuery(SQL);

      while (set.next()) {
        reimbursements = new Reimbursements(
            set.getInt(1),
            set.getString(2),
            set.getString(3),
            set.getString(4),
            set.getInt(5),
            set.getString(6));
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
  public void submitReimbursement(Reimbursements reimbursements) {

    final String SQL = "insert into reimbursements values(nextval('reimbursement_sequence'),?,?,?,?,?)";
    Connection conn = null;
    PreparedStatement stmt = null;

    try {

      conn = ConnectionFactory.getConnection();
      stmt = conn.prepareStatement(SQL);

      stmt.setString(1, reimbursements.getReimbursed_employee());
      stmt.setString(2, reimbursements.getReimbursed_past_pending());
      stmt.setString(3, reimbursements.getReimbursed_approval());
      stmt.setInt(4, reimbursements.getReimbursed_amount());
      stmt.setString(5, reimbursements.getReimbursed_reason());
      stmt.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      ConnectionClosers.closeConnection(conn);
      ConnectionClosers.closeStatement(stmt);
    }
  }

}
