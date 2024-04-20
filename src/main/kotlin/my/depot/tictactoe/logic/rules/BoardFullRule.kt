package my.depot.tictactoe.logic.rules

import my.depot.tictactoe.logic.GameResult
import my.depot.tictactoe.logic.GameState
import my.depot.tictactoe.logic.Move

class BoardFullRule : ProcessRule("Ends the game in a draw if the board is full and no winner has been declared.") {

    override fun processMove(gameState: GameState, move: Move) {
        if (!gameState.board.contains(null) && !gameState.isResolved()) {
            gameState.result = GameResult.DRAW
        }
    }

}