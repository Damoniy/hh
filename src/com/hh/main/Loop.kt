package com.hh.main

import com.hh.garden.Field
import com.hh.physics.CardinalHelper
import com.hh.robot.WateringBot

class Loop() : Runnable{

    private val r = Renderer()


    override fun run(){
        val f = Field(5, 3)
        val wb = WateringBot(f)

        f.field[4][0] =  wb.setFacingSide(CardinalHelper.SOUTH)

        println(wb.getPos())
        println(wb.currentFacingSide)

        while(true) {
            r.update(f)
            readLine()
        }
    }
}
