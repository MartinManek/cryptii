package cz.manek.cryptii.ciphers;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CipherMapperTest {

    private final CipherMapper tested = Mappers.getMapper( CipherMapper.class);

    @Test
    public void test() {
        System.out.println('A' - 'a');
    }

    @Test
    void mapDO2DTOSuccessTest() {
        Map<Character, String> encodingTableSample = new HashMap<>();
        encodingTableSample.put('a', "d");
        encodingTableSample.put('b', "e");
        encodingTableSample.put('c', "f");

        CipherDO sample = CipherDO.builder()
                .id(2L)
                .name("name")
                .encodingTable(encodingTableSample)
                .build();


        CipherDTO result = tested.map(sample);

        assertNotNull(result);
        assertEquals(2L, result.getId());
        assertEquals("name", result.getName());
        assertEquals("d", result.getEncodingTable().get('a'));
        assertEquals("e", result.getEncodingTable().get('b'));
        assertEquals("f", result.getEncodingTable().get('c'));
    }

    @Test
    void mapDO2DTONullTest() {
        CipherDO sample = null;

        CipherDTO result = tested.map(sample);

        assertNull(result);
    }

    @Test
    void mapDO2DTOAttributesNullTest() {
        CipherDO sample = CipherDO.builder()
                .id(2L)
                .name(null)
                .encodingTable(null)
                .build();

        CipherDTO result = tested.map(sample);

        assertNotNull(result);
        assertEquals(2L, result.getId());
        assertNull(result.getName());
        assertNull(result.getEncodingTable());
    }

    @Test
    void MapDTO2DO() {
        Map<Character, String> encodingTableSample = new HashMap<>();
        encodingTableSample.put('a', "d");
        encodingTableSample.put('b', "e");
        encodingTableSample.put('c', "f");

        CipherDTO sample = CipherDTO.builder()
                .id(3L)
                .name("name2")
                .encodingTable(encodingTableSample)
                .build();

        CipherDO result = tested.map(sample);

        assertNotNull(result);
        assertEquals(3L, result.getId());
        assertEquals("name2", result.getName());
        assertEquals("d", result.getEncodingTable().get('a'));
        assertEquals("e", result.getEncodingTable().get('b'));
        assertEquals("f", result.getEncodingTable().get('c'));
    }

    @Test
    void DOs2DTOsTest() {
        Map<Character, String> encodingTableSample = new HashMap<>();
        encodingTableSample.put('a', "d");
        encodingTableSample.put('b', "e");
        encodingTableSample.put('c', "f");

        CipherDO sample = CipherDO.builder()
                .id(3L)
                .name("name2")
                .encodingTable(encodingTableSample)
                .build();
        List<CipherDTO> resultCollection = tested.map(Collections.singletonList(sample));

        assertNotNull(resultCollection);
        assertFalse(resultCollection.isEmpty());
        CipherDTO result = resultCollection.get(0);
        assertEquals(3L, result.getId());
        assertEquals("name2", result.getName());
        assertEquals("d", result.getEncodingTable().get('a'));
        assertEquals("e", result.getEncodingTable().get('b'));
        assertEquals("f", result.getEncodingTable().get('c'));
    }
}