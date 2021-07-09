package com.example.myapplication.models

 class Ticket(
    val id:Int,
    val firstArray:List<Int>,
    var secondChoice:Int = -1
) {
     override fun toString(): String {
         var str = "["
         var i = 0
         while (i < firstArray.size) {
             str = str.plus(firstArray[i])
             if (i != firstArray.size -1) {
                 str = str.plus(",")
             }
             i++
         }
         str = str.plus("]")
         if (secondChoice != -1) {
             str = str.plus("[").plus(secondChoice).plus("]")
         }
         return str
     }
 }