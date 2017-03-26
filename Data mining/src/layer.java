import java.util.ArrayList;

public class layer {
	
	private ArrayList<neuron> Neurons = new ArrayList<neuron>();
	private layer previousLayer;
	private layer nextLayer;
	
	public layer(int num){
		
		for(int i=0;i<num;i++){
			neuron n=new neuron(this);
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
	

	
	
	
}
