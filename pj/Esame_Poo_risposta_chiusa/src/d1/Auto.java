package d1;

public class Auto {
    private String targa;

    public Auto(String targa) {
        this.targa = targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getTarga() {
        return this.targa;
    }

    public static void main(String[] argc) {
        Auto[] automobili = new Auto[3];

        Auto a = new Auto("0000");
        automobili[0] = a;
        a.setTarga("1111");
        a = new Auto("2222");
        automobili[1] = a;
        Auto b;
        b = a;
        b.setTarga("3333");
        automobili[2] = b;
        for (Auto auto : automobili)
            System.out.print(auto.getTarga() + " ");
    }
}