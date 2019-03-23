package esercitazione_forme;

public class Mainforme {
	public static void main(String[] args) {
		
	Punto origine= new Punto(0,0);
	Cerchio cerUnitario= new Cerchio(origine,1);
	Rettangolo retBaseDoppia= new Rettangolo(origine,1,2);
	
	GruppoDiForme G1= new GruppoDiForme();
	
	System.out.println("Cerchio: "+ cerUnitario.getRaggio()+" "+ cerUnitario.getCentro().getX()+","+cerUnitario.getCentro().getY());
	System.out.println("Rettangolo: "+ retBaseDoppia.getAltezza()+" "+ retBaseDoppia.getBase()+" "+ retBaseDoppia.getVertice().getX()
			+","+retBaseDoppia.getVertice().getY());
	
	G1.aggiungiForma(retBaseDoppia);
	G1.aggiungiForma(cerUnitario);
	
	G1.getFigure()[0].trasla(1, 1);
	G1.getFigure()[1].trasla(2, 2);
	System.out.println("Cerchio: "+ cerUnitario.getRaggio()+" "+ cerUnitario.getCentro().getX()+","+cerUnitario.getCentro().getY());
	System.out.println("Rettangolo: "+ retBaseDoppia.getAltezza()+" "+ retBaseDoppia.getBase()+" "+ retBaseDoppia.getVertice().getX()
			+","+retBaseDoppia.getVertice().getY());
	
	G1.traslaGruppo(1, 1);
	
	System.out.println("Cerchio: "+ cerUnitario.getRaggio()+" "+ cerUnitario.getCentro().getX()+","+cerUnitario.getCentro().getY());
	System.out.println("Rettangolo: "+ retBaseDoppia.getAltezza()+" "+ retBaseDoppia.getBase()+" "+ retBaseDoppia.getVertice().getX()
			+","+retBaseDoppia.getVertice().getY());
	
		
	
	
	
	
	
	
	}
}
