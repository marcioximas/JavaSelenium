package testClass;

import main.Main;
import main.driver.OpenDriver;
import main.functions.Functions;
import main.selectors.Login;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = Main.class)
@ExtendWith(SpringExtension.class)
public class TestOpen extends OpenDriver {

    Functions action = new Functions();

    Login  login_selectors = new Login();



    @Order(1)
    @Test
    public void testOpen() throws Exception {

    action.openPage("url")
            .text(login_selectors.GET_TEXT);
    System.out.println("*****"+get_text+"*****");

    }
    @Order(2)
    @Test
    public void login() throws IOException {

       action.keys(login_selectors.USER, propos("username"))
             .keys(login_selectors.PASSWORD, propos("password"))
             .click(login_selectors.BTN_LOGIN);


    }
}
