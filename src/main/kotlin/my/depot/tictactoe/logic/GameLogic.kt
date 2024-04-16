package my.depot.tictactoe.logic

import my.depot.tictactoe.logic.rules.MoveValidRule
import my.depot.tictactoe.logic.rules.ProcessRule

class GameLogic {

    fun makeMove(gameState: GameState, move: Move): Boolean {
        if (!canMakeMove(gameState, move)) return false
        processMoveRules(gameState, move)
        return true
    }

    private fun processMoveRules(gameState: GameState, move: Move) {
        gameState.rules.filterIsInstance<ProcessRule>().forEach {
            it.processMove(gameState, move)
        }
    }

    private fun canMakeMove(gameState: GameState, move: Move): Boolean {
        if (gameState.isResolved()) return false
        gameState.rules.filterIsInstance<MoveValidRule>().forEach {
            if (!it.moveValid(gameState, move)) {
                return@canMakeMove false
            }
        }
        return true
    }

}