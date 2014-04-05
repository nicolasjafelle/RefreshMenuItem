RefreshMenuItem
===========
RefreshMenuItem is a Menu item that shows an indeterminate progress in the Android ActionBar. It is simple to use, lightweight, scalable and uses intuitive methods names.<br>

![screenshot_one](https://raw2.github.com/nicolasjafelle/RefreshMenuItem/master/screenshot_one.png)
<br>
![screenshot_two](https://raw2.github.com/nicolasjafelle/RefreshMenuItem/master/screenshot_two.png)

Instructions 1
============

1. Clone the git repo
2. Import the "RefreshMenuItem" module into your Android-gradle project.
3. Add "RefreshMenuItem" module in your settings.gradle
4. DONE

Instructions 2 
============

1. Add Nicolas Jafelle's Maven repo to your build.gradle: <a href="https://github.com/nicolasjafelle/maven-repo">Instructions</a>
2. add this dependency: 'com.refresh.menuitem:refreshmenuitem:1.0'
3. DONE


How to Use it
================

Simple in your Activity or Fragment's onCreate() method instantiate it:
``` java 
refreshHelper = new RefreshMenuItemHelper();
```

Overrides the onCreateOptionsMenu(Menu menu) method and use the RefreshMenuItemHelper:
``` java 
@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// True to use Holo Dark, false for Holo Light
	return refreshHelper.onCreateOptionsMenu(getMenuInflater(), menu, true);
}
```

In the onOptionsItemSelected(MenuItem item) sets the MenuItem which will work as a "Loading" item:
``` java 
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
```

Then simple call:
``` java
refreshHelper.startLoading();
```

And:
``` java
refreshHelper.stopLoading();
```

Check the sample <a href="https://github.com/nicolasjafelle/RefreshMenuItem/tree/master/RefreshMenuItemProject/RefreshMenuItemSample">Demo Sample</a>

Developed By
================

* Nicolas Jafelle - <nicolasjafelle@gmail.com>


License
================

    Copyright 2014 Nicolas Jafelle

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
