// ============================================================================
//
// Copyright (C) 2006-2019 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.StringTest.encryption;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Assert;
import org.talend.daikon.crypto.CipherSource;
import org.talend.daikon.crypto.CipherSources;
import org.talend.daikon.crypto.KeySource;
import org.talend.daikon.crypto.KeySources;


public class EncryptionUtils {

    static final Random random = new SecureRandom();

    static final String ALGO = "AES"; //$NON-NLS-1$

    static final String GCMALGO = "AES/GCM/NoPadding"; //$NON-NLS-1$

    static final String UNICODE_FORMAT = "UTF8"; //$NON-NLS-1$

    private static byte[] key = null;

    public static final Function<byte[], String> BASE64_ENCODER = bytes -> Base64.getEncoder().encodeToString(bytes);

    public static final Function<byte[], byte[]> BASE64_DECODER = bytes -> Base64.getDecoder().decode(bytes);

    public static final byte[] mainKey =
            new byte[] { 'T', 'a', 'l', 'e', 'n', 'd', 'M', 'a', 'i', 'n', 'K', 'e', 'y', '1', '2', '3' };

    public static final byte[] secondKey =
            new byte[] { 'T', 'a', 'l', 'e', 'n', 'd', 'S', 'e', 'c', 'o', 'n', 'd', 'K', 'e', 'y', '1' };

    /**
     * <p>
     * Returns a {@link KeySource} that generates a random key using {@link SecureRandom#getInstanceStrong()}.
     * </p>
     * <p>
     * Please note that {@link KeySource#getKey()} always returns the same value when using the <b>same</b>
     * {@link KeySource} instance. Two different {@link KeySource} return <b>different</b> values.
     * </p>
     * <p>
     * When using this {@link KeySource}, you must save/keep the generated value if you plan on reusing it later on
     * (after a JVM restart for instance).
     * </p>
     * 
     * @param length The length of generated key.
     * @return A {@link KeySource} that uses a random key.
     * @see SecureRandom#getInstanceStrong()
     */

    public static synchronized byte[] getKey(int length) {
        if (key == null) {
            key = new byte[length];
            random.nextBytes(key);
        }
        return key;
    }

    /**
     * Every implementation of the Java platform is required to support the following standard Cipher transformations
     * with the keysizes in parentheses:
     * AES/CBC/NoPadding (128)
     * AES/CBC/PKCS5Padding (128)
     * AES/ECB/NoPadding (128)
     * AES/ECB/PKCS5Padding (128)
     * DES/CBC/NoPadding (56)
     * DES/CBC/PKCS5Padding (56)
     * DES/ECB/NoPadding (56)
     * DES/ECB/PKCS5Padding (56)
     * DESede/CBC/NoPadding (168)
     * DESede/CBC/PKCS5Padding (168)
     * DESede/ECB/NoPadding (168)
     * DESede/ECB/PKCS5Padding (168)
     * RSA/ECB/PKCS1Padding (1024, 2048)
     * RSA/ECB/OAEPWithSHA-1AndMGF1Padding (1024, 2048)
     * RSA/ECB/OAEPWithSHA-256AndMGF1Padding (1024, 2048)
     */
    private static Cipher get(int mode) throws Exception {
        final Cipher c = Cipher.getInstance(ALGO);

        System.out.println(c.getAlgorithm());
        System.out.println(c.getBlockSize());
        System.out.println(c.getMaxAllowedKeyLength(c.getAlgorithm()));
        final Key keySpec = new SecretKeySpec(getKey(c.getBlockSize()), c.getAlgorithm());
        c.init(mode, keySpec);
        return c;
    }

    public static String encrypt(String data) throws Exception {
        final byte[] encryptedBytes = get(Cipher.ENCRYPT_MODE).doFinal(data.getBytes(UNICODE_FORMAT));
        return BASE64_ENCODER.apply(encryptedBytes);
    }

    public static String decrypt(String data) throws Exception {
        final byte[] bytes = BASE64_DECODER.apply(data.getBytes());
        return new String(get(Cipher.DECRYPT_MODE).doFinal(bytes), UNICODE_FORMAT);
    }

    /**
     * @return A {@link CipherSource} using AES/GCM/NoPadding encryption.
     */

    private static Cipher getAesGcmCipher(int encryptMode, byte[] mainKey, byte[] secondKey) throws Exception {
        int ivLength = secondKey.length;
        if ((ivLength & 7) != 0) {
            throw new IllegalArgumentException("Invalid IV length"); //$NON-NLS-1$
        }

        final Cipher c = Cipher.getInstance(GCMALGO);
        final Key key = new SecretKeySpec(mainKey, ALGO);
        final GCMParameterSpec spec = new GCMParameterSpec(ivLength * 8, secondKey);
        c.init(encryptMode, key, spec);
        return c;
    }

