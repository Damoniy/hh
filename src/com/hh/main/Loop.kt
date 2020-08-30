package com.hh.main

import com.hh.garden.Field
import com.hh.physics.CardinalHelper
import com.hh.robot.WateringBot

class Loop() : Runnable{

    private val r = Renderer()


    override fun run(){
        val f = Field(5, 3)
        val wb = WateringBot()

        f.field[0][0] =  wb.getFacingPos(CardinalHelper.SOUTH)

        while(true) {
            r.update(f)
            readLine()
        }
    }
}
