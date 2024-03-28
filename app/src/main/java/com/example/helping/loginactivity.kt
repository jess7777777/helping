package com.example.helping



import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.helping.databinding.ActivityLoginBinding
import com.google.firebase.database.*

class loginactivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = FirebaseDatabase.getInstance().getReference("users")

        binding.loginbtn.setOnClickListener {
            val email = binding.email.text.toString()

            if (email.isNotEmpty()){
                database.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            // Email exists in the database
                            Toast.makeText(applicationContext, "Login successful", Toast.LENGTH_SHORT).show()
                            val intent = Intent(applicationContext, FirstActivity::class.java)
                            startActivity(intent)
                        } else {
                            // Email does not exist in the database
                            Toast.makeText(applicationContext, "User not found", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        Toast.makeText(applicationContext, "Database error", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(applicationContext, "Email cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signuptext.setOnClickListener {
            val signupIntent = Intent(applicationContext, SignUpActivity::class.java)
            startActivity(signupIntent)
        }
    }
}
