//Jacob Vargo
package race;
import java.util.Random;

class SynchronizedRandom{
	Random rand = new Random();
	int nextInt(){
		//generate random number between 1000 - 8000
		return rand.nextInt(7000)+1000;
	}
}