package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class Military {
	public String military;
	public String force;
	public String squadsize;
	public String condition;
	
	public Military(LineNumberReader reader) throws IOException {
		// First we get the [MILITARY] tag
		reader.readLine();
		this.military = StringUtilities.getPropertyValue(reader);
		this.force = StringUtilities.getPropertyValue(reader);
		this.squadsize = StringUtilities.getPropertyValue(reader);
		this.condition = StringUtilities.getPropertyValue(reader);
		
	}
}
