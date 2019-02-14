import Solution1.solve
import org.apache.commons.lang3.StringUtils
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Solution1Test {

    @Test
    fun solveImpossibleBecauseOfPrefixName() {
        assertEquals(solve(arrayListOf("hello", "abcd", "abc")).size, 0)
    }

    @Test
    fun solveImpossibleBecauseOfCycle() {
        assertEquals(solve(arrayListOf("a", "b", "a")).size, 0)
        assertEquals(solve(arrayListOf("a", "b", "c", "db", "da")).size, 0)
    }

    @Test
    fun solvePossible() {
        var names = arrayListOf("a", "b", "c")
        validate(names, solve(names))

        names = arrayListOf("a", "b", "c", "ca", "cb")
        validate(names, solve(names))

        names = arrayListOf("c", "b", "a", "dx", "da")
        validate(names, solve(names))

        names = arrayListOf("andrey", "alex", "vladimir", "semen", "egor", "masha")
        validate(names, solve(names))
    }


    private fun validate(names: ArrayList<String>, permutation: List<Char>) {
        for (i in 1 until names.size) {
            val diff_position = StringUtils.indexOfDifference(names[i - 1], names[i])
            if (diff_position == -1) {
                continue
            }
            assertTrue(diff_position < names[i].length)
            if (diff_position == names[i - 1].length) {
                continue
            }
            val char1 = permutation.indexOf(names[i - 1][diff_position])
            val char2 = permutation.indexOf(names[i][diff_position])
            assertTrue(char1 < char2)
        }
    }

}
