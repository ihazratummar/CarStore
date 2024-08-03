package com.practice.carstore.core.domain.model

import androidx.annotation.DrawableRes
import com.practice.carstore.R

/**
 * @author Hazrat Ummar Shaikh
 */

data class Car(
    val name: String,
    val carShortDetails: String,
    val carDescription: String,
    @DrawableRes val image: List<Int>,
    val price: Float,
    val rating: Float
)

val featuredCars = listOf(
    Car(
        name = "Tesla Model S",
        carShortDetails = "Tesla Model S",
        carDescription = "The Tesla Model S is a high-performance electric sedan.",
        image = listOf(
            R.drawable.tesla1,
            R.drawable.tesla2,
            R.drawable.tesla3,
        ),
        price = 79999f,
        rating = 4.8f
    ),
    Car(
        name = "Ford Mustang",
        carShortDetails = "Ford Mustang",
        carDescription = "The Ford Mustang is an iconic American sports car.",
        image = listOf(
            R.drawable.mastang1,
            R.drawable.mastang2,
        ),
        price = 55999f,
        rating = 4.6f
    ),
    Car(
        name = "Chevrolet Camaro",
        carShortDetails = "Chevrolet Camaro",
        carDescription = "The Chevrolet Camaro is a muscle car with a rich history.",
        image = listOf(
            R.drawable.chevrolet1,
            R.drawable.chevrolet2,
        ),
        price = 49999f,
        rating = 4.5f
    ),
    Car(
        name = "BMW 3 Series",
        carShortDetails = "BMW 3 Series",
        carDescription = "The BMW 3 Series is a compact executive car known for its performance.",
        image = listOf(
            R.drawable.bmw1,
            R.drawable.bmw2,
        ),
        price = 42999f,
        rating = 4.7f
    ),
    Car(
        name = "Audi A4",
        carShortDetails = "Audi A4",
        carDescription = "The Audi A4 is a luxury sedan with advanced technology.",
        image = listOf(
            R.drawable.audi1,
            R.drawable.audi2,
        ),
        price = 47999f,
        rating = 4.6f
    ),
    Car(
        name = "Mercedes-Benz C-Class",
        carShortDetails = "Mercedes-Benz C-Class",
        carDescription = "The Mercedes-Benz C-Class is a compact luxury sedan.",
        image = listOf(
            R.drawable.mercedes1,
            R.drawable.mercedes2,
        ),
        price = 53999f,
        rating = 4.7f
    ),
//    Car(
//        name = "Honda Accord",
//        carShortDetails = "Honda Accord",
//        carDescription = "The Honda Accord is a reliable and spacious midsize sedan.",
//        image = listOf(),
//        price = 27999f,
//        rating = 4.4f
//    ),
//    Car(
//        name = "Toyota Camry",
//        carShortDetails = "Toyota Camry",
//        carDescription = "The Toyota Camry is a best-selling midsize sedan.",
//        image = listOf(),
//        price = 28999f,
//        rating = 4.5f
//    ),
//    Car(
//        name = "Nissan Altima",
//        carShortDetails = "Nissan Altima",
//        carDescription = "The Nissan Altima is a stylish and efficient midsize sedan.",
//        image = listOf(),
//        price = 25999f,
//        rating = 4.3f
//    ),
//    Car(
//        name = "Hyundai Sonata",
//        carShortDetails = "Hyundai Sonata",
//        carDescription = "The Hyundai Sonata is a feature-packed midsize sedan.",
//        image = listOf(),
//        price = 24999f,
//        rating = 4.4f
//    )
)

