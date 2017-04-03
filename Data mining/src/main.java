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
			if (count<8){
				
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

		for(int i=0; i<100; i++){
			train(xtrain,ytrain);
		}
		
		
		predict(xtest,ytest);
		
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
			
			//System.out.println("");
			//System.out.println("time: "+i);
			layer layer=new layer(xtrain.get(i),null);	
			//printLayer(layer,1);
			layer.normalizationSigmoid();
			double w1[] = layer.makeZeroToOne();
			//System.out.println("");
			//System.out.println("w1: "+Arrays.toString(w1));
			
			layer layer2 = new layer(intialarray,layer);
			layer2.calculateAllValues();
			layer2.normalizationSigmoid();
			double w2[] = layer2.makeZeroToOne();
			//printLayer(layer2,2);
			
			//System.out.println("");
			//System.out.println("w2: "+Arrays.toString(w2));
			
			layer layer3 = new layer(resultArray,layer2);
			layer3.calculateAllValues();
			layer3.normalizationSigmoid();
			
			
			//printLayer(layer3,3);
			double result=layer3.getNeurons().get(0).getnValue();
			
			normalization nm = new normalization();
			uni.update(result,ytrain.get(i), w1, w2);
			//System.out.println("");
			
		}
		
		
	}
	
	public static void predict(ArrayList<double[]> xtest,ArrayList<Double> ytest){
		double[] intialarray = new double[xtest.get(0).length];
		double[] resultArray = new double[1];
		
		double fit = 0;
				
		for (int i=0; i<xtest.get(0).length;i++){
			intialarray[i]=0;
		}
		for (int i=0;i<xtest.size();i++){
			universal uni=new universal();
			//uni.initial();
			
			//System.out.println("");
			//System.out.println("time: "+i);
			uni.SetIndexZero();
			layer layer=new layer(xtest.get(i),null);	
			layer.normalizationSigmoid();;
			printLayer(layer,1);
			
			System.out.println("");
			//System.out.println("w1: "+Arrays.toString(w1));
			
			layer layer2 = new layer(intialarray,layer);
			layer2.calculateAllValues();
			layer2.normalizationSigmoid();;
			
			printLayer(layer2,2);
			
			System.out.println("");
			//System.out.println("w2: "+Arrays.toString(w2));
			
			layer layer3 = new layer(resultArray,layer2);
			layer3.calculateAllValues();
			//layer3.normalization();
			
			ArrayList<Double> w = layer3.getNeurons().get(0).getWeights();
			System.out.println("w: "+w);
			
			printLayer(layer3,3);
			double result=layer3.getNeurons().get(0).getnValue();
			
			System.out.println("class: "+ytest.get(i));
			System.out.println("");
			System.out.println("");
			
			fit += Math.abs(result - ytest.get(i));
		}
		
		System.out.println("fit: "+fit);
	}
	
	public static void printLayer(layer clayer,int layerIndex){
		System.out.print("layer "+layerIndex+"    ");
		for (int j=0;j<clayer.getNeurons().size();j++){
			System.out.print(clayer.getNeurons().get(j).getnValue()+" ");
		}
	}
}


