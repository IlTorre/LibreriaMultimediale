/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package libreria;

import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;

/** Brano Musicale.
 * 
 * Implementa la struttua di un brano musicale.
 *
 * @author Marco
 */
public class BranoMusicale extends Elemento {
private String durata;
private String frequenza;
private RiproduciMP3 rp;
private boolean inriproduzione;
private boolean attivo ;

/** Crea il brano musicale.
 * 
 * @param titolo identifica il titolo del brano.
 * @param autore identifica l'autore del brano.
 * @param anno identifica l'anno del brano.
 * @param durata identifica la durata del brano.
 * @param frequenza identifica la frequenza del brano.
 * @param percorso identifica la posizione del brano nel filesystem.
 */
public BranoMusicale(String titolo, String autore, String anno, String durata, String frequenza, String percorso){
		super.setTitolo(titolo);
		super.setAutore(autore);
		super.setAnno(anno);
		this.setDurata(durata);
		this.setFrequenza(frequenza);
		super.setPercorso(percorso);
                inriproduzione=false;
                attivo=false;
	}

    /** Imposta la durata del Brano Musicale.
     *
     * @param durata
     */
    public void setDurata(String durata){
        if(Elemento.isDoubleOrInt(durata)>=0)
		this.durata=durata;
	}
	/** Imposta la frequenza del Brano Musicale.
         * 
         * @param frequenza 
         */
	public void setFrequenza(String frequenza){
            if(Elemento.isDoubleOrInt(frequenza)>=0)
		this.frequenza=frequenza;
	}
	
        /**Ritorna la durata del Brano Musicale.
         * 
         * @return durata
         */
	public String getDurata(){
		return durata;
	}
	/**Ritorna la frequenza del Brano Musicale.
         * 
         * @return frequenza
         */
	public String getFrequenza(){
		return frequenza;
	}

    @Override
    /** Implementa la riproduzione.
     * 
     * Riproduce in background il brano musicale, se già in riproduzione lo mette in pausa.
     * 
     */
    public void play() {
        attivo=true;
       
   if (!inriproduzione){
    try {        
        rp = new RiproduciMP3(this.getPercorso());
        inriproduzione=true;
    } catch (JavaLayerException | IOException ex) {
        NotificaFrame notifica = new NotificaFrame("Errore: "+ex);
    }
   }
   else rp.pausa();
       
    }
    
 
 
/**Ritorna il tipo di elemento.
 * 
 * @return mp3
 */
    @Override
    public String getTipo() {
        return "MP3";
    }

    @Override
    /** Ferma la riproduzione.
     * 
     */
    public void stop() {
    
        if (attivo)
            rp.ferma();
            rp=null;
            inriproduzione=false;
            attivo=false;
    }
    
}
