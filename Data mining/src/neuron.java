import java.util.ArrayList;
import java.util.Random;

public class neuron {
    private universal weight=new universal();
	private double nValue;
	private ArrayList<Double> weights;
	private ArrayList<Double> bias;
	private layer currentLayer;
	private ArrayList<Double> previousXi;
	
	public neuron(layer currentLayer, double nvalue){
		this.nValue = nvalue;
		
		weights=weight.getweight();
		bias = weight.getbias();
		this.currentLayer = currentLayer;
		previousXi = new ArrayList<Double>();
		if (currentLayer.getPreviousLayer()!=null){
			ArrayList<neuron> Neurons = currentLayer.getPreviousLayer().getNeurons();
			for(neuron singleNeuron : Neurons){
				previousXi.add(singleNeuron.getnValue());
			}
		}
	}
	
	
	public double getnValue() {
		return nValue;
	}
	public void setnValue(double nValue) {
		this.nValue = nValue;
	}
	public ArrayList<Double> getWeights() {
		return weights;
	}
	public void setWeights(ArrayList<Double> weights) {
		this.weights = weights;
	}
	public ArrayList<Double> getBias() {
		return bias;
	}
	public void setBias(ArrayList<Double> bias) {
		this.bias = bias;
	}
	
	
	public void calculateValue(){
		for(int i=0; i<weights.size(); i++){
//			System.out.println(i);
//			System.out.print("w: "+weights.get(i)+" ");
//			System.out.print("x: "+previousXi.get(i)+" ");
//			System.out.print("b: "+bias.get(i));
//			System.out.println("");
			
			nValue += weights.get(i) * 
					previousXi.get(i) + 
					bias.get(i);	
		}
	}
	
	public void updateWeightsAndBias(){
		
	}
	
	public void initialWeightsAndBias(){
	
		if (weights.size() < previousXi.size()) {
			Random r=new Random();
			for(int i = 0; i<previousXi.size(); i++){
				double w=r.nextInt(10)+1;
				System.out.print(w+" ");
				
				weights.add(w);
			}
			System.out.println("");
			
			for(int j = 0; j<previousXi.size(); j++){
				double b=r.nextInt(10)+1;
				bias.add(b);
			}
		}
		else{
			Random r=new Random();
			for(int i = 0; i<previousXi.size(); i++){
				double w=r.nextInt(10)+1;
				System.out.print(w+" ");
				weights.set(i, w);
			}
			System.out.println("");
			
			for(int j = 0; j<previousXi.size(); j++){
				double b=r.nextInt(10)+1;
				bias.set(j, b);
			}
		}
	}

}
