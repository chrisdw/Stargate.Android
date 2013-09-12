package uk.org.downesward.stargate;

import java.io.IOException;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class KnownWorldSelectionActivity extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {

		Resources res = getResources();
		super.onCreate(savedInstanceState);
		AssetManager am = getAssets();
		
		try {
			String[] files = am.list("known worlds");
			
			ArrayAdapter<String> list = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, files);
			list.sort(String.CASE_INSENSITIVE_ORDER);
			this.setListAdapter(list);
			
		} catch (IOException e) {
			// Something is dying in real life - need to find out what.
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			
			builder.setMessage(e.getLocalizedMessage()).setTitle(res.getString(R.string.val_exception));
			builder.setPositiveButton(res.getString(R.string.val_ok),
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							// if this button is clicked, close
							// current activity
							KnownWorldSelectionActivity.this.finish();
						}
					});
			AlertDialog dialog = builder.create();
			dialog.show();
		}
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Bundle b = new Bundle();
		String item = (String) getListAdapter().getItem(position);
		b.putString("WORLD", item);
		Intent intent = this.getIntent();
		intent.putExtras(b);

		this.setResult(RESULT_OK, intent);
		finish();
	}
}
