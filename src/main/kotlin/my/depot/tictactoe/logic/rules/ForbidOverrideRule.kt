package my.depot.tictactoe.logic.rules

import my.depot.tictactoe.logic.GameState
import my.depot.tictactoe.logic.Move

class ForbidOverrideRule : MoveValidRule {

    override fun moveValid(gameState: GameState, move: Move): Boolean = gameState.getBoardAtPosition(move.coordinate) == null

}