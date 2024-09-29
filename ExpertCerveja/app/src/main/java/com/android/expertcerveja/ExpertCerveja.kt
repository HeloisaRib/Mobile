package com.android.expertcerveja

import android.content.Context

class ExpertCerveja {

    companion object {
        fun GetCervejasPorTipo(tipo: String, context: Context): String {
            lateinit var textArray: Array<String>
            when (tipo) {
                "Lager"     -> textArray = context.resources.getStringArray(R.array.cervejas_lager)
                "Pilsen"    -> textArray = context.resources.getStringArray(R.array.cervejas_pilsen)
                "Bock"      -> textArray = context.resources.getStringArray(R.array.cervejas_bock)
                "Witbier"   -> textArray = context.resources.getStringArray(R.array.cervejas_witbier)
                "Weissbier" -> textArray = context.resources.getStringArray(R.array.cervejas_weissbier)
                "IPA"       -> textArray = context.resources.getStringArray(R.array.cervejas_ipa)
                "Stout"     -> textArray = context.resources.getStringArray(R.array.cervejas_stout)
            }

            val cervejas = textArray.joinToString(separator = "\n")
            return cervejas;
        }
    }

}