import scala.collection.mutable.ArrayBuffer

class question1 {
    def bucketize(arr: Array[Double]): Array[String] = {
        val buckets = ArrayBuffer[String]()
        for (i <- arr) {
            val bucket = f"${math.floor(i)}%.3f-${math.floor(i) + 0.049}%.3f"
            buckets += bucket
        }
        buckets.toArray
    }
}

object question1 {
    def main(args: Array[String]): Unit = {
        val obj = new question1()
        val arr = Array(12.05, 12.03, 10.33, 11.45, 13.50)
        val result = obj.bucketize(arr)
        println(result.mkString("[", ", ", "]"))
    }
}
