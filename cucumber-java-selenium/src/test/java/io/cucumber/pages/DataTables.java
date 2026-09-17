package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;

public class DataTables extends Page {
    public DataTables(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(css = "#table1 tbody tr")
    private List<WebElement> rows;

    public int getRowCount() {
        return rows.size();
    }

    public List<List<String>> getTableData() {
        List<List<String>> tableData = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            List<String> rowData = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                rowData.add(cells.get(i).getText());
            }

            tableData.add(rowData);
        }

        return tableData;
    }

}