package com.example.word_cup_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // definindo id da lista
        val listView: ListView = findViewById(R.id.listing)

        // definindo adaptador
        // apos definir o adaptador, neste caso nos precisamos passar apenas dois parametros, pois
        // como a constante adapter é do tipo MyAdapter que definimos nos so precisamos passar a activity
        // e o nosso array
        val adapter = MyAdapter(
            this,
            generateData(),
        )

        listView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    // funcao de Data que recebe um ArrayList do tipo da nossa classe Model
    fun generateData(): ArrayList<CountryModel> {
        // constante com o ArrayModel
        val result = ArrayList<CountryModel>()
        // criando constantes que receberam os valores de cada tipo
        val country1 = CountryModel(
            "Brasil",
            "5",
            R.drawable.brazil
        )
        val country2 = CountryModel(
            "Spain",
            "1",
            R.drawable.spain
        )
        val country3= CountryModel(
            "Alemanha",
            "4",
            R.drawable.germany
        )
        val country4 = CountryModel(
            "France",
            "3",
            R.drawable.france
        )
        val country5= CountryModel(
            "England",
            "1",
            R.drawable.unitedkingdom
        )
        // adcionando cada constante a constante rersult que armazena todos os resultados
        result.add(country1)
        result.add(country2)
        result.add(country3)
        result.add(country4)
        result.add(country5)
        return result
    }
}