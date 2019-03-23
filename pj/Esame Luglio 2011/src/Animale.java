
public abstract class Animale {

	private int anni;
	private int forza;
	private Posizione posizione;

	private int livelloCibo;
	
	public Animale(int forza){
		this.forza = forza;
		this.livelloCibo = 2;
		this.anni = 0;
	}
	public void setPosizione(Posizione posizione){
		this.posizione = posizione;
	}

	public Posizione getPosizione() {
		return this.posizione;
	}
	
	public int getForza() {
		return this.forza;
	}
	
	public int getAnni() {
		return this.anni;
	}
	
	public boolean isMorto(){
		return (this.livelloCibo==0)||(this.anni==5);
	}
	
	public void incrementaAnni(){
		this.anni ++;
	}
	
	public void incrementaCibo(int cibo){
		this.livelloCibo+=cibo;
	}
	
	public abstract void agisci(Territorio territorio) ;
	


}
