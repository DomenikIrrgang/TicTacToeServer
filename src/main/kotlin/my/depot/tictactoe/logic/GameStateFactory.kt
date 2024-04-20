package my.depot.tictactoe.logic

import my.depot.tictactoe.logic.GameState

interface GameStateFactory {
    fun createGameState(gameOptions: GameOptions): GameState
}