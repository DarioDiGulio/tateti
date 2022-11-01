package com.upward.tateti.core.domain

import com.upward.tateti.core.domain.board.GameStatus
import com.upward.tateti.core.domain.board.Position
import com.upward.tateti.core.domain.players.Symbol
import com.upward.tateti.core.infrastructure.board.InMemoryBoard
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BoardTest {
    @Test
    fun `last player start with O player`() {
        assertThat(board.lastPlayer()).isEqualTo(Symbol.O)
    }

    @Test
    fun `last player change after add move`() {
        board.add(Position(0, 1))

        assertThat(board.lastPlayer()).isEqualTo(Symbol.X)
    }

    @Test
    fun `isFixed should return true on fixed position`() {
        board.add(Position(0, 1))

        assertThat(board.isFixed(Position(0, 1))).isTrue
    }

    @Test
    fun `isFixed should return false on non fixed position`() {
        assertThat(board.isFixed(Position(0, 1))).isFalse
    }

    @Test
    fun `get should return symbol fixed on given position`() {
        board.add(Position(0, 1))

        assertThat(board.get(Position(0, 1))).isEqualTo(Symbol.X)
    }

    @Test
    fun `gameStatus should return Xwins on first row X player full`() {
        board.add(Position(0, 0))
        board.add(Position(1, 1))
        board.add(Position(0, 1))
        board.add(Position(2, 2))
        board.add(Position(0, 2))

        assertThat(board.gameStatus()).isEqualTo(GameStatus.XWin)
    }

    @Test
    fun `gameStatus should return Owins on first row O player full`() {
        board.add(Position(1, 1))
        board.add(Position(0, 0))
        board.add(Position(2, 2))
        board.add(Position(0, 1))
        board.add(Position(1, 2))
        board.add(Position(0, 2))

        assertThat(board.gameStatus()).isEqualTo(GameStatus.OWin)
    }

    @Test
    fun `gameStatus should return Xwins on second row X player full`() {
        board.add(Position(1, 0))
        board.add(Position(0, 1))
        board.add(Position(1, 1))
        board.add(Position(2, 2))
        board.add(Position(1, 2))

        assertThat(board.gameStatus()).isEqualTo(GameStatus.XWin)
    }

    @Test
    fun `gameStatus should return Owins on second row O player full`() {
        board.add(Position(0, 1))
        board.add(Position(1, 0))
        board.add(Position(2, 2))
        board.add(Position(1, 1))
        board.add(Position(2, 2))
        board.add(Position(1, 2))

        assertThat(board.gameStatus()).isEqualTo(GameStatus.OWin)
    }
    private val board = InMemoryBoard()
}