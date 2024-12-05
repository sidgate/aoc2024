fun main() {

    val input = getLines("input/day04.1.txt")

    // horizontal
    var result = input.sumOf {
        it.split("XMAS").size - 1
    } + input.sumOf {
        it.split("SAMX").size - 1
    }

    val lineCount = input.size

    //vertical
    input.forEachIndexed { index, line ->
        line.forEachIndexed { i, ch ->
            if (ch == 'X') {
                if (index >= 3 && input[index - 1][i] == 'M' && input[index - 2][i] == 'A' && input[index - 3][i] == 'S') {
                    result++
                }
                if (index < lineCount - 3 && input[index + 1][i] == 'M' && input[index + 2][i] == 'A' && input[index + 3][i] == 'S') {
                    result++
                }
            }
        }
    }

    //diagonal
    input.forEachIndexed { index, line ->
        line.forEachIndexed { i, ch ->
            if (ch == 'X') {
                if (index >= 3 && i >= 3 && input[index - 1][i - 1] == 'M' && input[index - 2][i - 2] == 'A' && input[index - 3][i - 3] == 'S') {
                    result++
                }
                if (index >= 3 && i < line.length - 3 && input[index - 1][i + 1] == 'M' && input[index - 2][i + 2] == 'A' && input[index - 3][i + 3] == 'S') {
                    result++
                }
                if (index < lineCount - 3 && i >= 3 && input[index + 1][i - 1] == 'M' && input[index + 2][i - 2] == 'A' && input[index + 3][i - 3] == 'S') {
                    result++
                }
                if (index < lineCount - 3 && i < line.length - 3 && input[index + 1][i + 1] == 'M' && input[index + 2][i + 2] == 'A' && input[index + 3][i + 3] == 'S') {
                    result++
                }
            }
        }
    }

    println(result)

    part2(input)

}

private fun part2(input: List<String>) {
    var diag2 = 0

    input.mapIndexed { index, line -> index to line }
        .filter { (index, _) -> index > 0 && index < input.size - 1 }
        .forEach { (index, line) ->
            line.mapIndexed { i, ch -> i to ch }
                .filter { (i, ch) -> ch == 'A' && i > 0 && i < line.length - 1 }
                .forEach { (i, _) ->
                    val topLeft = input[index - 1][i - 1]
                    val bottomLeft = input[index + 1][i - 1]
                    val topRight = input[index - 1][i + 1]
                    val bottomRight = input[index + 1][i + 1]
                    if (topLeft == 'M' && bottomLeft == 'M' && topRight == 'S' && bottomRight == 'S') diag2++

                    if (topLeft == 'S' && bottomLeft == 'S' && topRight == 'M' && bottomRight == 'M') diag2++

                    if (topLeft == 'S' && bottomLeft == 'M' && topRight == 'S' && bottomRight == 'M') diag2++

                    if (topLeft == 'M' && bottomLeft == 'S' && topRight == 'M' && bottomRight == 'S') diag2++
                }
        }

    println(diag2)
}

