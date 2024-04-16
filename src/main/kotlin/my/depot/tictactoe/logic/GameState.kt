package my.depot.tictactoe.logic

import my.depot.tictactoe.logic.rules.GameRule

class GameState constructor(
        val width: Int,
        val height: Int,
        val agents: Array<Agent>,
        val rules: Array<GameRule>,
) {
    var turn: Int = 1
    var moveCount: Int = 0
    val board: Array<Agent?> = Array<Agent?>(width * height) { i -> null }
    var currentAgent: Agent = agents[(0..(agents.size - 1)).random()]
    var result: GameResult = GameResult.UNRESOLVED
    var winner: Agent? = null

    private fun getBoardPosition(coordinate: Coordinate): Int = width * coordinate.y + coordinate.x

    fun getBoardAtPosition(coordinate: Coordinate): Agent? = board[getBoardPosition(coordinate)]

    fun setBoardAtPosition(coordinate: Coordinate, agent: Agent) {
        board[getBoardPosition(coordinate)] = agent
    }

    fun isResolved(): Boolean = result != GameResult.UNRESOLVED

    fun getRow(coordinate: Coordinate): Array<Agent?> = board.copyOfRange(width * coordinate.y, width * coordinate.y + width)

    fun getColumn(coordinate: Coordinate): Array<Agent?> {
        return board.filterIndexed { index, _ -> index % width == coordinate.x }.toTypedArray()
    }

    fun getDiagonalLeft(coordinate: Coordinate): Array<Agent?> {
        var index = Coordinate(
                coordinate.x - (if (coordinate.x > coordinate.y) coordinate.y else coordinate.x),
                coordinate.y - (if (coordinate.y > coordinate.x) coordinate.x else coordinate.y)
        )
        val result = ArrayList<Agent?>()
        while (index.x < width && index.y < height) {
            result.add(getBoardAtPosition(index))
            index = Coordinate(index.x + 1, index.y + 1)
        }
        return board
    }

    fun getDiagonalRight(coordinate: Coordinate): Array<Agent?> {
        val distanceToRight = width - 1 - coordinate.x
        val distanceToTop = coordinate.y
        val smallestDistance = if (distanceToRight < distanceToTop) distanceToRight else distanceToTop
        var index = Coordinate(
                coordinate.x + smallestDistance,
                coordinate.y - smallestDistance
        )
        val result = ArrayList<Agent?>()
        while (index.x >= 0 && index.y < height) {
            result.add(getBoardAtPosition(index))
            index = Coordinate(index.x - 1, index.y + 1)
        }
        return board
    }
}