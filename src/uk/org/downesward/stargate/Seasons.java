package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

import uk.org.downesward.utiliites.StringUtilities;

public class Seasons {
	public String seasons;
	public String spring;
	public String springtemprature;
	public String summer;
	public String summertemprature;
	public String autumn;
	public String autumntemprature;
	public String winter;
	public String wintertemprature;
	
	public Seasons(LineNumberReader reader) throws IOException {
		// First we get the [SEASON] tag
		reader.readLine();
		this.seasons = StringUtilities.getPropertyValue(reader);
		this.spring = StringUtilities.getPropertyValue(reader);
		this.springtemprature = StringUtilities.getPropertyValue(reader);
		this.summer = StringUtilities.getPropertyValue(reader);
		this.summertemprature = StringUtilities.getPropertyValue(reader);
		this.autumn = StringUtilities.getPropertyValue(reader);
		this.autumntemprature = StringUtilities.getPropertyValue(reader);
		this.winter = StringUtilities.getPropertyValue(reader);
		this.wintertemprature = StringUtilities.getPropertyValue(reader);		
	}
}
