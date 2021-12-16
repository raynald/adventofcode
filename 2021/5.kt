fun main() {
    var mat: Array<IntArray> = Array(1000) { IntArray(1000) }
    while (true) {
        val x = readLine();
        if (x == null) break;
        val (a, b) = x.filter {it -> it != ' '}.split("->")
        val from = a.split(",").map {it.toInt()}
        val to = b.split(",").map {it.toInt()}
        if (from[0] == to[0]){
            if (from[1] < to[1]) {
                                   for (i in from[1]..to[1]) {
                                       mat[from[0]][i] ++
                                   }
            } else {
                                   for (i in to[1]..from[1]) {
                                       mat[from[0]][i] ++
                                   }
            }
        }
        if (from[1] == to[1]) {
            if (from[0] < to[0]) {
                                   for (i in from[0]..to[0]) {
                                       mat[i][from[1]] ++
                                   }
            } else {
                                   for (i in to[0]..from[0]) {
                                       mat[i][from[1]] ++
                                   }
            }
        }
        // Part 2: include diagonal
        if (from[0] - from[1] == to[0] - to[1]) {
            if (from[0] < to[0]) {
                                   for (i in from[0]..to[0]) {
                                       mat[i][from[1]-from[0] + i] ++
                                   }
            } else {
                                   for (i in to[0]..from[0]) {
                                       mat[i][from[1] - from[0] + i] ++
                                   }
            }
        }
        if (from[0] + from[1] == to[1] + to[0]) {
            if (from[0] < to[0]) {
                                   for (i in from[0]..to[0]) {
                                       mat[i][from[0] + from[1] - i] ++
                                   }
            } else {
                                   for (i in to[]..from[0]) {
                                       mat[i][from[0] + from[1] - i] ++
                                   }
            }
        }
    }
    var ans = 0
    for (i in 0..999) {
        for (j in 0..999) {
            if (mat[i][j] > 1) {
                ans ++
            }
        }
    }
    for (i in 0..9) {
        for (j in 0..9) {
            if (mat[i][j] > 0) print(mat[i][j]) else print('.')
        }
        println()
    }

    println(ans)
}
