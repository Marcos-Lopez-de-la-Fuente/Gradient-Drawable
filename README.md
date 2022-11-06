# Gradient-Drawable

Project in Android Studio to practice "Gradient Drawable".

<details>

**<summary>Application Images</summary>**

<img src="resForReadme/mobile.gif">

</details>

## **Code**

<ul>

### <li>**Java files**

<ul>

<li>

<details>

**<summary>`MainActivity.java`</summary>**

```java
package com.example.gradientdrawable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button getAccessButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getAccessButton = findViewById(R.id.get_access_btn);
        this.getAccessButton.setOnClickListener(view ->
                this.startActivity(new Intent(this, LinksGradientActivity.class))
        );
    }
}
```

</details>

</li>

<li>

<details>

**<summary>`LinksGradientActivity.java`</summary>**

```java
package com.example.gradientdrawable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LinksGradientActivity extends AppCompatActivity {

    private Button testButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links_gradient);

        this.testButton = findViewById(R.id.testButton);
        this.testButton.setOnClickListener(view ->
                this.startActivity(new Intent(this, SeekBackgroundActivity.class))
        );
    }
}
```

</details>

</li>

<li>

<details>

**<summary>`SeekBackgroundActivity.java`</summary>**

```java
package com.example.gradientdrawable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;

import java.util.Map;

import static java.util.Map.entry;


public class SeekBackgroundActivity extends AppCompatActivity {

    private SeekBar seekBarMain;
    private ConstraintLayout constraintMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_background);

        this.seekBarMain = findViewById(R.id.seekBarMain);
        this.constraintMain = findViewById(R.id.constraintMain);


        ///////////////////////////////////////////////////////////////////////////


        this.seekBarMain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                setNewColor(progressValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }


    public void setNewColor(int progressValue) {
        Map<Integer, Integer> colors = Map.ofEntries(
                entry(0, Color.RED),
                entry(1, Color.YELLOW),
                entry(2, Color.GREEN),
                entry(3, Color.MAGENTA),
                entry(4, Color.BLACK),
                entry(5, Color.BLUE),
                entry(6, Color.CYAN),
                entry(7, Color.DKGRAY),
                entry(8, Color.GRAY),
                entry(9, Color.LTGRAY),
                entry(10, Color.WHITE)
        );


        String progressStr = Integer.toString(progressValue);

        int newProgressValue = 0;
        switch (progressStr.length()) {
            case 1:
                newProgressValue = progressValue;
                break;
            case 2:
                newProgressValue = Integer.parseInt(progressStr.substring(1));
                break;
            case 3:
                newProgressValue = Integer.parseInt(progressStr.substring(2));
                break;
        }
        this.constraintMain.setBackgroundColor(colors.get(newProgressValue));
    }

}
```

</details>

</li>

</ul>

</li>

### <li>**XML files**

<ul>

#### <li>**`drawable`**

<ul>

<li>

<details>

**<summary>`first_example.xml`</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">

    <corners
        android:bottomRightRadius="10dp"
        android:radius="40dp" />

    <gradient
        android:angle="45"
        android:endColor="#01f1fa"
        android:startColor="#0189ff"
        android:type="linear" />

    <size
        android:width="82dp"
        android:height="82dp" />

    <stroke
        android:width="2dp"
        android:color="#FFFFFF" />

</shape>
```

</details>

</li>

<li>

<details>

**<summary>`background_gradient.xml`</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">

    <gradient
        android:angle="90"
        android:endColor="#ff009f"
        android:startColor="#1a2b5d"
        android:type="linear" />

</shape>
```

</details>

</li>

<li>

<details>

**<summary>`rounded_button_drawable.xml`</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">

    <corners android:radius="20dp" />

    <solid android:color="@android:color/transparent" />

    <stroke
        android:width="2dp"
        android:color="#FFFFFF" />

    <size
        android:width="165dp"
        android:height="40dp" />

</shape>
```

</details>

</li>

<li>

<details>

**<summary>`additional_exercise_gradient_background.xml`</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">

    <gradient
        android:angle="90"
        android:centerColor="#055798"
        android:endColor="#00FF0C"
        android:startColor="#F40303"
        android:type="linear" />

</shape>
```

</details>

</li>

</ul>

</li>

#### <li>**`layout`**

<ul>

<li>

<details>

**<summary>`activity_main.xml`</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/background_gradient">

    <TextView
        android:id="@+id/lets_go_tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        android:gravity="center"
        android:text="Let's go."
        android:textColor="#FFFFFF"
        android:textSize="50sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="@+id/lets_go_description_tv"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/lets_go_description_tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="If you're an artist or part of their management team,\nwe'll show you how to get the most out of Spotify"
        android:textAlignment="center"
        android:textColor="#FFFFFF"
        android:textSize="20sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="@+id/get_access_btn"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@+id/lets_go_tv" />

    <androidx.appcompat.widget.AppCompatButton
        android:id="@+id/get_access_btn"
        android:layout_width="164dp"
        android:layout_height="38dp"
        android:layout_marginTop="30dp"
        android:background="@drawable/rounded_button_drawable"
        android:text="Get Access"
        android:textAllCaps="true"
        android:textColor="#FFFFFF"
        android:textSize="12sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@+id/lets_go_description_tv" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

</details>

</li>

<li>

<details>

**<summary>`activity_links_gradient.xml`</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">


            <androidx.appcompat.widget.AppCompatButton
                android:id="@+id/testButton"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="16dp"
                android:background="@drawable/additional_exercise_gradient_background"
                android:padding="12dp"
                android:text="Gradient Color Button"
                android:textColor="#FFFFFF"
                android:textSize="24sp"
                android:textStyle="bold" />

            <TextView
                android:id="@+id/testTextView"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="20dp"
                android:background="@drawable/additional_exercise_gradient_background"
                android:fontFamily="monospace"
                android:padding="16dp"
                android:text="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
                android:textColor="#FFFFFF"
                android:textSize="16sp" />


            <ImageView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="16dp"
                android:background="@drawable/additional_exercise_gradient_background"
                android:padding="16dp"
                android:src="@drawable/ic_launcher_foreground" />

            <SeekBar
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="16dp"
                android:padding="8dp"
                android:progressDrawable="@drawable/additional_exercise_gradient_background" />


        </LinearLayout>
    </ScrollView>
</RelativeLayout>
```

</details>

</li>

<li>

<details>

**<summary>`activity_seek_background.xml`</summary>**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/constraintMain">

    <SeekBar
        android:id="@+id/seekBarMain"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        android:padding="8dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

</details>

</li>

</ul>

</ul>

</li>

</ul>
