package my.depot.tictactoe.logic

import jakarta.persistence.Entity
import my.depot.tictactoe.logic.rules.GameRule
import my.depot.tictactoe.logic.rules.MoveValidRule
import my.depot.tictactoe.logic.rules.ProcessRule

class GameState constructor(
    gameOptions: GameOptions
) {
    val width: Int = gameOptions.width
    val height: Int = gameOptions.height
    var agents: Array<Agent> = gameOptions.agents
    var rules: Array<GameRule> = gameOptions.rules.map { it.rule }.toTypedArray()
    var turn: Int = 1
    var moveCount: Int = 0
    val board: Array<Agent?> = Array<Agent?>(width * height) { null }
    var currentAgent: Agent? = if (agents.size > 0) agents[agents.indices.random()] else null
    var result: GameResult = GameResult.UNRESOLVED
    var winner: Agent? = null

    fun getBoardPosition(coordinate: Coordinate): Int = width * coordinate.y + coordinate.x

    fun getBoardAtPosition(coordinate: Coordinate): Agent? = board[getBoardPosition(coordinate)]

    fun setBoardAtPosition(coordinate: Coordinate, agent: Agent) {
        board[getBoardPosition(coordinate)] = agent
    }

    fun isResolved(): Boolean = result != GameResult.UNRESOLVED

    fun getRow(coordinate: Coordinate): Array<Agent?> {
        return board.filterIndexed { index, _ -> index / width == coordinate.y }.toTypedArray()
    }

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
        return result.toTypedArray()
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
        return result.toTypedArray()
    }

    fun makeMove(move: Move): Boolean {
        if (!canMakeMove(move)) return false
        processMoveRules(move)
        return true
    }

    private fun processMoveRules(move: Move) {
        rules.filterIsInstance<ProcessRule>().forEach {
            it.processMove(this, move)
        }
    }

    private fun canMakeMove(move: Move): Boolean {
        if (isResolved()) return false
        rules.filterIsInstance<MoveValidRule>().forEach {
            if (!it.moveValid(this, move)) {
                return@canMakeMove false
            }
        }
        return true
    }

    fun addRule(gameRule: GameRule): GameState {
        rules = rules.plus(gameRule)
        return this
    }

    fun addAgent(agent: Agent): GameState {
        if (currentAgent == null) currentAgent = agent
        agents = agents.plus(agent)
        return this
    }
}