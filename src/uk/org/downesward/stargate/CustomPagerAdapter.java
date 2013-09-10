package uk.org.downesward.stargate;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomPagerAdapter extends PagerAdapter {
	private Context mContext;
	private Vector<View> pages;
    private World world;
    
	List<String> pageTitles = new ArrayList<String>();

	public CustomPagerAdapter(Context context, Vector<View> pages, World world) {
		this.mContext = context;
		this.pages = pages;
		this.setWorld(world);

		pageTitles.add("Thermosphere");
		pageTitles.add("Atmosphere");
		pageTitles.add("Hydrosphere");
		pageTitles.add("Geosphere (Basic)");
		pageTitles.add("Geosphere (Tectonic)");
		pageTitles.add("Biosphere");
		pageTitles.add("Seasons");
		pageTitles.add("Anthrosphere");
		pageTitles.add("Military");
		pageTitles.add("Government");
		pageTitles.add("Xenosphere");
		pageTitles.add("Civil Rights");
		pageTitles.add("Origin");
		pageTitles.add("Notes");
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View page = pages.get(position);
		if (world != null) {
			switch (position) {
			case 0:
				// Thermosphere		
	
				setTextView(page, R.id.txtThermos, world.thermosphere.thermo);
				setTextView(page, R.id.txtThermoCR, world.thermosphere.cr);
				setTextView(page, R.id.txtOrbit, world.thermosphere.orbit);
				setTextView(page, R.id.txtTemperature, world.thermosphere.temp);
				break;
				
			case 1:
				
				// Atmosphere
				setTextView(page, R.id.txtAtmosphere, world.atmosphere.atmosphere);
				setTextView(page, R.id.txtAtmosCR, world.atmosphere.cr);
				setTextView(page, R.id.txtPressure, world.atmosphere.pressure);
				setTextView(page, R.id.txtIncrement, world.atmosphere.increment);
				setTextView(page, R.id.txtSave, world.atmosphere.save);
				setTextView(page, R.id.txtDamage, world.atmosphere.damage);
				setTextView(page, R.id.txtPen, world.atmosphere.pen);
				break;
				
			case 2:
				// Hydrosphere
				setTextView(page, R.id.txtHydrosphere, world.hydrosphere.hydrosphere);
				setTextView(page, R.id.txtRain, world.hydrosphere.rain);
				setTextView(page, R.id.txtNone, world.hydrosphere.none);
				setTextView(page, R.id.txtFlood, world.hydrosphere.flood);
				setTextView(page, R.id.txtStorm, world.hydrosphere.storm);
				setTextView(page, R.id.txtWind, world.hydrosphere.wind);
				break;
				
			case 3:
				// Geosphere Basic
				setTextView(page, R.id.txtGeoBasic, world.geospherebasic.geosphere);
				setTextView(page, R.id.txtGeobSpecial, world.geospherebasic.special);
				break;
				
			case 4:
				// Geosphere Tectonic
				setTextView(page, R.id.txtGeoTectonic, world.geospheretectonic.geosphere);
				setTextView(page, R.id.txtQuakeNone, world.geospheretectonic.quakesnone);	
				setTextView(page, R.id.txtQuakeMinor, world.geospheretectonic.quakesminor);
				setTextView(page, R.id.txtQuakeModerate, world.geospheretectonic.quakesmoderate);
				setTextView(page, R.id.txtQuakeMajor, world.geospheretectonic.quakesmajor);
				
				setTextView(page, R.id.txtVolcanoNone, world.geospheretectonic.volcanoesnone);
				setTextView(page, R.id.txtVolcanoSmall, world.geospheretectonic.volcanoessmall);
				setTextView(page, R.id.txtVolcanoMedium, world.geospheretectonic.volcanoesmedium);
				setTextView(page, R.id.txtVolcanoLarge, world.geospheretectonic.volcanoeslarge);
				break;
				
			case 5:
				// Biosphere
				setTextView(page, R.id.txtBiosphere, world.biosphere.biosphere);
				setTextView(page, R.id.txtMove, world.biosphere.move);
				setTextView(page, R.id.txtTemperature, world.biosphere.temperature);
				setTextView(page, R.id.txtRain, world.biosphere.rain);
				setTextView(page, R.id.txtVegetation, world.biosphere.vegetation);
				break;	
				
			case 6:

				// Seasons
				setTextView(page, R.id.txtSeasons, world.seasons.seasons);		
				setTextView(page, R.id.txtSpring, world.seasons.spring);		
				setTextView(page, R.id.txtSpringTemp, world.seasons.springtemprature);		
				setTextView(page, R.id.txtSummer, world.seasons.summer);		
				setTextView(page, R.id.txtSummerTemp, world.seasons.summertemprature);		
				setTextView(page, R.id.txtAutumn, world.seasons.autumn);		
				setTextView(page, R.id.txtAutumnTemp, world.seasons.autumntemprature);
				setTextView(page, R.id.txtWinter, world.seasons.winter);		
				setTextView(page, R.id.txtWinterTemp, world.seasons.wintertemprature);
				break;
				
			case 7:
				// Anthrosphere
				setTextView(page, R.id.txtAnthrosphere, world.anthrosphere.anthrosphere);
				setTextView(page, R.id.txtAdvances, world.anthrosphere.advances);
				setTextView(page, R.id.txtWeapons, world.anthrosphere.weapons);
				setTextView(page, R.id.txtVehicles, world.anthrosphere.vehicles);
				setTextView(page, R.id.txtPicks, world.anthrosphere.picks);
				setTextView(page, R.id.txtRP, world.anthrosphere.rp);
				break;	

			case 8:
				// Military
				setTextView(page, R.id.txtMilitary, world.military.military);
				setTextView(page, R.id.txtForce, world.military.force);
				setTextView(page, R.id.txtSquadSize, world.military.squadsize);
				setTextView(page, R.id.txtCondition, world.military.condition);
				break;
				
			case 9:
				// Government
				setTextView(page, R.id.txtGovernment, world.government.government);
				setTextView(page, R.id.txtRuler, world.government.ruler);
				break;
				
			case 10:
				// Xenophobia
				setTextView(page, R.id.txtXenophobia, world.xenophobia.xenophobia);
				setTextView(page, R.id.txtDisposition, world.xenophobia.disposition);
				setTextView(page, R.id.txtModifier, world.xenophobia.modifier);
				break;
				
			case 11:
				// Civil Rights
				setTextView(page, R.id.txtCivilRights, world.civilrights.civilrights);
				setTextView(page, R.id.txtSubjagation, world.civilrights.subjagation);
				setTextView(page, R.id.txtGenocide, world.civilrights.genocide);
				break;
				
			case 12:
				// Origin/Culture Age
				setTextView(page, R.id.txtOriginCultureAge, world.origincultureage.origincultureage);
				
				// Origin/Culture Roots
				setTextView(page, R.id.txtOriginCultureRoots, world.origincultureroots.origincultureroots);
				setTextView(page, R.id.txtOriginCultureDescription, world.origincultureroots.description);
				break;
				
			case 13:
				
				// Notes
				setTextView(page, R.id.txtNotes, world.notes);
				break;
			}
		}
		container.addView(page);
		return page;
	}

	@Override
	public int getCount() {
		return pages.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view.equals(object);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return pageTitles.get(position);
	}
	
	private void setTextView(View page, int id, String value) {
		TextView view = (TextView)page.findViewById(id);
		if (view != null && value != null) {
			view.setText(value);
		}
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
