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
	}
}
