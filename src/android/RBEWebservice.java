package br.com.pontosistemas.webservice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;


public class RBEWebservice extends CordovaPlugin {
	
	public static final String NATIVE_ACTION_STRING = "nativeAction";
	public static final String SUCCESS_PARAMETER="success";
	
	// Construtor
	public RBEWebservice(){
		
	}
	
	/*public void getDataSaveFile() {

		new AsyncTask<String, Void, JSONObject>() {
			JSONObject jsonItem;

			@Override
			protected void onPreExecute() {

			}

			protected JSONObject doInBackground(String... urls) {
				try {

					jsonItem = Json.getJson("http://www.rbenergia.com.br/ws/wsrbe.php");

				} catch (Exception e) {
					Log.d("ERROR", "Erro ao buscar os dados");
				}
				return jsonItem;
			}

			@Override
			protected void onPostExecute(JSONObject jsonData) {
				super.onPostExecute(jsonData);
				try {

					writeFileInternalStorage(jsonData.toString(),
							Util.activity.getApplicationContext(), "rbe.json");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.execute();
	}

	public static boolean isSdReadable() {

		boolean mExternalStorageAvailable = false;
		try {
			String state = Environment.getExternalStorageState();

			if (Environment.MEDIA_MOUNTED.equals(state)) {
				mExternalStorageAvailable = true;
				Log.i("isSdReadable", "External storage card is readable.");
			} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
				Log.i("isSdReadable", "External storage card is readable.");
				mExternalStorageAvailable = true;
			} else {
				mExternalStorageAvailable = false;
			}
		} catch (Exception ex) {

		}
		return mExternalStorageAvailable;
	}

	public static void writeFileInternalStorage(String strWrite,
			Context context, String fileName) {
		try {
			// Check if Storage is Readable
			if (isSdReadable()) // isSdReadable()e method is define at bottom of
								// the post
			{
				String smsfilename = fileName;
				FileOutputStream fos = context.openFileOutput(smsfilename,
						Context.MODE_PRIVATE);
				fos.write(strWrite.getBytes());
				fos.flush();
				fos.close();

			}
		} catch (Exception e) {
			// Your Code
		}
	}

	public static PluginResult readFileInternalStorage() {
		String stringToReturn = " ";
		try {
			if (isSdReadable()) // isSdReadable()e method is define at bottom of
								// the post
			{
				// String sfilename = fileName;
				InputStream inputStream = Util.activity.getApplicationContext()
						.openFileInput("rbe");

				if (inputStream != null) {
					InputStreamReader inputStreamReader = new InputStreamReader(
							inputStream);
					BufferedReader bufferedReader = new BufferedReader(
							inputStreamReader);
					String receiveString = "";
					StringBuilder stringBuilder = new StringBuilder();

					while ((receiveString = bufferedReader.readLine()) != null) {
						stringBuilder.append(receiveString);
					}
					inputStream.close();
					stringToReturn = stringBuilder.toString();
				}
			}
		} catch (FileNotFoundException e) {
			Log.e("TAG", "File not found: " + e.toString());
		} catch (IOException e) {
			Log.e("TAG", "Can not read file: " + e.toString());
		}
		PluginResult result = new PluginResult(PluginResult.Status.OK,
				stringToReturn);

		return result;
	}*/

	public PluginResult execute(String action, JSONArray data, String callbackId) {
		Log.d("Hello Plugin", "Hello, this is a native function called on javascript function");
		
		if (NATIVE_ACTION_STRING.equals(action)){
			
			String resultType = null; 
            try { 
                  resultType = data.getString(0); 
            } 
            catch (Exception ex) { 
                  Log.d("HelloPlugin", ex.toString()); 
            } 
            
            
            return new PluginResult(PluginResult.Status.OK, "Yay, Success!!!"); 
		}
		
		return null;
	}
}
