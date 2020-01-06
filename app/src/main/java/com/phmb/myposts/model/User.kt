package com.phmb.myposts.model

data class User(
    val name: String,
    val email: String,
    val phone: String,
    val address: Address) {
    data class Address(
        val suite: String,
        val street: String,
        val city: String,
        val zipcode: String)
}