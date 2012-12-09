package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

public class World {
	public String name;
	public Thermosphere thermosphere;
	public Atmosphere atmosphere;
	public Hydrosphere hydrosphere;
	
	public World(LineNumberReader reader) throws IOException {
		// First we see the [WORLD] tag
		reader.readLine();
		this.name = reader.readLine().split("=")[1];
		this.thermosphere = new Thermosphere(reader);
		this.atmosphere = new Atmosphere(reader);
		this.hydrosphere = new Hydrosphere(reader);
	}
}
