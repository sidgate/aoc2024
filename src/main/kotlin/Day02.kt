fun main() {
    val regex = """\s+""".toRegex()
    val reports = getLines("input/day02.1.txt").map {
        it.split(regex).map { it.toInt() }
    }
    println(reports.count(::isSafe))

    println(reports.count(::isSafe2))

}

fun isSafe2(level: List<Int>): Boolean {
    return level.indices.asSequence().map { idx->
        level.subList(0, idx) + level.subList(idx + 1, level.size)
    }.any(::isSafe)
}

fun isSafe(it: List<Int>): Boolean {
    val diffs = it.zipWithNext { a,b-> a-b }
    return diffs.all { it in 1..3 } || diffs.all { it in -3..-1 }
}
