package cpapi.controllers;

import cpapi.utilities.Common;
import cpapi.utilities.SMSSender;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.Date;

@Named("indexController")
@SessionScoped
public class IndexController extends BaseController {

    public String goHome() {
        return this.go("index");
    }

    public String goPrefs() {
        return this.go("prefs");
    }

    public Date getDate() {
        return Common.getDate();
    }

    public void test() {
        System.out.println("TEST");
        // Email.send("jmelendez025@gmail.com", "NOTIFICACIÓN DE TRANSFERENCIA", "PRUEBA", null);
        System.out.println(SMSSender.send("88998899", "prueba de mensaje "));
    }

}
