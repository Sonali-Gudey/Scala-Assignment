# Scala-Assignment

#### Question-1

1. Bucketise the given array[Double] into buckets having range interval (x, x+0.049).

```
0.000 - 0.049
0.050 - 0.099
0.100 - 0.149
0.150 - 0.199
0.200 - 0.249
0.250 - 0.299
0.300 - 0.349
0.350 - 0.399 
...
...
100.000 - 100.049
```

##### Code:

```
class question1() {
    def bucketize(n: Double): Unit = {
        var last_two_digits = (String.format("%.2f", Double.valueOf((n * 1000) % 100)))
        print(f"Value : $n")
        
        if (last_two_digits.toDouble >= 50) {
            val left = n - (last_two_digits.toDouble / 1000) + 0.050
            val right = n + (99 - last_two_digits.toDouble) / 1000
            print(f" Bucket : $left%,.3f" + " - " + f"$right%,.3f\n")
        
        } else {
            val left = n - (last_two_digits.toDouble / 1000)
            val right = n + (49 - last_two_digits.toDouble) / 1000
            print(f" Bucket : $left%,.3f" + " - " + f"$right%,.3f\n")
        }
    }
}
```

- If last_two_digits is greater than or equal to 50, then the bucket range is calculated by subtracting the last two digits of n from n, adding 0.050, and adding 99 minus the last two digits of n, respectively, and then printing out the bucket range.

- Otherwise, the bucket range is calculated by subtracting the last two digits of n from n and adding 49 minus the last two digits of n, respectively, and then printing out the bucket range.

```
object question1 {
    def main(args: Array[String]): Unit = {
        val obj = new question1()
        //Storing the values in an Array and fetching the bucket related to the given values. 
        val values = Array(12.05, 12.99, 10.33, 11.45, 13.50)
        for (i <- values) {
            obj.bucketize(i)
        }
    }
}
```

##### Output:
<img width="398" alt="Screenshot 2023-03-14 at 12 40 12 PM" src="https://user-images.githubusercontent.com/123619701/224928659-1d5dbdf8-053e-4b3b-ae1d-ab6d4ad7af42.png">


#### Question-2

For given players statistics..
    Found the below -
1. Player with the best highest run scored.
2. Top 5 players by run scored.
3. Top 5 players by wicket taken.
4. Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored.

```
case class Player(Year: Int, Name: String, Country: String, Matches: Int, Runs: Int, Wickets: Int)

```

The above is the case class definition for a player object. It has six attributes:

- Year: an integer representing the year in which the player played.
- Name: a string representing the name of the player.
- Country: a string representing the country that the player represents.
- Matches: an integer representing the number of matches that the player played.
- Runs: an integer representing the number of runs that the player scored.
- Wickets: an integer representing the number of wickets that the player took.

##### Task - 1:
Player with the highest run scored

```
val playerWithMaxRuns = players.maxBy(_.Runs)
        println(s"==> Player with the highest run scored: \n ${playerWithMaxRuns.Name} from ${playerWithMaxRuns.Country}, with ${playerWithMaxRuns.Runs} runs.")
```

##### Task - 2:
Top 5 players by run scored

```
val top5PlayersByRuns = players.sortBy(_.Runs)(Ordering[Int].reverse).take(5)
        println("==> Top 5 players by run scored:")
        top5PlayersByRuns.zipWithIndex.foreach { case (p, i) =>
            println(s" ${i + 1}. ${p.Name} from ${p.Country} with ${p.Runs} runs.")
        }
```

##### Task - 3:
Top 5 players by wicket taken

```
val top5PlayersByWickets = players.sortBy(_.Wickets)(Ordering[Int].reverse).take(5)
        println("==> Top 5 players by wicket taken:")
        top5PlayersByWickets.zipWithIndex.map { case (p, i) =>
            println(s" ${i + 1}. ${p.Name} from ${p.Country} with ${p.Wickets} wickets.")
        }
```

##### Task - 4:
Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored

```
val rankedPlayers = players.sortBy(p => (p.Wickets * 5 + p.Runs * 5 / 100.0))(Ordering[Double].reverse)
        println("==> Ranking of players based on overall performance:")
        rankedPlayers.zipWithIndex.foreach { case (p, i) =>
            println(s" ${i + 1}. ${p.Name} from ${p.Country} with ${p.Runs} runs and ${p.Wickets} wickets, overall score ${p.Wickets * 5 + p.Runs * 5 / 100.0}")
        }
```

The below code is a Scala code snippet defining a private method called read_data_from_file, which returns a list of Player objects. The method reads data from a file located at the path "//Users//sonali_gudey//Desktop//player_stats.txt" using the Source.fromFile method of the scala.io package.

```
private def read_data_from_file(): List[Player] = {
        Source.fromFile("//Users//sonali_gudey//Desktop//player_stats.txt").getLines()
            .map(line => {
                val Array(year, name, country, matches, runs, wickets) = line.split(", ")
                Player(year.toInt, name, country, matches.toInt, runs.toInt, wickets.toInt)
            })
            .toList
    }
```
##### Output:
<img width="771" alt="Screenshot 2023-03-14 at 3 10 48 PM" src="https://user-images.githubusercontent.com/123619701/224960402-53974298-ac59-4a60-8f94-a287e2592708.png">

