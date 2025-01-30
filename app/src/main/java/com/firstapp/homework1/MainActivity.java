package com.firstapp.homework1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firstapp.homework1.adapters.CharacterAdapter;
import com.firstapp.homework1.models.Character;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CharacterAdapter adapter;
    private EditText searchInput;
    private List<Character> characterList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        searchInput = findViewById(R.id.searchInput);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load characters (NO hardcoding! This can be loaded from JSON later)
        loadCharacters();

        adapter = new CharacterAdapter(this, characterList);
        recyclerView.setAdapter(adapter);

        // Implement Search Functionality
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void loadCharacters() {
        characterList.add(new Character("Tony Stark / Iron Man", "The genius billionaire superhero", R.drawable.ironman));
        characterList.add(new Character("Pepper Potts", "CEO of Stark Industries and Tony's love interest", R.drawable.pepper));
        characterList.add(new Character("James Rhodes / War Machine", "Tony's best friend and pilot of War Machine armor", R.drawable.warmachine));
        characterList.add(new Character("Aldrich Killian", "The main villain and leader of AIM", R.drawable.killian));
        characterList.add(new Character("Trevor Slattery", "A drunk actor pretending to be The Mandarin", R.drawable.mandarin));
        characterList.add(new Character("Maya Hansen", "A scientist who worked on Extremis", R.drawable.maya));
        characterList.add(new Character("Harley Keener", "A kid who helps Tony after his suit breaks", R.drawable.harley));
        characterList.add(new Character("Happy Hogan", "Tony's personal security and friend", R.drawable.happy));
        characterList.add(new Character("The President", "The President of the United States", R.drawable.president));
        characterList.add(new Character("Ellen Brandt", "A soldier enhanced with Extremis", R.drawable.brandt));
    }

    private void filter(String text) {
        List<Character> filteredList = new ArrayList<>();
        for (Character character : characterList) {
            if (character.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(character);
            }
        }
        adapter.filterList(filteredList);
    }
}
