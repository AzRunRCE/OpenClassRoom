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
public class A300B extends Vehicule  implements Serializable{
     public A300B()
    {
        super();
        super.prix = 28457.0;
        super.nom = "A300B";
        super.nomMarque = Marque.PIGEOT;
        
        
    }
}
