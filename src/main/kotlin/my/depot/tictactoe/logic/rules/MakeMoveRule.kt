package my.depot.tictactoe.logic.rules

import my.depot.tictactoe.logic.GameState
import my.depot.tictactoe.logic.Move

class MakeMoveRule : ProcessRule("Executes the move.") {

    override fun processMove(gameState: GameState, move: Move) {
        gameState.setBoardAtPosition(move.coordinate, move.agent)
        gameState.moveCount++
    }

}