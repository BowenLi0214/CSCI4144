import java.util.ArrayList;

public class layer {
	
	private ArrayList<neuron> Neurons = new ArrayList<neuron>();
	private layer previousLayer;
	private layer nextLayer;
	
	public layer(double[] array,layer plLayer){
		
		setPreviousLayer(plLayer);
		for(int i=0;i<array.length;i++){
			//System.out.println(i);
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
	
	public void normalization(){
		normalization nm = new normalization();
		double nValueNormalized = 0;
		double resultNormalized = 0;
		double maxValue = 0;
		double secondMaxValue = 0;
		double thirdMaxValue = 0;
		double minValue = 0;
		
		if (Neurons.size() == 1) {
//			nValueNormalized = Neurons.get(0).getnValue();
//			nValueNormalized = nm.DoNormalize(nValueNormalized,0, 200, 0, 3);
//			Neurons.get(0).setnValue(nValueNormalized);
			
//			nValueNormalized = Neurons.get(0).getnValue();
//			int IntnValueNormalized = (int) nValueNormalized -1 ;
//			nValueNormalized = nValueNormalized - IntnValueNormalized;
//			nValueNormalized = nm.DoNormalize(nValueNormalized,0, 2, 0, 3);
//			Neurons.get(0).setnValue(nValueNormalized);
			
			nValueNormalized = Neurons.get(0).getnValue();
			nValueNormalized = nm.sigmoid(nValueNormalized);
			Neurons.get(0).setnValue(nValueNormalized);
			
		}
		
		else{
			for(int i=0; i<Neurons.size();i++){
				double nValue = Neurons.get(i).getnValue();
				if (nValue >= maxValue) {
					thirdMaxValue = secondMaxValue;
					secondMaxValue = maxValue;
					maxValue = nValue;
					
				}
				if (nValue <= minValue) {
					minValue = nValue;
				}
			}
			
			for(int i=0; i<Neurons.size();i++){
				nValueNormalized = Neurons.get(i).getnValue();
				nValueNormalized = nm.DoNormalize(nValueNormalized,0, maxValue, 0, 3);
				Neurons.get(i).setnValue(nValueNormalized);
			}
			
			
			
		}
		
	}
	
	public void normalizationSigmoid(){
		normalization nm = new normalization();
		double nValueNormalized = 0;
		
		for(int i=0; i<Neurons.size();i++){
			nValueNormalized = Neurons.get(i).getnValue();
			nValueNormalized = nm.sigmoid(nValueNormalized);
			Neurons.get(i).setnValue(nValueNormalized);
		}
		
	}
	
	public void makeResultZeroToOne(){
		double nValue = 0;
		normalization nm = new normalization();
		if (Neurons.size() == 1) {
			nValue = Neurons.get(0).getnValue();
			//nValue = nm.sigmoid(nValue);
			Neurons.get(0).setnValue(nValue);
		}
	}
	
	public double[] makeZeroToOne(){
		double[] W = new double[Neurons.size()];
		normalization nm = new normalization();
		
		for(int i=0; i<Neurons.size();i++){
			double nValue = Neurons.get(i).getnValue();
			//nValue = nm.sigmoid(nValue);
			W[i] = nValue;
		}
		return W;
	}
	
	public void makePredition(){
		double nValue = 0;
		if (Neurons.size() == 1) {
			nValue = Neurons.get(0).getnValue();
			int nValueInt = (int)nValue + 1;
			Neurons.get(0).setnValue((double)nValueInt);
		}
	}
	
	
}
