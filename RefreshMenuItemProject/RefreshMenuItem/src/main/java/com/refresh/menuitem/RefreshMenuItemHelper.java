package com.refresh.menuitem;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.lang.ref.WeakReference;


/**
 * Helper class that shows and stop an indeterminate progress in the Action Bar.
 * Created by nicolas Jafelle.
 */
public class RefreshMenuItemHelper {
	private WeakReference<MenuItem> item;


	/**
	 * Inflates the menu with only one MenuItem with id:action_refresh.
	 * @param menuInflater The MenuInflater object
	 * @param menu The Menu object
	 * @param useHoloDark true to use Holo Dark assets, false for Holo Light
	 * @return true
	 */
	public boolean onCreateOptionsMenu(MenuInflater menuInflater, Menu menu, boolean useHoloDark) {
		if(useHoloDark) {
			menuInflater.inflate(R.menu.refresh_menu_holo_dark, menu);
		}else {
			menuInflater.inflate(R.menu.refresh_menu_holo_light, menu);
		}
		return true;
	}

	/**
	 * Set the menu item.
	 * @param item
	 */
	public void setMenuItem(MenuItem item) {
		this.item = new WeakReference<MenuItem>(item);
	}

	/**
	 * Start and show the indeterminate progress.
	 */
	public void startLoading() {
		if(item != null && item.get() != null) {
			item.get().setActionView(R.layout.menu_item_action_refresh);
			item.get().expandActionView();
		}
	}

	/**
	 * Stop and dismiss the indeterminate progress.
	 */
	public void stopLoading() {
		if(item != null && item.get() != null) {
			item.get().collapseActionView();
			item.get().setActionView(null);
		}
	}



}
