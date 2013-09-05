package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

public class Anthrosphere {
	public String anthrosphere;
	public String advances;
	public String weapons;
	public String vehicles;
	public String picks;
	public String rp;
	
	public Anthrosphere(LineNumberReader reader) throws IOException {
		// First we get the [ANTHRO] tag
		reader.readLine();
		this.anthrosphere = reader.readLine().split("=")[1];
		this.advances = reader.readLine().split("=")[1];
		this.weapons = reader.readLine().split("=")[1];
		this.vehicles = reader.readLine().split("=")[1];
		this.picks = reader.readLine().split("=")[1];
		this.rp = reader.readLine().split("=")[1];
	}
}
