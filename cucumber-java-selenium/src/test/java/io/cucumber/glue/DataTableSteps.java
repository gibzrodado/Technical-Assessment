package io.cucumber.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.pages.DataTables;
import io.cucumber.testdata.ExpectedTableData;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DataTableSteps extends Context {

    public DataTableSteps (Manager manager) {
        super(manager);
    }

    @Given("^Access sortable data table through '(.+)'$")
    public void accessSortableDataTable(String url) {
        manager.getDriver().get(url);
        DataTables dataTablesPage = new DataTables(manager.getDriver());
        stash("dataTablesPage", dataTablesPage);
    }

    @When("^I check the data of Example 1 table$")
    public void collectTableData() {
        DataTables dataTablesPage = (DataTables) getTestStash().get("dataTablesPage");
        int rowCount = dataTablesPage.getRowCount();
        List<List<String>> tableData = dataTablesPage.getTableData();

        stash("rowCount", rowCount);
        stash("tableData", tableData);
    }

    @Then("^Example 1 should display the 4 expected results$")
    public void checkTable() {
        Integer rowCount = (Integer) getTestStash().get("rowCount");
        List<List<String>> tableData = (List<List<String>>) getTestStash().get("tableData");

        assertEquals(4, rowCount);
        assertEquals(ExpectedTableData.ROWS, tableData);
    }
}