import java.util.*;

public class universal {
	private static int i=-1;
	private static ArrayList<ArrayList<ArrayList<Double>>> weight;
	private static ArrayList<ArrayList<ArrayList<Double>>> bias;
	//level 1 = layer
	//level 2 = neuron
	//level 3 = previos weight
	
	public ArrayList<Double> getweight(){
		i++;
		//System.out.println("layer:"+i/13);
		return weight.get(i/13).get(i%13);
	}
	public ArrayList<Double> getbias(){
		
		return bias.get(i/13).get(i%13);
	}
	public void initial(){
		i=0;
		Random r=new Random();
		ArrayList<ArrayList<ArrayList<Double>>> layer=new ArrayList<ArrayList<ArrayList<Double>>>();
		for (int i=0;i<3 ;i++){
			ArrayList<ArrayList<Double>> neurons=new ArrayList<ArrayList<Double>>();
			for (int j=0; j<13; j++){
				ArrayList<Double> neuronweights=new ArrayList<Double>();
				for (int k=0;k<13;k++){
					neuronweights.add(r.nextDouble()*10);
				}
				neurons.add(neuronweights);
			}
			layer.add(neurons);
		}
		weight = layer;
		layer=new ArrayList<ArrayList<ArrayList<Double>>>();
		for (int i=0;i<3 ;i++){
			ArrayList<ArrayList<Double>> neurons=new ArrayList<ArrayList<Double>>();
			for (int j=0; j<13; j++){
				ArrayList<Double> neuronweights=new ArrayList<Double>();
				for (int k=0;k<13;k++){
					neuronweights.add(r.nextDouble()*10);
				}
				neurons.add(neuronweights);
			}
			layer.add(neurons);
		}
		bias = layer;
	}
	
}
