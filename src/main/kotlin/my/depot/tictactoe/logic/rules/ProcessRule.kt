package my.depot.tictactoe.logic.rules

import my.depot.tictactoe.logic.GameState
import my.depot.tictactoe.logic.Move

abstract class ProcessRule(description: String) : GameRule(description) {

    abstract fun processMove(gameState: GameState, move: Move)

}