package uk.org.downesward.stargate;

import java.io.IOException;
import java.io.LineNumberReader;

public class Biosphere {
	public String biosphere;
	public String move;
	public String temprature;
	public String vegitation;
	
	public Biosphere(LineNumberReader reader) throws IOException {
		// First we get the [BIO] tag
		reader.readLine();
		this.biosphere = reader.readLine().split("=")[1];
		this.move = reader.readLine().split("=")[1];
		this.temprature = reader.readLine().split("=")[1];
		this.vegitation = reader.readLine().split("=")[1];
	}
}
