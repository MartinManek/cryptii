package cz.manek.cryptii.coder;

import cz.manek.cryptii.ciphers.CipherDO;
import cz.manek.cryptii.ciphers.CipherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/coder")
@Slf4j
public class CoderService {

    private CipherRepository cipherRepository;

    @Autowired
    public CoderService(CipherRepository cipherRepository) {
        this.cipherRepository = cipherRepository;
    }


//    @PostMapping
//    public String decode(String text) {
//        throw new RuntimeException("not implemented");
//    }

    @PostMapping("/test")
    public void createTestData() {
        CipherDO sample = new CipherDO();

        sample.setName("Casesar ciphre");

        Map<Character, String> encodingTableSample = new HashMap<>();
        encodingTableSample.put('a', "d");
        encodingTableSample.put('b', "e");
        encodingTableSample.put('c', "f");
        sample.setEncodingTable(encodingTableSample);

        CipherDO save = cipherRepository.save(sample);

        log.info("Save: " + save);
    }
}
