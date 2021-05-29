package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

public class FirstFragment extends Fragment {
    TextView countTextView;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*view.findViewById(R.id.random_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentCount = Integer.parseInt(countTextView.getText());
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });*/

        countTextView = view.findViewById(R.id.textview_first);

        Button toastButton = view.findViewById(R.id.toast_button);
        toastButton.setOnClickListener(this::onToastClick);

        Button countButton = view.findViewById(R.id.count_button);
        countButton.setOnClickListener(this::onCountClick);

        Button randomButton = view.findViewById(R.id.random_button);
        randomButton.setOnClickListener(this::onRandomClick);

    }

    public void onToastClick(View view) {
        Toast myToast = Toast.makeText(getActivity(), "Cześć, jestem tostem!", Toast.LENGTH_SHORT);
        myToast.show();
    }

    public void onCountClick(View view){
        String countString = countTextView.getText().toString();
        Integer countInt = Integer.parseInt(countString);
        countInt++;
        countTextView.setText(countInt.toString());
    }

    public void onRandomClick(View view) {
        int currentCount = Integer.parseInt(countTextView.getText().toString());
        FirstFragmentDirestions.ActionFirstFragmentToSecondFragment action = FirstFragmentDirection.actionFirstFragnentToSecondFragment(currentCount);
        NavHostFragment.findNavController(FirstFragment.this).navigate(action);
    }

}