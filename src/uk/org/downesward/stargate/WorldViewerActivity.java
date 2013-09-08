package uk.org.downesward.stargate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

import com.lamerman.FileDialog;
import com.lamerman.SelectionMode;

public class WorldViewerActivity extends TabActivity {
	
	private static final int REQUEST_SAVE = 0;
	private static final int REQUEST_OPEN = 1;
	private static final int REQUEST_OPEN_KNOWN = 2;
	private World world;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try
		{
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
				.setIndicator("Geosphere (Tectonic)",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabGeosphereTectonic);
		tabHost.addTab(spec);
		
		spec = tabHost
				.newTabSpec("biosphere")
				.setIndicator("Biosphere",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabBiosphere);
		tabHost.addTab(spec);
		
		spec = tabHost
				.newTabSpec("seasons")
				.setIndicator("Seasons",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabSeasons);
		tabHost.addTab(spec);	
		
		spec = tabHost
				.newTabSpec("anthrosphere")
				.setIndicator("Anthrosphere",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabAnthrosphere);
		tabHost.addTab(spec);		
		
		spec = tabHost
				.newTabSpec("military")
				.setIndicator("Military",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabMilitary);
		tabHost.addTab(spec);
		
		spec = tabHost
				.newTabSpec("government")
				.setIndicator("Government",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabGovernment);
		tabHost.addTab(spec);			
		
		spec = tabHost
				.newTabSpec("xenophobia")
				.setIndicator("Xenophobia",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabXenophobia);
		tabHost.addTab(spec);	
		
		spec = tabHost
				.newTabSpec("civilrights")
				.setIndicator("Civil Rights",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabCivilRights);
		tabHost.addTab(spec);	
		
		spec = tabHost
				.newTabSpec("origin")
				.setIndicator("Origin",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabOrigin);
		tabHost.addTab(spec);		
		
		spec = tabHost
				.newTabSpec("notes")
				.setIndicator("Notes",
						res.getDrawable(R.drawable.ic_launcher2))
				.setContent(R.id.tabNotes);
		tabHost.addTab(spec);			
		
		Bundle b = getIntent().getExtras();
		String worldFilename = "";
		if (b != null) {
			worldFilename = b.getString("WORLDFILE");
		}
		if (worldFilename.length() == 0) {
			getWorldFile();
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
		catch (Exception e) {
			AlertDialog.Builder builder = new AlertDialog.Builder(getCurrentActivity());
			builder.setMessage(e.getLocalizedMessage())
		       .setTitle(e.getMessage());
			AlertDialog dialog = builder.create();
			dialog.show();
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (requestCode == REQUEST_OPEN || requestCode == REQUEST_OPEN_KNOWN) {
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
		setTextView(R.id.txtGeoBasic, world.geospherebasic.geosphere);
		setTextView(R.id.txtGeobSpecial, world.geospherebasic.special);
		
		// Geosphere Tectonic
		setTextView(R.id.txtGeoTectonic, world.geospheretectonic.geosphere);
		setTextView(R.id.txtQuakeNone, world.geospheretectonic.quakesnone);	
		setTextView(R.id.txtQuakeMinor, world.geospheretectonic.quakesminor);
		setTextView(R.id.txtQuakeModerate, world.geospheretectonic.quakesmoderate);
		setTextView(R.id.txtQuakeMajor, world.geospheretectonic.quakesmajor);
		
		setTextView(R.id.txtVolcanoNone, world.geospheretectonic.volcanoesnone);
		setTextView(R.id.txtVolcanoSmall, world.geospheretectonic.volcanoessmall);
		setTextView(R.id.txtVolcanoMedium, world.geospheretectonic.volcanoesmedium);
		setTextView(R.id.txtVolcanoLarge, world.geospheretectonic.volcanoeslarge);
		
		// Biosphere
		setTextView(R.id.txtBiosphere, world.biosphere.biosphere);
		setTextView(R.id.txtMove, world.biosphere.move);
		setTextView(R.id.txtTemperature, world.biosphere.temperature);
		setTextView(R.id.txtRain, world.biosphere.rain);
		setTextView(R.id.txtVegetation, world.biosphere.vegetation);
		
		// Seasons
		setTextView(R.id.txtSeasons, world.seasons.seasons);		
		setTextView(R.id.txtSpring, world.seasons.spring);		
		setTextView(R.id.txtSpringTemp, world.seasons.springtemprature);		
		setTextView(R.id.txtSummer, world.seasons.summer);		
		setTextView(R.id.txtSummerTemp, world.seasons.summertemprature);		
		setTextView(R.id.txtAutumn, world.seasons.autumn);		
		setTextView(R.id.txtAutumnTemp, world.seasons.autumntemprature);
		setTextView(R.id.txtWinter, world.seasons.winter);		
		setTextView(R.id.txtWinterTemp, world.seasons.wintertemprature);
		
		// Anthrosphere
		setTextView(R.id.txtAnthrosphere, world.anthrosphere.anthrosphere);
		setTextView(R.id.txtAdvances, world.anthrosphere.advances);
		setTextView(R.id.txtWeapons, world.anthrosphere.weapons);
		setTextView(R.id.txtVehicles, world.anthrosphere.vehicles);
		setTextView(R.id.txtPicks, world.anthrosphere.picks);
		setTextView(R.id.txtRP, world.anthrosphere.rp);
		
		// Military
		setTextView(R.id.txtMilitary, world.military.military);
		setTextView(R.id.txtForce, world.military.force);
		setTextView(R.id.txtSquadSize, world.military.squadsize);
		setTextView(R.id.txtCondition, world.military.condition);
		
		// Government
		setTextView(R.id.txtGovernment, world.government.government);
		setTextView(R.id.txtRuler, world.government.ruler);
		
		// Xenophobia
		setTextView(R.id.txtXenophobia, world.xenophobia.xenophobia);
		setTextView(R.id.txtDisposition, world.xenophobia.disposition);
		setTextView(R.id.txtModifier, world.xenophobia.modifier);
		
		// Civil Rights
		setTextView(R.id.txtCivilRights, world.civilrights.civilrights);
		setTextView(R.id.txtSubjagation, world.civilrights.subjagation);
		setTextView(R.id.txtGenocide, world.civilrights.genocide);
		
		// Origin/Culture Age
		setTextView(R.id.txtOriginCultureAge, world.origincultureage.origincultureage);
		
		// Origin/Culture Roots
		setTextView(R.id.txtOriginCultureRoots, world.origincultureroots.origincultureroots);
		setTextView(R.id.txtOriginCultureDescription, world.origincultureroots.description);
		
		// Notes
		setTextView(R.id.txtNotes, world.notes);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.worldviewer, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.mnu_world_open) {
			getWorldFile();
		} else if (itemId == R.id.mnu_known_world_open) {
			getKnownWorldFile();
		} else {
			return super.onOptionsItemSelected(item);
		}
		return true;
	}	
	
	private void setTextView(int id, String value) {
		TextView view = (TextView)this.findViewById(id);
		if (view != null && value != null) {
			view.setText(value);
		}
	}
	
	private void getWorldFile() {
		Intent intent = new Intent(this.getBaseContext(), FileDialog.class);
		intent.putExtra(FileDialog.START_PATH,
				Environment.getExternalStorageDirectory());
		intent.putExtra(FileDialog.SELECTION_MODE, SelectionMode.MODE_OPEN);
		this.startActivityForResult(intent, REQUEST_OPEN);
	}
	
	private void getKnownWorldFile() {
		Intent intent = new Intent(this.getBaseContext(), FileDialog.class);
		intent.putExtra(FileDialog.START_PATH,
				Environment.getDataDirectory() + "data/Stargate.Android/known worlds");
		intent.putExtra(FileDialog.SELECTION_MODE, SelectionMode.MODE_OPEN);
		this.startActivityForResult(intent, REQUEST_OPEN);
	}	
}