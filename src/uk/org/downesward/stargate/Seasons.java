package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

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
		this.seasons = reader.readLine().split("=")[1];
		this.spring = reader.readLine().split("=")[1];
		this.springtemprature = reader.readLine().split("=")[1];
		this.summer = reader.readLine().split("=")[1];
		this.summertemprature = reader.readLine().split("=")[1];
		this.autumn = reader.readLine().split("=")[1];
		this.autumntemprature = reader.readLine().split("=")[1];
		this.winter = reader.readLine().split("=")[1];
		this.wintertemprature = reader.readLine().split("=")[1];		
	}
}
