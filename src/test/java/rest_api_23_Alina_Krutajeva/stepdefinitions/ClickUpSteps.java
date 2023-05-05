package rest_api_23_Alina_Krutajeva.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;
import rest_api_23_Alina_Krutajeva.domain.Folder;
import rest_api_23_Alina_Krutajeva.domain.List;
import rest_api_23_Alina_Krutajeva.domain.Task;
import rest_api_23_Alina_Krutajeva.helpers.TestCaseContext;


import static rest_api_23_Alina_Krutajeva.clients.ClickUpClient.*;
import static rest_api_23_Alina_Krutajeva.constants.ProjectConstants.*;
import static rest_api_23_Alina_Krutajeva.constants.ProjectConstants1.LIST_ID;
import static rest_api_23_Alina_Krutajeva.constants.ProjectConstants1.LIST_NAME;
import static rest_api_23_Alina_Krutajeva.constants.ProjectConstants2.TASK_ID;
import static rest_api_23_Alina_Krutajeva.constants.ProjectConstants2.TASK_NAME;

public class ClickUpSteps {

    @Given("Create a new Folder and verify that the name is correct")
    @SuppressWarnings("unchecked")
    public void createNewFolderAndVerifyFolderName() {
        JSONObject obj = new JSONObject();
        obj.put("name", "TestSpaceFolder");
        Response resp = createFolder(obj);
        Folder folder = resp.as(Folder.class);
        TestCaseContext.setFolder(folder);

        Assertions.assertThat(folder.getName())
                .as("We assert that the Folder name is correct!")
                .isEqualTo(FOLDER_NAME);

        System.out.println("THE 1ST STEP WAS EXECUTED!");
    }
    @When("Create a new List and verify that the name is correct")
    @SuppressWarnings("unchecked")
    public void createNewListAndVerifyListName() {
        JSONObject obj = new JSONObject();
        obj.put("name", "TestSpaceList");
        Response resp = createList(obj);
        List list = resp.as(List.class);
        TestCaseContext.setList(list);

        Assertions.assertThat(list.getName())
                .as("We assert that the List name is correct!")
                .isEqualTo(LIST_NAME);

        System.out.println("THE 2ND STEP WAS EXECUTED!");
    }
    @And("Create a one Task and verify that the name is correct")
    @SuppressWarnings("unchecked")
    public void createOneTaskAndVerifyTaskName() {
        JSONObject obj = new JSONObject();
        obj.put("name", "TestSpaceTask");
        Response resp = createTask(obj);
        Task task = resp.as(Task.class);
        TestCaseContext.setTask(task);

        Assertions.assertThat(task.getName())
                .as("We assert that the Task name is correct!")
                .isEqualTo(TASK_NAME);

        System.out.println("THE 3RD STEP WAS EXECUTED!");
    }
    @Then("Remove the Task from the List and verify if the Task can't be found there anymore")
    @SuppressWarnings("unchecked")
    public void removeTheTaskAndVerifyThatTaskDoesNotExist() {
        Response response = getListInfo(LIST_ID);
        List list = response.as(List.class);

        Assertions.assertThat(list.getId())
                .as("We assert that the Task is removed!")
                .doesNotContain(TASK_ID);

        System.out.println("THE 4TH STEP WAS EXECUTED!");

        TestCaseContext.getScenario().log(list.getId());
    }
}
