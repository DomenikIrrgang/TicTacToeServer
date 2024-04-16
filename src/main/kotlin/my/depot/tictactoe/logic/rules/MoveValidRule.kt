package my.depot.tictactoe.logic.rules

import my.depot.tictactoe.logic.GameState
import my.depot.tictactoe.logic.Move

interface MoveValidRule : GameRule {
    fun moveValid(gameState: GameState, move: Move): Boolean
}