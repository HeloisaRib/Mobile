package com.android.prova

data class Semestre (val semestre: String, val ano: String) {

    object SemestresData {
        fun getSemestres(): List<Semestre> {
            return listOf(
                Semestre("1º Semestre", "2020"),
                Semestre("2º Semestre", "2020"),
                Semestre("1º Semestre", "2021"),
                Semestre("2º Semestre", "2021"),
                Semestre("1º Semestre", "2022"),
                Semestre("2º Semestre", "2022"),
                Semestre("1º Semestre", "2023"),
                Semestre("2º Semestre", "2023"),
                Semestre("1º Semestre", "2024"),
                Semestre("2º Semestre", "2024")
            )
        }
    }
}