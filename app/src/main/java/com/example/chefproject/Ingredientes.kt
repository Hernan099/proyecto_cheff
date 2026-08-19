package com.example.chefproject
import java.math.*
/**
abstract class Ingrediente(nombre: String, cantidad: BigDecimal) {
    var cant = cantidad
    val name = nombre

    abstract fun cantPercentage(ingredien: Ingrediente, perc: BigDecimal)

    fun changeCant(x: BigDecimal?){
        cant = x
    }

}

class Solido(nombre: String, cantidad: BigDecimal): Ingrediente(nombre, cantidad){

    override fun toString(): String {
        return "$name = $cant kg"
    }

    override fun cantPercentage(ingredien: Ingrediente, perc: Int) {
        val value = (perc/100) * ingredien.cant
        val redondear = BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN)
        changeCant(redondear)
    }
}
*/