package cz.manek.cryptii.ciphers;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Controller for basic CRUD operation over cipher resource.
 *
 */
@RestController()
@RequestMapping("/ciphers")
@Slf4j
public class CipherController {

    private final CipherRepository cipherRepository;

    private final CipherService cipherService;

    private CipherMapper mapper = Mappers.getMapper( CipherMapper.class);

    @Autowired
    public CipherController(CipherRepository cipherRepository, CipherService cipherService) {
        this.cipherRepository = cipherRepository;
        this.cipherService = cipherService;
    }

    /**
     *
     *
     * @return
     */
    @GetMapping()
    public List<CipherDTO> getCiphers() {
        List<CipherDO> repositoryResult = cipherRepository.findAll();

        List<CipherDTO> result = Mappers.getMapper( CipherMapper.class).map(repositoryResult);
        return result;
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<CipherDTO> getCipher(@PathVariable() final long id) {
        CipherDO repositoryResult = cipherRepository.getById(id);

        CipherDTO result = mapper.map(repositoryResult);

        return ResponseEntity.ok().body(result);
    }

    @PostMapping()
    public ResponseEntity<CipherDTO> saveCipher(@RequestBody final CipherDTO request) {
        CipherDO cipher = Mappers.getMapper( CipherMapper.class).map(request);
        CipherDO result = new CipherDO();

        try {
            cipher.setId(null);
            result = cipherRepository.save(cipher);
        } catch (DataIntegrityViolationException e) {
            log.warn("Attempted to create cipher with name that already exists.");
            return new ResponseEntity(HttpStatus.CONFLICT);
        } catch (Exception e) {
            log.error("Error during creation of saveCipher: " + e.getMessage() + "For request: " + request);
            e.printStackTrace();
        }

        return ResponseEntity.created(URI.create("/ciphers" + result.getId())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CipherDTO> updateCipher(@PathVariable final long id,
                             @RequestBody final CipherDTO request) {
        Optional<CipherDO> cipherOptional = cipherRepository.findById(id);
        if (!cipherOptional.isPresent()) {
            log.warn("Attempted to update cipher which doesn't exists.");
            return ResponseEntity.notFound().build();
        }
        CipherDO existingCipher = cipherOptional.get();

        existingCipher.setName(request.getName());
        existingCipher.setEncodingTable(request.getEncodingTable());

        cipherRepository.save(existingCipher);

        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCipher(@PathVariable final Long id) {
        cipherRepository.deleteById(id);
    }

    @PostMapping(value = "/{cipherId}/coder", consumes = "text/text")
    public void encode(@PathVariable final long cipherId,
                      @RequestBody String text) {
        cipherService.encode(cipherId, text);
    }

    @PostMapping(value = "/{id}/coder", consumes = "text/encrypted")
    public void decode(@PathVariable final long id,
                      @RequestBody String text) {

        // TODO: 20.12.2021 finish this
        throw new IllegalStateException("Not yet implemented");
    }

}
