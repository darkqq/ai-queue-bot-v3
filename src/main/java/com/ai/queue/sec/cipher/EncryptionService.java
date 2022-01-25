package com.ai.queue.sec.cipher;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

@Service
public class EncryptionService {
    private static final String FACTORY_INSTANCE = "PBKDF2WithHmacSHA256";
    private static final String CIPHER_INSTANCE = "AES/CBC/PKCS5PADDING";
    private static final String SECRET_KEY_TYPE = "AES";
    private static final byte[] IV_CODE = new byte[16];
    @Value("${crypto.key.value}")
    private static String secretKey;
    @Value("${crypto.salt.value}")
    private static String salt;

    public String encrypt(Object obj) throws Exception {
        String value = new ObjectMapper().writeValueAsString(obj);
        Cipher cipher = initCipher(secretKey, salt);
        byte[] cipherText = cipher.doFinal(value.getBytes());
        byte[] cipherWithIv = addIVToCipher(cipherText);
        return Base64.getEncoder().encodeToString(cipherWithIv);
    }

    private Cipher initCipher(String secretKey, String salt) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(FACTORY_INSTANCE);
        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
        SecretKeySpec sKeySpec = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), SECRET_KEY_TYPE);
        Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE);
        SecureRandom random = new SecureRandom();
        random.nextBytes(IV_CODE);
        cipher.init(Cipher.ENCRYPT_MODE, sKeySpec, new IvParameterSpec(IV_CODE));
        return cipher;
    }

    private byte[] addIVToCipher(byte[] cipherText) {
        byte[] cipherWithIv = new byte[IV_CODE.length + cipherText.length];
        System.arraycopy(IV_CODE, 0, cipherWithIv, 0, IV_CODE.length);
        System.arraycopy(cipherText, 0, cipherWithIv, IV_CODE.length, cipherText.length);
        return cipherWithIv;
    }
}
