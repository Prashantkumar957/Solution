package io.kodular.technologygyan957.PDF_Book

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView

class PdfViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer) // Ensure this XML contains a PDFView

        val pdfView = findViewById<PDFView>(R.id.pdfView)

        // Get the chapter name passed from MainActivity
        val chapterName = intent.getStringExtra("chapter_name") ?: "Chapter 1"

        // Map chapter names to raw resource IDs
        val pdfResId = when (chapterName) {
            "Chapter 1: Real Numbers" -> R.raw.pdf1
            "Chapter 2: Polynomials" -> R.raw.pdf2
            "Chapter 3: Pair of Linear Equations" -> R.raw.pdf3
            "Chapter 4: Quadratic Equations" -> R.raw.pdf4
            "Chapter 5: Arithmetic Progressions" -> R.raw.pdf5
            "Chapter 6: Triangles" -> R.raw.pdf6
            "Chapter 7: Coordinate Geometry" -> R.raw.pdf7
            "Chapter 8: Introduction to Trigonometry" -> R.raw.pdf8
            "Chapter 9: Some Applications of Trigonometry" -> R.raw.pdf9
            "Chapter 10: Circles" -> R.raw.pdf10
            "Chapter 11: Constructions" -> R.raw.pdf11
            "Chapter 12: Areas Related to Circles" -> R.raw.pdf12
            "Chapter 13: Surface Areas and Volumes" -> R.raw.pdf13
            "Chapter 14: Statistics" -> R.raw.pdf14
            "Chapter 15: Probability" -> R.raw.pdf15
            else -> R.raw.pdf1 // Default PDF if no match
        }

        // Load PDF from res/raw
        val inputStream = resources.openRawResource(pdfResId)
        pdfView.fromStream(inputStream)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .load()
    }
}
