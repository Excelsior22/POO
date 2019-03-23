package p2;

public class Media2ElementiArray {

	public static double mediaArray(double[] a){
		double somma = 0;
		double media;

		for(int i=0; i<a.length;i++){
			somma += a[i];
		}
		media = somma/(a.length);
		return media;
	}
	public static void main(String[] args){

		double[] a = new double[] {1,2,3,4,5,6,7,8,9,10};
		System.out.println(mediaArray(a));
	}
}