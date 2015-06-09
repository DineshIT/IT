package com.example.audio;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

// variable declaration
private ListView mainList;
private MediaPlayer mp;
private final String[] listContent = { "chimes", "chord", "ding", "notify",
"recycle", "ringin", "ringout", "tada" };

private final int[] resID = { R.raw.chimes, R.raw.chord, R.raw.ding,
R.raw.notify, R.raw.recycle, R.raw.ringin, R.raw.ringout,
R.raw.tada };

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
// Initializing variables
mp = new MediaPlayer();
mainList = (ListView) findViewById(R.id.listView1);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
android.R.layout.simple_list_item_1, listContent);
mainList.setAdapter(adapter);

mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> adapterView, View view,
int position, long id) {
playSong(position);

}
});

}

public void playSong(int songIndex) {
// Play song
mp.reset();// stops any current playing song
mp = MediaPlayer.create(getApplicationContext(), resID[songIndex]);// create's
// new
// mediaplayer
// with
// song.

mp.start(); // starting mediaplayer

}

@Override
public void onDestroy() {
super.onDestroy();
mp.release();
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.main, menu);
return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
int id = item.getItemId();
if (id == R.id.action_settings) {
return true;
}
return super.onOptionsItemSelected(item);
}
}

