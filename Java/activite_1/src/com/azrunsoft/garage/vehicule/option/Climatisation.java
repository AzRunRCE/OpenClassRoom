/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azrunsoft.garage.vehicule.option;

import java.io.Serializable;

/**
 *
 * @author qmz
 */
public class Climatisation implements Option , Serializable {
     @Override
     public double getPrix()
     {
         return 347.3;
     }
     
     @Override
     public String toString()
     {
         return "Climatisation";
     }
}
