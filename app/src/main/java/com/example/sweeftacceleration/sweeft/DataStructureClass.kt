package com.example.sweeftacceleration.sweeft

class DataStructureClass {

    val map = mutableMapOf<Int,Int>()
    val list = mutableListOf<Int>()


    fun insert(element:Int){

        // თუ map არ შეიცავს ელემენტს მაშინ ...
        if(!map.containsKey(element)){

            // ელემენტის ინდექსი შევინახოთ map-ში
            map[element] = list.size
            // დავამატოთ ელემენტი სიაში
            list.add(element)
        }
    }

    fun delete(element:Int){

        // თუ map შეიცავს ელემენტს მაშინ ...
        if(map.containsKey(element)){

            // გავიგოთ ელემენტის ინდექსი
            val elementIndex = map[element]
            // გავიგოთ რომელია ბოლო ელემენტი სიაში
            val lastElement = list.last()
            // ჩავანაცვლოთ წაშლილი ელემენტი ბოლო ელემენტით
            list[elementIndex!!] = lastElement
            // განვაახლოთ მისი ინდექსი
            map[lastElement] = elementIndex
            // წავშალოთ ელემენტი map-დან
            map.remove(element)
            // წავშალოთ ელემენტი list-დან
            list.removeAt(list.size - 1)


        }

    }



}