package my.depot.tictactoe.services

import my.depot.tictactoe.controllers.GameResponse
import my.depot.tictactoe.logic.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class GameService {

    private val games: HashMap<Int, GameState> = HashMap<Int, GameState>()

    private val gameStateFactory: GameStateFactory = DefaultGameStateFactory()

    fun createGame(gameOptions: GameOptions): GameResponse {
        val gameState = gameStateFactory.createGameState(gameOptions)
        games[games.size + 1] = gameState
        return GameResponse(games.size, gameState)
    }

    fun getGame(id: Int): GameState? {
        return games[id]
    }

    fun makeMove(id: Int, move: Move): GameResponse {
        val state = getGame(id)
        state?.makeMove(move)
        return GameResponse(id, state)
    }

    fun getGames(): HashMap<Int, GameState> = games

}