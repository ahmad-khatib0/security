# Uses the Ed25519 signing algorithm, a popular signature scheme
from cryptography.hazmat.primitives.asymmetric.ed25519 import Ed25519PrivateKey
from cryptography.exceptions import InvalidSignature

# First generates the private key and then generates the public key
private_key = Ed25519PrivateKey.generate()
public_key = private_key.public_key()

# Using the private key, signs a message and obtains a signature
message = b"example.com has the public key 0xab70..."
signature = private_key.sign(message)

# Using the public key, verifies the signature over the message

if __name__ == "__main__":
    try:
        public_key.verify(signature, message)
        print("The signature is valid")
    except InvalidSignature as e:
        print(f"The signature is not valid: {e}")
