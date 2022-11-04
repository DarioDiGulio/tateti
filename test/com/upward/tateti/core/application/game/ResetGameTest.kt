package com.upward.tateti.core.application.game

import com.upward.tateti.core.domain.board.Position
import com.upward.tateti.core.domain.players.Player
import com.upward.tateti.core.domain.players.Symbol
import com.upward.tateti.core.infrastructure.board.InMemoryBoard
import com.upward.tateti.core.infrastructure.players.InMemoryPlayerStorage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResetGameTest {
    @Test
    fun `should reset board and players history`() {
        createPlayers()
        val xPlayer = xPlayerWins()

        handler.exec()

        assertThat(xPlayer.history).isEqualTo(0)
    }

    @Test
    fun `should reset board`() {
        board.add(Position(1, 2))
        board.add(Position(2, 2))

        handler.exec()

        assertThat(board.isEmpty()).isTrue
    }

    private val players = InMemoryPlayerStorage()
    private val board = InMemoryBoard()
    private val handler = ResetGame(players, board)

    private fun xPlayerWins() = players.getBySymbol(Symbol.X).also { it.win() }

    private fun createPlayers() {
        players.add(Player("Alice", Symbol.X))
        players.add(Player("Bob", Symbol.O))
    }
}