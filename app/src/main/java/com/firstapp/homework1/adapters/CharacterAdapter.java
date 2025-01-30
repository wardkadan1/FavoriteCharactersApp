package com.firstapp.homework1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firstapp.homework1.R;
import com.firstapp.homework1.models.Character;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private Context context;
    private List<Character> characterList;

    public CharacterAdapter(Context context, List<Character> characterList) {
        this.context = context;
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characterList.get(position);
        holder.characterName.setText(character.getName());
        holder.characterDescription.setText(character.getDescription());
        holder.characterImage.setImageResource(character.getImageResId());

        // Click event: Show Toast with character name
        holder.itemView.setOnClickListener(v ->
                Toast.makeText(context, "Clicked: " + character.getName(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public void filterList(List<Character> filteredList) {
        this.characterList = filteredList;
        notifyDataSetChanged();
    }

    // ViewHolder Class
    public static class CharacterViewHolder extends RecyclerView.ViewHolder {
        TextView characterName, characterDescription;
        ImageView characterImage;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            characterName = itemView.findViewById(R.id.characterName);
            characterDescription = itemView.findViewById(R.id.characterDescription);
            characterImage = itemView.findViewById(R.id.characterImage);
        }
    }
}
