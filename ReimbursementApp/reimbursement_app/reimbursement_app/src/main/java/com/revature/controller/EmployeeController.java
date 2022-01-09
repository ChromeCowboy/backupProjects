package com.revature.controller;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import com.revature.model.Reimbursements;
import com.revature.service.EmployeeService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class EmployeeController {

  private Javalin app;
  private EmployeeService employeeService;

  public EmployeeController(Javalin app) {
    this.app = app;
    this.employeeService = new EmployeeService();
  }

  public void initEndpoints() {

    this.app.routes(() -> {

      path("/employee", () -> {

        path("/all", () -> {

        });

        path("/submit", () -> {
          post(submitReimbursement);
        });

        // this is a key inside the brackets, {name}
        path("/name/{name}", () -> {
          get(findReimburseByName);
        });
      });
    });

  }

  private Handler submitReimbursement = ctx -> {
    System.out.println(ctx.body());
    // // bodyAsClass changes the json, into the toString method which is a java
    // // object, you could pass in a save method.
    Reimbursements submitReimbursements = ctx.bodyAsClass(Reimbursements.class);
    System.out.println(submitReimbursements);
    this.employeeService.submitReimbursement(submitReimbursements);

  };

  private Handler findReimburseByName = ctx -> {
    // proof of concept
    System.out.println(ctx.pathParam("name"));
    Reimbursements retrieveReimbursements = this.employeeService.findReimburseByName((ctx.pathParam("name")));
    // write the retrieved reimbursement to the response body as JSON
    // System.out.println(retrieveReimbursements);
    ctx.json(retrieveReimbursements);
  };
}
