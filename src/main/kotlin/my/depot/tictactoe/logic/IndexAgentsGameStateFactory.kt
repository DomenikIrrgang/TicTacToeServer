package my.depot.tictactoe.logic

import my.depot.tictactoe.logic.rules.MakeMoveRule

class IndexAgentsGameStateFactory: GameStateFactory {
    override fun createGameState(gameOptions: GameOptions): GameState {
        val gameState: GameState = GameState(gameOptions)
        for (y in 0..< gameState.height) {
            for (x in 0..< gameState.width) {
                gameState.makeMove(Move(
                        Agent(gameState.getBoardPosition(Coordinate(x, y)).toString()),
                        Coordinate(x, y)
                ))
            }
        }
        return gameState
    }

}