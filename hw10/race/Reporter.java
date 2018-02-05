//Jacob Vargo
package race;
import java.lang.Thread;

class Reporter extends Thread{
	TimeKeeper timer;
	Reporter(TimeKeeper mytimer){
		timer = mytimer;
	}
	public void run(){
		while(!timer.is_race_over()){
			timer.print_score();
			try{
				Thread.sleep(2000);
			} catch (InterruptedException e){
				System.out.println("Interrupted\n");
			}
		}
		timer.print_score();
		timer.print_finish();
	}
}