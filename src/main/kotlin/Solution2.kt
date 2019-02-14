import java.util.*
import kotlin.collections.HashMap

class Solution2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val reader = Scanner(System.`in`)
            val n = reader.nextInt()

            val namingSystem = Solution2()
            for (i in 1..n) {
                val name = readLine()!!
                println(namingSystem.process(name))
            }
        }
    }

    fun process(name: String): String {
        val value = names.getOrDefault(name, 0)
        names.set(name, value + 1)
        return if (value == 0) "ok" else name + value
    }

    private val names = HashMap<String, Int>()
}