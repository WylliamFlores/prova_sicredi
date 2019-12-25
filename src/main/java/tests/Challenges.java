package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.CustomerAddPage;
import pages.CustomersLlistPage;

public class Challenges extends BaseTest {

	CustomersLlistPage customersPage = new CustomersLlistPage();
	CustomerAddPage addCustomerPage = new CustomerAddPage();

	@Test
	public void challenge1_addCustomer() {
		customersPage.selectVersion("Bootstrap V4 Theme");
		customersPage.waitForPageLoaded();
		customersPage.clickAddCustomer();
		addCustomerPage.setName("Teste Sicredi");
		addCustomerPage.setLastName("Teste");
		addCustomerPage.setContactName("seu nome");
		addCustomerPage.setPhone("51 9999-9999");
		addCustomerPage.setAddressLine1("Av Assis Brasil, 3970");
		addCustomerPage.setAddressLine2("Torre D");
		addCustomerPage.setCity("Porto Alegre");
		addCustomerPage.setState("RS");
		addCustomerPage.setPostalCode("91000-000");
		addCustomerPage.setCountry("Brasil");
		addCustomerPage.selectFromEmployeer("Fixter");
		addCustomerPage.setCreditLimit("200");
		addCustomerPage.clickSave();
		addCustomerPage.waitMessageSuccess();
		Assert.assertTrue(addCustomerPage.getMessageSuccess());
	}

	@Test
	public void challenge2_deleteCustomer() {
		challenge1_addCustomer();
		addCustomerPage.clickGoBackList();
		customersPage.search("Teste Sicredi");
		customersPage.waitForPageLoaded();
		customersPage.clickCheck();
		customersPage.clickDelete();
		customersPage.waitMessageConfirmDelete();
		Assert.assertEquals("Are you sure that you want to delete this 1 item?",
				customersPage.getMessageConfirmDelete());
		customersPage.clickConfirmDelete();
		customersPage.waitMessageDelete();
		Assert.assertEquals("Your data has been successfully deleted from the database.",
				customersPage.getMessageDelete());
	}
}