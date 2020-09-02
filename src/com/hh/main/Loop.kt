package com.hh.main

import com.hh.garden.Field
import com.hh.physics.CardinalHelper
import com.hh.robot.WateringBot

class Loop() : Runnable{

    private val r = Renderer()

    override fun run(){
        val f = Field(6, 5)
        val wb = WateringBot(f)

        wb.setPos(5, 3, CardinalHelper.NORTH)

        r.update(f)

        wb.travelTo(3, 4)

        r.update(f)

        for(i in 0 until wb.cmd.log.size) {
            print(wb.cmd.log[i] + " ")
        }

       /* println("Bem-vindo ao console do WateringBot, soluções de irrigação para sua horta! \n" +
                "É preciso que informe uma coordenada inicial no formato (x, y) para o robo se localizar:")

        val coords = readLine()
        val x: Int = coords?.substring(1, 2)!!.toInt()
        val y: Int = coords?.substring(4, 5)!!.toInt()

        println("Também é preciso que informe uma direção para o final da configuração de localização (sendo elas N, S, L, O):")

        val facing = readLine()

        when(facing) {
            "N" -> { wb.setPos(x, y, CardinalHelper.NORTH) }
            "s" -> { wb.setPos(x, y, CardinalHelper.SOUTH) }
            "L" -> { wb.setPos(x, y, CardinalHelper.EAST) }
            "O" -> { wb.setPos(x, y, CardinalHelper.WEST) }
        }

        r.update(f)

        var shouldContinue = true

        while(shouldContinue) {
            println("Digite a coordenada do canteiro a ser irrigado no formato (x, y): ")
            var irgCoord = readLine()

            val x: Int = irgCoord?.substring(1, 2)!!.toInt()
            val y: Int = irgCoord?.substring(4, 5)!!.toInt()

            wb.travelTo(x, y)

            r.update(f)

            println("Canteiro irrigado! Deseja irrigar outro canteiro? (S / N)")
            val sc = readLine()
            shouldContinue = sc == "S"
        }

        when(facing) {
            "N" -> { wb.setPos(x, y, CardinalHelper.NORTH) }
            "S" -> { wb.setPos(x, y, CardinalHelper.SOUTH) }
            "L" -> { wb.setPos(x, y, CardinalHelper.EAST) }
            "O" -> { wb.setPos(x, y, CardinalHelper.WEST) }
        }

        r.logActivities(f, wb)
        */

    }
}
