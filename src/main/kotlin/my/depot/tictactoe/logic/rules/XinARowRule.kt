package my.depot.tictactoe.logic.rules

import my.depot.tictactoe.logic.GameResult
import my.depot.tictactoe.logic.GameState
import my.depot.tictactoe.logic.Move
import my.depot.tictactoe.util.hasValueConsecutively

class XinARowRule constructor(private val amount: Int) : ProcessRule("Declares a winner if an agent has a certain amount of tokens in a row.") {

    override fun processMove(gameState: GameState, move: Move) {
        if (!gameState.isResolved()) {
            val row = gameState.getRow(move.coordinate)
            if (row.hasValueConsecutively(move.agent, amount)) {
                gameState.result = GameResult.RESOLVED
                gameState.winner = move.agent
            }
        }
    }

}