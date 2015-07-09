/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package libreria;

import javax.swing.table.AbstractTableModel;

/**
 * Implementa il modello per visualizzare i campi comuni degli elementi nella tabella.
 * 
 * @author Marco
 */
public class MyTableModel extends AbstractTableModel{
    private MyLibreria lib;
    private final String [] intestazione ={"Tipo","Titolo","Autore","Anno"};
  
    
    
    public MyTableModel (MyLibreria lib){
            this.lib=lib;
           
    }

    @Override
    public int getRowCount() {
    
        return lib.size();
    }

    @Override
    public int getColumnCount() {
    
        return intestazione.length;
    }

    @Override
 public Object getValueAt(int row, int col) {
        Elemento temp = lib.get(row);
        
                
        
        switch (col){
            case 0 : return temp.getTipo();
            case 1 : return temp.getTitolo();
            case 2 : return temp.getAutore();
            case 3 : return (temp.getAnno());
        }
        return null;
    }
    @Override
 public boolean isCellEditable(int row, int col) { 
        
        return false; 
    }
    
    @Override
    public String getColumnName (int col){
        
        return (intestazione[col]);
        }
    
    public void aggiorna(){
    this.fireTableDataChanged();
    }
    
}
