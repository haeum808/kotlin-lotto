package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoMoney
import lotto.domain.LottoNumber
import lotto.exception.Validator

object InputView {
    fun readInputMoney(): LottoMoney {
        val input = readln()
        Validator.checkInputMoney(input)
        return LottoMoney(input.toInt())
    }

    fun readInputWinningLotto(): Lotto {
        val input = readln()
        return Lotto(input.split(",").map { LottoNumber.from(it.toInt()) })
    }

    fun readInputBonusNumber(): LottoNumber {
        val input = readln()
        Validator.checkInputBonusNumber(input)
        return LottoNumber.from(input.toInt())
    }
}
