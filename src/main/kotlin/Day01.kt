import kotlin.math.abs

fun main() {

    val regex = Regex("\\s+")
    val (list1, list2) = getLines("input/day01.1.txt").map {
        it.split(regex).map { it.toLong() }.let {
            it[0] to it[1]
        }
    }.unzip()


    val result1 = list1.sorted().zip(list2.sorted()).map {
        abs(it.first - it.second)
    }.sum()
    println(result1)

    val list2Count = list2.groupingBy { it }.eachCount()

    val result2 = list1.map {
        list2Count.getOrDefault(it, 0) * it
    }.sum()
    println(result2)

}