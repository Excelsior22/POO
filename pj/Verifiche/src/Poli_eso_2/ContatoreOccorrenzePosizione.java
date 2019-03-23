package Poli_eso_2;

public class ContatoreOccorrenzePosizione {

    public int[] contaOccorrenze(String[] sequenza, String[] daControllare) {        
        //Implementare questo metodo di modo
        //che restituisca l'array contentente le occorrenze
        //delle parole da controllare
        int lunghezza= daControllare.length;
        int[] output= new int[lunghezza];
        int i=0;
        int occorenze;
        
        for(String controllare: daControllare){
            occorenze=0;
            for(String seq: sequenza){
                if(controllare.equals(seq))
                occorenze++;
            }
        output[i]= occorenze;
        i++;
        }
        return output;
    }
}
