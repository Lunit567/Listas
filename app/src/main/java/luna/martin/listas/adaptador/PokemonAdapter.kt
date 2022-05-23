package luna.martin.listas.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import luna.martin.listas.R
import luna.martin.listas.modelo.Pokemon

class PokemonAdapter(val listaPokemon:ArrayList<Pokemon>): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vista,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Nombre.text=listaPokemon[position].nombre
        Picasso.get()
            .load(listaPokemon[position].imgcarta)
            .into(holder.Imagen)
    }

    override fun getItemCount(): Int {
        return listaPokemon.size
    }

    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){
        val Nombre: TextView
        val Imagen: ImageView

        init {
            Nombre = vista.findViewById(R.id.NomPok)
            Imagen = vista.findViewById(R.id.Image)
        }
    }
}