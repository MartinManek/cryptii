package cz.manek.cryptii.caesar_ciphre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CaesarCipherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void encodeMessageSuccessTest() throws Exception {
        mockMvc.perform(post("/caesar/3/coder")
                .content("he told me i could never teach a llama to drive")
                .contentType("text/plain"))
                //result
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("kh wrog ph l frxog qhyhu whdfk d oodpd wr gulyh")));
    }

    @Test
    void decodeMessageSuccessTest() throws Exception {
        mockMvc.perform(post("/caesar/3/coder")
                        .content("hkh wrog ph l frxog qhyhu whdfk d oodpd wr gulyh")
                        .contentType("text/encrypted"))
                //result
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("he told me i could never teach a llama to drive")));
    }
}