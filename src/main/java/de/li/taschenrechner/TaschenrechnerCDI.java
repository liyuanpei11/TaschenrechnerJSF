package de.li.taschenrechner;

import de.li.Pages;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("rechner")
@ApplicationScoped
public class TaschenrechnerCDI {

    @Inject
    private TaschenrechnerSessionBean tsBean;

    private int zahl1;
    private int zahl2;
    private int ergebnis;

    public String doBerechnung(String op) {
        switch (op) {
            case "+": ergebnis = tsBean.add(zahl1, zahl2); break;
            case "-": ergebnis = tsBean.sub(zahl1, zahl2); break;
            case "*": ergebnis = tsBean.mul(zahl1, zahl2); break;
            case "/": ergebnis = tsBean.div(zahl1, zahl2); break;
        }
        return Pages.AUSGABE.getPage();
    }

    public String doPlus() {
        ergebnis = tsBean.add(zahl1, zahl2);
        return Pages.AUSGABE.getPage();
    }

    public String doMinus() {
        ergebnis = tsBean.sub(zahl1, zahl2);
        return Pages.AUSGABE.getPage();
    }

    public String doMulti() {
        ergebnis = tsBean.mul(zahl1, zahl2);
        return Pages.AUSGABE.getPage();
    }

    public String doDiv() {
        ergebnis = tsBean.div(zahl1, zahl2);
        return Pages.AUSGABE.getPage();
    }

    public int getZahl1() {
        return zahl1;
    }

    public void setZahl1(int zahl1) {
        this.zahl1 = zahl1;
    }

    public int getZahl2() {
        return zahl2;
    }

    public void setZahl2(int zahl2) {
        this.zahl2 = zahl2;
    }

    public int getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(int ergebnis) {
        this.ergebnis = ergebnis;
    }
}
