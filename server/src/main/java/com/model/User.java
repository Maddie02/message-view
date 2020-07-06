package com.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

@Document(collection = "user")
public class User {
    @Id
    private ObjectId id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;

        String encryptedPass = "";
        String key = "PaSsEnCrIpTiOn!?";

        try {
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(password.getBytes());
            encryptedPass = new String(encrypted);
            //System.err.println(encryptedPass);

			/*cipher.init(Cipher.DECRYPT_MODE, aesKey);
			String decrypted = new String(cipher.doFinal(encrypted));
			System.err.println(decrypted);*/
        } catch (Exception ex) {
            System.out.println("Something went wrong!");
        }

        this.password = encryptedPass;
    }

    public ObjectId getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
}