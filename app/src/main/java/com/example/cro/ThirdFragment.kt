package com.example.cro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class  ThirdFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        val taskNameEditText: EditText = view.findViewById(R.id.editTaskName)
        val taskCategoryEditText: EditText = view.findViewById(R.id.editTaskCategory)
        val taskIntervalEditText: EditText = view.findViewById(R.id.editTaskInterval)
        val taskWinEditText: EditText = view.findViewById(R.id.editTaskWin)
        val taskImageEditText: EditText = view.findViewById(R.id.editTaskImage)
        val addTaskButton: Button = view.findViewById(R.id.btnAddTask)

        addTaskButton.setOnClickListener {
            val taskName = taskNameEditText.text.toString().trim()
            val taskCategory = taskCategoryEditText.text.toString().trim()
            val taskInterval = taskIntervalEditText.text.toString().trim()
            val taskWin = taskWinEditText.text.toString().trim()
            val taskImage = taskImageEditText.text.toString().trim()

            if (validateInput(taskName, taskCategory, taskInterval, taskWin, taskImage)) {
                val newTask = Task(0, taskName, taskCategory, taskInterval, taskWin, taskImage)
                sharedViewModel.addTask(newTask)

                findNavController().popBackStack()
            } else {
            }
        }

        return view
    }
    private fun validateInput(vararg inputs: String): Boolean {
        inputs.forEach {
            if (it.isEmpty()) {
                return false
            }
        }
        return true
    }
}
