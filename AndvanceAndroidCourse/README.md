# Advance Android Course

#### **Fragment Navigation**

* Step 1) Add Below Dependency in project level build.gradle file.  

    `dependencies {  
    ..  
        // fragment Navigation  
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"   
    }`  


* Step 2) Add Below Dependency in app level build.gradle file.  

    `
    dependencies {  
    ..  
        //fragment navigation
        implementation 'androidx.navigation:navigation-fragment-ktx:2.3.2'  
        implementation 'androidx.navigation:navigation-ui-ktx:2.3.2'  
    }
    `  
    
* step 3) Update the activity_main.xml file to include layout xml as the root element and build project and add fragment container view element.  

    `
    <layout xmlns:android="http://schemas.android.com/apk/res/android"  
        xmlns:tools="http://schemas.android.com/tools"  
        xmlns:app="http://schemas.android.com/apk/res-auto">  
        ...  
        
    </layout>
    `  

* step 4) Create the navigation xml file and add the fragments and there actions.
