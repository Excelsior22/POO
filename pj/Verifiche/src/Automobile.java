public class Automobile {
    private String targa;
    
    public Automobile(String targa){
        this.targa = targa;
    }
    
    public String getTarga(){
        return this.targa;
    }
    
    public String cambiaTarga(String targa){
        String vecchiaTarga;
        vecchiaTarga = this.targa;
        this.targa = targa;
        return vecchiaTarga;
    }
    
    public static void main(String[] args) {
        Automobile a1 = new Automobile("0000");
        Automobile a2 = new Automobile("1111");

        a1 = a2;
        a1.cambiaTarga(a2.cambiaTarga("3333"));
        System.out.println(a1.getTarga());
        System.out.println(a2.getTarga());

        a2 = new Automobile("4444");
        a1.cambiaTarga(a2.cambiaTarga("5555"));
        System.out.println(a1.getTarga());
        System.out.println(a2.getTarga());
    }
}
