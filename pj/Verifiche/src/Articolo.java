public class Articolo {
    private String titolo;

    public Articolo(String titolo) {
        this.titolo = titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public static void main(String[] argc) {
        Articolo[] articoli = new Articolo[3];
        Articolo a;
        Articolo b;
        
        a = new Articolo("AAAA");
        articoli[0] = a;
        a = new Articolo("BBBB");
        articoli[1] = a;
        articoli[0].setTitolo("CCCC");
        a = new Articolo("DDDD");
        b = a;
        a.setTitolo("EEEE");
        articoli[2] = b;
        for (Articolo articolo : articoli)
            System.out.print(articolo.getTitolo() + " ");
    }
}




