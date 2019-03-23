package Poli_eso_2;

public class Persone {
    private String[] nomi;
    
    public Persone(int numeroPersone) {
        this.nomi = new String[numeroPersone];
    }
    
    public void aggiungiNome(String nome, int indice) {
        this.nomi[indice] = nome;
    }
    
    public boolean verificaDuplicati(String nome) { 
        int uguali=0;
        
        for(String persona: nomi){
            if(persona==nome){
                uguali++;
            }
            if(uguali==2){
                return true;
            }
        }
        return false;
    }

}