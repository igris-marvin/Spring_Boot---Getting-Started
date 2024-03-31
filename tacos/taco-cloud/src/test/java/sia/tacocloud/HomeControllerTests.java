package sia.tacocloud;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import sia.tacocloud.controller.HomeController;

@WebMvcTest(HomeController.class) //Web Test for HomeController class
public class HomeControllerTests {

    @Autowired  // <- Auto-configures MockMvc Component into HomeControllerClass Component
    private MockMvc mockMvc; // <- Injects MockMvc

    @Test //Text annotation, tests method -> textHomePage()
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) // <- Performs GET
            .andExpect(status().isOk()) // <- Expect HTTP 200
            .andExpect(view().name("home")) // <- Excpects a home page
            .andExpect(content().string(containsString("Welcome to..."))); // <- expects Welcome to... text
    }
}
