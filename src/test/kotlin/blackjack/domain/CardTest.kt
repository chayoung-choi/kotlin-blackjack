package blackjack.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CardTest {
    @CsvSource("2,HEART", "9,CLOVER", "A,DIAMOND", "K,SPADE")
    @ParameterizedTest
    fun `A,K,Q,J,2~9 중 하나와 4종류의 모양 중 하나를 가진다`(number: String, shape: String) {
        val card = Card(CardNumber.of(number), CardShape.valueOf(shape))
        card.number.value shouldBe number
        card.shape.name shouldBe shape
    }

    @CsvSource("1,HEART", "11,CLOVER", "B,DIAMOND", "12,HEART", "2,STAR")
    @ParameterizedTest
    fun `범위에 있지 않은 카드는 예외 발생`(number: String, shape: String) {
        shouldThrow<IllegalArgumentException> {
            Card(CardNumber.of(number), CardShape.valueOf(shape))
        }
    }
}
