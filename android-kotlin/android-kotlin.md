
# Android Development in Kotlin

## Table of Contents

  - [Activities and Lifecycle](#activities-and-lifecycle)
  - [Logcat: Solving Errors in Android Studio](#logcat-solving-errors-in-android-studio)
    - [Types of Log Messages](#types-of-log-messages)
    - [What We Look For in Logcat](#what-we-look-for-in-logcat)
  - [Layouts in Android](#layouts-in-android)
    - [Linear Layout](#linear-layout)
      - [Density Independent Pixels (dp or dip)](#density-independent-pixels-dp-or-dip)
      - [Scaleable Independent Pixels (sp)](#scaleable-independent-pixels-sp)
    - [Constraint Layout](#constraint-layout)
      - [Chains and Guidelines](#chains-and-guidelines)
  - [Views in Android](#views-in-android)
    - [Buttons](#buttons)
    - [Textviews](#textviews)
    - [EditText](#edittext)
    - [ImageView](#imageview)
  - [Intent and Multiple Activities](#intent-and-multiple-activities)
  - [Permissions](#permissions)
  - [Implicit Intents](#implicit-intents)
  - [Toolbar Menus](#toolbar-menus)
  - [Fragments](#fragments)
    - [Static Fragments](#static-fragments)
    - [Dynamic Fragments](#dynamic-fragments)
      - [Fragment Transaction](#fragment-transaction)
  - [Miscellenious Tips](#miscellenious-tips)
  - [References](#references)

## Activities and Lifecycle

Activity in Android is simple Kotlin Class. Thus, each activity can be represented by a Kotlin class. MainActivity inherits from AppCompatActivity().

<p align="center">
  <img width="400" height="300" src="https://user-images.githubusercontent.com/41933169/165211141-3708dbb5-fca7-4c0f-b64a-9e5c50631118.png">
</p>

When there are multiple activities running at the same time, Android uses a STACK to manage them. The first activity executed goes to the bottom of the STACK and following activities are stacked on top of each other. When an user presses a back button, the current activity gets popped out of the stack, and returns the activity right below it.

<p align="center">
  <img width="800" height="400" src="https://user-images.githubusercontent.com/41933169/165211071-9a2f7211-c338-4271-b3b2-1a3613d7c768.png">
</p>

- onCreate(): When activity is started, onCreate() is called.
- onStart()
- onResume(): at this point, the activity is at the top of the activity stack.
- onPause(): the activity goes to the background (guaranteed to be called, should save data onPause())
- onResume(): when the activity gets the user's focus, it starts onResume() (don't recreate it)
- onStop(): onStop is not guaranteed to be called later.
- onDestroy(): shuts down activity. If app process is killed, we have to create the activity all over again from onCreate().

## Logcat: Solving Errors in Android Studio

### Types of Log Messages

- **Verbose (Log.v)**: show all log messages
- **Debug (Log.d)**: shows all log messages related to Debug and everything else below (Info, Warn, Error and Assert)
- **Info (Log.i)**: shows all log messages related to Info and everything else below (Warn, Error, and Assert)

In similar manner, we can select which types of log messages we want to display on Logcat. We can search log messages by tags to just display what we want.

### What We Look For in Logcat

From Logcat, the useful information we can find is sometimes from "Caused by" clause. "Caused by" clause provides specific error messages. Also, the blue links on Logcat lead us the locations of error sources.

## Layouts in Android

### Linear Layout

We can construct a layered structure of multiple linear layouts to design an activity.

#### Density Independent Pixels (dp or dip)

An abstract unit that is based on the physical density of the screen. These units are relative to a 160 dpi screen, so one dp is one pixel on a 160 dpi screen. The ratio of dp-to-pixel will change with the screen density, but not necessarily in direct proportion. Note: The compiler accepts both "dip" and "dp", though "dp" is more consistent with "sp".

#### Scaleable Independent Pixels (sp)

This is like the dp unit, but it is also scaled by the user's font size preference. It is recommended you use this unit when specifying font sizes, so they will be adjusted for both the screen density and the user's preference. Note, the Android documentation is inconsistent on what sp actually stands for, one doc says "scale-independent pixels", the other says "scaleable pixels".

- padding
- match_parent vs. wrap_content
- layout_weight: When organizing multiple views over the horizontal frame, we can use layout_weight to give them unique weights.
- orientation: horizontal vs. vertical

### Constraint Layout

Constraint Layout helps us flatten the layout hierarchy and build simple layout designs. We don't use Expand Horizontally and Expand Vertically features because they are not reliable. The best practice with Constraint Layout is to set each constraint manually.

#### Chains and Guidelines

- Chains + 0 widths give views equal widths horizontally.
- Helpers: Vertical or Horizontal Guidelines

## Views in Android

### Buttons

There are two ways of accessing buttons or views in Kotlin.

```
val btnABC = findViewById(R.id.btnABC) # Java way
btnABC # directly imports the id.
```

In order to directly import the ids, we need to make sure to have the following lines in build.gradle(module).

```
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-android-extensions'
}
```

### Textviews

- textSize
- textStyle
- textAlignment

### EditText

- ems: If layout_width == "wrap_content", ems sets how many capital letters can be fitted into EditText (adjusts the length of EditText)
- hint
- inputType: if "number", only shows the numeric keyboard. if "textPassword", shows the keyboard for password. if "phone", shows the phone keyboard.

### ImageView

- scaleType

## Intent and Multiple Activities

- We can create `Intent()` object to go to other activities by running `startActivity(intent)`
- When sending data, we use `putExtra` and `getExtra` functions to send data.
- We can create `data class` to store data and use `Serializable` to send them to other activities.

## Permissions

- We can ask for permissions to users by stating `uses-permission` in `AndroidManifest` file.
- `ActivityCompat.checkSelfPermission(Context: this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED`

## Implicit Intents

- `Intent(Intent.ACTION_GET_CONTENT).also {it.type = "image/*" startActivityForResult(it, request_code=0)}`
- `onActivityResult`

## Toolbar Menus

- `onCreateOptionsMenu(menu)` -> `menuInflator.inflate(R.menu.app_our_menu, menu)`
- `onOptionsItemSelected(item)` -> when(item.itemId)

## Fragments

An activity can host one or more fragments inside of it.
Fragments inside an activity are affected by the life cycle of their activity.
Using fragments, we don't have to create a whole new activity.

In Fragment class, there are two functions for initialization. 

- `onCreateView` inflates the view of fragment.
- `onCreate` 
- `onViewCreated` allows to access all the views within fragment.

Alternatively, we can pass in the id of fragment layout in Fragment().

`class FirstFragment : Fragment(R.layout.fragment_first)`

### Static Fragments

`android:name` allows to set the fragment we want to display.

### Dynamic Fragments

#### Fragment Transaction 

```kotlin
btnFragment.setOnClickListner{
  supportFragmentManager.beginTransaction().apply {
    replace(R.id.flFragment, firstFragment)
    addToBackStack(null) // navigates back to previous fragment
    commit()
  }
}
```
## Miscellenious Tips

- Refactor/Rename: **Shift + F6**
- Show all possible options: **Ctrl + Space**
- Rarrange XML attributes (id to the top): **Ctrl + Alt + L**
- Duplicate a line: **Ctrl + D**


## References

- [Android Fundamentals by Philipp Lackner](https://youtube.com/playlist?list=PLQkwcJG4YTCTq1raTb5iMuxnEB06J1VHX)