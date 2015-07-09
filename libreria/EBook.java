/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package libreria;

import java.io.File;
import java.io.IOException;

/** Implementa un E-Book.
 *
 * @author Marco
 */
public class EBook extends Elemento{

    private String npagine;
	/**
         * Implementa la struttura di un E-Book.
         * 
         * @param titolo
         * @param autore
         * @param anno
         * @param npagine
         * @param percorso 
         */
	public EBook(String titolo, String autore, String anno, String npagine, String percorso){
		super.setTitolo(titolo);
		super.setAutore(autore);
		super.setAnno(anno);
		this.setNPagine(npagine);
		super.setPercorso(percorso);
	}
	
        /**
         * Setta in numero di pagine.
         * @param npagine 
         */
	public void setNPagine(String npagine){
            if(Elemento.isDoubleOrInt(npagine)==0)
		this.npagine=npagine;
	}
	
        /**
         * Ritorna il numero di pagine.
         * 
         * @return 
         */
	public String getNPagine(){
		return npagine;
	}
    
        /**
         * Esegue un E-Book.
         * 
         * Usa l'applicazione di default per aprire e visualizzare un E-Book.
         */
    @Override
        public void play() {
        File file = new File(this.getPercorso());
        try {
            java.awt.Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            
           NotificaFrame err = new NotificaFrame("Imporribile aprire il programma associato ai PDF");
        }
    
    }

    /**
     * Ritorna il tipo di Elemento
     * @return PDF
     */
    @Override
    public String getTipo() {
    
        return "PDF";
    }

    @Override
    public void stop() {
       
    }
    
    
}
