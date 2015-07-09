/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package libreria;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Implementa la struttura dati della libreria multimediale
 * 
 * @author Marco
 */
public class MyLibreria implements Serializable{
    private ArrayList<Elemento> libreria;
    private Elemento temporaneo=null;
    
    public MyLibreria(){
    libreria = new ArrayList<Elemento>();
    }
    
    public void inserisci (Elemento temp){
    
        libreria.add(temp);
        
    }
    
    public ArrayList<Elemento> getLibreria(){
    
        return libreria;
    }
    
    public void setLibreria(ArrayList<Elemento> libreria){
    
        this.libreria=new ArrayList<Elemento>();
        this.libreria= libreria;
        
    }
    
    public int size(){
    
        return libreria.size();
    }
    public Elemento get(int row){
    
        return libreria.get(row);
    }
    
    public void creaBrano (String titolo, String autore, String anno, String durata, String frequenza, String percorso){
     temporaneo = new BranoMusicale(titolo, autore, anno, durata, frequenza, percorso);
     inserisci(temporaneo);
     temporaneo=null;
    }
    
    public void creaVideo (String titolo, String autore, String anno, String durata, String percorso){
     temporaneo = new Video(titolo, autore, anno, durata, percorso);
     inserisci(temporaneo);
     temporaneo=null;
    }
    
    public void creaEBook(String titolo, String autore, String anno, String npagine, String percorso){
    
        temporaneo = new EBook(titolo, autore, anno, npagine, percorso);
        inserisci(temporaneo);
        temporaneo=null;
    }
    
    public void elimina(int pos){
    
        this.get(pos).stop();
        libreria.remove(pos);
    }
}
