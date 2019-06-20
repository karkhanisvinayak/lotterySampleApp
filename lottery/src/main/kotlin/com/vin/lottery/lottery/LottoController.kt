package com.vin.lottery.lottery

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class LottoController{

    @Autowired
    lateinit var lottoService : LottoService

    @RequestMapping(method=arrayOf(RequestMethod.GET))

    fun load(): String{

        val drawings : Set<Drawing>

        try{
            drawings = lottoService.getDrawings()
        }catch (e : Exception){
            return "Failed to load due to exception: ${e.message}"
        }
        val numOfDrawings = drawings.size
        return "Successfully loaded. " + "Number of drawings loaded: $numOfDrawings" + " You may close the application."

    }

}