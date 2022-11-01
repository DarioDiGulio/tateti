package com.upward.tateti.core.application.players

import com.upward.tateti.core.domain.players.Symbol
import com.upward.tateti.core.infrastructure.players.InMemoryBoard
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PlayerMoveTest {
    @Test
    fun `first move should save in board player X movement`() {
        handler.exec(0, 1)

        assertThat(board.get(0, 1)).isEqualTo(Symbol.X)
    }

    private val board = InMemoryBoard()
    private val handler = PlayerMove(board)
}