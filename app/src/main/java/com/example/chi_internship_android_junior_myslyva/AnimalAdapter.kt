package com.example.chi_internship_android_junior_myslyva

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class AnimalAdapter(
    private val items: List<Animal>
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    inner class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(animal: Animal) {
            itemView.run {
                val name = findViewById<TextView>(R.id.name)
                name.text = animal.name


                val animalPhoto = findViewById<ImageView>(R.id.icon)
                Glide.with(this)
                    .load(animal.imageLink)
                    .circleCrop()
                    .transition(DrawableTransitionOptions.withCrossFade(3000))
                    .into(animalPhoto)


//                val userNameAge = findViewById<TextView>(R.id.users_name_age)
//                val userIsStudent = findViewById<CheckBox>(R.id.is_student)
//                userNameAge.text = "${user.name}, ${user.age} years old"
//                userIsStudent.isChecked = user.isStudent
//                userIsStudent.setOnCheckedChangeListener { _, isChecked ->
//                    user.isStudent = isChecked
//                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.animals_list_item_fragment, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = items[position]
        holder.bind(animal)
    }

    override fun getItemCount(): Int = items.size
}
