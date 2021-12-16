fun main() {
    var fish = readLine()!!.split(",").map {it.toInt()}
    var count = LongArray(9)
    for (item in fish) {
        count[item] ++
    }
    for (i in 1..256) {
        val temp = count[0]
        for (j in 0..7) {
            count[j] = count[j + 1]
        }
        count[8] = temp
        count[6] += temp
    }
    println(count.sum())
}
