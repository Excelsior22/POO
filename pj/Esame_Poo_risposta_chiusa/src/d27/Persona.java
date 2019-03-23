package d27;

public class Persona {
    private String nome;

    public Persona(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }


    public static void main(String args[]) {
        Persona[] aula = new Persona[10];
        Persona p1 = new Persona("marco");

        aula[0] = p1;
        
        aula[1] = new Persona("giovanni");
        
        //p1.setNome("ambrogio");
        
        aula[2] = new Persona("luigi");
       
        aula[3] = new Persona("Luca");

        aula[4] = new Persona("franco");
        Persona docente = new Persona("franco");
        p1.setNome("ambrogio");
        for(int i = 0; i<5; i++)
        	
                System.out.println(aula[i].getNome()+" ");
     }
}