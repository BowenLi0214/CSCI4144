import java.io.FileNotFoundException;
import java.util.*;

public class helloword {
	public static void main(String [] args) throws FileNotFoundException{

		OpenOB trainingData = new OpenOB();
		trainingData.loadDB();
		trainingData.showDB();
		
		ArrayList<Double> xtrain = new ArrayList<Double>();
		ArrayList<Double> ytrain = new ArrayList<Double>();
		
		ArrayList<Double> xtest = new ArrayList<Double>();
		ArrayList<Double> ytest = new ArrayList<Double>();
		
		Scanner r=new Scanner(System.in);
		r.nextInt();
		
		
	}
}


