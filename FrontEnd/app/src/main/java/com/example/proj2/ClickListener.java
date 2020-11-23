package com.example.proj2;

import android.view.View;

public interface ClickListener {
    void onListClick(int adapterPosition, View v);
    void onListLongClick(int adapterPosition, View v);
}
