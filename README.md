# Project 9: Maintenance Tracker
v1.0 of Udacity Project 9 - Habit Tracker app

# Description
The goal of this project was to design and create the structure of a Habit Tracking app which would allow a user to store and track their habits over time. This project shouldn't have had any UI as its main task was to allow me to practice my SQLite3 storage skills in Android as I had to focus on what is happening behind the scenes, practicing how to design and implement a simple database. Still, I added some simple UI to help me track/visualize the changes. It is to be considered as a warm up project to "Project.10.Auto.Inventory".

My tasks in this project include:
- Creating an SQLite table in the app.
- Populating that table with new entries.
- Modifying the entries.
- Displaying the contents of the table to users via simple UI.

# Requirements
The design must include:
- Layout:
  - No UI is required for this project. (I still added some)
- Functionality:
  - The code compiles without errors. 
  - There exists a contract class that defines the name of table and constants. Inside the contract class, there is an inner class for each table created. 
  - There exists a subclass of SQLiteOpenHelper that overrides onCreate() and onUpgrade().
  - There is a single insert method that adds at least two values of two different datatypes (e.g. INTEGER, STRING) into the database using a ContentValues object and the insert() method. 
  - There is a single read method that returns a Cursor object. It should get the data repository in read and use the query() method to retrieve at least one column of data. 
  - No external libraries (e.g. Realm) are used for the database code, and no Content Providers is used. All data insertion and reading should be done using direct method calls to the SQLite database in the SQLiteOpenHelper class. 
- Code Readability:
  - The code is easily readable such that a fellow programmer can understand the purpose of the app. 
  - All variables, methods, and resource IDs are descriptively named such that another developer reading the code can easily understand their function.
  - The code is properly formatted: 
    - No unnecessary blank lines.
    - No unused variables or methods.
    - No commented out code.
    - The code also has proper indentation when defining variables and methods.
  
# Screenshots
[Screenshot 1](https://drive.google.com/open?id=12wM0ld6zmkhmuMAcPlMw-EvWUcOO866H) |
[Screenshot 2](https://drive.google.com/open?id=1hElGqNRyzLdbdARgEvL7FTpOwDSEg51-) |
[Screenshot 3](https://drive.google.com/open?id=1GXdh05UnYyn_6HHtBVnoWW-P87iLblag) |
[Screenshot 4](https://drive.google.com/open?id=1OY0MgbxjjmqH8y2YZlKjr-hGPZ36qFl5)
