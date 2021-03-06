package com.revature.repository;

import java.util.List;

import com.revature.model.Reimbursements_Alli;
import com.revature.util.HibernateSessionFactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AlliRepositoryImpl implements AlliRepository {

  @Override
  public List<Reimbursements_Alli> findAllAlli() {

    List<Reimbursements_Alli> reimbursements = null;

    Session session = null;
    Transaction transaction = null;

    try {
      session = HibernateSessionFactory.getSession();
      transaction = session.beginTransaction();
      reimbursements = session.createQuery("FROM Reimbursements_Alli", Reimbursements_Alli.class).getResultList();

      transaction.commit();

    } catch (HibernateException e) {

      transaction.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
    return reimbursements;
  }

  @Override
  public void submitReimbursement(Reimbursements_Alli reimbursements) {

    Session session = null;
    Transaction transaction = null;

    try {
      session = HibernateSessionFactory.getSession();
      transaction = session.beginTransaction();

      session.save(reimbursements);
      transaction.commit();

    } catch (HibernateException e) {

      transaction.rollback();
      e.printStackTrace();

    } finally {
      session.close();
    }

  }
}

// values(nextval('reimbursement_sequence'),?,?,?,?,?)";

// }

// ====================================================================
// ====================================================================
// ====================================================================
// hibernate example. prefers sets when using embedded collections

// "validate" mode can be harder since EVERYTHING has to match the database. but
// it's best practice since everything has to match.

// "update", updates the database as you go.

// public void save(Ingredient ingredient) {
// Session session = null;
// Transaction transaction = null;

// try {

// session = HibernateSessionFactory.getSession();
// transaction = session.beginTransaction();
// session.save(ingredient);
// transaction.commit();
// } catch (HibernateException e) {
// transaction.rollback();
// e.printStackTrace();
// }
// }

// public void delete(Ingredient ingreident) {
// Session session = null;
// Transaction transaction = null;

// try {

// session = HibernateSessionFactory.getSession();
// transaction = session.beginTransaction();
// session.delete(ingredient);
// transaction.commit();

// } catch (HibernateException e) {
// transaction.rollback();
// e.printStackTrace();
// }
// }

// public void update(Ingredient ingredient) {
// Session session = null;
// Transaction transaction = null;

// try {

// session = HibernateSessionFactory.getSession();
// transaction = session.beginTransaction();
// session.update(ingredient);
// transaction.commit();

// } catch (HibernateException e) {
// transaction.rollback();
// e.printStackTrace();
// }
// }
