/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azrunsoft.garage.vehicule.option;

import com.azrunsoft.garage.vehicule.option.Option;
import java.io.Serializable;

/**
 *
 * @author qmz
 */
public class GPS implements Option  , Serializable {
     @Override
     public double getPrix()
     {
         return 113.5;
     }
     @Override
     public String toString()
     {
         return "GPS";
     }
     
}
