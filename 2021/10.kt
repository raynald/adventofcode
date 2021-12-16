fun part1() {
    val parMap = mapOf('(' to ')', '[' to ']', '<' to '>', '{' to '}')
    var result = 0
    while (true) {
        val e = readLine()
        if (e == null) break
        var str = ""
        var ans = 0
        println("This is: ----")
        println(e)
        for (ch in e) {
            println(str)
            if (ch == ')') {
                if (str.last() != '(') {
                    println("error: expected '" + parMap[str.last()] + "', got ')'")
                    ans = 3
                    break
                } else str = str.dropLast(1)
            } else if (ch == ']') {
                if (str.last() != '[') {
                    println("error: expected '" + parMap[str.last()] + "', got ']'")
                    ans = 57
                    break
                } else str = str.dropLast(1)
            } else if (ch == '}') {
                if (str.last() != '{') {
                    println("error: expected '" + parMap[str.last()] + "', got '}'")
                    ans = 1197
                    break
                } else str = str.dropLast(1)
            } else if (ch == '>') {
                if (str.last() != '<') {
                    println("error: expected '" + parMap[str.last()] + "', got '>'")
                    ans = 25137
                    break
                } else str = str.dropLast(1)
            } else {
                str += ch
            }
            if (ans > 0) break
        }
        result += ans
    }
    println(result)
}

fun part2() {
    val parMap = mapOf('(' to ')', '[' to ']', '<' to '>', '{' to '}')
    var ansList: MutableList<Long> = mutableListOf()
    while (true) {
        val e = readLine()
        if (e == null) break
        var str = ""
        var ans = 0
        for (ch in e) {
            if (ch == ')') {
                if (str.last() != '(') {
                    println("error: expected '" + parMap[str.last()] + "', got ')'")
                    ans = 3
                    break
                } else str = str.dropLast(1)
            } else if (ch == ']') {
                if (str.last() != '[') {
                    println("error: expected '" + parMap[str.last()] + "', got ']'")
                    ans = 57
                    break
                } else str = str.dropLast(1)
            } else if (ch == '}') {
                if (str.last() != '{') {
                    println("error: expected '" + parMap[str.last()] + "', got '}'")
                    ans = 1197
                    break
                } else str = str.dropLast(1)
            } else if (ch == '>') {
                if (str.last() != '<') {
                    println("error: expected '" + parMap[str.last()] + "', got '>'")
                    ans = 25137
                    break
                } else str = str.dropLast(1)
            } else {
                str += ch
            }
            if (ans > 0) break
        }
        if (ans == 0) {
            var score: Long = 0
            val scoreMap = mapOf('(' to 1, '[' to 2, '<' to 4, '{' to 3)
            for (ch in str.reversed()) {
                score = score * 5 + scoreMap.getOrDefault(ch, 0)
            }
            ansList.add(score)
        }
    }
    ansList.sort()
    println(ansList.joinToString())
    println(ansList[ansList.size / 2])
}

fun main() {
    // part1()
    part2()
}
