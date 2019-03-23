

public class Persone {
    private String[] nomi;
    
    public Persone() {
        this.nomi = new String[5];
    }
    
    public void aggiungiNome(String nome, int indice) {
        this.nomi[indice] = nome;
    }
    
    public boolean verificaDuplicati(String nome) {
        int cont=0;
        for(int i=0;i<5;i++){
            if(nomi[i]!=null){
            if(nomi[i].equals(nome)){
                cont++;
            }
        }
        }
        if(cont>= 2){
            return true;
        }
        else{
            return false;
        }
    }

}
