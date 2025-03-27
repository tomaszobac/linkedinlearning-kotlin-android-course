# Complete Guide to Android Development with Kotlin for Beginners
## Branch contents
2. Getting Started
   1. Create your first Android app
   2. Explore Android Studio
   3. Create virtual devices for testing
   4. Install device drivers on Windows
   5. Set up debugging on a physical device
   6. Android command-line tools
   7. Find answers in the documentation
3. Explore Android Projects
   1. Check out the exercise files on GitHub
   2. Explore the project structure
   3. Introduction to Gradle
   4. Manage Gradle build scripts
   5. Using dependencies
   6. Explore Jetpack components
   7. Troubleshoot Android Studio projects
   8. Challenge: Find the dependency
   9. Solution: Find the dependency
4. Kotlin for Android Development
   1. Quick look at Kotlin functions
   2. Work with Kotlin variables and expressions
   3. Work with Kotlin extension functions and properties
   4. Understand lambdas
   5. Define higher-order functions
   6. Execute code asynchronously with Kotlin Coroutines
5. Define Screens with Composables
   1. Define screens with Activities and Composables
   2. Implement designs using Composables
   3. Display UI elements with Column, Row, and Box
   4. Units of measurement in Android
   5. Use modifiers to customize your layout
   6. Challenge: Laying it out
   7. Solution: Laying it out
6. Create Themes and Styles
   1. Define visual styles and themes
   2. Configure Material Design theme colors
   3. Use Material Design Components
7. Display and Collect Text
   1. Manage string values as resources
   2. Style the text in your app
   3. Manage data entry with TextField
   4. Use string resources with placeholders
   5. Display snackbar messages
   6. Challenge: Get to know you
   7. Solution: Get to know you
8. Display Images
   1. Display image resources
   2. Load image resources at runtime
   3. Reduce file size with WebP images
   4. Use XML-based VectorDrawable images
   5. Create icons in Android Studio
   6. Challenge: Load a network image
   7. Solution: Load a network image
9. Manage Compose Lifecycle and State
   1. Understand composable functions
   2. Introduction to state in Compose
   3. Understand state hoisting
   4. Use the remember function
   5. Challenge: What state are you in?
   6. Solution: What state are you in?
10. Architecting Your Compose UI
	   1. Introduction to unidirectional data flow
	   2. Add a ViewModel to a composable
	   3. Store and publish data in a ViewModel
	   4. Challenge: Take my order
	   5. Solution: Take my order
11. Manage Navigation
	   1. Handle app communication with Intents
	   2. Share data with implicit Intents
	   3. Introduction to the Navigation component
	   4. Set up a navigation controller
	   5. Learn how to navigate between screens
12. Work with the Bottom Navigation Component
	   1. Add a bottom Navigation component
	   2. Handle navigation of navigation item events
	   3. Handle navigation with the back stack
	   4. Challenge: Badge of honor
	   5. Solution: Badge of honor
13. Package Static Data in JSON Files
	   1. Model an entity in a Kotlin data class
	   2. Read files from resources
	   3. Read files from assets
	   4. Parse JSON strings with Moshi
14. Get Data from a Web Service
	   1. Share data with StateFlow objects
	   2. Explore HTTP clients
	   3. Add Retrofit dependencies
	   4. Define a Retrofit interface
	   5. Retrieve remote data with Retrofit
15. Display Data in a LazyGrid
	   1. Explore lazy layouts in Compose
	   2. Add a LazyGrid to a composable screen
	   3. Create a grid item composable
	   4. Challenge: Random pics
	   5. Solution: Random pics
16. Display Selected Data Items
	   1. Handle lazy layout item click events
	   2. Navigate to a detail composable screen
	   3. Pass data in a ViewModel
	   4. Challenge: Lights, camera, action
	   5. Solution: Lights, camera, action
17. Read and Write Files
	   1. Manage storage on Android
	   2. Save files to internal storage
	   3. Read files from internal storage
	   4. Manage runtime permissions
	   5. Save files to external storage
18. Persist Data in DataStore
	   1. Explore Jetpack DataStore
	   2. Use the Preferences DataStore to manage user settings
	   3. Challenge: Read our newsletter
	   4. Solution: Read our newsletter
19. Manage Databases with Room
	   1. Manage data with Room
	   2. Define a database with Room
	   3. Define SQL operations in a DAO
	   4. Insert data with Room
	   5. Retrieve data with Room

This is the repository for the LinkedIn Learning course `Complete Guide to Android Development with Kotlin for Beginners`. The full course is available from [LinkedIn Learning][lil-course-url].

![lil-thumbnail-url]

This complete guide to Android development with Kotlin offers an overview of the basics of application management for new and early-career Android developers. Explore the foundational skills required to get up and running with everything from creating your first Android application and customizing architectural components like screens, text, and images, to understanding and managing data and storage like a pro. Along the way, instructor Annyce Davis offers practical tips on how to optimize your application and workflow. By the end of this course, you’ll be prepared to continue with the next steps on your Android learning journey.

_See the readme file in the main branch for updated instructions and information._
## Instructions
This repository has branches for each of the videos in the course. You can use the branch pop up menu in github to switch to a specific branch and take a look at the course at that stage, or you can add `/tree/BRANCH_NAME` to the URL to go to the branch you want to access.

## Branches
The branches are structured to correspond to the videos in the course. The naming convention is `CHAPTER#_MOVIE#`. As an example, the branch named `02_03` corresponds to the second chapter and the third video in that chapter. 
Some branches will have a beginning and an end state. These are marked with the letters `b` for "beginning" and `e` for "end". The `b` branch contains the code as it is at the beginning of the movie. The `e` branch contains the code as it is at the end of the movie. The `main` branch holds the final state of the code when in the course.

When switching from one exercise files branch to the next after making changes to the files, you may get a message like this:

    error: Your local changes to the following files would be overwritten by checkout:        [files]
    Please commit your changes or stash them before you switch branches.
    Aborting

To resolve this issue:
	
    Add changes to git using this command: git add .
	Commit changes using this command: git commit -m "some message"

## Instructor

Annyce Davis

Engineering Leader, International Conference Speaker, and Author
             

Check out my other courses on [LinkedIn Learning](https://www.linkedin.com/learning/instructors/annyce-davis?u=104).

[0]: # (Replace these placeholder URLs with actual course URLs)

[lil-course-url]: https://www.linkedin.com/learning/complete-guide-to-android-development-with-kotlin-for-beginners
[lil-thumbnail-url]: https://media.licdn.com/dms/image/v2/D4E0DAQEVl8ruJES7MA/learning-public-crop_675_1200/learning-public-crop_675_1200/0/1724188010632?e=2147483647&v=beta&t=e3E5FngiOudXD1U7eFvIrjpgZ6iWmVUC0U0jJ-Lua2Q

