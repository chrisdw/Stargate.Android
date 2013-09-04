package uk.org.downesward.stargate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TabHost;
import android.widget.TextView;

import com.lamerman.FileDialog;
import com.lamerman.SelectionMode;

public class WorldViewerActivity extends TabActivity {
	
	private static final int REQUEST_SAVE = 0;
	private static final int REQUEST_OPEN = 1;
	private World world;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.worldviewer);

		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Resusable TabSpec for each tab

		// Initialize a TabSpec for each tab and add it to the TabHost
		spec = tabHost
				.newTabSpec("Thermosphere")
				.setIndicator("Thermosphere",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabThermos);
		tabHost.addTab(spec);

		spec = tabHost
				.newTabSpec("atmosphere")
				.setIndicator("Atmosphere",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabAtmosphere);
		tabHost.addTab(spec);
		
		spec = tabHost
				.newTabSpec("hydrosphere")
				.setIndicator("Hydrosphere",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabHydrosphere);
		tabHost.addTab(spec);
		
		spec = tabHost
				.newTabSpec("geospherebasic")
				.setIndicator("Geosphere (Basic)",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabGeosphereBasic);
		tabHost.addTab(spec);		
		
		spec = tabHost
				.newTabSpec("geospheretectonic")
				.setIndicator("Geosphere (Tectnoic)",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabGeosphereTectonic);
		tabHost.addTab(spec);				
		
		Bundle b = getIntent().getExtras();
		String worldFilename = "";
		if (b != null) {
			worldFilename = b.getString("WORLDFILE");
		}
		if (worldFilename.length() == 0) {
			geWorldFile();
		}
		else {
			try {
				processWorldFile(worldFilename);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		tabHost.setCurrentTab(0);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (requestCode == REQUEST_OPEN) {
			if (resultCode == RESULT_OK) {
				String path = data.getStringExtra(FileDialog.RESULT_PATH);
				try {
					processWorldFile(path);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private void processWorldFile(String worldFilename) throws IOException {
		FileInputStream fileInput = new FileInputStream(worldFilename);
		Reader r = new InputStreamReader(fileInput);
		LineNumberReader input = new LineNumberReader(r);
		world = new World(input);
		this.setTitle(world.name);

		// Thermosphere
		setTextView(R.id.txtThermos, world.thermosphere.thermo);
		setTextView(R.id.txtThermoCR, world.thermosphere.cr);
		setTextView(R.id.txtOrbit, world.thermosphere.orbit);
		setTextView(R.id.txtTemperature, world.thermosphere.temp);
		
		// Atmosphere
		setTextView(R.id.txtAtmosphere, world.atmosphere.atmosphere);
		setTextView(R.id.txtAtmosCR, world.atmosphere.cr);
		setTextView(R.id.txtPressure, world.atmosphere.pressure);
		setTextView(R.id.txtIncrement, world.atmosphere.increment);
		setTextView(R.id.txtSave, world.atmosphere.save);
		setTextView(R.id.txtDamage, world.atmosphere.damage);
		setTextView(R.id.txtPen, world.atmosphere.pen);
		
		// Hydrosphere
		setTextView(R.id.txtHydrosphere, world.hydrosphere.hydrosphere);
		setTextView(R.id.txtRain, world.hydrosphere.rain);
		setTextView(R.id.txtNone, world.hydrosphere.none);
		setTextView(R.id.txtFlood, world.hydrosphere.flood);
		setTextView(R.id.txtStorm, world.hydrosphere.storm);
		setTextView(R.id.txtWind, world.hydrosphere.wind);
		
		// Geosphere Basic
		setTextView(R.id.txGeoBasic, world.geospherebasic.geosphere);
		setTextView(R.id.txtGeobSpecial, world.geospherebasic.special);
		
		// Geosphere Tectonic
		setTextView(R.id.txGeoTectonic, world.geospheretectonic.geosphere);
		setTextView(R.id.txtQuakeNone, world.geospheretectonic.quakesnone);	
		
		// Biosphere
		
		// Seasons
		
		// Anthrosphere
		
		// Military
		
		// Government
		
		// Civil Rights
		
		// Origin
		
		// Notes
	}
	
	private void setTextView(int id, String value) {
		TextView view = (TextView)this.findViewById(id);
		view.setText(value);
	}
	
	private void geWorldFile() {
		Intent intent = new Intent(this.getBaseContext(), FileDialog.class);
		intent.putExtra(FileDialog.START_PATH,
				Environment.getExternalStorageDirectory());
		intent.putExtra(FileDialog.SELECTION_MODE, SelectionMode.MODE_OPEN);
		this.startActivityForResult(intent, REQUEST_OPEN);
	}
}