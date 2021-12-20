package cz.manek.cryptii.ciphers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class CipherServiceTest {

    CipherService tested = new CipherService();

    private static Map<Character, String> alphabetEncodingTable = new HashMap<>();

    @BeforeAll
    private static void setUp() {
        alphabetEncodingTable.put('a', "d");
        alphabetEncodingTable.put('b', "e");
        alphabetEncodingTable.put('c', "f");
        alphabetEncodingTable.put('d', "g");
        alphabetEncodingTable.put('e', "h");
        alphabetEncodingTable.put('f', "i");
        alphabetEncodingTable.put('g', "j");
        alphabetEncodingTable.put('h', "k");
        alphabetEncodingTable.put('i', "l");
        alphabetEncodingTable.put('j', "m");
        alphabetEncodingTable.put('k', "n");
        alphabetEncodingTable.put('l', "o");
        alphabetEncodingTable.put('m', "p");
        alphabetEncodingTable.put('n', "q");
        alphabetEncodingTable.put('o', "r");
        alphabetEncodingTable.put('p', "s");
        alphabetEncodingTable.put('q', "t");
        alphabetEncodingTable.put('r', "u");
        alphabetEncodingTable.put('s', "v");
        alphabetEncodingTable.put('t', "w");
        alphabetEncodingTable.put('u', "z");
        alphabetEncodingTable.put('v', "a");
        alphabetEncodingTable.put('w', "b");
        alphabetEncodingTable.put('z', "c");
    }
}