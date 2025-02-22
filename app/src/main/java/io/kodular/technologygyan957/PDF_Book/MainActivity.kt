package io.kodular.technologygyan957.PDF_Book

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.kodular.technologygyan957.PDF_Book.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ChapterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set app bar title
        supportActionBar?.title = "Class 10th NCERT Math Solution"

        // Setup RecyclerView
        val chapters = listOf(
            "Chapter 1: Real Numbers",
            "Chapter 2: Polynomials",
            "Chapter 3: Pair of Linear Equations",
            "Chapter 4: Quadratic Equations",
            "Chapter 5: Arithmetic Progressions",
            "Chapter 6: Triangles",
            "Chapter 7: Coordinate Geometry",
            "Chapter 8: Introduction to Trigonometry",
            "Chapter 9: Some Applications of Trigonometry",
            "Chapter 10: Circles",
            "Chapter 11: Constructions",
            "Chapter 12: Areas Related to Circles",
            "Chapter 13: Surface Areas and Volumes",
            "Chapter 14: Statistics",
            "Chapter 15: Probability"
        )

        adapter = ChapterAdapter(this, chapters) { chapter ->
            val intent = Intent(this, PdfViewerActivity::class.java)
            intent.putExtra("chapter_name", chapter)
            startActivity(intent)
        }


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}
