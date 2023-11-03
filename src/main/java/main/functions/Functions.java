package main.functions;

import org.openqa.selenium.By;

import static main.driver.OpenDriver.*;

public class Functions {

    public Functions openPage(String path) throws Exception {
        page(propos(path));
        return this;
    }

    public Functions keys(String selector, String text) {
        driver.findElement(By.cssSelector("[" + selector + "]")) // [id="username"]
                .sendKeys(text);
        return this;
    }

    public Functions click(String selector) {
        driver.findElement(By.cssSelector("[" + selector + "]")) // [id="username"]
                .click();
        return this;
    }
    public Functions text(String selector) {
        get_text = driver.findElement(By.cssSelector("[" + selector + "]"))
                .getText();
        return this;
    }
}
