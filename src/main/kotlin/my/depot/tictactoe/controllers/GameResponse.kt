package my.depot.tictactoe.controllers

import my.depot.tictactoe.logic.GameState

data class GameResponse(
    val id: Int,
    val state: GameState?
) {}