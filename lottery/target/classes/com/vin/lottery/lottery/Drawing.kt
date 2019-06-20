package com.vin.lottery.lottery

import java.time.LocalDate

abstract class Drawing (val date: LocalDate,
                        val corePicks: Set<Int>) {

    abstract fun validate()

    fun validateCorePicksSize(expectedSize: Int) {

        if (corePicks.isEmpty() || corePicks.size != expectedSize) {
            throw IllegalArgumentException("Core picks are not the expected size: $expectedSize")
        }
    }
}