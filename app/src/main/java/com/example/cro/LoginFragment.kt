package com.example.cro

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    private var users: List<User> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val user = view.findViewById<EditText>(R.id.username)
        val password = view.findViewById<EditText>(R.id.password)
        val hashEditText = view.findViewById<EditText>(R.id.hash)
        val button = view.findViewById<Button>(R.id.submit)

        button.setOnClickListener {
            validUsers()

            if (user.text?.isNotBlank() == true && password.text?.isNotBlank() == true && hashEditText.text?.isNotBlank() == true) {

                val email = user.text.toString()
                val pass = password.text.toString()
                val hash = hashEditText.text.toString()

                if (checkUser(email, pass, hash, users)) {
                    Toast.makeText(context, "Login Correcto", Toast.LENGTH_SHORT)
                        .show()

                    // TODO: Cambiar a MainActivity
                    val i = Intent(view.context, MainActivity::class.java)
                    startActivity(i)
                    activity?.finish()

                } else {
                    Toast.makeText(
                        context,
                        "Las credenciales no coinciden",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    context,
                    "Ambos campos son requeridos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return view
    }

    private fun checkUser(
        username: String,
        password: String,
        hash: String,
        users: List<User>
    ): Boolean {
        return users.any { user ->
            username == user.email && password == user.password && hash == user.hash
        }
    }

    private fun validUsers() {
        users = listOf(
            User(1, "yuinfor@gmail.com", "Microbio40", "hash1"),
            User(2, "1", "1", "1"),
            User(3, "john@gmail.com", "2guys1pencil", "hash3"),
            User(4, "johndoe@gmail.com", "woeisme", "hash4")
        )
    }
}