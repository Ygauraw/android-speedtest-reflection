package se.mobileapplab.speedtest_reflection;

import java.util.HashMap;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	void outputResult(SpeedResult result) {
		TextView text = (TextView)MainActivity.this.findViewById(R.id.text);
		String string = text.getText().toString();
		string += String.format("%s: %d.%03d, GC: %s\n", result.name, 
			result.time/1000, result.time%1000, result.didGC ? "yes":"no");
		text.setText(string);
	}

	public void onReflect(View src) {
		new AsyncTask<Void, Void, SpeedResult>() {
			@Override
			protected SpeedResult doInBackground(Void... params) {
				TestReflection ref = new TestReflection();
				Item item = new Item();
				item.name = "This is a name";
				item.description = "This is a description";
				item.category = 1;
				item.value = 12345.6;
				item.active = true;
				
				SpeedResult result = new SpeedResult("Reflection");
				for (int i = 0; i<1000; i++) {
					ref.test(item);
				}
				result.end();
				
				return result;
			}
			
			@Override
			protected void onPostExecute(SpeedResult result) {
				outputResult(result);
			}
		}.execute();
	}

	public void onHash(View src) {
		new AsyncTask<Void, Void, SpeedResult>() {
			@Override
			protected SpeedResult doInBackground(Void... params) {
				TestHashMap ref = new TestHashMap();
				HashMap<String, Object> item = new HashMap<String, Object>();
				item.put("name", "This is a name");
				item.put("description", "This is a description");
				item.put("category", 1);
				item.put("value", 12345.6);
				item.put("active", true);
				
				SpeedResult result = new SpeedResult("HashMap");
				for (int i = 0; i<1000; i++) {
					ref.test(item);
				}
				result.end();
				
				return result;
			}
			
			@Override
			protected void onPostExecute(SpeedResult result) {
				outputResult(result);
			}
		}.execute();
	}

	public void onDirect(View src) {
		new AsyncTask<Void, Void, SpeedResult>() {
			@Override
			protected SpeedResult doInBackground(Void... params) {
				TestDirect ref = new TestDirect();
				Item item = new Item();
				item.name = "This is a name";
				item.description = "This is a description";
				item.category = 1;
				item.value = 12345.6;
				item.active = true;
				
				SpeedResult result = new SpeedResult("Direct");
				for (int i = 0; i<1000; i++) {
					ref.test(item);
				}
				result.end();
				
				return result;
			}
			
			@Override
			protected void onPostExecute(SpeedResult result) {
				outputResult(result);
			}
		}.execute();
	}
}
