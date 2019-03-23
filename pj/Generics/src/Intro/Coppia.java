package Intro;

public class Coppia<T> {
	
	private T primo;
	private T secondo;
	
	public Coppia(T primo,T secondo) {
		this.primo= primo;
		this.secondo= secondo;
	}
	
	public T getPrimo() {
		return primo;
	}

	public void setPrimo(T primo) {
		this.primo = primo;
	}

	public T getSecondo() {
		return secondo;
	}

	public void setSecondo(T secondo) {
		this.secondo = secondo;
	}
}
