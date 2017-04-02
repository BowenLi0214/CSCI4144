import java.io.FileNotFoundException;
import java.util.*;

import com.sun.javafx.scene.layout.region.LayeredBackgroundPositionConverter;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class main {
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
		
//		for (int i=0; i<xtrain.size(); i++){
//			for (int j=0; j<xtrain.get(i).length; j++){
//				System.out.print(xtrain.get(i)[j]+"\t");
//			}
//			
//			System.out.println(ytrain.get(i));
//		}
		
		train(xtrain,ytrain);
		
	}
	
	public static void train(ArrayList<double[]> xtrain,ArrayList<Double> ytrain){
		double[] intialarray = new double[xtrain.get(0).length];
		double[] resultArray = new double[1];
				
		for (int i=0; i<xtrain.get(0).length;i++){
			intialarray[i]=0;
		}
		for (int i=0;i<xtrain.size();i++){
			universal uni=new universal();
			uni.initial();
			System.out.println("time: "+i);
			layer layer=new layer(xtrain.get(i),null);	
			
			printLayer(layer,1);
			System.out.println("");
			
			layer layer2 = new layer(intialarray,layer);
			layer2.calculateAllValues();
			printLayer(layer2,2);
			System.out.println("");
			
			layer layer3 = new layer(resultArray,layer2);
			layer3.calculateAllValues();
			printLayer(layer3,3);
			double result=layer3.getNeurons().get(0).getnValue();
			uni.update(result,ytrain.get(i));
			System.out.println("");
			
		}
		
		
	}
	
	public static void printLayer(layer clayer,int layerIndex){
		for (int j=0;j<clayer.getNeurons().size();j++){
			System.out.print("layer "+layerIndex+"    ");
			System.out.print(clayer.getNeurons().get(j).getnValue()+" ");
		}
	}
}


