package my.depot.tictactoe.logic

class DefaultGameStateFactory: GameStateFactory {

    override fun createGameState(gameOptions: GameOptions): GameState {
        return GameState(gameOptions)
    }

}