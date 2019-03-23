/* obiettivo: verificare comprensione dettagli ereditarieta'

	- leggere attentamente il codice
	- che cosa stampa il programma se eseguito
	- perche' ?
	- compilare ed eseguire il programma per verificare
	  la propria risposta
*/

class Velivolo {
        public String motore() {
			return "Velivolo-motore";
		}

        public String tipologia() {
			return "Velivolo-tipologia";
		}

        public String toString() {
			return "Velivolo";
		}
}

public class Elicottero extends Velivolo  {
        public String motore() {
			return "Elicottero-motore";
		}

        public String toString() {
                return motore()+" "+super.motore()+" "+this.tipologia();
        }

        public static void main(String argv[]) {
				Velivolo v = new Elicottero();
                System.out.println(v.toString());
        }
}

//Elicottero-motore Velivolo-motore Velivolo-tipologia 