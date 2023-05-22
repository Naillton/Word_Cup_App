package com.example.word_cup_app

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

// criando classe myAdapter que é do tipo BaseAdapter, onde usamos para adaptar nossa classe a listView
// a classe myAdapter tem dois parametros um activity que vai representar o nosso Activity e o items que vai ser do tipo
// da nossa classe model
class MyAdapter(private var activity: Activity, private var items: ArrayList<CountryModel>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(p0: Int): CountryModel {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("InflateParams")
    // metodo para visualizar lista onde passamos um View e nossa ViewHolder
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View?
        val viewHolder: ViewHolder

        // se nossa View no passada no parametro for null, iniciaremos um inflater
        // que contera o layout e a view
        if (p1 == null){
            val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            view = inflater.inflate(R.layout.list_items, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        }else{
            view = p1
            viewHolder = view.tag as ViewHolder
        }

        // criando array de itens onde definimos todas as nossas posicoes com o ViewHolder
        val countries = items[p0]
        viewHolder.name?.text = countries.name
        viewHolder.champion?.text = countries.champion
        viewHolder.flagImg?.setImageResource(countries.flagImg)

        view?.setOnClickListener(){
            Toast.makeText(activity,
                "You Choose: ${countries.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view as View
    }

    // criando suporte de vizualiacao onde passaremos tudo que queremos ser visualizado na lista
    // depois iniciamos pasando o id para cada posicao
    private class ViewHolder(row: View?) {
        var name: TextView? = null
        var champion: TextView? = null
        var flagImg: ImageView? = null

        init {
            this.name = row?.findViewById(R.id.tView)
            this.champion = row?.findViewById(R.id.tView2)
            this.flagImg = row?.findViewById(R.id.flagImage)
        }

    }
}