package cz.manek.cryptii.caesar_ciphre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


class CaesarCipherServiceTest {

    CaesarCipherService testedService = new CaesarCipherService();

    @Test
    void encodeSuccessTest() {
        String result = testedService.encode(3, "he told me i could never teach a llama to drive");

        assertNotNull(result);
        assertEquals("kh wrog ph l frxog qhyhu whdfk d oodpd wr gulyh", result);
    }

    @Test
    void encodeFailNullAsMessageTest() {

        NullPointerException exception = assertThrows(NullPointerException.class, () -> testedService.encode(3, null));

        assertNotNull(exception);
        assertEquals("Message parameter can't be null",exception.getMessage());;
    }

    @Test
    void encodeSuccessEmptyMessageTest() {
        String result = testedService.encode(3, "");

        assertNotNull(result);
        assertEquals("", result);
    }

    @Test
    void encodeSuccessMinusOffsetTest() {
        String result = testedService.encode(-3, "he told me i could never teach a llama to drive");

        assertNotNull(result);
        assertEquals("eb qlia jb f `lria kbsbo qb^`e ^ ii^j^ ql aofsb", result);
    }


    @Test
    void decodeSuccessTest() {
        String result = testedService.decode(3, "kh wrog ph l frxog qhyhu whdfk d oodpd wr gulyh");


        assertNotNull(result);
        assertEquals("he told me i could never teach a llama to drive", result);
    }

    @Test
    void decodeSuccessEmptyTest() {
        String result = testedService.decode(3, "");


        assertNotNull(result);
        assertEquals("", result);
    }

    @Test
    void decodeFailNullAsEncryptedMessageTest() {

        NullPointerException exception = assertThrows(NullPointerException.class, () -> testedService.decode(3, null));

        assertNotNull(exception);
        assertEquals("EncryptedMessage parameter can't be null",exception.getMessage());;
    }
}