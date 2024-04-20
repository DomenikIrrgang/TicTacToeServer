package my.depot.tictactoe.logic.rules

enum class Rules(val rule: GameRule) {
    MAKE_MOVE(MakeMoveRule()),
    AGENT_SWAP_TURN_AFTER_ONE_MOVE(AgentSwapTurnRule { it.moveCount >= 1 }),
    PREVENT_OUT_OF_BOUNDS(OutOfBoundsRule()),
    FORBID_OVERRIDE(ForbidOverrideRule()),
    ONLY_ALLOW_CURRENT_AGENT(AgentTurnRule()),
    THREE_IN_A_ROW(XinARowRule(3)),
    THREE_IN_A_COLUMN(XinAColumnRule(3)),
    THREE_IN_A_DIAGONAL(XinADiagonalRule(4)),
    END_ON_FULL_BOARD(BoardFullRule()),
}