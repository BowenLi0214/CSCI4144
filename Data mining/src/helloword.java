import java.io.FileNotFoundException;
import java.util.*;

public class helloword {
	public static void main(String [] args) throws FileNotFoundException{

		OpenOB trainingData = new OpenOB();
		trainingData.loadDB();
		
		
		ArrayList<double[]> xtrain = new ArrayList<double[]>();
		ArrayList<Double> ytrain = new ArrayList<Double>();
		
		ArrayList<double[]> xtest = new ArrayList<double[]>();
		ArrayList<Double> ytest = new ArrayList<Double>();
		
		Random r=new Random();
		for (int i=0; i<trainingData.lines.length; i++){
			int count=r.nextInt(10)+1;
			if (count>7){
				
				double temparray[]=new double[trainingData.lines[i].length-1];
				double tempy=-1;
				for (int j=0; j<trainingData.lines[i].length;j++){
					if (j!=0){
						double temp = Double.parseDouble(trainingData.lines[i][j]);
						temparray[j-1]=temp;
					}
					else{
						tempy=Double.parseDouble(trainingData.lines[i][j]);
					}
				}
				xtrain.add(temparray);
				ytrain.add(tempy);
			}
			else{
				double tempy=-1;
				double temparray[]=new double[trainingData.lines[i].length-1];
				for (int j=0; j<trainingData.lines[i].length;j++){
					if (j!=0){
						double temp = Double.parseDouble(trainingData.lines[i][j]);
						temparray[j-1]=temp;
					}
					else{
						tempy=Double.parseDouble(trainingData.lines[i][j]);
					}
				}
				xtest.add(temparray);
				ytest.add(tempy);
			}
		}
		for (int i=0; i<xtrain.size(); i++){
			for (int j=0; j<xtrain.get(i).length; j++){
				System.out.print(xtrain.get(i)[j]+"\t");
			}
			
			System.out.println(ytrain.get(i));
		}
		
	}
}


