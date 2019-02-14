import org.junit.Assert.assertEquals
import org.junit.Test


class Solution2Test {

    @Test
    fun solveImpossibleBecauseOfPrefixName() {
        val solution = Solution2()
        assertEquals("ok", solution.process("andrey"))
        assertEquals("andrey1", solution.process("andrey"))
        assertEquals("andrey2", solution.process("andrey"))
        assertEquals("ok", solution.process("masha"))
        assertEquals("andrey3", solution.process("andrey"))
    }
}
