import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(bufferReader.readLine());
			Person[] data = new Person[n];
			for (int i=0;i<n;i++) {
				String[] sRecord = bufferReader.readLine().split(" ");
				Person record = new Person(Integer.parseInt(sRecord[0]),Integer.parseInt(sRecord[1]),Integer.parseInt(sRecord[2]));
				data[i] = record;
			}
			
			Arrays.sort(data, (x,y)->x.p-y.p);
			
			System.out.println(getMinTime(data));
		}
		catch (Exception excpt) {
			System.out.println(excpt);
		}
	}

	private static long getMinTime(Person[] data) {
		// TODO Auto-generated method stub
		long minTime = Long.MAX_VALUE;
		
		for (int c=0;c<=data[data.length-1].p;c++) {
			long time = getMoveTime(data, c);
			if (time<minTime) {
				minTime = time;
			}
		}
		return minTime;
	}

	private static long getMoveTime(Person[] data, int c) {
		// TODO Auto-generated method stub
		int sumOfTimes=0;
		for (Person record:data) {
			int time = getPersonMoveTime(record, c);
			sumOfTimes += time;
		}
		return sumOfTimes;
	}

	private static int getPersonMoveTime(Person record, int c) {
		// TODO Auto-generated method stub
		int distance = Math.abs(record.p - c);
		if (distance<=record.d) 
			return 0;
		int meters = distance-record.d;
		return meters*record.w;
	}

}

class Person {
	int p;
	int w;
	int d;
	
	public Person(int p, int w, int d) {
		this.p = p;
		this.w = w;
		this.d = d;
	}
}

