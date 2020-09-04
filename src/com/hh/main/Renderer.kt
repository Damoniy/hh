package com.hh.main

import com.hh.garden.Field
import com.hh.physics.CardinalHelper
import com.hh.robot.WateringBot

class Renderer {

    var row = "+---"
    var plus = "+"
    var tab = "   "

    fun update(f: Field){

        var rows = f.rows

        for((l, r) in f.field.withIndex()){
            var i = 0
                print(tab)
            for(c in r){
                print(row)

                i++

                if(i > f.columns - 1){
                    println(plus)
                    print(String.format("%d  ", l))
                    i = 0

                    for(j in r.indices){
                        print(String.format("| %s ", f.field[l][j]))
                    }

                    println("|")
                }
            }
        }

        print(tab)

        for(i in 0 until f.columns){
            print(row)
        }
        println(plus)

        print(tab)

        for(i in 0 until f.columns) {
            print(String.format("  %d ", i))
        }
        println()
    }

    fun logActivities(f: Field, wb: WateringBot){
        wb.printHistory()

        for((l, r) in f.field.withIndex()){
            var i = 0
            print(tab)
            for(c in r){
                print(row)

                i++

                if(i > f.columns - 1){
                    println(plus)
                    print(String.format("%d  ", l))
                    i = 0

                    for(j in r.indices){
                        print(String.format("| %s ", f.field[l][j]))
                    }

                    println("|")
                }
            }
        }

        print(tab)

        for(i in 0 until f.columns){
            print(row)
        }
        println(plus)

        print(tab)

        for(i in 0 until f.columns) {
            print(String.format("  %d ", i))
        }
        println()

        print("Comandos: ")

        for(i in 0 until wb.cmd.log.size) {
            print(wb.cmd.log[i] + " ")
        }

        println("Orientação final: " + wb.getFacingSide().getValue())
    }
}