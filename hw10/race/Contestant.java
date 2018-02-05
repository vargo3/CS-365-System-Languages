//Jacob Vargo
package race;
import java.lang.Thread;

class Contestant extends Thread{
	TimeKeeper timer;
	SynchronizedRandom rand;
	int num, tot_time;
	Contestant(TimeKeeper time, SynchronizedRandom random, int id){
		timer = time;
		rand = random;
		num = id;
		tot_time = 0;
	}
	public void run(){
		int i, segtime;
		for (i = 0; i < 4; i++){
			segtime = rand.nextInt();
			try{
				Thread.sleep(segtime);
			} catch (InterruptedException e){
				System.out.println("Interrupted\n");
			}
			tot_time += segtime;
			timer.update_contestant(this, segtime);
		}
		timer.update_finished(this);
	}
}