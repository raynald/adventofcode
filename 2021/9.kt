fun part1(mat: MutableList<IntArray>) {
    var ans = 0
    for (i in 0..mat.size -1) {
        for (j in 0..mat[0].size - 1) {
            if ((i == 0 || mat[i-1][j] > mat[i][j]) && (i == mat.size - 1 || mat[i + 1][j] > mat[i][j])
                 && (j == 0 || mat[i][j- 1] > mat[i][j]) && (j == mat[0].size - 1 || mat[i][j + 1] > mat[i][j])) {
                ans += mat[i][j] + 1
            }
        }
    }
    println(ans)
}

fun search(x: Int, y: Int, mat: MutableList<IntArray>): Int {
    mat[x][y] = 9
    var ans = 1
    val n = mat.size
    val m = mat[0].size
    if (x < n - 1 && mat[x + 1][y] < 9) ans += search(x + 1, y, mat)
    if (y < m - 1 && mat[x][y + 1] < 9) ans += search(x, y + 1, mat)
    if (x > 0 && mat[x - 1][y] < 9) ans += search(x - 1, y, mat)
    if (y > 0 && mat[x][y - 1] < 9) ans += search(x, y - 1, mat)
    return ans
}
fun part2(mat: MutableList<IntArray>) {
    var box: MutableList<Int> = mutableListOf()
    for (i in 0..mat.size -1) {
        for (j in 0..mat[0].size - 1) {
            if (mat[i][j] < 9) {
                box.add(search(i, j, mat))
            }
        }
    }
    box.sortDescending()
    println(box[0] * box[1] * box[2])
}

fun main() {
    var mat: MutableList<IntArray> = mutableListOf()
    while (true) {
        val e = readLine()
        if (e == null) break
        val arr = e.map {it.code-48}.toIntArray()
        mat.add(arr)
    }
    // part1(mat)
    part2(mat)
}
