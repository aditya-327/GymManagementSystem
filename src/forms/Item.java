/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

/**
 *
 * @author User1
 */
public class Item {
    private int value;
	    private String label;

	   
                public Item(int value, String label)
                {
	    	this.value = value;
	        this.label = label;
		}

		public int getValue()
	    {
	        return this.value;
	    }

	    public String getLabel()
	    {
	        return this.label;
	    }

	    @Override
	    public String toString() {
	        return label;
	    }

    
}
