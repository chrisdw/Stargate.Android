package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

public class Atmosphere {
	public String atmosphere;
	public String cr;
	public String pressure;
	public String pen;
	public String increment;
	public String save;
	public String damage;
	public String time;
	
	public Atmosphere(LineNumberReader reader) throws IOException {
		// First we get the [ATMO] tag
		reader.readLine();
		this.atmosphere = reader.readLine().split("=")[1];
		this.cr = reader.readLine().split("=")[1];		
		this.pressure = reader.readLine().split("=")[1];		
		this.pen = reader.readLine().split("=")[1];		
		this.increment = reader.readLine().split("=")[1];		
		this.save = reader.readLine().split("=")[1];		
		this.damage = reader.readLine().split("=")[1];		
		this.time = reader.readLine().split("=")[1];		
	}
}
