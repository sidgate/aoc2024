fun main() {
    println("1232".substring(2,-1))

    val regex = """mul\((\d+),(\d+)\)""".toRegex()
    val lines = getLines("input/day03.2.txt")
    val result = lines.flatMap {
        regex.findAll(it).map {
            it.groups[1]!!.value.toInt() * it.groups[2]!!.value.toInt()
        }
    }.sum()
    println(result)

    val input = getText("input/day03.2.txt")
    var indexOfDo = 0
    var sum = 0
    var stop = false
    while (!stop){
        var indexOfDont = input.indexOf("don't()", indexOfDo)
        if(indexOfDont <0) {
            indexOfDont = input.length -1
            stop = true
        }
        val substring = input.substring(indexOfDo, indexOfDont)
        sum += regex.findAll(substring).map {
            it.groups[1]!!.value.toInt() * it.groups[2]!!.value.toInt()
        }.sum()
        indexOfDo = input.indexOf("do()", indexOfDont)
        if(indexOfDo <0) stop = true

    }
    println(sum)


}
