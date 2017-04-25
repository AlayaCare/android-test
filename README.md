AlayaCare Android skill test
=============================


### What's included
The repo contains a skeleton Android application created using Android Studio 2.2 and Gradle 2.2. The app contains:
* NoteActivity: An empty activity to display a list of notes. 
* NoteModel: An empty data model to represent a note entity. 
* activity_note.xml: An empty XML view for the note activity. 

### Requirements
* Android Studio 2.2
* Gradle 2.2 (can be installed using Android Studio)
* Android SDK tools necessary platforms (can be installed using Android Studio SDK Manager)
* A github account

### Installation
* Fork this repository
* Open the directory in Android Studio 2.2
* The app should build and run if all requirements are met

### Instructions
The goal of this exercise is to create a very simple note app by following the tasks below. 
Code should be clear, easy to read, and modular. 

* TASK 1: Create a data source for the notes:
  * Add non-null `text` and non-null `date` fields to the note model
  * Create a mock API to return a list of fake notes asynchronously

* TASK 2: Display a list of notes in the note activity:
  * use the mock API to populate the list
  * each list item should display the note text and date

* Task 3: Implement logic for creating a new note:
  * do this however you want
  * storage can be in memory 
  * note text should not be empty
  * new notes should appear in the note activity

* Task 4: Add search functionality to your list of notes:
  * search should support matching to any part of the note text

* OPTIONAL Task 5: Save and delete notes
  * create a database to persist the notes
  * remove your mock API and save new notes to your database
  * add an option to delete a note from the list
