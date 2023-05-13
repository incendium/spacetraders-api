This repository is a work-in-progress implementation of the SpaceTraders API in Kotlin leveraging coroutines.  The API 
is by no means stable, so expect some churn in the near term.

The goal for this project is to have an easy to use, functional programming-friendly API client which supports most MPP 
targets.  The big goals are to support at least Kotlin/JVM, Kotlin/JS, and Kotlin/WASM.  Contributors are most welcome 
to help implement other targets such as Android, iOS, Native, etc.

Once the implementation is complete enough and tested, there are plans to have artifacts available in Maven Central.
