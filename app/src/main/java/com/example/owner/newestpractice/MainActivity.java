package com.example.owner.newestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView;
    private Button button;
    private CheckBox checkBox;
    private List<Image> list;
    private int index = 0;
    private ImageView favorite;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.ivMain);
        button = findViewById(R.id.button1);
        checkBox = findViewById(R.id.checker);
        favorite = findViewById(R.id.favorite);

        createList();

        button.setOnClickListener(this);
        checkBox.setOnClickListener(this);

        Image currentImage = list.get(index);
        imageView.setImageResource(currentImage.getNumID());
        checkBox.setChecked(currentImage.getChecker());
    }

    @Override
    public void onClick(View view) {

        int viewId = view.getId();

        switch (viewId){

            case R.id.button1:
                if (index + 1 > list.size() - 1){

                    index = 0;
                }else{
                    index++;
                }

                Image current = list.get(index);
                boolean isFavorited = list.get(index).getChecker();
                imageView.setImageResource(current.getNumID());

                checkBox.setChecked(current.getChecker());

                if (isFavorited){
                    favorite.setImageResource(R.drawable.hearts);



                }else {

                    favorite.setImageDrawable(null);

                }

             break;

            case R.id.checker:
                Image on = list.get(index);




                if (!checkBox.isChecked()){

                    favorite.setImageDrawable(null);

                }else{

                    for (Image e: list ){

                        e.setChecker(false);
                    }
                    
                    favorite.setImageResource(R.drawable.hearts);



                }

                list.get(index).setChecker(checkBox.isChecked());
                break;
        }
    }

    public void createList(){

        Image image1 = new Image(R.drawable.pet0, false);
        Image image2 = new Image(R.drawable.pet1, false);
        Image image3 = new Image(R.drawable.pet2, false);

        list = new ArrayList<>();
        list.add(image1);
        list.add(image2);
        list.add(image3);



    }
}
