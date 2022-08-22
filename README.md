# CHI_Internship_Android_Junior_Myslyva

Level 1 

Create Activity with a button in the center and  TextView above the button 
Every click on the button increases counter and shows how much you clicked in TextView

Level 2

Create Activity with RecyclerView with 7 hardcoded elements
Every item is User, User has fields like this – Name, Age, isStudent (boolean field)
Init isStudent = false for all users 

You should show the name, the age and the switcher/check box like the indicator if User is a student or not
You can change the indicator from true to false
When you scroll up/down, all indicators should save their status true/false
You should store User after changing the screen orientation
For saving User you can use DB or SharedPreferences
After clicking on the user item from RecyclerView you should open Fragment with detailed info about the clicked User – Name, Age and isStudent. This Fragment is static, you can’t change isStudent status like in Activity

Level 3

Use this API  - https://zoo-animal-api.herokuapp.com/animals/rand/10 It returns JSON with 10 random animals

Create Activity which shows Fragment and makes an internet request for fetch data.
Show fetched data in RecyclerView in any way you want – show us your UI/UX skill.
