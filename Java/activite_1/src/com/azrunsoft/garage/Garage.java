/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azrunsoft.garage;

import static com.azrunsoft.garage.Main.ANSI_RED;
import com.azrunsoft.garage.vehicule.Vehicule;
import com.azrunsoft.garage.vehicule.option.Option;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qmz
 */
public class Garage  implements Serializable{
    List<Vehicule> voitures;
    Garage()
    {
        try {
            ObjectInputStream ois;
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("garage"))));                  
            this.voitures = (List<Vehicule>)ois.readObject();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {    
            this.voitures =  new ArrayList<>();
        }    
    }


    @Override
    public String toString()
    {
        String output ="************************\n* Garage OpenClassRoom *\n************************\n"; 
        if (voitures.size() <= 0)
            return output + ANSI_RED + "Aucun voitures sauvgardée !";
        for (Vehicule voiture : voitures)
        {
            output += "Voiture " + voiture.getMarque().toString() + " : " + voiture.toString() + " "  + voiture.GetMoteur().toString() + " [";
            String opt_output = "";
            double total_prix_opt = 0;
            for(Option plop : voiture.getOptions() )
            {
                if(opt_output.length() == 0)
                    opt_output += plop.toString();
                else
                    opt_output +=  ", " + plop.toString();
              opt_output += " (" + plop.getPrix() + "€)";
              total_prix_opt += plop.getPrix();
            }
            output += opt_output + "] d'une valeur totale de " + (double)(voiture.getPrix() + total_prix_opt) + " €\n";
        }
       
        return output;
    }

    public void addVoiture(Vehicule voiture)
    {
        this.voitures.add(voiture);
        try {
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("garage"))));
            oos.writeObject(voitures);
            oos.close();  
        } catch (IOException e) {
        e.printStackTrace();
        }         
    }   
}
