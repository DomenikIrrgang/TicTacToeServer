package my.depot.tictactoe.logic.rules

import my.depot.tictactoe.logic.GameResult
import my.depot.tictactoe.logic.GameState
import my.depot.tictactoe.logic.Move
import my.depot.tictactoe.util.hasValueConsecutively

class XinADiagonalRule constructor(private val amount: Int) : ProcessRule("Declares a winner if an agent has a certain amount of tokens in a diagonal.") {

    override fun processMove(gameState: GameState, move: Move) {
        if (!gameState.isResolved()) {
            val diagonalLeft = gameState.getDiagonalLeft(move.coordinate)
            val diagonalRight = gameState.getDiagonalRight(move.coordinate)
            if (diagonalLeft.hasValueConsecutively(move.agent, amount) || diagonalRight.hasValueConsecutively(move.agent, amount) ) {
                gameState.result = GameResult.RESOLVED
                gameState.winner = move.agent
            }
        }
    }

}