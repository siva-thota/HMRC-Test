package demo.driver;

import io.cucumber.java8.En;

public class Hooks implements En {

    public void cleanUp() {
        Driver.quitDriver();
    }

}
