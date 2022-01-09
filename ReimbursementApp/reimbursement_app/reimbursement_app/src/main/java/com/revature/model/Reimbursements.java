package com.revature.model;

import java.util.Objects;

public class Reimbursements {

    private int reimbursed_invoice_num;
    private String reimbursed_employee;
    private String reimbursed_past_pending;
    private String reimbursed_approval;
    private int reimbursed_amount;
    private String reimbursed_reason;

    public Reimbursements() {
        super();
    }

    public Reimbursements(int reimbursed_invoice_num, String reimbursed_employee, String reimbursed_past_pending,
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
        if (!(o instanceof Reimbursements)) {
            return false;
        }
        Reimbursements reimbursements = (Reimbursements) o;
        return reimbursed_invoice_num == reimbursements.reimbursed_invoice_num
                && Objects.equals(reimbursed_employee, reimbursements.reimbursed_employee)
                && Objects.equals(reimbursed_past_pending, reimbursements.reimbursed_past_pending)
                && Objects.equals(reimbursed_approval, reimbursements.reimbursed_approval)
                && reimbursed_amount == reimbursements.reimbursed_amount
                && Objects.equals(reimbursed_reason, reimbursements.reimbursed_reason);
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
