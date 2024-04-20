package my.depot.tictactoe.controllers

import jakarta.websocket.server.PathParam
import my.depot.tictactoe.logic.*
import my.depot.tictactoe.logic.rules.*
import my.depot.tictactoe.services.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController constructor(
    val gameService: GameService
) {

    val defaultGameOptions: GameOptions = GameOptions(
        3,
        3,
        arrayOf()
    )

    @PostMapping("/game")
    fun startGame(@RequestBody gameOptions: GameOptions): GameResponse {
        return this.gameService.createGame(gameOptions)
    }

    @GetMapping("/game/{id}")
    fun getGame(@PathVariable id: Int): GameState? {
        return gameService.getGame(id)
    }

    @GetMapping("/games")
    fun getGames(): HashMap<Int, GameState> {
        return gameService.getGames()
    }

    @PostMapping("/game/{id}/move")
    fun move(@PathVariable id: Int, @RequestBody move: Move): GameResponse {
        return this.gameService.makeMove(id, move)
    }


}