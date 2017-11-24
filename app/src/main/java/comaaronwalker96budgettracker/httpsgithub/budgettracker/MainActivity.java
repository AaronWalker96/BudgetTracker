package comaaronwalker96budgettracker.httpsgithub.budgettracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vars
        double rentExpense = 0;
        double utilitiesExpense = 0;
        double foodExpense = 0;
        double leisureExpense = 0;

        //Get data passed from Add Expense activity
        Intent intent = getIntent();

        //The following requires fixing--------------------------------------------------------------------------------------------------------------

//        //Only do the following if data is passed, this prevents the app from crashing on startup or if no data was provided
//        if (intent.getStringExtra("Rent_Expense") != null) {
//            //collect all of the variables passed through from the add expense activity, try catch is used if the vars do not contain integers
//            try {
//                rentExpense = Double.parseDouble(getIntent().getStringExtra("Rent_Expense"));
//                utilitiesExpense = Double.parseDouble(getIntent().getStringExtra("Utilities_Expense"));
//                foodExpense = Double.parseDouble(getIntent().getStringExtra("Food_Expense"));
//                leisureExpense = Double.parseDouble(getIntent().getStringExtra("Leisure_Expense"));
//
//                double totalExpense;
//
//                totalExpense = rentExpense + utilitiesExpense + foodExpense + leisureExpense;
//                DecimalFormat df = new DecimalFormat("####0.00");
//                String totalExpenseFormatted = "Total Expenses: £" + df.format(totalExpense);
//
//                TextView expensesText = (TextView)findViewById(R.id.txtExpenses);
//                expensesText.setText(totalExpenseFormatted);
//
//            } catch(NumberFormatException nfe) {
//
//            }
//
//        }
    }

    public void addExpenseBtn(View view) {
        Intent intent = new Intent(this, AddExpense.class);
        startActivity(intent);
    }

    public void addIncomeBtn(View view) {
        Intent intent = new Intent(this, AddIncome.class);
        startActivity(intent);
    }

}
