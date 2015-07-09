/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package libreria;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;



/**
 * Implementa il file chooser.
 * 
 * @author Marco
 */
public class MyFolderChooser extends JFileChooser{

    private JFileChooser chooser;
    private File cartella = null;
    private File []files;
    private int tipo;
    
    /**
     * Genera il folder chooser.
     * In base al tipo di file che si vuole aggiungere seleziona i file 
     * della data estensione e li aggiunge alla libreria.
     * 
     * @param tipo 1 musica, 2 video, 3 pdf
     * @param lib
     * @param modello
     * @param parent
     */
    public MyFolderChooser(int tipo,MyLibreria lib,MyTableModel modello,java.awt.Frame parent){
        this.tipo=tipo;
        chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String ext="";
        switch (tipo){
            case 1 : ext=".mp3"; break;
            case 2 : ext=".avi"; break;
            case 3 : ext=".pdf"; break;
        }
        
	    int returnVal = chooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       //System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
	       cartella = chooser.getSelectedFile();
	       files = cartella.listFiles();
               DialogModifica vis;
               for(int i=0;i<files.length;i++)
                   if (ext.equals(getEstensioneFile(files[i].getName())))
                    switch (tipo){
                        case 1 : lib.creaBrano("", "", "", "", "", files[i].getAbsolutePath());  vis = new DialogModifica(lib, lib.size()-1, modello, parent, true); break;
                        case 2 : lib.creaVideo("", "", "", "",files[i].getAbsolutePath()); vis = new DialogModifica(lib, lib.size()-1, modello, parent, true); break;
                        case 3 : lib.creaEBook("", "", "", "", files[i].getAbsolutePath()); vis = new DialogModifica(lib, lib.size()-1, modello, parent, true); break;
                        }
                   
	       }
    }
    
    /**
     * Ritorna l'estensione di un file (es .mp3) oppure cartella se è una cartella.
     * 
     * @param nomeFile
     * @return 
     */
    private String getEstensioneFile(String nomeFile){
        if (nomeFile.contains("."))
        return nomeFile.substring(nomeFile.lastIndexOf("."));
        else
            return"cartella";
    }
            
 
       
        
}