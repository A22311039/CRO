package com.example.cro

data class Task(
    val id: Int,
    val name: String,
    val category: String,
    val interval: String,
    val win: String,
    val image: String
)
{
    constructor(name: String) : this(0, name, "", "", "", "")
}