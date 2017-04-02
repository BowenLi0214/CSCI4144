import java.util.ArrayList;
import java.util.Random;

public class neuron {
    private universal weight=new universal();
	private double nValue;
	private ArrayList<Double> weights;
	private double bias;
	private layer currentLayer;
	private ArrayList<Double> previousXi;
	static int count=-1;
	static int num=0;
	public void reset(){
		count=-1;
		num=0;
	}
	public neuron(layer currentLayer, double nvalue){
		
		this.nValue = nvalue;
		if (num==14){
			
			count=-1;
			num=0;
		}
		count++;
		
		if (count>12){
			num++;
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
	public double getBias() {
		return bias;
	}
	public void setBias(double bias) {
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
					previousXi.get(i);
		}
		nValue+= bias;	
	}
	
	public void updateWeightsAndBias(){
		
	}
	
	
}
