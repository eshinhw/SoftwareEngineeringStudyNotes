# Kotlin Coroutines

## What is a Coroutine?

A **function** is a sequence of instructions that takes inputs and gives us outputs.
A **thread** describes in which context this sequence of instructions should be executed.

Running an app in a single thread has many disadvantages. This is why we are introduced the concept of multithreading.

**Multithreading** is useful for network calls and database operations which can be done in the background not affecting the UI.

## What distinguishes Coroutines from Threads?

**Coroutines** are light weight threads with some more extra functionalities.

- Coroutines are executed within a thread. We can start many coroutines inside a single thread.
- Coroutines are suspendable which means we can execute some instructions, pass the coroutine in the middle of execution, and let it continue when we want it to 
- Coroutines can switch their context easily from one thread to another thread.

## How to Start a Coroutine

```kotlin

ClobalScope.launch {
    delay(3000L) // on pause for one specific coroutine
    // sleep function makes pause on all coroutines (understand the difference!)
    Log.d(TAG, "message from coroutine")
}
```

If the main thread is finished, all coroutines are automatically destroyed even the ones with on pause or on delay.

## Suspend Functions

`Thread.currentThread().name` prints the name of current thread

Suspend function is a function that could be started, paused, and resume. One of the most important points to remember about the suspend functions is that **they are only allowed to be called from a coroutine or another suspend function.**

## Coroutine Contexts

```kotlin
GlobalScope.launch(Dispatchers.PARAMETER) {}
```
- `Dispatchers.Main`: useful for UI operations in coroutine 
- `Dispatchers.IO`: related to data operations (networking, database, writing to files)
- `Dispatchers.Default`
- `Dispatchers.Unconfined`
- `newSingleThreadContext("MyThread")`: custom thread context

`withContext(Dispatchers.Main)` changes thread.

## runBlocking

`runBlocking` actually blocks the main thread. It can be used for accessing suspend function from the main thread.


```kotlin
runBlocking {
    launch {
        // synchronized code blocks
    }
    Log.d(TAG, "Start of runBlocking")
    delay(5000L) // dealy function can be called inside runBlocking
    Log.d(TAG, "End of runBlocking")
}
```

the `launch` blocks inside `runBlocking` are synchronized which means they are executed at the same time.

## Jobs, Waiting and Cancellation

```kotlin
val job = GlobalScope.launch(Dispatchers.Default) {
    // repeat is a suspend function 
    repeat(5) { 
        Log.d(TAG, "Coroutine is still running...)
        delay(1000L)
    }
}

runBlocking {
    job.join() // join function makes the main thread wait until job is finished
    job.cancel() // cancel function cancels the job immediately
    Log.d(TAG, "Main Thread is continuing...")
}
```

## References

