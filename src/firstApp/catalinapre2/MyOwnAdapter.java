package firstApp.catalinapre2;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
//import android.widget.CompoundButton;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MyOwnAdapter extends ArrayAdapter<Model> {

	private final List<Model> list;
	private final Activity context;

	public MyOwnAdapter(Activity context, List<Model> list) {
		super(context, R.layout.listitemlayout, list);
		this.context = context;
		this.list = list;
	}

	static class ViewHolder {
		protected TextView text;
		protected SeekBar seekBar;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		if (convertView == null) {
			LayoutInflater inflator = context.getLayoutInflater();
			view = inflator.inflate(R.layout.listitemlayout, null);
			final ViewHolder viewHolder = new ViewHolder();
			viewHolder.text = (TextView) view.findViewById(R.id.label);
			viewHolder.seekBar = (SeekBar) view.findViewById(R.id.seek);
			final Model actual = list.get(position);
			viewHolder.seekBar.setMax(actual.getMaxQuantity());
			viewHolder.seekBar.setProgress(actual.getMaxQuantity());
			OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {

				@Override
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
					actual.setCurrentQuantity(progress);
					
				}

				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
				}

				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					actual.setCurrentQuantity(seekBar.getProgress());
					
				}};
			viewHolder.seekBar.setOnSeekBarChangeListener(listener);
			view.setTag(viewHolder);
			viewHolder.seekBar.setTag(list.get(position));
		} else {
			view = convertView;
			((ViewHolder) view.getTag()).seekBar.setTag(list.get(position));
		}
		ViewHolder holder = (ViewHolder) view.getTag();
		holder.text.setText(list.get(position).getName());
		return view;
	}
}