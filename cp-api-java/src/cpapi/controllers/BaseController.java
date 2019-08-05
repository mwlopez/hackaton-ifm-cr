package cpapi.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

public class BaseController implements Serializable {

    protected static final String SP = "/";
    private static final String EXT = ".xhtml";
    private static final String REDIR = "?faces-redirect=true";

    static void addMessage(String msg) {
        msg = msg.toLowerCase();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info: " + msg, ""));
    }

    static void addMessageErr(String msg) {
        msg = msg.toLowerCase();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error: " + msg, ""));
    }

    public String go(String page) {
        return "/" + page + EXT + REDIR;
    }

    public String stay(String page) {
        return "/" + page + EXT;
    }
}

