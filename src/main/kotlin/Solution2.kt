import java.util.*
import kotlin.collections.HashMap

class Solution2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val reader = Scanner(System.`in`)
            val n = reader.nextInt()

            val namingSystem = Solution2()
            for (i in 0..n) {
                val name = reader.nextLine()
                println(namingSystem.process(name))
            }
        }
    }

    fun process(name: String): String {
        val value = names.getOrDefault(name, 0)
        names.set(name, value + 1)
        return name + (if (value == 0) "" else value)
    }

    private val names = HashMap<String, Int>()
}