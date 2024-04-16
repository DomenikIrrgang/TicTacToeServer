package my.depot.tictactoe

import my.depot.tictactoe.logic.*
import my.depot.tictactoe.logic.rules.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController {

    @GetMapping("/")
    fun startGame(): GameState {
        val gameState = GameState(
                3,
                3,
                arrayOf(Agent("Valeri"), Agent("Joachim")),
                arrayOf(
                        OutOfBoundsRule(),
                        ForbidOverrideRule(),
                        AgentTurnRule(),
                        MakeMoveRule(),
                        AgentSwapTurnRule { it.moveCount >= 3 },
                        XinARowRule(3),
                        XinAColumnRule(3),
                        XinADiagonalRule(3),
                        BoardFullRule()
                )
        )
        val gameLogic = GameLogic()
        gameLogic.makeMove(gameState, Move(
                Agent("Valeri"),
                Coordinate(0, 0)
        ))
        gameLogic.makeMove(gameState, Move(
                Agent("Valeri"),
                Coordinate(1, 1)
        ))
        gameLogic.makeMove(gameState, Move(
                Agent("Valeri"),
                Coordinate(2, 2)
        ))
        return gameState
    }


}