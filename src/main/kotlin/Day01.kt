import kotlin.math.abs

fun main() {

    val (list1, list2) =  getLines("input/day01.2.txt").map {
        it.split(Regex("\\s+")).map { it.toInt() }
    }.fold(Pair(emptyList<Int>(), emptyList<Int>())){acc, pair ->
        acc.first+pair[0] to acc.second + pair[1]
    }


    println(list1.sorted().zip(list2.sorted()).map {
        abs(it.first - it.second)
    }.sum())

    val list2Count = list2.groupingBy { it }.eachCount()

    println(list1.map {
        (list2Count[it] ?: 0) * it
    }.sum())

}