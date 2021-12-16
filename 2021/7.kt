fun part1(input: IntArray) {
    input.sort()
    val pivot = input[input.size / 2]
    var ans = 0
    for (item in input) {
        ans += Math.abs(item - pivot)
    }
    println(ans)
}

fun part2(input: IntArray) {
    input.sort()
    var result  = Int.MAX_VALUE
    for (i in input[0]..input[input.size - 1]) {
        var ans = 0
        for (item in input) {
            val step = Math.abs(item - i)
            ans += step * (step + 1) / 2
        }
        result = Math.min(result, ans)
    }
    println(result)
}

fun main() {
    val input = readLine()!!.split(",").map {it.toInt()}.toIntArray()
    part2(input)
}
