package p2;

public class ProvaMoltoBanale {

    private int a;
    private int b;
    
    public ProvaMoltoBanale(int a, int b)  {
        this.a = a;
        this.b = b;
    }

    public int somma() {
        // scrivere il codice di questo metodo affinche' ritorni a + b
    	return this.a+this.b;
    }

    public int moltiplicazione() {
        // scrivere il codice di questo metodo affinche' ritorni a * b
    	return this.a*this.b;
    }

    public int modulo() {
        // scrivere il codice di questo metodo affinche' ritorni a modulo b
    	return this.a%this.b;
    }
}
