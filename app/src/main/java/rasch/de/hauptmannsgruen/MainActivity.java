package rasch.de.hauptmannsgruen;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        webView =(WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        String summary = "<html><body>Loading ...</body></html>";
        webView.loadData(summary, "text/html", null);

        webView.loadUrl("http://rasch.myhmg.de/myHmgFeed/hmgFeed.php");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
		switch(item.getItemId()) {
			case R.id.menuitem_app:
				/*
				Intent intent = new Intent(MainActivity.this, WebActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("LatValue", (int)39485000); 
				intent.putExtra("LongValue", (int)-80142777);
				startActivity(intent);
				return true;
				*/
			case R.id.menuitem_gps:
				doDialogAbout();
				return true;
			default:
				return super.onOptionsItemSelected(item);
    }
	
	
	/**
	 * 
	*/
    private void doDialogAbout() {
    	
    	try{
    		
    		final Dialog dialog = new Dialog(this);
    		dialog.setContentView(R.layout.about_dlg);
    		dialog.setTitle("Info..." );
   
	 		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
	 		TextView dialogText = (TextView) dialog.findViewById(R.id.textView1);
	 		
	 		dialogButton.setOnClickListener(new OnClickListener() {
	  				@Override
	  				public void onClick(View v) {
	  					dialog.dismiss();
	  				}
	  		});
	  		dialog.show();
	  		
	    }catch(Exception e) {
	    }
	}
	
	
	
	
}
