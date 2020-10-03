package com.example.move_prototype_02.UI.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.move_prototype_02.R;


public class NewHabit_fragment extends Fragment {

    EditText text_meta, text_nome, text_unidade;
    String nome_habito, unidade, meta;


    public NewHabit_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_habit, container, false);
        Button  b_go = view.findViewById(R.id.b_go);

        text_meta = view.findViewById(R.id.text_meta);
        text_nome = view.findViewById(R.id.text_habito);
        text_unidade = view.findViewById(R.id.text_unidade);

        b_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return view;

    }

}