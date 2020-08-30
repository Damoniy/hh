package com.hh.main

import com.hh.garden.Field

class Renderer {

    var row = "+---"
    var plus = "+"

    fun update(f: Field){

        for((l, r) in f.field.withIndex()){
            var i = 0

            for(c in r){
                print(row)

                i++

                if(i > f.columns - 1){
                    println(plus)
                    i = 0

                    for(j in r.indices){
                        print(String.format("| %s ", f.field[l][j]))
                    }

                    println("|")
                }
            }
        }
        for(i in 0 until f.columns){
            print(row)
        }
        print(plus)
    }
}