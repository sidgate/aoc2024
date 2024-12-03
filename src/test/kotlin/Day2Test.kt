import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource

class Day2Test {
    companion object {
        @JvmStatic
        fun safeData() = listOf(
            of(listOf(7, 6, 4, 2, 1)),
            of(listOf(1, 3, 6, 7, 9)),
        )

        @JvmStatic
        fun unsafeData() = listOf(
            of(listOf(1, 2, 7, 8, 9)),
            of(listOf(9, 7, 6, 2, 1)),
            of(listOf(1, 3, 2, 4, 5)),
            of(listOf(8, 6, 4, 4, 1)),
            of(listOf(5, 3, 6, 7, 9)),
            of(listOf(1, 3, 6, 7, 6)),
        )

        @JvmStatic
        fun safeData2() = listOf(
            of(listOf(7, 6, 4, 2, 1)),
            of(listOf(1, 3, 6, 7, 9)),
            of(listOf(1, 3, 2, 4, 5)),
            of(listOf(8, 6, 4, 4, 1)),
            of(listOf(5, 3, 6, 7, 9)),
            of(listOf(1, 3, 6, 7, 6)),
        )

        @JvmStatic
        fun unsafeData2() = listOf(
            of(listOf(1, 2, 7, 8, 9)),
            of(listOf(9, 7, 6, 2, 1)),
        )
    }

    @ParameterizedTest
    @MethodSource("safeData")
    fun testSafe(list: List<Int>) {
        assertEquals(true, isSafe(list))
    }

    @ParameterizedTest
    @MethodSource("unsafeData")
    fun testunSafe(list: List<Int>) {
        assertEquals(false, isSafe(list))
    }

    @ParameterizedTest
    @MethodSource("safeData2")
    fun testSafe2(list: List<Int>) {
        assertEquals(true, isSafe2(list))
    }

    @ParameterizedTest
    @MethodSource("unsafeData2")
    fun testunSafe2(list: List<Int>) {
        assertEquals(false, isSafe2(list))
    }
}