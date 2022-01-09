package com.revature.model;

import java.util.Objects;

public class Employee {

    private int employee_login_id;
    private String employee_login_name;
    private String employee_password;

    public Employee() {
        super();
    }

    public Employee(int employee_login_id, String employee_login_name, String employee_password) {
        super();
        this.employee_login_id = employee_login_id;
        this.employee_login_name = employee_login_name;
        this.employee_password = employee_password;
    }

    public int getEmployee_login_id() {
        return this.employee_login_id;
    }

    public void setEmployee_login_id(int employee_login_id) {
        this.employee_login_id = employee_login_id;
    }

    public String getEmployee_login_name() {
        return this.employee_login_name;
    }

    public void setEmployee_login_name(String employee_login_name) {
        this.employee_login_name = employee_login_name;
    }

    public String getEmployee_password() {
        return this.employee_password;
    }

    public void setEmployee_password(String employee_password) {
        this.employee_password = employee_password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return employee_login_id == employee.employee_login_id
                && Objects.equals(employee_login_name, employee.employee_login_name)
                && Objects.equals(employee_password, employee.employee_password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_login_id, employee_login_name, employee_password);
    }

    @Override
    public String toString() {
        return "{" +
                " employee_login_id='" + getEmployee_login_id() + "'" +
                ", employee_login_name='" + getEmployee_login_name() + "'" +
                ", employee_password='" + getEmployee_password() + "'" +
                "}";
    }

}
