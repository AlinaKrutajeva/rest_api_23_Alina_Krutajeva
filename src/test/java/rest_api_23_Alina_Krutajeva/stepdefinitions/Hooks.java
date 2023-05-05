package rest_api_23_Alina_Krutajeva.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import rest_api_23_Alina_Krutajeva.helpers.TestCaseContext;

import static rest_api_23_Alina_Krutajeva.clients.ClickUpClient.*;

public class Hooks {

    @Before
    public void beforeHook(Scenario scenario){
        TestCaseContext.init();
        TestCaseContext.setScenario(scenario);
        System.out.println("THE SCENARIO HAS STARTED!");
    }

    @After
    public void afterHook(){
        deleteTask(TestCaseContext.getTask().getId());
        getListInfo(TestCaseContext.getList().getId());
        deleteFolder(TestCaseContext.getFolder().getId());
        System.out.println("THE SCENARIO HAS ENDED!");
    }
}
