public class CalcolatoreMedia {
    
    public CalcolatoreMedia() {}
    
    public double calcolaMedia(int[] sequenza) {
        int v=0;
        double somma=0;
       
        for(int seq: sequenza){
            somma+= seq;
            v++;
        }
        return somma/v;
    }
}