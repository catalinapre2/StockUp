package firstApp.catalinapre2;


public class Model {

	private String name;
	private int max_quantity, current_quantity;

	public Model(String name, int max) {
		this.name = name;
		this.max_quantity = max;
		this.current_quantity = max;
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxQuantity() {
		return max_quantity;
	}
	
	public int getCurrentQuantity(){
		return current_quantity;
	}

	public void setMaxQuantity(int max) {
		this.max_quantity = max;
	}
	
	public void setCurrentQuantity(int c){
		this.current_quantity=c;
	}

}