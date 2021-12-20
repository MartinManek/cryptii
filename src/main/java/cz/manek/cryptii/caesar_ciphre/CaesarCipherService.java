package cz.manek.cryptii.caesar_ciphre;

import org.springframework.stereotype.Service;

/**
 * Caesar cipher service. Manages encoding/decoding of message with Caesar cipher.
 *
 */
@Service
public class CaesarCipherService {

    /**
     * Encrypt given message by Caesar cipher. Take into account some simple alphabet length(26) and if offset is multiply of 26 then it's handled as to go over.
     *
     * @param offset number of letter of each letter should be shifted right in the alphabet(unicode table). Can handle minus values, but doesn't guarantee correct result.
     * @param message message which should be encrypted by Caesar cipher
     * @return encrypted message
     */
    public String encode(int offset, String message) {
        if (null == message) {throw new NullPointerException("Message parameter can't be null");}

        StringBuilder result = new StringBuilder();

        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
    /**
     * Decrypt given message encrypted by Caesar cipher for given offset.
     *
     * @param offset number of letter of each letter should be shifted right in the alphabet(unicode table). Can handle minus values, but doesn't guarantee correct result.
     * @param encryptedMessage message which should be encrypted by Caesar cipher
     * @return decrypted message
     */
    public String decode(int offset, String encryptedMessage) {
        if (null == encryptedMessage) {throw new NullPointerException("EncryptedMessage parameter can't be null");}

        StringBuilder result = new StringBuilder();

        for (char character : encryptedMessage.toCharArray()) {
            if (character != ' ') {
            int originalAlphabetPosition = character - 'a';
            int newAlphabetPosition = (originalAlphabetPosition - offset) % 26;
            char newCharacter = (char) ('a' + newAlphabetPosition);
            result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
