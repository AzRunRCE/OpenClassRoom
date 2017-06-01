/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azrunsoft.garage.vehicule.moteur;

import java.io.Serializable;

/**
 *
 * @author qmz
 */


public enum TypeMoteur  implements Serializable{
    DIESEL("DIESEL"),
    ESSENCE("ESSENCE"),
    HYBRIDE("HYBRIDE"),
    ELECTRIQUE("ELECTRIQUE");
    private final String text;

    /**
     * @param text
     */
    private TypeMoteur(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
    
}
