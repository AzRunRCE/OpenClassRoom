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
public class MoteurEssence  extends Moteur  implements Serializable{
    public  MoteurEssence(String cylindre,double  prix)
    {
       super(cylindre, prix);   
       super.type = TypeMoteur.ESSENCE;       
    }
}
