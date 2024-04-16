package my.depot.tictactoe.logic.rules

import my.depot.tictactoe.logic.GameState
import my.depot.tictactoe.logic.Move

class AgentTurnRule : MoveValidRule {

    override fun moveValid(gameState: GameState, move: Move): Boolean = gameState.currentAgent == move.agent

}