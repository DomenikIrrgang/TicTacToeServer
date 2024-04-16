package my.depot.tictactoe.logic.rules

import my.depot.tictactoe.logic.GameState
import my.depot.tictactoe.logic.Move

interface ProcessRule : GameRule {

    fun processMove(gameState: GameState, move: Move)

}