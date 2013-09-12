package uk.org.downesward.stargate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.Vector;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.lamerman.FileDialog;
import com.lamerman.SelectionMode;

public class WorldViewerActivity extends Activity {

	private static final int REQUEST_SAVE = 0;
	private static final int REQUEST_OPEN = 1;
	private static final int REQUEST_OPEN_KNOWN = 2;
	private World world;

	private Context mContext;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			mContext = this;
			setContentView(R.layout.worldviewer);

			ViewPager vp = (ViewPager) findViewById(R.id.viewpager);

			Vector<View> pages = new Vector<View>();

			LayoutInflater inflater = LayoutInflater.from(mContext);

			View page = inflater.inflate(R.layout.thermosphere, null, false);
			pages.add(page);

			page = inflater.inflate(R.layout.atmosphere, null, false);
			pages.add(page);

			page = inflater.inflate(R.layout.hydrosphere, null, false);
			pages.add(page);

			page = inflater.inflate(R.layout.geospherebasic, null, false);
			pages.add(page);

			page = inflater.inflate(R.layout.geospheretectonic, null, false);
			pages.add(page);

			page = inflater.inflate(R.layout.biosphere, null, false);
			pages.add(page);

			page = inflater.inflate(R.layout.seasons, null, false);
			pages.add(page);

			page = inflater.inflate(R.layout.anthrosphere, null, false);
			pages.add(page);

			page = inflater.inflate(R.layout.military, null, false);
			pages.add(page);

			page = inflater.inflate(R.layout.government, null, false);
			pages.add(page);

			page = inflater.inflate(R.layout.xenophobia, null, false);
			pages.add(page);

			page = inflater.inflate(R.layout.civilrights, null, false);
			pages.add(page);

			page = inflater.inflate(R.layout.origin, null, false);
			pages.add(page);

			page = inflater.inflate(R.layout.notes, null, false);
			pages.add(page);

			CustomPagerAdapter adapter = new CustomPagerAdapter(mContext,
					pages, world);
			vp.setAdapter(adapter);

			Bundle b = getIntent().getExtras();
			String worldFilename = "";
			if (b != null) {
				worldFilename = b.getString("WORLDFILE");
			}
			if (worldFilename.length() == 0) {
				getKnownWorldFile();
			} else {
				processWorldFile(worldFilename);
			}
		} catch (Throwable e) {
			// Something is dying in real life - need to find out what.
			displayException(e);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		try {

			if (requestCode == REQUEST_OPEN) {
				if (resultCode == RESULT_OK) {
					String path = data.getStringExtra(FileDialog.RESULT_PATH);

					processWorldFile(path);

				}
			} else if (requestCode == REQUEST_OPEN_KNOWN) {
				if (resultCode == RESULT_OK) {
					String path = data.getStringExtra("WORLD");
					AssetManager am = getAssets();
					InputStream is = am.open("known worlds/" + path);
					processWorldFile(is);
				}
			}
		} catch (IOException e) {
			displayException(e);
		}
	}

	public void displayException(Throwable e) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		Resources res = getResources();

		builder.setMessage(e.getLocalizedMessage()).setTitle(
				res.getString(R.string.val_exception));
		builder.setPositiveButton(res.getString(R.string.val_ok),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// if this button is clicked, close
						// current activity
						WorldViewerActivity.this.finish();
					}
				});
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	private void processWorldFile(InputStream is) throws IOException {
		Reader r = new InputStreamReader(is);
		LineNumberReader input = new LineNumberReader(r);
		world = new World(input);
		this.setTitle(world.name);

		// Notify change
		ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
		CustomPagerAdapter adapter = (CustomPagerAdapter) vp.getAdapter();
		adapter.setWorld(world);
		adapter.notifyDataSetChanged();
	}

	private void processWorldFile(String worldFilename) throws IOException {
		FileInputStream fileInput = new FileInputStream(worldFilename);
		processWorldFile(fileInput);
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

	private void getWorldFile() {
		Intent intent = new Intent(this.getBaseContext(), FileDialog.class);
		intent.putExtra(FileDialog.START_PATH,
				Environment.getExternalStorageDirectory());
		intent.putExtra(FileDialog.SELECTION_MODE, SelectionMode.MODE_OPEN);
		this.startActivityForResult(intent, REQUEST_OPEN);
	}

	private void getKnownWorldFile() {
		Intent intent = new Intent(this.getBaseContext(),
				KnownWorldSelectionActivity.class);
		intent.setAction(Intent.ACTION_PICK);
		startActivityForResult(intent, REQUEST_OPEN_KNOWN);
	}
}