fun main() {

    val input = getLines("input/day05.2.txt")


    val index = input.indexOfFirst { it.isEmpty() }

    val rules = input.subList(0, index).flatMap {
        val (first, second) = it.split("|").map { it.toInt() }
        listOf(Page(first, emptyList(), listOf(second)), Page(second, listOf(first), emptyList()))
    }.groupBy {
        it.value
    }.values.map {
        it.reduce { acc, p -> Page(p.value, acc.before + p.before, acc.after + p.after) }
    }.associateBy { it.value }


    val inputPages = input.subList(index + 1, input.size)
        .map { it.split(",").map { it.toInt() } }

    val sorted = inputPages.map {
        it.mapNotNull<Int, Page> { rules[it] }.sorted<Page>()
    }.map {
        it.map { it.value }
    }
    val result = sorted.filterIndexed { idx, it ->
        it == inputPages[idx]
    }.map {
        it[it.size / 2]
    }.sum()

    val result2 = sorted.filterIndexed { idx, it ->
        it != inputPages[idx]
    }.map {
        it[it.size / 2]
    }.sum()

    println(inputPages)
    println(result)
    println(result2)


}


data class Page(val value: Int, val before: List<Int>, val after: List<Int>) : Comparable<Page> {

    override fun compareTo(other: Page): Int {
        if (this.after.contains(other.value)) {
            return -1
        }
        if (before.contains(other.value)) {
            return 1
        }
        if (other.before.contains(value)) {
            return 1
        }
        if (other.after.contains(value)) {
            return -1
        }
        return value.compareTo(other.value)
    }

}
