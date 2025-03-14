package hybird_encryption;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.hybrid.HybridKeyTemplates.ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM;
import com.google.crypto.tink.KeysetHandle;

// One note to help you understand the ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM
// string: ECIES (for Elliptic Curve Integrated Encryption Scheme) is the hybrid 
// encryption standard to use. You’ll learn about this later in this chapter. 
// The rest of the string lists the algorithms used to instantiate ECIES:
//   P256 is the NIST standardized elliptic curve you learned about in chapter 5.
//   HKDF is a key derivation function you will learn about in chapter 8.
//   HMAC is the message authentication code you learned about in chapter 3.
//   SHA-256 is the hash function you learned about in chapter 2.
//   AES-128-GCM is the AES-GCM authenticated encryption algorithm using a 128bit key 
//    you learned about in chapter 4.

public class App {

  public static void main(String[] args) {
    // Generates keys for a specific hybrid encryption scheme
    KeysetHandle privkey = KeysetHandle.generateNew(ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM);

    // Obtains the public key part that we can publish or share
    KeysetHandle publicKeysetHandle = privkey.getPublicKeysetHandle();

    // Anyone who knows this public key can use it to encrypt
    // plaintext and can authenticate some associated data.
    HybridEncrypt hybridEncrypt = publicKeysetHandle.getPrimitive(HybridEncrypt.class);
    byte[] ciphertext = hybridEncrypt.encrypt(plaintext, associatedData);

    // Decrypts an encrypted message using the same associated data.
    // If the decryption fails, it throws an exception.
    HybridDecrypt hybridDecrypt = privkey.getPrimitive(HybridDecrypt.class);
    byte[] plaintext = hybridDecrypt.decrypt(ciphertext, associatedData);

    System.out.println(new String(plaintext));
  }
}
