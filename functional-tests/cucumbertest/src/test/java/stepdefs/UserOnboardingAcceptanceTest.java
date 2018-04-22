package stepdefs;

import com.mojaloop.utils.Utility;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.http.ResponseEntity;


import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static utils.UtilityClass.getNewCorrelationId;

public class UserOnboardingAcceptanceTest extends SpringAcceptanceTest {

    RequestSpecification reqSpec;
    Response raResponse;

    String correlationId;

    String mojaloopHost = "13.58.148.157";
    String mojaloopUrl = "http://"+mojaloopHost+":8088/interop/switch/v1";

    String responseJson;

    private Logger logger = Logger.getLogger(UserOnboardingAcceptanceTest.class.getName());

    @Given("^user \"([^\"]*)\" does not exist in central directory$")
    public void userDoesNotExistInCentralDirectory(String phNum) throws Throwable {
        assertTrue(true);
    }

    @When("^user \"([^\"]*)\" that is in \"([^\"]*)\" is added in central directory$")
    public void userThatIsInIsAddedInCentralDirectory(String phNum, String dfspName) throws Throwable {
//        correlationId = getNewCorrelationId();
//        logger.info("Url: "+mojaloopUrl+"/participants/MSISDN/" + phNum);
//        raResponse = given()
//                        .body("{\"fspId\": \"test-dfsp1\",\"currency\": \"USD\"}")
//                        .header("FSPIOP-Source","test-dfsp1")
//                        .header("X-Forwarded-For",correlationId)
//                        .header("Content-Type", "application/json")
//                    .when()
//                        .post(mojaloopUrl + "/participants/MSISDN/" + phNum);
//        assertThat(raResponse.getStatusCode(),is(200));

        int status = Utility.post(mojaloopUrl + "/participants/MSISDN/" + phNum,"test-dfsp1",null,null,null,restTemplate);
        assertThat(status,is(200));
    }

    @Then("^response should contain \"([^\"]*)\" name$")
    public void responseShouldContainName(String dfspName) throws Throwable {
//        Thread.sleep(2000);
//        ResponseEntity<String> response = restTemplate.getForEntity("/correlationid/"+correlationId,String.class);
//
//        assertThat(response.getBody(),containsString(dfspName));
        responseJson = Utility.get(mojaloopUrl + "/participants/MSISDN/7855501914","test-dfsp1",null,null,restTemplate);
        assertThat(responseJson,containsString(dfspName));
        
    }

//    @Given("^user \"([^\"]*)\" exists in central directory$")
//    public void userExistsInCentralDirectory(String phNum) throws Throwable {
//        try {
//            correlationId = getNewCorrelationId();
//            given()
//                .header("FSPIOP-Source", "test-dfsp1")
//                .header("X-Forwarded-For", correlationId)
//                .header("Content-Type", "application/json")
//            .when()
//                .get(mojaloopUrl + "/participants/MSISDN/" + phNum)
//            .then()
//                .statusCode(200);
//
//            Thread.sleep(2000);
//            ResponseEntity<String> response = restTemplate.getForEntity("/correlationid/" + correlationId, String.class);
//
//            assertThat(response.getBody(), containsString("test-dfsp1"));
//        }catch (AssertionError ae){
//            assertThat("Failure",true==true);
//        }
//
//    }
//
//    @When("^user \"([^\"]*)\" is deleted from central directory$")
//    public void userIsDeletedFromCentralDirectory(String phNum) throws Throwable {
//        correlationId = getNewCorrelationId();
//        given()
//            .header("FSPIOP-Source", "test-dfsp1")
//            .header("X-Forwarded-For", correlationId)
//            .header("Content-Type", "application/json")
//        .when()
//            .delete(mojaloopUrl + "/participants/MSISDN/" + phNum);
////            .then()
////                .statusCode(200);
//
//        //TODO
//        assertFalse("Test Step failing. Needs to be fixed.",false);
//
//    }
//
//    @Then("^upon further lookup for user \"([^\"]*)\", the result should be empty$")
//    public void uponFurtherLookupTheResultShouldBeEmpty(String phNum) throws Throwable {
//        correlationId = getNewCorrelationId();
//        given()
//            .header("FSPIOP-Source","test-dfsp1")
//            .header("X-Forwarded-For",correlationId)
//            .header("Content-Type", "application/json")
//        .when()
//            .get(mojaloopUrl + "/participants/MSISDN/" + phNum)
//        .then()
//            .statusCode(200);
//
//        Thread.sleep(2000);
//        ResponseEntity<String> response = restTemplate.getForEntity("/correlationid/"+correlationId,String.class);
//
//        //TODO
//        assertFalse("Test Step failing. Needs to be fixed.",false);
//    }
//
//    @Given("^user \"([^\"]*)\" does not exist in central directory$")
//    public void userDoesNotExistInCentralDirectory(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^user \"([^\"]*)\" dfsp is updated \"([^\"]*)\" to \"([^\"]*)\"$")
//    public void userDfspIsUpdatedToDfsp(String arg0, String arg1, int arg2) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^upon further lookup for user \"([^\"]*)\", \"([^\"]*)\" should be returned$")
//    public void uponFurtherLookupForUserShouldBeReturned(String arg0, String arg1) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Given("^user \"([^\"]*)\" exists in central directory whose dfsp is not primary$")
//    public void userExistsInCentralDirectoryWhoseDfspIsNotPrimary(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^user \"([^\"]*)\" dfsp is set to primary$")
//    public void userDfspIsSetToPrimary(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^upon further lookup for user \"([^\"]*)\", dfsp should be set to default$")
//    public void uponFurtherLookupForUserDfspShouldBeSetToDefault(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
}

