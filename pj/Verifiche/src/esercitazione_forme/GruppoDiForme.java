package esercitazione_forme;

public class GruppoDiForme {
	private Forma[] figure= new Forma[10];
	int i=0;
	
	
	
	void trasla(Cerchio cerchio, int deltaX, int deltaY) {
		cerchio.trasla(deltaX, deltaY);
	}
	
	void trasla(Rettangolo rettangolo, int deltaX, int deltaY) {
		rettangolo.trasla(deltaX, deltaY);
	}
	
	void traslaGruppo(int deltaX, int deltaY) {
		int v=0;
		while(figure[v]!=null) {
			figure[v].trasla(deltaX, deltaY);
			v++;
		}
	}

	void aggiungiForma(Forma forma) {
		if( i<=10) {
			figure[i]=forma;
			i++;
		}
		else
			System.out.println("Limite raggiunto!");
	}
	
	public Forma[] getFigure() {
		return figure;
	}


}
