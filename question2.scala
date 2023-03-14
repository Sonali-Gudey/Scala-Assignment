import scala.io.Source

case class Player(Year: Int, Name: String, Country: String, Matches: Int, Runs: Int, Wickets: Int)

object question2 {
    def main(args: Array[String]): Unit = {
        val players = read_data_from_file()

        // Task 1: Player with the highest run scored
        val playerWithMaxRuns = players.maxBy(_.Runs)
        println(s"==> Player with the highest run scored: \n ${playerWithMaxRuns.Name} from ${playerWithMaxRuns.Country}, with ${playerWithMaxRuns.Runs} runs.")

        // Task 2: Top 5 players by run scored
        val top5PlayersByRuns = players.sortBy(_.Runs)(Ordering[Int].reverse).take(5)
        println("==> Top 5 players by run scored:")
        top5PlayersByRuns.foreach(p => println(s" ${p.Name} from ${p.Country} with ${p.Runs} runs."))

        // Task 3: Top 5 players by wicket taken
        val top5PlayersByWickets = players.sortBy(_.Wickets)(Ordering[Int].reverse).take(5)
        println("==> Top 5 players by wicket taken:")
        top5PlayersByWickets.foreach(p => println(s" ${p.Name} from ${p.Country} with ${p.Wickets} wickets."))

        // Task 4: Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored
        val rankedPlayers = players.sortBy(p => (p.Wickets * 5 + p.Runs * 5 / 100.0))(Ordering[Double].reverse)
        println("==> Ranking of players based on overall performance:")
        rankedPlayers.zipWithIndex.foreach { case (p, i) =>
            println(s" ${i + 1}. ${p.Name} from ${p.Country} with ${p.Runs} runs and ${p.Wickets} wickets, overall score ${p.Wickets * 5 + p.Runs * 5 / 100.0}")
        }
    }

    private def read_data_from_file(): List[Player] = {
        Source.fromFile("//Users//sonali_gudey//Desktop//player_stats.txt").getLines()
            .map(line => {
                val Array(year, name, country, matches, runs, wickets) = line.split(", ")
                Player(year.toInt, name, country, matches.toInt, runs.toInt, wickets.toInt)
            })
            .toList
    }
}
