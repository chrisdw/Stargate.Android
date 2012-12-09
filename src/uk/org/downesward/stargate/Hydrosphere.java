package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

public class Hydrosphere {
	public String hydrosphere;
	public String rain;
	public String none;
	public String flood;
	public String storm;
	public String wind;
	
	public Hydrosphere(LineNumberReader reader) throws IOException {
		// First we get the [HYDRO] tag
		reader.readLine();
		this.hydrosphere = reader.readLine().split("=")[1];
		this.rain = reader.readLine().split("=")[1];
		this.none = reader.readLine().split("=")[1];
		this.flood = reader.readLine().split("=")[1];
		this.storm = reader.readLine().split("=")[1];
		this.wind = reader.readLine().split("=")[1];	
	}
}
