package com.example.shoppingapp;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private EditText productNameEditText, productQuantityEditText;
    private Button addProductButton;
    private RecyclerView productsRecyclerView;
    private ProductsAdapter productsAdapter;
    private List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        String username = getIntent().getStringExtra("USERNAME");
        TextView welcomeTextView = findViewById(R.id.usernameTextView);
        welcomeTextView.setText("Welcome, " + username);


        usernameTextView = findViewById(R.id.usernameTextView);
        productNameEditText = findViewById(R.id.productNameEditText);
        productQuantityEditText = findViewById(R.id.productQuantityEditText);
        addProductButton = findViewById(R.id.addProductButton);
        productsRecyclerView = findViewById(R.id.productsRecyclerView);


        setupRecyclerView();

        addProductButton.setOnClickListener(view -> addProduct());
    }

    private void setupRecyclerView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        productsRecyclerView.setLayoutManager(layoutManager);


        productsAdapter = new ProductsAdapter(productList);


        productsRecyclerView.setAdapter(productsAdapter);
    }

    private void addProduct() {
        String name = productNameEditText.getText().toString().trim();
        String quantityString = productQuantityEditText.getText().toString().trim();
        int quantity = quantityString.isEmpty() ? 0 : Integer.parseInt(quantityString);

        if (!name.isEmpty() && quantity > 0) {

            productList.add(new Product(name, quantity));


            productsAdapter.notifyDataSetChanged();

            productNameEditText.setText("");
            productQuantityEditText.setText("");
        }
    }
}
