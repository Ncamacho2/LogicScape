package logicscape.utilidades;

import org.junit.Assert;
import org.junit.Test;

public class EncriptarPasswordTest {
	@Test
	public void testEncriptarPassword() {
		String password = "password";
		String expectedHash = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8";

		String actualHash = EncriptarPassword.encriptarPassword(password);

		Assert.assertEquals(expectedHash, actualHash);
	}
}
