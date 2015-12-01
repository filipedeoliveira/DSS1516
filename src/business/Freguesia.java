/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Objects;

/**
 *
 * @author Filipe Oliveira
 */
public class Freguesia {
    private String freguesia;

    public Freguesia(String freguesia) {
        this.freguesia = freguesia;
    }

    public String getFreguesia() {
        return freguesia;
    }

    public void setFreguesia(String freguesia) {
        this.freguesia = freguesia;
    }
    
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Freguesia other = (Freguesia) obj;
        if (!Objects.equals(this.freguesia, other.freguesia)) {
            return false;
        }
        return true;
    }
    public String toString() {
        return "Freguesia{" + "freguesia=" + freguesia + '}';
    }
    
    
}
