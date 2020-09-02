package com.hh.main

import com.hh.garden.Field
    import com.hh.robot.WateringBot

class Commands(field: Field, var wb: WateringBot){
    var f:Field = field;

    val log = arrayListOf<String>()

    fun execute(cmd: String){
        when(cmd){
            "D" -> { wb.rotateTo("right"); log.add("D ")}
            "E" -> { wb.rotateTo("left"); log.add("E ") }
            "M" -> { wb.move(); log.add("M ") }
            "I" -> { wb.irrigate(); log.add("I ")}
        }
    }
}