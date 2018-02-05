//Jacob Vargo
package race;
import java.lang.Thread;

public class Race{
	static public void main(String args[]){
		int i, num;
		num = Integer.parseInt(args[0]);
		TimeKeeper timer = new TimeKeeper(num);
		Reporter report = new Reporter(timer);
		report.start();
		SynchronizedRandom rand = new SynchronizedRandom();
		Contestant[] racers = new Contestant[num];
		for (i = 0; i < num; i++){
			racers[i] = new Contestant(timer, rand, i);
			racers[i].start();
		}
	}
}