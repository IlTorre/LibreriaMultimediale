/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;



/**
 * Implementa il file chooser.
 * 
 * @author Marco
 */
public class MyFileChooser extends JFileChooser{
    private FileNameExtensionFilter filter;
    private JFileChooser chooser;
    private File selezionato = null;
    
    /**
     * Genera il file chooser.
     * In base al tipo di Elemento da aggiungere crea il filtro appropriato per filtrare le estensioni dei file.
     * 
     * @param tipo 
     */
    public MyFileChooser(int tipo){
        switch (tipo){
            case 1 : filter = new FileNameExtensionFilter("Brani mucicali supportati","mp3"); break;//filtro mp3
            case 2 : filter = new FileNameExtensionFilter("Video supportati","avi"); break;//filtro video
            case 3 : filter = new FileNameExtensionFilter("E-Book supportati","pdf"); break;//filtro pdf
        }
        chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
	    int returnVal = chooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       //System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
	       selezionato = chooser.getSelectedFile();
	       
	       }
    }
            
    /**
     * Ritorna il file selezionato
     * @return 
     */
     public File getFile(){
        return selezionato;
        }
       
        
}