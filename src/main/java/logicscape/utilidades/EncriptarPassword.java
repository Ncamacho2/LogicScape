package logicscape.utilidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * 
 * Esta clase proporciona métodos para encriptar contraseñas utilizando el
 * algoritmo SHA-256.
 */
public class EncriptarPassword {

	/**
	 * Encripta una contraseña utilizando el algoritmo SHA-256.
	 *
	 * @param password la contraseña a encriptar
	 * @return la contraseña encriptada como una cadena de caracteres hexadecimal, o
	 *         null si ocurre un error
	 */
	public static String encriptarPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes());
			StringBuilder hexString = new StringBuilder();
			for (byte b : hash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}
