import java.util.*;

public class universal {
	private static int i=-1;
	private static int j=-1;
	private static ArrayList<ArrayList<ArrayList<Double>>> weight;
	private static ArrayList<ArrayList<Double>> bias;
	private final double learningrate=0.8;
	//level 1 = layer
	//level 2 = neuron
	//level 3 = previos weight
	
	public ArrayList<Double> getweight(){
		i++;
		if (i>13)
			return weight.get(i/13).get(0);
		return weight.get(i/13).get(i%13);
	}
	public double getbias(){
		j++;
		if (j>13)
			return bias.get(1).get(0);
		return bias.get(j/13).get(j%13);
	}
	public void initial(){
		i=0;
		Random r=new Random();
		int num=13;
		ArrayList<ArrayList<ArrayList<Double>>> layer=new ArrayList<ArrayList<ArrayList<Double>>>();
		for (int i=0;i<2 ;i++){
			ArrayList<ArrayList<Double>> neurons=new ArrayList<ArrayList<Double>>();
			if (i==1)
				num=1;
			for (int j=0; j<num; j++){
				ArrayList<Double> neuronweights=new ArrayList<Double>();
				for (int k=0;k<13;k++){
					neuronweights.add(r.nextDouble()*10);
				}
				neurons.add(neuronweights);
			}
			layer.add(neurons);
		}
		weight = layer;
		num=13;
		ArrayList<ArrayList<Double>> layer2=new ArrayList<ArrayList<Double>>();
		for (int i=0;i<2 ;i++){
			ArrayList<Double> neurons=new ArrayList<Double>();
			if (i==1)
				num=1;
			for (int j=0; j<num; j++){
				neurons.add(r.nextDouble()*10);
			}
			layer2.add(neurons);
		}
		bias = layer2;
	}
	public void update(double result, double y) {
		double error=y-result;
		double minuserror=-error;
		double diffactivation=result*(1-result);
		bias.get(bias.size()-1).set(0,bias.get(bias.size()-1).get(0)-learningrate*(-diffactivation*minuserror));
		
	}
	
}
