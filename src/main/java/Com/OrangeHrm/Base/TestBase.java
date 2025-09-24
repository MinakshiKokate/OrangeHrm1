package Com.OrangeHrm.Base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Com.OrangeHrm.Keyword;
import Com.OrangeHrm.Utile.App;

public class TestBase {

	@BeforeMethod
	public void teardown() throws IOException {
		Keyword keyword = new Keyword();
		keyword.LaunchBrowser("Chrome");
		keyword.launchUrl(App.getAppUrl("qa"));

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Keyword.driver.quit();

	}
}/*
	 * @BeforeMethod TestNG का Annotation है।
	 * 
	 * इसका मतलब:
	 * 
	 * हर एक Test Method के चलने से पहले यह method अपने आप execute होगा।
	 * 
	 * Step by step:
	 * 
	 * Keyword keyword = new Keyword();
	 * 
	 * Keyword class का एक object बनाया।
	 * 
	 * यह वही class है जो आपने पहले दी थी, जिसमें browser launch, click, enter text
	 * आदि methods हैं।
	 * 
	 * keyword.LaunchBrowser("Chrome");
	 * 
	 * Chrome Browser launch होगा।
	 * 
	 * keyword.launchUrl(App.getAppUrl("qa"));
	 * 
	 * App.getAppUrl("qa") method से QA environment का URL लिया जाएगा।
	 * 
	 * फिर browser में वह URL open किया जाएगा।
	 * 
	 * यानी आपका test हमेशा QA environment पर run होगा।
	 */