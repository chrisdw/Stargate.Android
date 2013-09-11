package uk.org.downesward.stargate;

import uk.org.downesward.utiliites.Dice;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class PlotGeneratorActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.plotgenerator);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.plotgenerator, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.mnuGenerate) {
			// Generate a plot
			generatePlot();
		} else {
			return super.onOptionsItemSelected(item);
		}
		return true;
	}	
	
	private void generatePlot() {
		SQLiteDatabase db = null;
		try
		{
			DatabaseHelper dbh = new DatabaseHelper(this);
			db = dbh.getReadableDatabase();
			// Plot type
			Cursor res = db.rawQuery("SELECT BaseId, PlotType, Description FROM PlotType", null);
			Dice die = new Dice(res.getCount());
			int row = die.roll();
			if (res.moveToPosition(row)) {
				TextView tv = (TextView) this.findViewById(R.id.txtPlotType);
				tv.setText(res.getString(1));
				tv = (TextView) this.findViewById(R.id.txtPlotTypeDesc);
				tv.setText(res.getString(2));
			}
			// Hook
			res = db.rawQuery("SELECT BaseId, Hook, Description FROM Hook", null);
			die = new Dice(res.getCount());
			row = die.roll();
			if (res.moveToPosition(row)) {
				TextView tv = (TextView) this.findViewById(R.id.txtHook);
				tv.setText(res.getString(1));
				tv = (TextView) this.findViewById(R.id.txtHookDesc);
				tv.setText(res.getString(2));
			}
		}
		catch (Throwable e) {
			// Something is dying in real life - need to find out what.
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(e.getLocalizedMessage())
		       .setTitle(db.getPath());
			builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, close
					// current activity
					PlotGeneratorActivity.this.finish();
				}
			  });		
			AlertDialog dialog = builder.create();
			dialog.show();
		}
	}
}
