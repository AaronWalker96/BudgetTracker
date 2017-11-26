package comaaronwalker96budgettracker.httpsgithub.budgettracker;

import android.content.Intent;
import android.content.SharedPreferences;
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
        double rentExpense;
        double utilitiesExpense;
        double foodExpense;
        double leisureExpense;
        double salaryIncome;
        double otherIncome;
        String totalExpenseText = "Total Expenses: £";
        String totalIncomeText = "Total Income: £";
        TextView expensesText = (TextView)findViewById(R.id.txtExpenses);
        TextView incomeText = (TextView)findViewById(R.id.txtIncome);
        DecimalFormat df = new DecimalFormat("####0.00");

        //Set default expenses to £0
        expensesText.setText(totalExpenseText + "0");
        incomeText.setText(totalIncomeText + "0");

        //Get data passed from Add Expense activity
        Intent intent = getIntent();

        //Only do the following if data is passed, this prevents the app from crashing on startup or if no data was provided
        if (intent.getStringExtra("Rent_Expense") != null || intent.getStringExtra("Utilities_Expense") != null || intent.getStringExtra("Food_Expense") != null || intent.getStringExtra("Leisure_Expense") != null) {
            //collect all of the variables passed through from the add expense activity, try catch is used if the vars do not contain integers
            try {
                //For Expenses
                rentExpense = Double.parseDouble(getIntent().getStringExtra("Rent_Expense"));
                utilitiesExpense = Double.parseDouble(getIntent().getStringExtra("Utilities_Expense"));
                foodExpense = Double.parseDouble(getIntent().getStringExtra("Food_Expense"));
                leisureExpense = Double.parseDouble(getIntent().getStringExtra("Leisure_Expense"));

                double totalExpense;

                totalExpense = rentExpense + utilitiesExpense + foodExpense + leisureExpense;

                totalExpenseText = totalExpenseText + df.format(totalExpense);

                expensesText.setText(totalExpenseText);

            } catch(NumberFormatException nfe) {

            }

        }

        //Only do the following if data is passed, this prevents the app from crashing on startup or if no data was provided
        if (intent.getStringExtra("Salary_Income") != null || intent.getStringExtra("Other_Income") != null) {
            //collect all of the variables passed through from the add Income activity, try catch is used if the vars do not contain integers
            try {
                //For Income
                salaryIncome = Double.parseDouble(getIntent().getStringExtra("Salary_Income"));
                otherIncome = Double.parseDouble(getIntent().getStringExtra("Other_Income"));

                double totalIncome;

                totalIncome = salaryIncome + otherIncome;
                totalIncomeText = totalIncomeText + df.format(totalIncome);

                incomeText.setText(totalIncomeText);

            } catch(NumberFormatException nfe) {

            }

        }
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
