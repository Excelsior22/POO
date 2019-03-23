package d21;

class Auto {
    private int cilindrata = 0;

    public Auto(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public int getCilindrata() {
        return this.cilindrata;
    }
}

class Officina {
    public void cambiaCilindrata(Auto auto, int nuovaCilindrata) {
        auto.setCilindrata(nuovaCilindrata);
    }
}

public class Quiz {
    public static void main(String[] args) {
        Officina officina = new Officina();
        Auto piccola = new Auto(2000);
        Auto grande = piccola;

        System.out.print(grande.getCilindrata()+" ");
        System.out.print(piccola.getCilindrata()+" ");
        System.out.print(". ");

        officina.cambiaCilindrata(grande, 1500);
        System.out.print(grande.getCilindrata()+" ");
        System.out.print(piccola.getCilindrata()+" ");
        System.out.print(". ");

        officina.cambiaCilindrata(piccola, 1000);
        System.out.print(grande.getCilindrata()+" ");
        System.out.print(piccola.getCilindrata()+" ");
    }
}