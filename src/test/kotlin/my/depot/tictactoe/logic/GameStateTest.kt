package my.depot.tictactoe.logic

import my.depot.tictactoe.logic.rules.GameRule
import my.depot.tictactoe.logic.rules.MakeMoveRule
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GameStateTest {

    val gameStateFactory: GameStateFactory = IndexAgentsGameStateFactory()

    @Test
    fun testGetRow() {
        val gameState: GameState = gameStateFactory.createGameState(GameOptions(10, 9))
        for (y in 0 ..< gameState.height) {
            assert(gameState.getRow(Coordinate(0,y)).size == gameState.width)
            gameState.getRow(Coordinate(0, y)).forEachIndexed { index, agent ->
                assert(gameState.width * y + index == agent?.name?.toInt()) {
                    println("Invalid agent, expected " + (gameState.width * y + index) + " but got " + agent?.name)
                }
            }
        }
    }

    @Test
    fun testGetColumm() {
        val gameState: GameState = gameStateFactory.createGameState(GameOptions(10, 9))
        for (x in 0 ..< gameState.width) {
            assert(gameState.getColumn(Coordinate(x,0)).size == gameState.height)
            gameState.getColumn(Coordinate(x, 0)).forEachIndexed { index, agent ->
                assert(gameState.width * index + x == agent?.name?.toInt()) {
                    println("Invalid agent, expected " + (gameState.width * index + x) + " but got " + agent?.name)
                }
            }
        }
    }

    @Test
    fun testGetLeftDiagonal() {
        val gameState: GameState = gameStateFactory.createGameState(GameOptions(5, 5))
        var leftDiagonal: Array<Agent?> = gameState.getDiagonalLeft(Coordinate(4, 0))
        assert(leftDiagonal.size == 1) { println("expected 1 but was " + leftDiagonal.size )}
        leftDiagonal = gameState.getDiagonalLeft(Coordinate(3, 1))
        assert(leftDiagonal.size == 3) { println("expected 3 but was " + leftDiagonal.size )}
        leftDiagonal = gameState.getDiagonalLeft(Coordinate(2, 2))
        assert(leftDiagonal.size == 5) { println("expected 5 but was " + leftDiagonal.size )}
        leftDiagonal = gameState.getDiagonalLeft(Coordinate(1, 3))
        assert(leftDiagonal.size == 3) { println("expected 3 but was " + leftDiagonal.size )}
        leftDiagonal = gameState.getDiagonalLeft(Coordinate(0, 4))
        assert(leftDiagonal.size == 1) { println("expected 1 but was " + leftDiagonal.size )}
    }

    @Test
    fun testGetRightDiagonal() {
        val gameState: GameState = gameStateFactory.createGameState(GameOptions(5, 5))
        var rightDiagonal: Array<Agent?> = gameState.getDiagonalRight(Coordinate(1, 1))
        assert(rightDiagonal.size == 3) { println("expected 5 but was " + rightDiagonal.size )}
        rightDiagonal = gameState.getDiagonalRight(Coordinate(0, 0))
        assert(rightDiagonal.size == 1) { println("expected 1 but was " + rightDiagonal.size )}
        rightDiagonal = gameState.getDiagonalRight(Coordinate(2, 2))
        assert(rightDiagonal.size == 5) { println("expected 5 but was " + rightDiagonal.size )}
        rightDiagonal = gameState.getDiagonalRight(Coordinate(3, 3))
        assert(rightDiagonal.size == 3) { println("expected 3 but was " + rightDiagonal.size )}
        rightDiagonal = gameState.getDiagonalRight(Coordinate(4, 4))
        assert(rightDiagonal.size == 1) { println("expected 1 but was " + rightDiagonal.size )}
    }
}