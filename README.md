# Android Fundamentals

Below contents are basic concepts of Kotlin and Android App Development in Android Studio created by [Philipp Lackner](https://www.youtube.com/channel/UCKNTZMRHPLXfqlbdOI7mCkg) on YouTube. You can find the full video series [here](https://youtube.com/playlist?list=PLQkwcJG4YTCTq1raTb5iMuxnEB06J1VHX).

## Activities and Lifecycle

Activity in Android is simple Kotlin Class.
    Each activity can be represented by a Kotlin class.
    MainActivity inherits from AppCompatActivity()

    When there are multiple activities running at the same time,
    it uses a STACK to manage multiple activities.
    At the bottom of the STACK, there is FirstActivity.
    When second activity is initiated, the second activity goes on top of the first activity in the stack.

    |                 |
    | Second Activity |
    | First Activity  |

    When an user presses a back button, the current activity gets popped out of the stack, and returns
    the activity right below the one which just popped.

    Activity is started
        -> onCreate() is called
        -> onStart()
        -> onResume() at this point, the activity is at the top of the activity stack.
        -> Activity Running
        -> onPause() the activity goes to the background (guaranteed to be called, should save data onPause())
        -> onResume() when the activity gets the user's focus, it starts onResume() (don't recreate it)
        -> onStop() (not guaranteed to be called)
        -> onDestroy() # Activity shut down
    If app process is killed, we have to create the activity all over again from onCreate()

<p align="center">
  <img width="600" height="450" src="https://user-images.githubusercontent.com/41933169/165211141-3708dbb5-fca7-4c0f-b64a-9e5c50631118.png">
</p>

Android uses an activity stack to manage multiple activities running at the same time.

<p align="center">
  <img width="1000" height="500" src="https://user-images.githubusercontent.com/41933169/165211071-9a2f7211-c338-4271-b3b2-1a3613d7c768.png">
</p>

There are different kinds of lifecycle functions in Android with different purposes.

## Logcat: Solving Errors in Android Studio

### Types of Log Messages

- **Verbose (Log.v)**: show all log messages
- **Debug (Log.d)**: shows all log messages related to Debug and everything else below (Info, Warn, Error and Assert)
- **Info (Log.i)**: shows all log messages related to Info and everything else below (Warn, Error, and Assert)
- In similar manner, we can select which types of log messages we want to display on Logcat.
- We can search log messages by tags to just display what we want.

### What We Look For in Logcat

- From Logcat, the useful information we can find is sometimes from "Caused by" clause. 
- "Caused by" clause provides specific error messages.
- Also, the blue links on Logcat lead us the locations of error sources.

## Linear Layout Basics

<p align="center">
  <img width="700" height="400" src="https://user-images.githubusercontent.com/41933169/165412375-7110391a-8af2-4e1b-b7b9-8d43fa9d16e3.png">
</p>

In order to create a layout which looks above using Linear Layout, we have to create sub-layouts below the parent layout.

- Density Independent Pixels (dp or dip): an abstract unit that is based on the physical density of the screen. These units are relative to a 160 dpi screen, so one dp is one pixel on a 160 dpi screen. The ratio of dp-to-pixel will change with the screen density, but not necessarily in direct proportion. Note: The compiler accepts both "dip" and "dp", though "dp" is more consistent with "sp".
- Scaleable Independent Pixels (sp): this is like the dp unit, but it is also scaled by the user's font size preference. It is recommended you use this unit when specifying font sizes, so they will be adjusted for both the screen density and the user's preference. Note, the Android documentation is inconsistent on what sp actually stands for, one doc says "scale-independent pixels", the other says "scaleable pixels".
- padding
- match_parent vs. wrap_content
- layout_weight: When organizing multiple views over the horizontal frame, we can use layout_weight to give them unique weights.
- orientation: horizontal vs. vertical

## Constraint Layout Basics

- Constraint Layout helps us flatten the layout hierarchy and build simple layout designs.
- Don't use Expand Horizontally and Expand Vertically features. They are not reliable.
- The best practice with Constraint Layout is to set each constraint manually.

## Chains and Guidelines

- Chains + 0 widths give views equal widths horizontally.
- Helpers: Vertical or Horizontal Guidelines

## Buttons

- **Shift + F6** refactors/renames.
- There are two ways of accessing buttons or views in Kotlin.
```
val btnABC = findViewById(R.id.btnABC) # java way
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

## Textviews

<p align="center">
  <img width="500" height="800" src="https://user-images.githubusercontent.com/41933169/165643542-6ddcbecc-0d86-4f7a-9b76-6afc35c35138.png">
</p>

- textSize: use sp
- textStyle
- textAlignment
- **Ctrl + Alt + L**: Rarrange XML attributes (id to the top)

## EditText

**Ctrl + Space**: shows all possible options
- ems: if layout_width == "wrap_content", ems sets how many capital letters can be fitted into EditText (adjusts the length of EditText)
- hint
- inputType: if "number", only shows the numeric keyboard. if "textPassword", shows the keyboard for password. if "phone", shows the phone keyboard.
- 



