//Jacob Vargo
package race;
import java.util.LinkedList;

//must use synchronized methods only when it is necessary
//race is finished when all contestant have finished

class TimeKeeper{
	LinkedList<Contestant> finished = new LinkedList<Contestant>(); //queue of contestants who have finished in order of who finished first to last
	int[] seg_time; //segment time for each contestant
	int[] tot_time; //total time for each contestant
	int[] segments;
	int[] reported;
	int num_contestants;
	TimeKeeper(int num_cont){
		num_contestants = num_cont;
		seg_time = new int[num_contestants];
		tot_time = new int[num_contestants];
		segments = new int[num_contestants];
		reported = new int[num_contestants];
	}
	synchronized void print_score(){
		int i;
		System.out.printf("%n");
		for (i = 0; i < num_contestants; i++){
			System.out.printf("Contestant: %d Segments Completed: %d Time Completed: %d ms%n", i+1, segments[i], tot_time[i]);
			if (reported[i] == 1){
				System.out.printf("\tTime Taken: %d%n", seg_time[i]);
				reported[i] = 0;
			}
		}
	}
	void print_finish(){
		Contestant racer;
		while (finished.size() != 0){
			racer = finished.remove();
			System.out.printf("Contestant %d finished in %d ms%n", racer.num+1, racer.tot_time);
		}
	}
	synchronized void update_contestant(Contestant me, int time){
		tot_time[me.num] += time;
		seg_time[me.num] = time;
		segments[me.num]++;
		reported[me.num] = 1;
	}
	synchronized void update_finished(Contestant me){
		finished.addLast(me);
	}
	Boolean is_race_over(){
		if (finished.size() == num_contestants) return true;
		else return false;
	}
}