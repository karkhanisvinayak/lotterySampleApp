package com.vin.lottery.lottery

import java.time.LocalDate
import java.util.stream.IntStream

data class PowerDrawing(private val powerDate: LocalDate,
                        private val powerCorePicks: Set<Int>,
                        val powerPick: Int)
                          : Drawing(powerDate, powerCorePicks) {

    companion object {
        const val MAX_CORE_PICK: Int = 65
        const val MAX_POWER_PICK: Int = 36
        const val CORE_PICKS_SIZE: Int = 5
    }

    override fun validate() {

        super.validateCorePicksSize(CORE_PICKS_SIZE)
        val corePicksInRange = corePicks.stream()
            .allMatch { x -> IntStream.rangeClosed(1,
              MAX_CORE_PICK).anyMatch { r -> r == x } 
            }

        if (!corePicksInRange) {
            throw IllegalArgumentException("Core picks not in acceptable range 1 ... $MAX_CORE_PICK")
        }

        val powerPickInRange = IntStream.rangeClosed(1, 
            MAX_POWER_PICK).anyMatch { r -> r == powerPick }

        if (!powerPickInRange) {
            throw IllegalArgumentException("Power pick not in acceptable range 1 ... $MAX_POWER_PICK")
        }
    }
}