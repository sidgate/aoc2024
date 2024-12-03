fun main() {
    val regex = """\s+""".toRegex()
    val reports = getLines("input/day02.2.txt").map {
        it.split(regex).map { it.toInt() }
    }
    println(reports.count(::isSafe))

    println(reports.count(::isSafe2))

}

fun isSafe2(level: List<Int>) = level.indices.any { idx ->
    val list = level.toMutableList().apply { removeAt(idx) }
    isSafe(list)
}

fun isSafe(it: List<Int>): Boolean {
    val diffs = it.zipWithNext { a,b-> a-b }
    return diffs.all { it in -3..3 } &&
            ( diffs.all { it>0 } || diffs.all { it<0 })

}
