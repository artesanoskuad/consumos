package com.artesanoskuad.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

object CurrencyUtils {
    const val CURRENCY_CHAR = "$"
    const val DECIMAL_SEPARATOR = "."
    const val EMPTY_CHARACTER = ""

    private val decimalFormatSymbols = DecimalFormatSymbols().apply {
        decimalSeparator = ','
        groupingSeparator = '.'
    }

    private val formattedValue = DecimalFormat("###,###", decimalFormatSymbols)

    fun currencyFormat(value: Int): String {
        return CURRENCY_CHAR + formattedValue.format(value)
    }

    fun currencyToNumber(value: String): Long {
        var auxValue: String = value.replace(DECIMAL_SEPARATOR, EMPTY_CHARACTER)
        auxValue = auxValue.replace(CURRENCY_CHAR, EMPTY_CHARACTER)
        return auxValue.toLong()
    }
}