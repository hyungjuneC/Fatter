package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoginModelTest {

	@Test
	public void test() {
		LoginModel loginModel = new LoginModel();
		
		//empty input
		boolean result = loginModel.compareIDPassword("  ", "  ");
		assertEquals(true, result);
	}

}
