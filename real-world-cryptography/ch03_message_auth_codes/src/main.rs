use hmac::{Hmac, Mac};
use sha2::Sha256;

// Note that this protocol is not perfect: it allows replays. If a message and its authentica-
// tion tag are replayed at a later point in time, they will still be authentic,

fn send_message(key: &[u8], message: &[u8]) -> Vec<u8> {
    // Instantiates HMAC with a secret key and the SHA-256 hash function
    let mut mac = Hmac::<Sha256>::new(key.into());

    // Buffers more input for HMAC
    mac.update(message);
    // Returns the authentication tag
    mac.finalize().into_bytes().to_vec()
}

fn receive_message(key: &[u8], message: &[u8], authentication_tag: &[u8]) -> bool {
    // The receiver needs to recreate the authentication tag from the same key and message.
    let mut mac = Hmac::<Sha256>::new(key.into());

    mac.update(message);

    // Checks if the reproduced authentication tag matches the received one
    mac.verify_slice(authentication_tag).is_ok()
}

fn main() {
    println!("Hello World")
}
