package com.example.raas.programquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Alfalaq extends AppCompatActivity {
    TextView mTextQuestion;
    Button mBtnSubmit;
    RadioGroup optionGroup;
    RadioButton optionA, optionB,optionC,optionD;
    List<QuizModel> quizModelList = new ArrayList<>();
    TextView score;
    int mscore=0;
    int no = 0;
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alfalaq);

        score =(TextView) findViewById(R.id.score) ;
        mTextQuestion = (TextView) findViewById(R.id.mTextQuestion);
        mBtnSubmit = (Button) findViewById(R.id.mBtnSubmit);
        optionGroup = (RadioGroup) findViewById(R.id.optionGroup);
        optionA = (RadioButton) findViewById(R.id.optionA);
        optionB = (RadioButton) findViewById(R.id.optionB);
        optionC = (RadioButton) findViewById(R.id.optionC);
        optionD = (RadioButton) findViewById(R.id.optionD);
        prepareData();
        setData();

        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(no<quizModelList.size()) {
                    checkAnswer();
                    no++;
                }
                if(no<quizModelList.size()) {
                    setData();
                }


            }
        });
    }






    //digunakan untuk menset soal
    void prepareData(){
        setQuestion("potongan ayat berikut ini مِن شَرِّ مَا خَلَقَ merupakan ayat ke berapa?", "ke-1", "ke-5", "ke-3", "ke-2", "D");
        setQuestion( "potongan ayat berikut ini وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ merupakan ayat ke berapa?", "ke-1", "ke-2", "ke-3", "ke-4", "C");
        setQuestion( "potongan ayat berikut ini قُلْ أَعُوذُ بِرَبِّ الْفَلَقِْ merupakan ayat ke berapa?", "ke-1", "ke-5", "ke-3", "ke-4", "A");
        setQuestion("potongan ayat berikut ini وَمِن شَرِّ النَّفّٰثٰتِ فِى الْعُقَدِ  merupakan ayat ke berapa?", "ke-1", "ke-2", "ke-5", "ke-4", "D");
        setQuestion("potongan ayat berikut ini وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ  merupakan ayat ke berapa?", "ke-1", "ke-2", "ke-5", "ke-4", "C");
        setQuestion("Ini Adalah Akhir Dari Quiz Tekan Tombol Submit Untuk Kembali ke Menu Utama", "", "", "", "", "");
    }

    void setData(){
        mTextQuestion.setText(quizModelList.get(no).getQuestion());
        optionA.setText(quizModelList.get(no).getOptionA());
        optionB.setText(quizModelList.get(no).getOptionB());
        optionC.setText(quizModelList.get(no).getOptionC());
        optionD.setText(quizModelList.get(no).getOptionD());


    }

    void checkAnswer(){
        int index =0;
        switch (quizModelList.get(no).getAnswer()){
            case "A":
                index =0;


                break;
            case "B":
                index =1;


                break;
            case "C":
                index =2;


                break;
            case "D":
                index =3;


                break;
            default:index=0; break;
        }

        int selectedAnsewer = optionGroup.indexOfChild(findViewById(optionGroup.getCheckedRadioButtonId()));
        if(index == selectedAnsewer){
            a=a+1;
            mscore = mscore + 1;
            score.setText(""+mscore);
            Toast.makeText(this, "Benar", Toast.LENGTH_SHORT).show();
            if (a==5 ){
                if(mscore==5){
                    Toast.makeText(this, "Selamat Nilaimu Sempurna", Toast.LENGTH_SHORT).show(); }
                else{Toast.makeText(this, "Belajar Lagi Ya", Toast.LENGTH_SHORT).show();}}
            if (a==6){
                Intent i = new Intent(Alfalaq.this, Isi.class);

                startActivity(i);}
        }
        else{
            a=a+1;
            if (a==6){
                Intent i = new Intent(Alfalaq.this, Isi.class);

                startActivity(i);}
            Toast.makeText(this, "Salah", Toast.LENGTH_SHORT).show();

        }
    }


    //fungsi untuk mengeset soal ke model yang kemudian akan dimasukan ke modellist
    void setQuestion(String question, String optionA, String optionB, String optionC, String optionD, String answer){
        QuizModel quizModel = new QuizModel(question, optionA, optionB, optionC, optionD, answer);
        quizModelList.add(quizModel);
    }
}