package de.li.taschenrechner;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TaschenrechnerSessionBean {

    public int add(int zahl1, int zahl2) {
        return zahl1 + zahl2;
    }

    public int sub(int zahl1, int zahl2) {
        return zahl1 - zahl2;
    }

    public int mul(int zahl1, int zahl2) {
        return zahl1 * zahl2;
    }

    public int div(int zahl1, int zahl2) {
        return zahl1 / zahl2;
    }
}
