import java.util.ArrayList;

public class layer {
	
	private ArrayList<neuron> Neurons = new ArrayList<neuron>();
	private layer previousLayer;
	private layer nextLayer;
	
	public layer(double[] array,layer plLayer){
		
		setPreviousLayer(plLayer);
		for(int i=0;i<array.length;i++){
			neuron n=new neuron(this,array[i]);
			Neurons.add(n);
		}
		
	}
	
	public layer getPreviousLayer() {
		return previousLayer;
	}

	public void setPreviousLayer(layer previousLayer) {
		this.previousLayer = previousLayer;
	}

	public layer getNextLayer() {
		return nextLayer;
	}

	public void setNextLayer(layer nextLayer) {
		this.nextLayer = nextLayer;
	}

	
	public ArrayList<neuron> getNeurons() {
		return Neurons;
	}
	
	public void calculateAllValues(){
		if (previousLayer != null) {
			for(int i=0; i<Neurons.size();i++){
				Neurons.get(i).calculateValue();
			}
		}
	}
	
	public void initialAllWeightsAndBias(){
		for(int i=0; i<Neurons.size();i++){
			Neurons.get(i).initialWeightsAndBias();
		}
	}
	

	
	
	
}