    private static String encryptGCM(String data, byte[] mainKey, byte[] secondKey) throws Exception {
        final byte[] dataBytes = data.getBytes(UNICODE_FORMAT);
        int ivLength = secondKey.length;
        final Cipher cipher = getAesGcmCipher(Cipher.ENCRYPT_MODE, mainKey, secondKey);

        final byte[] encryptedData = cipher.doFinal(dataBytes);
        final byte[] encryptedBytes = new byte[encryptedData.length + ivLength];
        System.arraycopy(secondKey, 0, encryptedBytes, 0, ivLength);
        System.arraycopy(encryptedData, 0, encryptedBytes, ivLength, encryptedData.length);

        return BASE64_ENCODER.apply(encryptedBytes);
    }

    private static String decryptGCM(String data, byte[] mainKey, int secondKeyLength) throws Exception {
        final byte[] encryptedBytes = BASE64_DECODER.apply(data.getBytes(UNICODE_FORMAT));

        final byte[] secondKey = new byte[secondKeyLength];
        System.arraycopy(encryptedBytes, 0, secondKey, 0, secondKeyLength);

        final Cipher cipher = getAesGcmCipher(Cipher.DECRYPT_MODE, mainKey, secondKey);
        return new String(cipher.doFinal(encryptedBytes, secondKeyLength, encryptedBytes.length - secondKeyLength),
                UNICODE_FORMAT);
    }

    public static void main(String[] args) throws Exception {
        // testASE();
        // testASEGCM();
        // testASEGCMSameWithDaikon(); //need to modify aesGcm.get method first
        // testParameter();
        testDaikonMethodByDifferentLength();
        // testDaikonMethod(8);

    }

    private static void testDaikonMethodByDifferentLength() {
        for (int i = 0; i <= 256; i++) {
            try {
                testDaikonMethod(12);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(i);
        }
    }

    private static void testDaikonMethod(int keyLength) throws Exception {
        CipherSource aesGcm = CipherSources.aesGcm(keyLength);
        KeySource myDecryptKeySource = new KeySource() {

            @Override
            public byte[] getKey() throws Exception {

                return mainKey;

            }
        };

        String encrypt = aesGcm.encrypt(myDecryptKeySource, "foo");
        System.out.println("encrypt==" + encrypt);
        String decrypt = aesGcm.decrypt(myDecryptKeySource, encrypt);
        System.out.println("decrypt==" + decrypt);
        Assert.assertEquals("The result should be foo", "foo", decrypt);

    }

    private static void testASEGCMSameWithDaikon() throws Exception {
        CipherSource aesGcm = CipherSources.aesGcm(16);
        KeySource myEncryptKeySource = new KeySource() {

            private int executeTime = 0;

            @Override
            public byte[] getKey() throws Exception {
                if (executeTime++ % 2 == 0) {
                    return secondKey;
                } else {
                    return mainKey;
                }
            }
        };
        KeySource myDecryptKeySource = new KeySource() {


            @Override
            public byte[] getKey() throws Exception {

                return mainKey;

            }
        };
        String encrypt = aesGcm.encrypt(myEncryptKeySource, "foo");
        System.out.println("encrypt==" + encrypt);
        String decrypt = aesGcm.decrypt(myDecryptKeySource, encrypt);
        System.out.println("decrypt==" + decrypt);
        Assert.assertEquals("The result should be foo", "foo", decrypt);
        String decryptGCM = decryptGCM(encrypt, mainKey, secondKey.length);
        System.out.println("decryptGCM==" + decryptGCM);
        Assert.assertEquals("The result should be foo", "foo", decryptGCM);

    }

    private static void testParameter() throws Exception {
        for (int i = 0; i <= 256; i++) {
            try {
            testValidSize(Cipher.ENCRYPT_MODE, KeySources.random(i).getKey());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(i);
            try {
            testValidSize(Cipher.DECRYPT_MODE, KeySources.random(i).getKey());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(i);
        }
        
    }

    private static void testValidSize(int encryptMode, byte[] secondKey) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
        int ivLength = secondKey.length;
        if ((ivLength & 7) != 0 && Stream.of(128, 120, 112, 104, 96).noneMatch(i -> i == ivLength)) {
            throw new IllegalArgumentException("Invalid IV length"); //$NON-NLS-1$
        }
        final Cipher c = Cipher.getInstance(GCMALGO);
        final Key key = new SecretKeySpec(mainKey, ALGO);
        final GCMParameterSpec spec = new GCMParameterSpec(ivLength * 8, secondKey);
        c.init(encryptMode, key, spec);

    }

    private static void testASEGCM() {
        try {
            String encryptAES = encryptGCM("foo", mainKey, secondKey); //$NON-NLS-1$
            String decryptAES = decryptGCM(encryptAES, mainKey, secondKey.length);
            Assert.assertEquals("The value of decryptAES should be foo", "foo", decryptAES);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

    }

    private static void testASE() throws Exception {
        String inputStr = "my name is shenze";
        String encrypt = encrypt(inputStr);
        String decrypt = decrypt(encrypt);
        System.out.println("encrypting as: " + encrypt);
        System.out.println("decrypting as: " + decrypt);
    }

}
