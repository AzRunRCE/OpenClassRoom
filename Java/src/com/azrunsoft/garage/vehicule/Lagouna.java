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
public class Lagouna extends Vehicule  implements Serializable{
      public Lagouna()
    {
        super();
        super.prix = 23123;
        super.nom = "Lagouna";
        super.nomMarque = Marque.RENO;
        
        
    }
}
