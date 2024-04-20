package my.depot.tictactoe.logic

import my.depot.tictactoe.logic.rules.Rules

data class GameOptions(
    val width: Int,
    val height: Int,
    val agents: Array<Agent> = arrayOf(),
    val rules: Array<Rules> = arrayOf(
        Rules.PREVENT_OUT_OF_BOUNDS,
        Rules.FORBID_OVERRIDE,
        Rules.ONLY_ALLOW_CURRENT_AGENT,
        Rules.MAKE_MOVE,
        Rules.THREE_IN_A_ROW,
        Rules.THREE_IN_A_COLUMN,
        Rules.THREE_IN_A_DIAGONAL,
        Rules.END_ON_FULL_BOARD,
        Rules.AGENT_SWAP_TURN_AFTER_ONE_MOVE
    )
) {}