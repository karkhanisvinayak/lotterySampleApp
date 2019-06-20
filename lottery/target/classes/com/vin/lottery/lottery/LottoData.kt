package com.vin.lottery.lottery

import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.*

@Component
class LottoData{

    fun getPowerDrawing(): Drawing {

        // Simulation of drawing retrieval from some source.
        val date: LocalDate = LocalDate.of(2017, 10, 1)
        val powerPick: Int = (1..PowerDrawing.MAX_POWER_PICK).random()
        val corePicks: HashSet<Int> = HashSet()
        for (n in 1..5) {
            while (true) {
                val pick: Int = (1..PowerDrawing.MAX_CORE_PICK).random()
                if (!corePicks.contains(pick)) {
                    corePicks.add(pick)
                    break
                }
            }
        }

        val powerDrawing = PowerDrawing(date, corePicks, powerPick)
        powerDrawing.validate()
        return powerDrawing
    }

    private fun ClosedRange<Int>
            .random() = Random().nextInt(endInclusive - start) + start
}