package guru.springframework.sfgpetclinic.controllers;

public class IndexController {

    public String index() {

        return "index";
    }

    public String oopsHandler(boolean throwException) {
        if (throwException) {
            throw new RuntimeException();
        } else {
            return "";
        }
    }
}
