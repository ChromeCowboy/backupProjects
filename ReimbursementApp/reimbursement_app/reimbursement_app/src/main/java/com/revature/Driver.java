package com.revature;

import com.revature.controller.EmployeeController;
import com.revature.controller.ManagerController;
import com.revature.logging.Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Driver {

    public static void main(String[] args) {

        Logger myLogger = LoggerFactory.getLogger(Logging.class);

        myLogger.info("app startsssss");
        Javalin app = Javalin.create().start(8000);

        EmployeeController employeeController = new EmployeeController(app);
        employeeController.initEndpoints();

        ManagerController managerController = new ManagerController(app);
        managerController.initEndpoints();

        app._conf.addStaticFiles("/static", Location.CLASSPATH);
        app._conf.prefer405over404 = true;

    }
}
