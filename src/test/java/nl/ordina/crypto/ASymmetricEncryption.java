package nl.ordina.crypto;

import nl.ordina.crypto.util.Utils;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.*;

public class ASymmetricEncryption {

    @Test
    public void encryptSomethingWithRsa() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchProviderException {

        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair keyPair = kpGen.generateKeyPair();


        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());

        byte[] text = Files.readAllBytes(Path.of("largefile.txt"));
        byte[] encryptedText = cipher.doFinal(text);
    }

    @Test
    public void encryptSomethingWithRsaShorter() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchProviderException {

        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair keyPair = kpGen.generateKeyPair();


        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());

        byte[] text = Files.readAllBytes(Path.of("justright.txt"));
        byte[] encryptedText = cipher.doFinal(text);
    }

}