package my.depot.tictactoe.logic.rules

import my.depot.tictactoe.logic.GameState
import my.depot.tictactoe.logic.Move

abstract class MoveValidRule(description: String) : GameRule(description) {
    abstract fun moveValid(gameState: GameState, move: Move): Boolean

}