import java.util.ArrayList;

public class neuron {

	private double nValue;
	private ArrayList<Double> weights;
	private ArrayList<Double> bias;
	private layer currentLayer;
	private ArrayList<Double> previousXi;
	
	public neuron(layer currentLayer){
		this.nValue = 0;
		this.weights = new ArrayList<Double>();
		this.bias = new ArrayList<Double>();
		this.currentLayer = currentLayer;
		previousXi = new ArrayList<Double>();
		
		ArrayList<neuron> Neurons = currentLayer.getPreviousLayer().getNeurons();
		for(neuron singleNeuron : Neurons){
			previousXi.add(singleNeuron.getnValue());
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
			nValue += weights.get(i) * previousXi.get(i) + bias.get(i);
		}
	}
	
	public void updateWeightsAndBias(){
		
	}

}
