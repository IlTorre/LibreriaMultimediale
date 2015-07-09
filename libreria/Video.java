/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package libreria;

import java.io.File;
import java.io.IOException;

/**
 * Implementa un video.
 * 
 * @author Marco
 */
public class Video extends Elemento {
    
    private String durata;

    /**
     * Implementa la struttura di un video
     * 
     * @param titolo
     * @param autore
     * @param anno
     * @param durata
     * @param percorso 
     */
    public Video(String titolo, String autore, String anno, String durata, String percorso){
		super.setTitolo(titolo);
		super.setAutore(autore);
		super.setAnno(anno);
		this.setDurata(durata);
		super.setPercorso(percorso);
	}
	
    /**
     * Setta la durata di un video
     * 
     * @param durata 
     */
	public void setDurata(String durata){
            if(Elemento.isDoubleOrInt(durata)>=0)
		this.durata=durata;
	}
	
        /**
         * Ritorna la durata di un video.
         * 
         * @return 
         */
	public String getDurata(){
		return durata;
	}

        /**
         * Esegue un video.
         * 
         * Usa l'applicazione di default per aprire e eseguire un video.
         */
    @Override
       public void play() {
        File file = new File(this.getPercorso());
        try {
            java.awt.Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            
           NotificaFrame err = new NotificaFrame("Imporribile aprire il programma associato ai Video");
        }
    
    }

       /**
        * Ritorna il tipo di elemento.
        * 
        * @return AVI 
        */
    @Override
    public String getTipo() {
        return "AVI";
    }

    @Override
    public void stop() {
    }
    
}
