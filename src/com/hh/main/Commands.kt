package com.hh.main

import com.hh.garden.Field
import com.hh.robot.WateringBot

class Commands(field: Field, var wt: WateringBot){
    var f:Field = field;

    fun execute(cmd: String){
        when(cmd){
            "D" -> {  }
            "E" -> { }
            "M" -> { wt.move() }
            "I" -> { wt.irrigate() }
        }
    }
}