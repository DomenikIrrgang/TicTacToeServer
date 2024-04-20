package my.depot.tictactoe.logic.rules

import my.depot.tictactoe.logic.GameState
import my.depot.tictactoe.logic.Move

class OutOfBoundsRule : MoveValidRule("Prevents making moves outside of the bounds of the board.") {

    override fun moveValid(gameState: GameState, move: Move): Boolean {
        return move.coordinate.x >= 0 && move.coordinate.x < gameState.width &&
                move.coordinate.y >= 0 && move.coordinate.y < gameState.height
    }

}