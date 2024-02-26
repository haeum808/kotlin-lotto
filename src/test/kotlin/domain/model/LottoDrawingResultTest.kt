package domain.model

import domain.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoDrawingResultTest {

    @Test
    fun `로또 결과에 대한 총 상금을 구한다`() {
        val rank = mapOf(Rank.FIRST to 0, Rank.SECOND to 0, Rank.THIRD to 1, Rank.FOURTH to 0, Rank.FIFTH to 0)
        val lottoDrawingResult = LottoDrawingResult(rank)

        val expected = lottoDrawingResult.calculateTotalPrize()
        val actual = 1_500_000L

        assertThat(expected).isEqualTo(Money(actual))
    }

    @Test
    fun `Int형 범위를 넘어가는 총 상금이어도 정상 작동한다`() {
        val rank = mapOf(Rank.FIRST to 2, Rank.SECOND to 0, Rank.THIRD to 0, Rank.FOURTH to 0, Rank.FIFTH to 0)
        val lottoDrawingResult = LottoDrawingResult(rank)

        val expected = lottoDrawingResult.calculateTotalPrize()
        val actual = 4_000_000_000

        assertThat(expected).isEqualTo(Money(actual))
    }
}
