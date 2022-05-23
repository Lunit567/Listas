package luna.martin.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import luna.martin.listas.adaptador.PokemonAdapter
import luna.martin.listas.modelo.Pokemon

class MainActivity : AppCompatActivity() {
    lateinit var miRecycler: RecyclerView
    val listaPokemon = ArrayList<Pokemon>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        miRecycler= findViewById(R.id.RecyclerPokemon)
        miRecycler.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        getPokemon()
    }
    fun getPokemon(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://rickandmortyapi.com/api/character"
        val jsonObject = JsonObjectRequest(Request.Method.GET, url, null,
            {respuesta ->
                val newjson = respuesta.getJSONArray("results")
                for(i in 0..10) {
                    val newobj = newjson.getJSONObject(i)

                    val pokemon = Pokemon(newobj.getString("name"), newobj.getString("image"))
                    listaPokemon.add(pokemon)
                }
                miRecycler.adapter=PokemonAdapter(listaPokemon)
            }, { error ->
                Log.e("Lista","Error")
            }
        )
        queue.add(jsonObject)
    }
}