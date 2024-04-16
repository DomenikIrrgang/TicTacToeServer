package my.depot.tictactoe.logic.rules

import my.depot.tictactoe.logic.GameState
import my.depot.tictactoe.logic.Move

class AgentSwapTurnRule constructor(private val swapCondition: (GameState) -> Boolean): ProcessRule {

    override fun processMove(gameState: GameState, move: Move) {
        if (swapCondition(gameState)) {
            val newAgentIndex = gameState.agents.indexOf(gameState.currentAgent) + 1
            gameState.currentAgent = if (newAgentIndex >= gameState.agents.size) gameState.agents[0] else gameState.agents[newAgentIndex]
            gameState.moveCount = 0
        }
    }

}