package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@Table(name = "reimbursements_ben")
public class Reimbursements_Ben {
    @Id
    @Column
    @GeneratedValue(generator = "reimbursement_invoice_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(allocationSize = 1, name = "reimbursement_invoice_seq", sequenceName = "reimbursement_invoice_seq")
    private int reimbursed_invoice_num;
    @Column
    private String reimbursed_employee;
    @Column
    private String reimbursed_past_pending;
    @Column
    private String reimbursed_approval;
    @Column
    private int reimbursed_amount;
    @Column
    private String reimbursed_reason;

    public Reimbursements_Ben() {
        super();
    }

    public Reimbursements_Ben(int reimbursed_invoice_num, String reimbursed_employee, String reimbursed_past_pending,
            String reimbursed_approval, int reimbursed_amount, String reimbursed_reason) {
        super();
        this.reimbursed_invoice_num = reimbursed_invoice_num;
        this.reimbursed_employee = reimbursed_employee;
        this.reimbursed_past_pending = reimbursed_past_pending;
        this.reimbursed_approval = reimbursed_approval;
        this.reimbursed_amount = reimbursed_amount;
        this.reimbursed_reason = reimbursed_reason;
    }

    public int getReimbursed_invoice_num() {
        return this.reimbursed_invoice_num;
    }

    public void setReimbursed_invoice_num(int reimbursed_invoice_num) {
        this.reimbursed_invoice_num = reimbursed_invoice_num;
    }

    public String getReimbursed_employee() {
        return this.reimbursed_employee;
    }

    public void setReimbursed_employee(String reimbursed_employee) {
        this.reimbursed_employee = reimbursed_employee;
    }

    public String getReimbursed_past_pending() {
        return this.reimbursed_past_pending;
    }

    public void setReimbursed_past_pending(String reimbursed_past_pending) {
        this.reimbursed_past_pending = reimbursed_past_pending;
    }

    public String getReimbursed_approval() {
        return this.reimbursed_approval;
    }

    public void setReimbursed_approval(String reimbursed_approval) {
        this.reimbursed_approval = reimbursed_approval;
    }

    public int getReimbursed_amount() {
        return this.reimbursed_amount;
    }

    public void setReimbursed_amount(int reimbursed_amount) {
        this.reimbursed_amount = reimbursed_amount;
    }

    public String getReimbursed_reason() {
        return this.reimbursed_reason;
    }

    public void setReimbursed_reason(String reimbursed_reason) {
        this.reimbursed_reason = reimbursed_reason;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Reimbursements_Ben)) {
            return false;
        }
        Reimbursements_Ben reimbursements_Ben = (Reimbursements_Ben) o;
        return reimbursed_invoice_num == reimbursements_Ben.reimbursed_invoice_num
                && Objects.equals(reimbursed_employee, reimbursements_Ben.reimbursed_employee)
                && Objects.equals(reimbursed_past_pending, reimbursements_Ben.reimbursed_past_pending)
                && Objects.equals(reimbursed_approval, reimbursements_Ben.reimbursed_approval)
                && reimbursed_amount == reimbursements_Ben.reimbursed_amount
                && Objects.equals(reimbursed_reason, reimbursements_Ben.reimbursed_reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbursed_invoice_num, reimbursed_employee, reimbursed_past_pending, reimbursed_approval,
                reimbursed_amount, reimbursed_reason);
    }

    @Override
    public String toString() {
        return "{" +
                " reimbursed_invoice_num='" + getReimbursed_invoice_num() + "'" +
                ", reimbursed_employee='" + getReimbursed_employee() + "'" +
                ", reimbursed_past_pending='" + getReimbursed_past_pending() + "'" +
                ", reimbursed_approval='" + getReimbursed_approval() + "'" +
                ", reimbursed_amount='" + getReimbursed_amount() + "'" +
                ", reimbursed_reason='" + getReimbursed_reason() + "'" +
                "}";
    }

}
