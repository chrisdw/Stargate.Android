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
		Cursor res = db.rawQuery("SELECT BaseId, Hook, Description FROM Hook", null);
		return res;

	}

	public Cursor getGoals() {
		SQLiteDatabase db = getReadableDatabase();
		Cursor res = db.rawQuery("SELECT BaseId, Goal, Description FROM Goal", null);
		return res;
	}
	
	public Cursor getPlots() {
		SQLiteDatabase db = getReadableDatabase();
		Cursor res = db.rawQuery("SELECT BaseId, PlotType, Description FROM PlotType", null);
		return res;
	}	
}
