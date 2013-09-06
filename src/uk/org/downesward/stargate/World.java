package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class World {
	public String name;
	public Thermosphere thermosphere;
	public Atmosphere atmosphere;
	public Hydrosphere hydrosphere;
	public GeosphereBasic geospherebasic;
	public GeosphereTectonic geospheretectonic;
	public Biosphere biosphere;
	public Seasons seasons;
	public Anthrosphere anthrosphere;
	public Military military;
	public Government government;
	public Xenophobia xenophobia;
	public CivilRights civilrights;
	public OriginCultureAge origincultureage;
	public OriginCultureRoots origincultureroots;
	public String notes;
	
	public World(LineNumberReader reader) throws IOException {
		// First we see the [WORLD] tag
		reader.readLine();
		this.name = StringUtilities.getPropertyValue(reader);
		this.thermosphere = new Thermosphere(reader);
		this.atmosphere = new Atmosphere(reader);
		this.hydrosphere = new Hydrosphere(reader);
		this.geospherebasic = new GeosphereBasic(reader);
		this.geospheretectonic = new GeosphereTectonic(reader);
		this.biosphere = new Biosphere(reader);
		this.seasons = new Seasons(reader);
		this.anthrosphere = new Anthrosphere(reader);
		this.military = new Military(reader);
		this.government = new Government(reader);
		this.xenophobia = new Xenophobia(reader);
		this.civilrights = new CivilRights(reader);
		this.origincultureage = new OriginCultureAge(reader);
		this.origincultureroots = new OriginCultureRoots(reader);
		this.notes = StringUtilities.getPropertyValue(reader);
	}
}
