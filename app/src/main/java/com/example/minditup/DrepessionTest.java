package com.example.minditup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrepessionTest extends Fragment {

    public DrepessionTest() {
        // Required empty public constructor
    }

    private FrameLayout parentFrameLayout;
    
private TextView question,questionNumber;
private Button option1Btn, option2Btn, option3Btn, option4Btn, option5Btn;
private ArrayList<DepTestModal> depTestModalArrayList;

Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drepession_test, container, false);
        parentFrameLayout = getActivity().findViewById(R.id.depressed_FrameLayout);

        question = view.findViewById(R.id.question);
        questionNumber = view.findViewById(R.id.questionNumber);
        option1Btn = view.findViewById(R.id.idBtnOption1);
        option2Btn = view.findViewById(R.id.idBtnOption2);
        option3Btn = view.findViewById(R.id.idBtnOption3);
        option4Btn = view.findViewById(R.id.idBtnOption4);
        option5Btn = view.findViewById(R.id.idBtnOption5);
        depTestModalArrayList = new ArrayList<>();

        random = new Random();
        getQuizQuestion(depTestModalArrayList);
        currentPos = random.nextInt(depTestModalArrayList.size());
        setDataToViews(currentPos);

        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentScore+=4;
                questionAttempted++;
                currentPos = random.nextInt(depTestModalArrayList.size());
                setDataToViews(currentPos);
            }

        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentScore+=3;
                questionAttempted++;
                currentPos = random.nextInt(depTestModalArrayList.size());
                setDataToViews(currentPos);
            }

        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentScore+=2;
                questionAttempted++;
                currentPos = random.nextInt(depTestModalArrayList.size());
                setDataToViews(currentPos);
            }

        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentScore++;
                questionAttempted++;
                currentPos = random.nextInt(depTestModalArrayList.size());
                setDataToViews(currentPos);
            }

        });

        option5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionAttempted++;
                currentPos = random.nextInt(depTestModalArrayList.size());
                setDataToViews(currentPos);
            }

        });
        
        return view;
    }

    private void setDataToViews(int currentPos) {

        questionNumber.setText(questionAttempted + "/12"+"questions answered");
        if(questionAttempted == 12){
//            showBottomSheet();
            //Todo:
        }else{
            question.setText(depTestModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(depTestModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(depTestModalArrayList.get(currentPos).getOption2());
            option3Btn.setText(depTestModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(depTestModalArrayList.get(currentPos).getOption4());
            option5Btn.setText(depTestModalArrayList.get(currentPos).getOption5());
        }
    }

    private void getQuizQuestion(ArrayList<DepTestModal> depTestModalArrayList) {
        depTestModalArrayList.add(new DepTestModal("Could you tell us about your sleeping patterns in the last few weeks?","I've been sleeping more than usual", "I've been sleeping less than usual","I've been sleeping more but somewhat usual",
                "I've been sleeping less but somewhat usual","I haven't noticed any changes"));

        depTestModalArrayList.add(new DepTestModal("How often does this happen? (Related to previous question)","Rarely","All the Time","Sometimes","Often","Manytimes"));

        depTestModalArrayList.add(new DepTestModal("How has your appetite pattern been over past few weeks?","I've larger appetite than usual","I've a very smaller appetite than usual","I,ve larger appetite but somewhat usual","I've a smaller appetite but somewhat usual","I haven't noticed any changes"));

        depTestModalArrayList.add(new DepTestModal("How often does this happen? (Related to previous question)","Rarely","All the Time","Sometimes","Often","Manytimes"));

        depTestModalArrayList.add(new DepTestModal("Have you been less active than usual?","A lot","Quite a bit","Somewhat","Maybe a little","Not Really"));



        depTestModalArrayList.add(new DepTestModal("I've a tendency to look at things negatively.","Completely True","Somewhat True","I'm unsure","Somewhat Untrue","Completely Untrue"));

        depTestModalArrayList.add(new DepTestModal("I don't Think I'm good enough.","Strongly Agree","Agreed","Neutral","Disagree","Strongly Disagree"));

        depTestModalArrayList.add(new DepTestModal("I've feel that even minor tasks seems to take a lot of effort for me.","Completely True","Somewhat True","I'm Unsure","somewhat Untrue","Completely Untrue"));

        depTestModalArrayList.add(new DepTestModal("I'm not interested in doing activities that I used to like.","Strongly Agree","Agreed","Neutral","Disagree","Strongly Disagree"));

        depTestModalArrayList.add(new DepTestModal("I feel nervous or Anxious.","Always","A lot of time","Maybe sometimes","Not very often","Never"));

        depTestModalArrayList.add(new DepTestModal("It's difficult for me to concentrate on my hobbies.","Always","Most of the time","Maybe sometimes","Hardly ever","Never"));



        depTestModalArrayList.add(new DepTestModal("Do you believe that depression makes it difficicult for you to work, socialise or take care of yourself?","Always","Often","Sometimes","Rarely","Never"));
    }
}