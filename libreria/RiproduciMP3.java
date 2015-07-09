/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package libreria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 * Implementa la riproduzione di un MP3.
 * @author Marco
 */
public class RiproduciMP3 extends Thread {
    
    private AdvancedPlayer pl;
    //private RiproduciMP3 rp = null;
    private FileInputStream in = null;
    private NotificaFrame notifica;
    private boolean riproduce;

    /**
     * Crea il file input stream e l'advance player necessari alla riproduzione.
     * e avvia il thread per la riproduzione.
     * @param percorso
     * @throws FileNotFoundException
     * @throws JavaLayerException
     * @throws IOException 
     */
    public RiproduciMP3(String percorso) throws FileNotFoundException, JavaLayerException, IOException{
    
        in = new FileInputStream(percorso);
        pl = new AdvancedPlayer(in);
        riproduce=false;
        this.start();
        
    }
   
    
   /**
    * Riproduce il brano attraverso l'advance player
    */
    @Override
    public void run()  {
        
           
        try {
            riproduce=true;
            pl.play();
        } catch (JavaLayerException ex) {
            notifica = new NotificaFrame("Errore: "+ex);
        }
        try {      
            pl.stop();
            in.close();
        } catch (IOException ex) {
            notifica = new NotificaFrame("Errore: "+ex);
        }
      
    }
    
    /**
     * Sospende la riproduzione del brano sospendendo il thread, se il tread 
     * è già sospeso le riavvia.
     */
    public void pausa(){
    if(riproduce){
        riproduce=false;
        this.suspend();
        
    }
    else{
    
        riproduce=true;
        this.resume();
    }
    }
    
    /**
     * Ferma la riproduzione e chiude il thread.
     */
        public void ferma(){
    this.stop();
    }
    

    
 
}
