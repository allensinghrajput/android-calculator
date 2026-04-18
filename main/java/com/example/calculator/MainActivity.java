package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvExpression, tvResult;

    String input = "";
    String operator = "";
    double firstValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvExpression = findViewById(R.id.tvExpression);
        tvResult = findViewById(R.id.tvResult);

        makeButtonsResponsive();

        tvResult.post(() -> adjustTextSize());
    }

    // 🔢 NUMBER CLICK
    public void onNumberClick(View view) {
        Button btn = (Button) view;
        String value = btn.getText().toString();

        if (value.equals(".") && input.contains(".")) return;

        input += value;

        tvResult.setText(input);
        tvResult.post(() -> adjustTextSize());
    }

    // ➕ OPERATOR CLICK
    public void onOperatorClick(View view) {
        Button btn = (Button) view;

        if (!input.isEmpty()) {
            firstValue = Double.parseDouble(input);
            operator = btn.getText().toString();

            tvExpression.setText(input + " " + operator);
            tvExpression.setTextColor(0xFF818186);

            input = "";
        }
    }

    // 🟰 EQUAL CLICK
    public void onEqualClick(View view) {
        if (!input.isEmpty() && !operator.isEmpty()) {
            double secondValue = Double.parseDouble(input);
            double result = 0;

            switch (operator) {
                case "+": result = firstValue + secondValue; break;
                case "-": result = firstValue - secondValue; break;
                case "×": result = firstValue * secondValue; break;
                case "÷":
                    if (secondValue == 0) {
                        tvResult.setText("Error");
                        tvResult.post(() -> adjustTextSize());
                        return;
                    }
                    result = firstValue / secondValue;
                    break;
            }

            tvExpression.setText(firstValue + " " + operator + " " + secondValue);
            tvExpression.setTextColor(0xFF818186);

            if (result == (long) result) {
                input = String.valueOf((long) result);
            } else {
                input = String.valueOf(result);
            }

            tvResult.setText(input);
            tvResult.post(() -> adjustTextSize());

            operator = "";
        }
    }

    // 🧹 CLEAR
    public void onClearClick(View view) {
        input = "";
        operator = "";
        firstValue = 0;

        tvExpression.setText("");
        tvResult.setText("0");

        tvResult.post(() -> adjustTextSize());
    }

    // 🔙 DELETE
    public void onDeleteClick(View view) {
        if (!input.isEmpty()) {
            input = input.substring(0, input.length() - 1);
        }

        tvResult.setText(input.isEmpty() ? "0" : input);
        tvResult.post(() -> adjustTextSize());
    }

    // ➗ PERCENT
    public void onPercentClick(View view) {
        if (!input.isEmpty()) {
            double value = Double.parseDouble(input);
            value = value / 100;

            input = String.valueOf(value);
        }

        tvResult.setText(input);
        tvResult.post(() -> adjustTextSize());
    }

    // ➕➖ SIGN CHANGE
    public void onSignChangeClick(View view) {
        if (!input.isEmpty()) {
            double value = Double.parseDouble(input);
            value = -value;

            input = String.valueOf(value);
        }

        tvResult.setText(input);
        tvResult.post(() -> adjustTextSize());
    }

    // 📱 RESPONSIVE BUTTONS
    private void makeButtonsResponsive() {
        GridLayout grid = findViewById(R.id.buttonGrid);

        grid.post(() -> {
            int totalWidth = grid.getWidth();
            int columnCount = 4;

            int marginPx = dpToPx(2);
            int totalMargin = columnCount * 2 * marginPx;

            int buttonSize = (totalWidth - totalMargin) / columnCount;

            int childCount = grid.getChildCount();

            for (int i = 0; i < childCount; i++) {
                View child = grid.getChildAt(i);

                GridLayout.LayoutParams params =
                        (GridLayout.LayoutParams) child.getLayoutParams();

                params.width = buttonSize;
                params.height = buttonSize;

                params.setMargins(marginPx, marginPx, marginPx, marginPx);

                child.setLayoutParams(params);
            }
        });
    }

    // 🔥 PIXEL-PERFECT AUTO TEXT RESIZE
    private void adjustTextSize() {

        String text = tvResult.getText().toString();

        float maxWidth = tvResult.getWidth();
        if (maxWidth == 0) return;

        float textSize = 130f;

        android.graphics.Paint paint = new android.graphics.Paint();
        paint.set(tvResult.getPaint());

        while (textSize > 45f) {
            paint.setTextSize(textSize * getResources().getDisplayMetrics().scaledDensity);

            float textWidth = paint.measureText(text);

            if (textWidth <= maxWidth) break;

            textSize -= 2;
        }

        tvResult.setTextSize(textSize);
    }

    // 🔧 DP → PX
    private int dpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
}