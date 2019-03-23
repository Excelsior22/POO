import java.util.List;

public class mainCatLib {
	public static void main(String[] args) {
		
		Libro l1= new Libro("a",100);
		Libro l2= new Libro("b",200);
		Libro l3= new Libro("c",50);
		Libro l4= new Libro("d",100);
		Libro l5= new Libro("e",50);                          //Output desiderato: c e a d b 
		CatalogatoreLibri cat= new CatalogatoreLibri();
		cat.aggiungiLibro(l1);;
		cat.aggiungiLibro(l2);
		cat.aggiungiLibro(l3);
		cat.aggiungiLibro(l4);
		cat.aggiungiLibro(l5);
		 
		List<Libro> lista= cat.elencoOrdinatoPerPagineISIN();
		for(Libro elem: lista) {
			System.out.println(elem.getCodiceISIN()+ " "+ elem.getNumeroPagine());
		}
		
	}

}
