/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azrunsoft.garage.vehicule;

import java.io.Serializable;

/**
 *
 * @author qmz
 */
public enum Marque  implements Serializable{
    RENO("RENO"),
    PIGEOT("PIGEOT"),
    TROEN("TROEN");
 

    private final String text;

    /**
     * @param text
     */
    private Marque(final String text) {
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
