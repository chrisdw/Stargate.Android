package uk.org.downesward.stargate;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHelper extends SQLiteAssetHelper {

	private static String DB_NAME = "worldgen";

	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, 1);
	}

	public Cursor getHooks() {
		SQLiteDatabase db = getReadableDatabase();
		Cursor res = db.rawQuery("SELECT BaseId, Hook, Description FROM Hook",
				null);
		return res;
	}

	public Cursor getGoals() {
		SQLiteDatabase db = getReadableDatabase();
		Cursor res = db.rawQuery("SELECT BaseId, Goal, Description FROM Goal",
				null);
		return res;
	}

	public Cursor getPlots() {
		SQLiteDatabase db = getReadableDatabase();
		Cursor res = db.rawQuery(
				"SELECT BaseId, PlotType, Description FROM PlotType", null);
		return res;
	}

	public Cursor getClimaxes() {
		SQLiteDatabase db = getReadableDatabase();
		Cursor res = db.rawQuery(
				"SELECT BaseId, Climax, Description FROM Climax", null);
		return res;
	}

	public Cursor getEncounters() {
		SQLiteDatabase db = getReadableDatabase();
		Cursor res = db.rawQuery(
				"SELECT BaseId, Encounter, Description FROM Encounters", null);
		return res;
	}

	public Cursor getLocation() {
		SQLiteDatabase db = getReadableDatabase();
		Cursor res = db.rawQuery(
				"SELECT BaseId, Location, Description FROM Location", null);
		return res;
	}

	public Cursor getNPCs() {
		SQLiteDatabase db = getReadableDatabase();
		Cursor res = db
				.rawQuery(
						"SELECT BaseId, NPC, Description, RelativeLevel, Reaction FROM NPC",
						null);
		return res;
	}

	public Cursor getSettings() {
		SQLiteDatabase db = getReadableDatabase();
		Cursor res = db.rawQuery(
				"SELECT BaseId, Setting, Description FROM Setting", null);
		return res;
	}
}
