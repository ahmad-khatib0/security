// AES-GCM, is the most widely used AEAD
//
async function main() {
  let config = {
    name: 'AES-GCM',
    length: 128, // Generates a 128-bit key for 128 bits of security
  }

  let keyUsages = ['encrypt', 'decrypt']
  let key = await crypto.subtle.generateKey(config, false, keyUsages)

  // Generates a 12-byte IV randomly
  let iv = new Uint8Array(12)
  await crypto.getRandomValues(iv)

  let te = new TextEncoder()
  // Uses some associated data to encrypt our plaintext.
  // Decryption must use the same IV and associated data.
  let ad = te.encode('some associated data')
  let plaintext = te.encode('hello world')
  console.log(ad)

  let param = {
    name: 'AES-GCM',
    iv: iv,
    additionalData: ad,
  }

  let ciphertext = await crypto.subtle.encrypt(param, key, plaintext)
  // Decryption throws an exception if the IV, ciphertext, or associated data are tampered with.
  let result = await window.crypto.subtle.decrypt(param, key, ciphertext)
  let decode = new TextDecoder('utf-8').decode(result)
  console.log(decode)
}

main()
