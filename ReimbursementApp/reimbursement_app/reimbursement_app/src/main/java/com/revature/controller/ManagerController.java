package com.revature.controller;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

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

        path("/all", () -> {
          get(findAllReimburse);
        });

        path("/pending", () -> {
          get(retrievePending);
        });

        // this is a key inside the brackets, {name}
        path("/name/{pending}&{id}", () -> {
          post(setPendingToPast);
        });

        path("approval/{approval}&{id}", () -> {
          post(setApproveNotApprove);
        });

      });
    });

  }

  private Handler findAllReimburse = ctx -> {
    ctx.json(this.managerService.findAllReimburse());
  };

  private Handler retrievePending = ctx -> {
    ctx.json(this.managerService.retrievePending());
  };

  private Handler setPendingToPast = ctx -> {
    this.managerService.setPendingToPast(ctx.pathParam("pending"), (Integer.parseInt(ctx.pathParam("id"))));
  };

  private Handler setApproveNotApprove = ctx -> {
    this.managerService.setApproveNotApprove(ctx.pathParam("approval"), (Integer.parseInt(ctx.pathParam("id"))));
  };

}
