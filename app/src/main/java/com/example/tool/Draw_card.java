package com.example.tool;

import androidx.appcompat.app.AppCompatActivity;

public class Draw_card{

    int[] imgId = {R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4, R.drawable.f5,
            R.drawable.f6, R.drawable.f7, R.drawable.f8, R.drawable.f9, R.drawable.f10,
            R.drawable.f11, R.drawable.f12, R.drawable.f13,
            R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5,
            R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10,
            R.drawable.h11, R.drawable.h12, R.drawable.h13,
            R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5,
            R.drawable.d6, R.drawable.d7, R.drawable.d8, R.drawable.d9, R.drawable.d10,
            R.drawable.d11, R.drawable.d12, R.drawable.d13,
            R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5,
            R.drawable.b6, R.drawable.b7, R.drawable.b8, R.drawable.b9, R.drawable.b10,
            R.drawable.b11, R.drawable.b12, R.drawable.b13,};

    int[] point = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};

    int HowManyCard = imgId.length;
    int number[] = imgId;
    int point2[] = point;

    int PointAndNumber[] = {0,0,0};

    int use = 0;

    public int[] Draw_card() {

        if (use < HowManyCard) {

            use++;
            int count = number.length - use;
            int p = (int) (Math.random() * count);

            PointAndNumber[0] = point2[p];
            PointAndNumber[1] = number[p];
            PointAndNumber[2] = use;

            int i;
            for (i = p; i < count - 1; i++) {
                point2[i] = point2[i + 1];
                number[i] = number[i + 1];
            }

            return PointAndNumber;
        }else{
            return new int[]{0,0,0};
        }

    }
}
