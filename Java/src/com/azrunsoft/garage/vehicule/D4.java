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
public class D4 extends Vehicule  implements Serializable{
    public D4()
    {
        super();
        super.prix = 25147;
        super.nom = "D4";
        super.nomMarque = Marque.TROEN;
        
        
    }
}
