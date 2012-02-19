			
package firstApp.catalinapre2;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;

public class MyList extends ListActivity {

	
/** Called when the activity is first created. */

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		// Create an array of Strings, that will be put to our ListActivity
		List<Model> list = getModel();
		MyOwnAdapter adapter = new MyOwnAdapter(this, list);
		setListAdapter(adapter);
		
	}

	private List<Model> getModel() {
		List<Model> list = new ArrayList<Model>();
		list.add(get("Corona",24));
		list.add(get("Sol",12));
		list.add(get("Becks",12));
		list.add(get("Peroni",12));
		list.add(get("Red Stripe",12));
		list.add(get("Budweiser",20));
		list.add(get("Miller",15));
		list.add(get("Desperados",15));
		list.add(get("Tiger",15));
		return list;
	}

	private Model get(String s, int q) {
		return new Model(s,q);
	}

}
