package com.upward.tateti.core.application.players

import com.upward.tateti.core.domain.board.Position
import com.upward.tateti.core.domain.board.PositionFixedError
import com.upward.tateti.core.domain.players.Symbol
import com.upward.tateti.core.infrastructure.players.InMemoryBoard
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PlayerMoveTest {
    @Test
    fun `first move should save in board player X movement`() {
        handler.exec(Position(0, 1))

        assertThat(board.get(Position(0, 1))).isEqualTo(Symbol.X)
    }

    @Test
    fun `when right player move should save in board O symbol with given position`() {
        handler.exec(Position(0, 1))
        handler.exec(Position(0, 2))

        assertThat(board.get(Position(0, 1))).isEqualTo(Symbol.X)
        assertThat(board.get(Position(0, 2))).isEqualTo(Symbol.O)
    }

    @Test
    fun `move fails when position is already fixed`() {
        handler.exec(Position(0, 1))

        assertThrows<PositionFixedError> { handler.exec(Position(0, 1)) }
    }

    private val board = InMemoryBoard()
    private val handler = PlayerMove(board)
}