package com.revature.controller;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import com.revature.model.Reimbursements_Alli;
import com.revature.model.Reimbursements_Ben;
import com.revature.model.Reimbursements_Sam;
import com.revature.service.ManagerService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ManagerController {

  private Javalin app;
  private ManagerService managerService;

  public ManagerController(Javalin app) {
    this.app = app;
    this.managerService = new ManagerService();
  }

  public void initEndpoints() {

    this.app.routes(() -> {

      path("/manager", () -> {

        path("/Alli/{id}", () -> {
          get(getAlliPendingOrPast);
        });
        path("/Ben/{id}", () -> {
          get(getBenPendingOrPast);
        });
        path("/Sam/{id}", () -> {
          get(getSamPendingOrPast);
        });

        path("/AlliApproval", () -> {
          post(updateAlliApproveNotApprove);
        });
        path("/BenApproval", () -> {
          post(updateBenApproveNotApprove);
        });
        path("/SamApproval", () -> {
          post(updateSamApproveNotApprove);
        });

        path("/pending", () -> {
          get(retrievePending);
        });
      });
    });

  }

  private Handler retrievePending = ctx -> {
    // ctx.json(this.managerService.retrievePending());
  };

  private Handler getAlliPendingOrPast = ctx -> {
    Reimbursements_Alli alli = this.managerService.getAlliPendingOrPast(Integer.parseInt(ctx.pathParam("id")));
    ctx.json(alli);
  };
  private Handler getBenPendingOrPast = ctx -> {
    Reimbursements_Ben ben = this.managerService.getBenPendingOrPast(Integer.parseInt(ctx.pathParam("id")));
    ctx.json(ben);
  };
  private Handler getSamPendingOrPast = ctx -> {
    Reimbursements_Sam sam = this.managerService.getSamPendingOrPast(Integer.parseInt(ctx.pathParam("id")));
    ctx.json(sam);
  };

  private Handler updateAlliApproveNotApprove = ctx -> {
    Reimbursements_Alli alli = ctx.bodyAsClass(Reimbursements_Alli.class);
    this.managerService.updateAlliApproveOrNotApprove(alli);
    // (Integer.parseInt(ctx.pathParam("id"))));
  };
  private Handler updateBenApproveNotApprove = ctx -> {
    Reimbursements_Ben ben = ctx.bodyAsClass(Reimbursements_Ben.class);
    this.managerService.updateBenApproveOrNotApprove(ben);
    // (Integer.parseInt(ctx.pathParam("id"))));
  };
  private Handler updateSamApproveNotApprove = ctx -> {
    Reimbursements_Sam sam = ctx.bodyAsClass(Reimbursements_Sam.class);
    this.managerService.updateSamApproveOrNotApprove(sam);
    // (Integer.parseInt(ctx.pathParam("id"))));
  };

}
