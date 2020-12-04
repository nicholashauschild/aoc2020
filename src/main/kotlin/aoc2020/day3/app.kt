package aoc2020.day3

import aoc2020.processLines

// data structures
internal class Forest(
    val thinForests: List<ThinForest>
)

internal class ThinForest(
    val forestSpaces: List<ForestSpace>
) {
    override fun toString(): String {
        return forestSpaces.toString()
    }
}

internal class ForestSpace(
    val isTree: Boolean
) {
    override fun toString(): String {
        return isTree.toString()
    }
}

internal fun Forest.treesOnSlope(x: Int, y:Int): Int {
    var xCur = 0
    var trees = 0

    thinForests.filterIndexed { index, _ -> y == 1 || index % y == 0 }
        .forEach { forest ->
            //println(forest)
            if(forest.forestSpaces[xCur].isTree) { ++trees }
            xCur = (xCur + x) % forest.forestSpaces.size
        }
    return trees
}



// input processing
internal fun processedInput() : Forest {
    return Forest(processLines("input_3", ::createThinForest))
}

internal fun createThinForest(input: String): ThinForest {
    return ThinForest(input.map { ch -> ForestSpace(ch == '#')})
}