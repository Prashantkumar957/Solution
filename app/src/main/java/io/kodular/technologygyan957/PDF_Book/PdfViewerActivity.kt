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
            else -> R.raw.pdf1 // Default PDF
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
