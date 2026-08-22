package ru.vluzhnykh.authbasics;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MainTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void loggingInWithWrongAuthority() throws Exception {
        mvc.perform(
                        formLogin()
                                .user("joey")
                                .password("12345")
                )
                .andExpect(header().exists("failed"))
                .andExpect(unauthenticated())
                .andExpect(redirectedUrl("/failure"));
    }

    @Test
    //@WithUserDetails(value = "John")
    public void loggingInWithCorrectAuthority() throws Exception {
        mvc.perform(
                        formLogin()
                                .user("John")
                                .password("12345")
                )
                .andExpect(status().isFound())
                .andExpect(authenticated())
                .andExpect(redirectedUrl("/index"));
    }

}
