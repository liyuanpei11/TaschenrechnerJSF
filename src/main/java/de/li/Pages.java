package de.li;

public enum Pages {

    AUSGABE("ausgabe"), EINGABE("taschenrechner"), USERPAGE("userhome"), ERROR("error"), LOGIN("login"),
    REGISTER("register"), EDITTODO("edittodo"), ADDTODO("addtodo");

    private String page;

    Pages(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }
}
