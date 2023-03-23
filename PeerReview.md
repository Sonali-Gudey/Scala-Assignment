## Peer Learning Assignment
### Shubham's Approach

#### Question-1:

- He defined a Scala function called "bucketize" that takes a list of double values and returns an ArrayBuffer of strings representing the bucket range in which each value falls.
- For each value, it first extracts the integer part of the number using integer division (p/1).toInt and the decimal part using modulo operation (p%1).
- Then it calculates the bucket number to which this value belongs by dividing the decimal part by the bucket size (0.049) and rounding up to the nearest integer using the ceil function from the math library.
- If the bucket number is 0, then the start value is just the integer part of the number. The start value is then rounded to 3 decimal places using the setScale method of the BigDecimal class with the RoundingMode.HALF_UP rounding mode.
- Finally, the code creates a string representation of the bucket range and appends it to the outputBucket ArrayBuffer. 

##### Output:
[12.050-12.099, 12.050-12.099, 10.300-10.349, 11.450-11.499, 13.500-13.549]

#### Question-2:

##### Task-1:
The code finds the player with the highest score (in runs) from the given players collection, using the 'maxBy' method. It then prints a message with the name of the player and their score.

##### Task-2:
The code finds the top five players with the highest score (in runs) from the players collection. It first sorts the collection in descending order of scores using the sortBy method. It then prints the names and scores of the top five players using a while loop.

##### Task-3:
The code finds the top five players with the highest number of wickets from the players collection. It first sorts the collection in descending order of wickets using the sortBy method. It then prints the names and number of wickets of the top five players using a while loop.

##### Task-4:
The code creates a new collection of players with scores calculated based on a specific formula (Wickets * 5 + Runs * 0.05). It first maps the players collection to a new collection with player names and their calculated scores. It then sorts the new collection in descending order of scores using the sortBy method. Finally, it prints the sorted collection with the name of each player and their score using a for loop.


### Shikhar's Approach

#### Question-1:

- This is a function that takes a double value as input and returns a string that represents a range of values.
- The function first calculates the remainder of the input value when multiplied by 1000 to determine if the value needs to be rounded up or down to the nearest 0.05.
- Depending on the remainder value, the function calculates the left and right boundaries of the range and formats them as strings with 3 decimal places, concatenating them with a hyphen to create the range string.

#### Question-2:

##### Task-1:
Sorted the list in descending order based on the runs scored by the players using sortby function and then top player instance is taken by using the take function.

##### Task-2:
Sorted the list in descending order based on the runs scored by the players using sortby function and then the top 5 players' instances are taken by using the take function.

##### Task-3:
Sorted the list in descending order based on the wickets taken by the players using sortby function and then the top 5 players' instances are taken by using the take function.

##### Task-4:
Sorted the list in descending order based on the performance taken by the players using sortwith function and then the rank of players is printed by a user-defined function.

#### Comparision:
- In the first question, Shubham calculated the integer and decimal parts of the input value seperately and finds the range to which it belongs to and appends it to the outputBucket ArrayBuffer, Shikhar on the other hand done this question in the similar way as me by using last two digits of the value of the input, using an if else condition we found the range. Shubham's code has more functionality as compared to Shikhar's and mine.
- In the second question, task-1, Shikhar used a loop to find the player with the highest runs while me and Shubham used maxBy function to find the player with the highest runs.
- In the second question, task-2, Shikhar and Shubham used a loop to iterate through the top 5 players and print their details with a numbering. They also sorted the players by runs scored in descending order using sortBy method and then reversing it. I used the 'zipWithIndex' method to iterate through the top 5 players and sorted the players by runs scored in descending order using 'sortBy' method and an ordering defined by 'Ordering[Int].reverse'.
- In the second question, task-3, Shikhar used functional programming concepts like sortBy, take, and foreach, Shubham used a while loop to iterate over the top 5 players, while I used a 'zipWithIndex' method to print each player's rank along with their details.
- In the second question, task-4, Shubham used a 'map' method to transform each player object into a tuple containing the player's name and their overall performance score. The formula for calculating the overall performance score is slightly different in each of our codes.
