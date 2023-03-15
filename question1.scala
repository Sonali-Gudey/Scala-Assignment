class question1() {
    def bucketize(n: Double): Unit = {
        // Fetching the last two digits
        var last_two_digits = (n * 1000) % 100
        print(f"Value : $n")

        /*
        If the value of the last two digits after the decimal point is greater than or equal to 50,
        then the bucket range is from `n - (last two digits/1000) + 0.050 to n + (99 - last two digits)/1000
        */

        if (last_two_digits >= 50) {
            val left = n - (last_two_digits / 1000) + 0.050
            val right = n + (99 - last_two_digits) / 1000
            print(f" Bucket : $left%,.3f" + " - " + f"$right%,.3f\n")

            /*
            Otherwise, the bucket range is from `n - (last two digits/1000) to n + (49 - last two digits)/1000
            */

        } else {
            val left = n - (last_two_digits / 1000)
            val right = n + (49 - last_two_digits) / 1000
            print(f" Bucket : $left%,.3f" + " - " + f"$right%,.3f\n")
        }
    }
}

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
