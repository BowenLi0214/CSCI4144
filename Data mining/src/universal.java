import java.util.*;

public class universal {
	private static int i=-1;
	private static int j=-1;
	private static ArrayList<ArrayList<ArrayList<Double>>> weight;
	
	public static ArrayList<ArrayList<ArrayList<Double>>> getWeight() {
		return weight;
	}
	public static void setWeight(ArrayList<ArrayList<ArrayList<Double>>> weight) {
		universal.weight = weight;
	}
	public static ArrayList<ArrayList<Double>> getBias() {
		return bias;
	}
	public static void setBias(ArrayList<ArrayList<Double>> bias) {
		universal.bias = bias;
	}

	private static ArrayList<ArrayList<Double>> bias;
	private final double learningrate = 0.5;
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
					neuronweights.add(r.nextDouble()*1);
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
				neurons.add(r.nextDouble()*1);
			}
			layer2.add(neurons);
		}
		bias = layer2;
	}
	
	public void update(double result, double y, double[] w1, double[] w2) {
		double error=y-result;
		double minuserror=-error;
		double diffactivation=result*(1-result);
		//2nd layer bias update
		double newbias=bias.get(bias.size()-1).get(0)-learningrate*(-diffactivation*minuserror);
		bias.get(1).set(0,newbias);
		//1st layer bias update
		for (int i=0;i<13;i++){
			newbias=bias.get(0).get(i)-learningrate*(-diffactivation*minuserror*weight.get(1).get(0).get(i)*w2[i]*(1-w2[i]));
			bias.get(0).set(i,newbias);
		}
		//2nd layer weight update
		for (int i=0;i<13;i++){
			double newweight=weight.get(1).get(0).get(i)-learningrate*(diffactivation*minuserror*w2[i]);
			weight.get(1).get(0).set(i, newweight);
		}
		
		//1st layer weight update
		
		for (int i=0;i<13;i++){
			for (int j=0;j<13;j++){
				double newweight=weight.get(0).get(i).get(j)-learningrate*(diffactivation*minuserror*w2[i]*(1-w2[i])*weight.get(1).get(0).get(i)*w1[j]);
				weight.get(0).get(i).set(j, newweight);
			}
		}
	}
	
	public void SetIndexZero(){
		i = 0;
	}
}
