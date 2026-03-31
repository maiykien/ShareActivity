package edu.temple.funwithintents

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This view contains the text to share
        val editText = findViewById<EditText>(R.id.editTextText)



        // When the user clicks this button, share the text if not empty
        findViewById<ImageButton>(R.id.shareImageButton).setOnClickListener {

            // Open the text to show the text string.
            var text_String = editText.text.toString()

            if (text_String.isEmpty()) {
                return@setOnClickListener
            }


            val sendIntent = Intent()

            sendIntent.action = Intent.ACTION_SEND

            sendIntent.putExtra(Intent.EXTRA_TEXT, text_String)
            sendIntent.type = "text/plain"

            if (sendIntent.resolveActivity(packageManager) != null) {

                startActivity(sendIntent)

            }

        }
    }
}