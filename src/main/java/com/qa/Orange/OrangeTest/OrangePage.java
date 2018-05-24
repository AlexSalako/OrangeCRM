package com.qa.Orange.OrangeTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangePage {
	
	


		@FindBy(xpath = "//*[@id=\"btnLogin\"]")
		private WebElement loginButton;

		public void method() {

			loginButton.click();

		}

		
		//public void sendKeysToSearch(String arg1) {
			// TODO Auto-generated method stub
			
		}

	//}


