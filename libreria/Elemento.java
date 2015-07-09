package libreria;

import java.io.Serializable;
/**
 * Implementa un elemento generico della libreria.
 * @author Marco
 */
public abstract class Elemento implements Serializable{
	private String titolo, autore, percorso, anno;

	
	public void setTitolo(String titolo){
		this.titolo=titolo;
	}
	
	public void setAutore(String autore){
		this.autore=autore;
	}
	
	public void setPercorso(String percorso){
		this.percorso=percorso;
	}
	

        
/**
 * Verifica se una stringa è un numero (double o int).
 * @param num
 * @return -1 se non è una stringa valida,
 * 0 se è un int, 1 se è un double
 */
public static int isDoubleOrInt(String num){
  try{
    Integer.parseInt(num);
    return 0;
  }catch(Exception e){
    try{
      Double.parseDouble(num);
      return 1;
    }catch(Exception e2){
      return -1;
    }
  }
}

	public void setAnno(String anno){
            if (isDoubleOrInt(anno)==0)
            		this.anno=anno;
	}
	
	public String getTitolo(){
		return titolo;
	}
	
	public String getAutore(){
		return autore;
	}
	
	public String getPercorso(){
		return percorso;
	}
	
	public String getAnno(){
		return anno;
	}
        
        abstract public  String getTipo();
	
	abstract public void play();
        abstract public void stop();

     
}