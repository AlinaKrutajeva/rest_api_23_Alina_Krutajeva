package rest_api_23_Alina_Krutajeva.clients;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static rest_api_23_Alina_Krutajeva.constants.ProjectConstants.*;
import static rest_api_23_Alina_Krutajeva.constants.ProjectConstants1.LIST_ID;

public class ClickUpClient {

    private static RequestSpecification clickUpSpec() {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", API_TOKEN);
    }
    public static Response createFolder(JSONObject obj) {
        return RestAssured
                .given(clickUpSpec())
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/space/" + SPACE_ID + "/folder")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response createList(JSONObject obj) {
        return RestAssured
                .given(clickUpSpec())
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/folder/" + FOLDER_ID + "/list")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response createTask(JSONObject obj) {
        return RestAssured
                .given(clickUpSpec())
                .body(obj)
                .when()
                .post("https://api.clickup.com/api/v2/list/" + LIST_ID + "/task")
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response deleteTask(String taskId) {
        return RestAssured
                .given(clickUpSpec())
                .queryParam("value", true)
                .when()
                .delete("https://api.clickup.com/api/v2/task/" + taskId)
                .then().log().all()
                .statusCode(204)
                .extract().response();
    }
    public static Response getListInfo(String listId) {
        return RestAssured
                .given(clickUpSpec())
                .when()
                .get("https://api.clickup.com/api/v2/list/" + listId)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
    public static Response deleteFolder(String folderId) {
        return RestAssured
                .given(clickUpSpec())
                .when()
                .delete("https://api.clickup.com/api/v2/folder/" + folderId)
                .then().log().all()
                .statusCode(200)
                .extract().response();
    }
}
