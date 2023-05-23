package com.example.word_cup_app

import android.view.View
import android.widget.ImageView
import android.widget.TextView

// criando suporte de visualizacao onde passaremos tudo que queremos ser visualizado na lista
// depois iniciamos pasando o id para cada posicao
class ViewHolder(row: View?) {
    var name: TextView? = null
    var champion: TextView? = null
    var flagImg: ImageView? = null
    init {
        this.name = row?.findViewById(R.id.tView)
        this.champion = row?.findViewById(R.id.tView2)
        this.flagImg = row?.findViewById(R.id.flagImage)
    }
}