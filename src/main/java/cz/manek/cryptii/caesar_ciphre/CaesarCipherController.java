package cz.manek.cryptii.caesar_ciphre;

import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController()
@RequestMapping("/caesar")
public class CaesarCipherController {

    private CaesarCipherService cipherService;

    public CaesarCipherController(CaesarCipherService cipherService) {
        this.cipherService = cipherService;
    }

    @PostMapping(value = "/{offset}/coder", consumes = "text/plain")
    public String encodeMessage(@PathVariable
                       @Min(value = 0, message = "Offset must be at least 0.")
                       final int offset,
                       @NotNull
                       @RequestBody
                       String message) {
        return cipherService.encode(offset, message);
    }

    @PostMapping(value = "/{offset}/coder", consumes = "text/encrypted")
    public String decodeMessage(@PathVariable
                                @Min(value = 0, message = "Offset must be at least 0.")
                                final int offset,
                                @NotNull
                                @RequestBody
                                String encryptedMessage) {
        return cipherService.decode(offset, encryptedMessage);
    }
}
