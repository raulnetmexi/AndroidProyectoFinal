package mx.com.android.purchasesalecars.model

import java.io.Serializable


data class Car(
    val name: String,
    val age: String,
    val image: Int
    ): Serializable
