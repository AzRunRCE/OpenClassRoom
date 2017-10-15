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
public class Moteur  implements Serializable{
   protected TypeMoteur type;
   private String cylindre;
   private double prix;
   
   public Moteur(String cylindre,double  prix)
   {
       this.cylindre = cylindre;
       this.prix = prix;
   }
   public double getPrix()
   {
       return this.prix;
   }
   @Override
   public String toString() {
        return this.type.toString() + " "+ cylindre + " (" + prix + "€)" ;
   }
}
