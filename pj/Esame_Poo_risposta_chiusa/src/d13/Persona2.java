package d13;


import java.util.*;

class Persona2 {
    private String nome;

    public Persona2(String nome) {
        this.nome = nome;
    }
    
    public String getNome(){
    	return this.nome;
    }

    public void setNome (String n) {
        nome = n;
    }

    public String toString(){
        return nome;
    }
    
    public boolean equals(Object o) {
  	Persona2 p = (Persona2)o;
      	return this.nome.equals(p.getNome());
      }
   
      public int hashCode(){
      return this.nome.hashCode();
    }
}