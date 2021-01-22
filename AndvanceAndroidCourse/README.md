# Advance Android Course

#### **Fragment Navigation**

* Step 1) Add Below Dependency in project level build.gradle file.  

    ```
    dependencies {  
    ...  
        // fragment Navigation  
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"   
    }
    ```  


* Step 2) Add Below Dependency in app level build.gradle file.  

    ```
    dependencies {  
        ...  
  
        //fragment navigation
        implementation 'androidx.navigation:navigation-fragment-ktx:2.3.2'  
        implementation 'androidx.navigation:navigation-ui-ktx:2.3.2'  
    }
    ```
    
* step 3) Update the activity_main.xml file to include layout xml as the root element and build project and add fragment container view element.  

    ```
    <layout xmlns:android="http://schemas.android.com/apk/res/android"  
        xmlns:tools="http://schemas.android.com/tools"  
        xmlns:app="http://schemas.android.com/apk/res-auto">  
        ...  
        
    </layout>
    ```  

* step 4) Create the navigation xml file and add the fragments and there actions, build the project.

* step 5) Below is example code to navigate between fragments.
    
    ```
        // In Activity  
        this.findNavController(R.id.myNavHostFragment).navigate(HomeFragmentDirections.actionHomeFragmentToPastTransactionFragment())  
  
        // In Fragments   
        requireActivity().findNavController(R.id.myNavHostFragment).navigate(HomeFragmentDirections.actionHomeFragmentToPastTransactionFragment())  

    ```

#### **To Set Up Notification**

* Step 1) Add Below Dependency in app level build.gradle file.  

    ```
    dependencies {  
        ...  
  
        //lifecycle dependecies
        implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
        implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0-rc01'
  
        //Firebase dependecies
        implementation 'com.google.firebase:firebase-core:18.0.1'
        implementation 'com.google.firebase:firebase-iid:21.0.1'
        implementation 'com.google.firebase:firebase-messaging:21.0.1'
        implementation 'android.arch.work:work-runtime:1.0.1'
    }
    ```

* Step 2) Create an NotificationUtils file in utils package and Extend `NotificationManager` with function `sendNotification()` with parameters `messageBody` and `applicationContext`.    
    ```
    //File NotificationUtils.kt  > sendNotification()
    fun NotificationManager.sendNotification(messageBody: String, applicationContext: Context) {
        ...
    }
    ```
* Steps 3) Create an PendingIndent for the MainActivity(Activity) you want to launch on click of notification.
    ```
    //File NotificationUtils.kt   > sendNotification()
    val contentIntent = Intent(applicationContext, MainActivity::class.java)
  
    val contentPendingIntent = PendingIntent.getActivity(
        applicationContext,
        NOTIFICATION_ID,
        contentIntent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )        
    ```
  
* Step 4) Get an instance of `NotificationCompat.Builder` with a specific channel name.
    ```
    //File NotificationUtils.kt   > sendNotification()
  	val builder = NotificationCompat.Builder(
  		applicationContext,
  		applicationContext.getString(R.string.egg_notification_channel_id)
  	)
    ```
  
* Step 5) Add the `title` ,`text`and `icon` to the builder , also add the onclick content which was initialised earlier , set the priority and finally call `notify` method.
  ```
    //File NotificationUtils.kt > sendNotification()
    .setSmallIcon(R.drawable.cooked_egg)
    .setContentTitle(applicationContext
        .getString(R.string.notification_title))
    .setContentText(messageBody)
  
    // Intent launched on click of notification
    .setContentIntent(contentPendingIntent)
    .setAutoCancel(true)
    
    .setPriority(NotificationCompat.PRIORITY_HIGH)
  
    notify(NOTIFICATION_ID, builder.build())
  ```
  
* Step 6) Extend `NotificationManager` with function `cancelNotifications` used to cancel all notifications.    
    ```
     //File NotificationUtils.kt  
      fun NotificationManager.cancelNotifications() {
        cancelAll()
      }
    ```
* step 7) To Receive Notification Create an Class which Extends `BroadcastReceiver()`, get the Instance of `NotificationManager` and call the `sendNotification()` fun
    ```kotlin
    class AlarmReceiver : BroadcastReceiver() {
      
        override fun onReceive(context: Context, intent: Intent) {
            //Instance of NotificationManager
            val notificationManager = ContextCompat.getSystemService(
                context,
                NotificationManager::class.java
            ) as NotificationManager
            //Instance of NotificationManager
  
            notificationManager.sendNotification(
                context.getText(R.string.eggs_ready).toString(),
                context
            )
        }
    }
    ```
* step 8) To Send an Notification ,create an PendingIndent for the Receiver(BroadcastReceiver()) you want to use and call the getBroadcast() fun.
    
  ```kotlin
    //Initialise the Intent
    val notifyIntent = Intent(app, AlarmReceiver::class.java)
    
    //call the getBroadcast() fun
    val notifyPendingIntent = PendingIntent.getBroadcast(
        getApplication(),
        REQUEST_CODE,
        notifyIntent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )
  ```
