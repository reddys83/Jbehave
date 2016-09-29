package com.accuity.zeus.aft.jbehave.pages;

import com.accuity.zeus.aft.io.ApacheHttpClient;
import com.accuity.zeus.aft.io.Database;
import com.accuity.zeus.aft.io.HeraApi;
import com.accuity.zeus.aft.jbehave.identifiers.LegalEntityIdentifiers;
import com.accuity.zeus.aft.jbehave.identifiers.OfficeIdentifiers;
import com.accuity.zeus.aft.rest.RestClient;
import com.accuity.zeus.xml.XmlDocument;
import com.accuity.zeus.xml.XmlDocumentLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public abstract class AbstractPage {

    private final static long STANDARD_WAIT = 1000L;

    private WebDriver driver;

    private String urlPrefix;

    protected final Database database;

    protected final ApacheHttpClient apacheHttpClient;

    protected final HeraApi heraApi;

    protected final RestClient restClient;

    public DataPage dataPage;
    public String bigString="";
    protected By contentLocator = By.xpath("//body/div[@id='content']");

    public AbstractPage(WebDriver driver, String urlPrefix, Database database, ApacheHttpClient apacheHttpClient, RestClient restClient, HeraApi heraApi) {
        this.driver = driver;
        this.urlPrefix = urlPrefix;
        this.database = database;
        this.apacheHttpClient = apacheHttpClient;
        this.heraApi = heraApi;
        this.restClient = restClient;
    }

    public abstract String getPageUrl();

    public void open() {
        driver.get(getPageUrl());
        if (driver instanceof InternetExplorerDriver) {
            try {
                driver.navigate().to("javascript:document.getElementById('overridelink').click()");
            } catch (Exception e) {
                System.out.println("SSL not handled");
            }
        }
    }

    public void validatePage() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotNull(driver);
        assertTrue(driver.findElement(contentLocator).isEnabled());
    }

    public void validatePage(By by) {
        assertNotNull(driver);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getUrlPrefix() {
        return urlPrefix;
    }

    public Database getDatabase() {
        return database;
    }

  public RestClient getRestClient() {
      return restClient;
  }

    public ApacheHttpClient getApacheHttpClient() {
        return apacheHttpClient;
    }

    public HeraApi getHeraApi() {
        return heraApi;
    }

    public String getTextOnPage(By by) {
        int attempts = 0;
        String text = null;
        while (true) {
            waitFor();
            if (driver.findElement(by).isDisplayed()) {
                text = driver.findElement(by).getText().trim();
                break;
            }
            if (attempts >= 10) {
                break;
            }
            waitFor();
            attempts++;
        }
        return text;
    }

    public void attemptClick(By by) {
        int attempts = 0;
        String text = null;
        while (true) {
            waitFor();
            if (driver.findElement(by).isDisplayed()) {
                driver.findElement(by).click();
                break;
            }
            if (attempts >= 10) {
                break;
            }
            waitFor();
            attempts++;
        }
    }
    private void waitFor() {
        try {
            Thread.sleep(STANDARD_WAIT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToAppear(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }

    public void waitForElementToDisappear(By by) {
        try {
            try {
                Thread.sleep(STANDARD_WAIT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
        catch (org.openqa.selenium.StaleElementReferenceException e) {
        }
    }

    public void selectItemFromDropdownListByValue(By by, String value) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(value);

    }

    public void selectItemFromDropdownListByText(By by, String value) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select dropdown = new Select(driver.findElement(by));
        if (value.equals("")) {
            dropdown.selectByValue(value);
        } else {
            dropdown.selectByVisibleText(value);
        }
    }

    public void selectItemFromDropdownListByText(WebElement obj, String value) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select dropdown = new Select(obj);
        if (value.equals("")) {
            dropdown.selectByValue(value);
        } else {
            dropdown.selectByVisibleText(value);
        }
    }

    public void modifyHtmlByName(By element, String attribute, String value) {
        WebElement webElement = getDriver().findElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";
        executor.executeScript(scriptSetAttrValue, webElement, attribute, value);
    }

    public List<String> getNodeValuesByTagName(Document document, String tagName)
    {
        ArrayList<String> nodeValues=new ArrayList<String>();
        if((document!=null)&(document.getElementsByTagName(tagName).getLength() != 0))
        {
            for (int i=0;i<document.getElementsByTagName(tagName).getLength();i++) {

             NodeList children=document.getElementsByTagName(tagName).item(i).getChildNodes();
                for (int j = 0;j < children.getLength();j++) {
                    if (children.item(j).getNodeType() != Node.ELEMENT_NODE)
                        nodeValues.add(document.getElementsByTagName(tagName).item(i).getFirstChild().getNodeValue());
                }
            }
        }
        return nodeValues;
    }


    public void selectRadioButtonByValue(By by, String value)
    {
        List<WebElement> radioButtons=getDriver().findElements(by);
        for (WebElement radioButton:radioButtons) {
            if (radioButton.getAttribute("value").equals(value)) {
                radioButton.click();
                break;
            }
        }
    }

    public String getSelectedRadioValue(By by)
    {
        String selectedValue="";
        List<WebElement> radioButtons=getDriver().findElements(by);
        for (WebElement radioButton:radioButtons) {
            if (radioButton.isSelected())
            {
                selectedValue= radioButton.getAttribute("value");
            }
        }
        return selectedValue;
    }

    public String getSelectedDropdownValue(By by) {
        Select dropdown = new Select(driver.findElement(by));
        String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
        return selectedValue;
    }

    public String getSelectedDropdownText(By by) {
        Select dropdown = new Select(driver.findElement(by));
        String selectedValue = dropdown.getFirstSelectedOption().getText();
        return selectedValue;
    }

    public String createBigString(int stringSize)
    {
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length()<stringSize) {
            builder.append("abcde12345abcde12345abcde12345abcde12345abcde12345abcde12345abcde12345abcde12345abcde12345abcde12345");
        }
        bigString=builder.toString();
        return bigString;

    }
    
    /**
	 * This method is to generate a random numeric number in specified range
	 * @param limit
	 * @return the generated random number
	 */
	public String getRandomNumericString(int limit) {
		int randomNum = 0;
		String randomString = "";
		Random ran = new Random();
		for(int index =0 ; index < limit ; index++)
		{
			randomNum = ran.nextInt(9);
			randomString += randomNum;
		}	    	
		return randomString;
	}

    public List returnAllListValues(By by){
        List<String> dropdownValuesList = new ArrayList<>();
        Select dropdown = new Select(getDriver().findElement(by));
        String selectedValue = dropdown.getFirstSelectedOption().getText();
        for (WebElement option : dropdown.getOptions()) {
            if(!option.getText().equals("")){
            dropdownValuesList.add(option.getAttribute("value"));}
        }

               return dropdownValuesList;
    }

    public List returnAllDropDownUnselectedValues(By by){
        List<String> dropdownValuesList = new ArrayList<>();
        Select dropdown = new Select(getDriver().findElement(by));
        String selectedValue = dropdown.getFirstSelectedOption().getText();
        for (WebElement option : dropdown.getOptions()) {
            dropdownValuesList.add(option.getAttribute("value"));
        }
        dropdownValuesList.remove(selectedValue);
        if (dropdownValuesList.get(0).equals("")) {
            dropdownValuesList.remove(0);
        }
        return dropdownValuesList;
    }

    public void selectItemFromDropdownListByindex(By by, int i) {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByIndex(i);

    }

    public List<String> getAlreadySelectedValuesInAllRowsForADropdown(By by) {
        ArrayList<String> selectedValueList = new ArrayList();
        for (WebElement WebElement : getDriver().findElements(by)) {
            Select dropdown = new Select(WebElement);
            String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
            selectedValueList.add(selectedValue);
        }
        return selectedValueList;
    }

    public XmlDocument getTestDataXml(String resource, String fileName){

        URI filePath = null;
        try {
            filePath = getClass().getResource("/testdata/" + resource + "/" + fileName + ".xml").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return XmlDocumentLoader.loadDocumentFromFile(filePath);
    }

    public String getResourceURL(String resource, String fileName){
        URI filePath = null;
        try {
            filePath = getClass().getResource("/testdata/" + resource + "/" + fileName + ".xml").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Document document =  XmlDocumentLoader.getDocument(filePath);
        String resourceURL=document.getElementsByTagName(resource).item(0).getAttributes().getNamedItem("resource").getNodeValue();
        if(resourceURL.contains("http")){
            String[] splitURL=resourceURL.split(heraApi.getPath());
            resourceURL=splitURL[1];
        }
        return resourceURL;
    }
    
    public void selectDropDownValueFromRowNumber(By by, String value, int rowNumber) {
		try {
			List<WebElement> dropdownValue = getDriver().findElements(by);
			if (rowNumber <= dropdownValue.size()) {
				Select dropdown = new Select(dropdownValue.get(rowNumber - 1));
				if (value.equals("")) {
					dropdown.selectByValue(value);
				} else {
					dropdown.selectByVisibleText(value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void selectTexBoxValueFromRowNumber(By by, String value, int rowNumber) {
		try {
			List<WebElement> textBoxValues = getDriver().findElements(by);
			if (rowNumber <= textBoxValues.size()) {
				textBoxValues.get(rowNumber - 1).clear();
				textBoxValues.get(rowNumber - 1).sendKeys(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public String getDayLaterThanToday() throws ParseException {
    	Format dateFormat = new SimpleDateFormat("dd");
    	Calendar cal = Calendar.getInstance();		 	
		cal.add(Calendar.DATE, 1);
		return dateFormat.format(cal.getTime());
	}	

    public void textToBePresentInElement(WebElement requiredMessage) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 25);
            wait.until(ExpectedConditions.textToBePresentInElement(requiredMessage,"Required"));
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
    }
}