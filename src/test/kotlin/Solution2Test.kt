import org.junit.Assert.assertEquals
import org.junit.Test


class Solution2Test {

    @Test
    fun solveImpossibleBecauseOfPrefixName() {
        val solution = Solution2()
        assertEquals(solution.process("andrey"), "andrey")
        assertEquals(solution.process("andrey"), "andrey1")
        assertEquals(solution.process("andrey"), "andrey2")
        assertEquals(solution.process("masha"), "masha")
        assertEquals(solution.process("andrey"), "andrey3")
    }
}
