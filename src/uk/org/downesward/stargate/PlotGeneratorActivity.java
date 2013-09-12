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
	
	private DatabaseHelper db;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.plotgenerator);
		
		db = new DatabaseHelper(this); 
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
		try
		{
			
			// Hook
			Cursor res = db.getHooks();
			Dice die = new Dice(res.getCount());
			int row = die.roll();
			if (res.moveToPosition(row)) {
				TextView tv = (TextView) this.findViewById(R.id.txtHook);
				tv.setText(res.getString(1));
				tv = (TextView) this.findViewById(R.id.txtHookDesc);
				tv.setText(res.getString(2));
			}
			
			// Goal
			res = db.getGoals();
			die = new Dice(res.getCount());
			row = die.roll();
			if (res.moveToPosition(row)) {
				TextView tv = (TextView) this.findViewById(R.id.txtGoal);
				tv.setText(res.getString(1));
				tv = (TextView) this.findViewById(R.id.txtGoalDesc);
				tv.setText(res.getString(2));
			}
			
			// Plot type
			res = db.getPlots();
			die = new Dice(res.getCount());
			row = die.roll();
			if (res.moveToPosition(row)) {
				TextView tv = (TextView) this.findViewById(R.id.txtPlotType);
				tv.setText(res.getString(1));
				tv = (TextView) this.findViewById(R.id.txtPlotTypeDesc);
				tv.setText(res.getString(2));
			}
			
			// Setting
			
			// NPC
			
			// Location
			
			// Encounters
			
			// Climax

		}
		catch (Throwable e) {
			// Something is dying in real life - need to find out what.
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage(e.getLocalizedMessage())
		       .setTitle("Exception");
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
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		db.close();
	}
}
