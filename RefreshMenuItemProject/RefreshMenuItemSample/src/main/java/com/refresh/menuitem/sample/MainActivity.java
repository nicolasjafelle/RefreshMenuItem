package com.refresh.menuitem.sample;

import android.app.Activity;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.refresh.menuitem.RefreshMenuItemHelper;


public class MainActivity extends Activity {


	private RefreshMenuItemHelper refreshHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

	    refreshHelper = new RefreshMenuItemHelper();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	    return refreshHelper.onCreateOptionsMenu(getMenuInflater(), menu, true);
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
		    case R.id.action_refresh:
			    refreshHelper.setMenuItem(item);
			    new RefreshAsyncTask().execute();
			    return true;
		    default:
			    return super.onOptionsItemSelected(item);
	    }
	}

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }


	private class RefreshAsyncTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			refreshHelper.startLoading();
		}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);
			refreshHelper.stopLoading();
		}
	}

}
