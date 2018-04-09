/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azrunsoft.garage.vehicule;

import com.azrunsoft.garage.vehicule.option.Option;
import com.azrunsoft.garage.vehicule.moteur.Moteur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qmz
 */
public class Vehicule   implements Serializable{
    protected double                prix;
    protected String                nom;
    protected Marque                nomMarque;
    private final List<Option>      options;
    private Moteur                  moteur;
    
    Vehicule()
    {
        options = new ArrayList<>();
    }
    public void addOption(Option opt)
    {
        this.options.add(opt);
    }
    @Override
    public String toString()
    {
        return this.nom;
    }
        
    public void setMoteur(Moteur moteur)
    {
        this.moteur = moteur;
    }
    
     public Moteur GetMoteur()
    {
        return moteur;
    }

    public Marque  getMarque()
    {
        return this.nomMarque;
    }
     
    public List<Option> getOptions()
    {
        return options;
    }
     
    public double getPrix()
    {
        return prix;
    }
}
