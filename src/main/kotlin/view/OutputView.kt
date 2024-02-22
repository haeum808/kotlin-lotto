package view

import model.Lotto
import model.LottoDrawingResult
import model.Margin
import model.Rank

object OutputView {

    fun printLottoQuantity(quantity: Int) {
        println("${quantity}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottoTickets: List<Lotto>) {
        lottoTickets.forEach {
            println(it.numbers.map { it.value }.joinToString(prefix = "[", separator = ", ", postfix = "]"))
        }
    }

    fun printLottoResult(lottoDrawingResult: LottoDrawingResult) {
        println("당첨 통계\n---------")
        lottoDrawingResult.statistics.forEach { (rank, count) ->
            if (rank == Rank.SECOND) {
                println("${rank.countOfMatch}개 일치, 보너스 볼 일치(${rank.winningMoney}원)- ${count}개")
            } else {
                println("${rank.countOfMatch}개 일치 (${rank.winningMoney}원)- ${count}개")
            }
        }
    }

    fun printMargin(marginRate: Margin) {
        print("총 수익률은 ${formatDouble(marginRate.rate)}입니다.")
        if (marginRate.rate < 1) print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    private fun formatDouble(value: Double): String {
        return if (value % 1.0 == 0.0) {
            String.format("%.0f", value)
        } else {
            String.format("%.2f", value)
        }
    }
}
