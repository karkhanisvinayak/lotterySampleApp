package com.vin.lottery.lottery

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class LottoService{

    @Autowired
    lateinit var lottoData : LottoData

    fun getDrawings(): Set<Drawing> {

        val drawings = HashSet<Drawing>()

        val powerDrawing1: Drawing = lottoData.getPowerDrawing()
        drawings.add(powerDrawing1)

        val powerDrawing2: Drawing = lottoData.getPowerDrawing()
        drawings.add(powerDrawing2)

        return drawings
    }
}