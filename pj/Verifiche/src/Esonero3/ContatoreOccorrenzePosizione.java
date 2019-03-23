package Esonero3;

public class ContatoreOccorrenzePosizione {

    public int[] contaOccorrenze(String[] sequenza, String[] daControllare) {        
        //Implementare questo metodo di modo
        //che restituisca l'array contentente le occorrenze
        //delle parole da controllare
        
        int[] array_occ;
        int lunghezza= daControllare.length;
        array_occ= new int[lunghezza];
        int i=0;
        int same;
        for(String a: daControllare){
            same=0;
            for(String b: sequenza){
                if(a.equals(b))
                same++;
            }
            array_occ[i]=same;
            i++;
        }
        return array_occ;
    }
}
