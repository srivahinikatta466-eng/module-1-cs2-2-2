package sri.example.srivahinics_2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.util.Linkify
import androidx.appcompat.app.AppCompatActivity
import sri.example.srivahinics_2.databinding.ActivityMainBinding
import sri.example.srivahinics_2.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set data in views using binding
        binding.titleTextView.text = "The Eiffel Tower"
        binding.descriptionTextView.text = """
           The Eiffel Tower is a wrought-iron lattice tower on the Champ de Mars in Paris, France.
           It is named after the engineer Gustave Eiffel, whose company designed and built the tower.
       """.trimIndent()

        val additionalInfo = """
           For more information:
           <a href="https://www.toureiffel.paris/en">Official Eiffel Tower Website</a>
       """.trimIndent()
        binding.additionalInfoTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toureiffel.paris/en"))
            startActivity(intent)
        }

        Linkify.addLinks(binding.additionalInfoTextView, Linkify.WEB_URLS)

        // Set image resource
        binding.imageView.setImageResource(R.drawable.eiffel_tower)
    }
}