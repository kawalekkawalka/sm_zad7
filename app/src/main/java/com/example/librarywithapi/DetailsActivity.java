package com.example.librarywithapi;

import static com.example.librarywithapi.MainActivity.IMAGE_URL_BASE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    public final static String EXTRA_BOOK_OBJ = "EXTRA_BOOK_OBJ";

    private TextView bookTitleTextView;
    private TextView bookAuthorTextView;
    private ImageView bookCover;
    private TextView bookYearOfPublishingTextView;
    private TextView bookLanguageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        bookTitleTextView = findViewById(R.id.book_title);
        bookAuthorTextView = findViewById(R.id.book_author);
        bookCover = findViewById(R.id.img_cover);
        bookYearOfPublishingTextView = findViewById(R.id.book_year_of_publishing);
        bookLanguageTextView = findViewById(R.id.book_language);

        Book book = (Book) getIntent().getSerializableExtra(EXTRA_BOOK_OBJ);

        bookTitleTextView.setText(getString(R.string.title) + book.getTitle());
        bookAuthorTextView.setText(getString(R.string.author) + TextUtils.join(", ", book.getAuthors()));
        bookYearOfPublishingTextView.setText(getString(R.string.year_of_publishing) + String.valueOf(book.getYearOfPublishing()));
        bookLanguageTextView.setText(getString(R.string.language) + book.getLanguage());

        if (book.getCover() != null) {
            Picasso.with(getApplicationContext())
                    .load(IMAGE_URL_BASE + book.getCover() + "-L.jpg")
                    .placeholder(R.drawable.ic_baseline_book_24).into(bookCover);
        } else {
            bookCover.setImageResource(R.drawable.ic_baseline_book_24);
        }
    }
}