package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

public class Thermosphere {
	public String thermo;
	public String cr;
	public String orbit;
	public String temp;
	
	public Thermosphere(LineNumberReader reader) throws IOException {
		// First we get the [THERMO] tag
		reader.readLine();
		this.thermo = reader.readLine().split("=")[1];
		this.cr = reader.readLine().split("=")[1];
		this.orbit = reader.readLine().split("=")[1];
		this.temp = reader.readLine().split("=")[1];
	}
}
