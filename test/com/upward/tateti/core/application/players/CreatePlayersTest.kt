package com.upward.tateti.core.application.players

import com.upward.tateti.core.domain.players.Symbol
import com.upward.tateti.core.infrastructure.board.InMemoryPlayerStorage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CreatePlayersTest {
    @Test
    fun `should create new players with given names`() {
        handler.exec("Alice", "Bob")

        assertThat(players.get()[0].name).isEqualTo("Alice")
        assertThat(players.get()[0].symbol).isEqualTo(Symbol.X)
        assertThat(players.get()[1].name).isEqualTo("Bob")
        assertThat(players.get()[1].symbol).isEqualTo(Symbol.O)
    }

    private val players = InMemoryPlayerStorage()
    private val handler = CreatePlayers(players)
}