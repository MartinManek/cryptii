package cz.manek.cryptii.ciphers;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class CipherService {

    private CipherRepository cipherRepository;

    /**
     * Encrypts given message by chosen cipher
     *
     * @param cipherId id of cipher
     * @param message message to be encrypted
     * @return encrypted message
     */
    public String encode(long cipherId, String message) {
        Optional<CipherDO> cipher = cipherRepository.findById(cipherId);
        Map<Character, String> encodingTable = cipher.get().getEncodingTable();


        StringBuilder encodedText = encryptText(message, encodingTable);

        return encodedText.toString();
    }

    StringBuilder encryptText(String text, Map<Character, String> encodingTable) {

        char[] chars = text.toCharArray();
        StringBuilder encodedText = new StringBuilder();

        for (char character: chars) {
            if(character != ' ') {
                String encodedCharacter = encodingTable.get(character);
                encodedText.append(encodedCharacter);
            } else {
                encodedText.append(character);
            }
        }
        return encodedText;
    }
}
