package com.example.cro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class TaskAdapter(private var tasks: List<Task>): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.render(task)

    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    fun updateTasks(newTasks: List<Task>) {
        tasks = newTasks
        notifyDataSetChanged()
    }

    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.country_name)
        val category: TextView = view.findViewById(R.id.country_capital)
        val interval: TextView = view.findViewById(R.id.country_continent)
        val win: ImageView = view.findViewById(R.id.country_flag)
        val image: ImageView = view.findViewById(R.id.country_image)

        fun render(task: Task) {
            name.text = task.name + ", "
            category.text = task.category
            interval.text = task.interval
            Picasso.get().load(task.win).into(win)
            Picasso.get().load(task.image).into(image)


        }
    }
}