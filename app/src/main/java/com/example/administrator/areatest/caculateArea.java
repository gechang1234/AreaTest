package com.example.administrator.areatest;

import android.util.Log;

/**
 * Created by Administrator on 2017/12/15.
 */

/**
 * Coordinate node class
 */
class point {
    public int x;
    public int y;

    point() {
        this.x = 0;
        this.y = 0;
    }
}

public class caculateArea {
    /**
     * Calculate the area of the polygon
     *
     * @param vertex   the result of the parse array
     * @param pointNum the length of parse array
     * @return the area of the polygon
     */
    public static float caculate(point vertex[], int pointNum) {
        int i = 0;
        float temp = 0;
        for (; i < pointNum - 1; i++) {
            temp += (vertex[i].x - vertex[i + 1].x) * (vertex[i].y + vertex[i + 1].y);
        }
        temp += (vertex[i].x - vertex[0].x) * (vertex[i].y + vertex[0].y);
        return temp / 2;
    }

    /**
     * Parse the input string
     *
     * @param orig the input string
     * @return the result of the parse array
     */
    public static point[] parserCoor(String orig) {
        point[] vertex = new point[100];
        for (int i = 0; i < 100; i++) {
            vertex[i] = new point();
        }
        if (orig.contains("；")) {
            String[] str = orig.split("；");
            for (int i = 0; i < str.length; i++) {

                vertex[i].x = Integer.valueOf(str[i].split("，")[0]);
                vertex[i].y = Integer.valueOf(str[i].split("，")[1]);
                Log.d("gc", "parserCoor: " + vertex[i].x + vertex[i].y);
            }
        } else {
            return null;
        }
        return vertex;
    }
}


