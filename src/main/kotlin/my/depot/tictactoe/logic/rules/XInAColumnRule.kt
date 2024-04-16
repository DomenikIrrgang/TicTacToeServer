package my.depot.tictactoe.logic.rules

import my.depot.tictactoe.logic.GameResult
import my.depot.tictactoe.logic.GameState
import my.depot.tictactoe.logic.Move
import my.depot.tictactoe.util.hasValueConsecutively

class XinAColumnRule constructor(private val amount: Int) : ProcessRule {

    override fun processMove(gameState: GameState, move: Move) {
        if (!gameState.isResolved()) {
            val column = gameState.getColumn(move.coordinate)
            if (column.hasValueConsecutively(move.agent, amount)) {
                gameState.result = GameResult.RESOLVED
                gameState.winner = move.agent
            }
        }
    }

}