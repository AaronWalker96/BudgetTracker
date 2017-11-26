package comaaronwalker96budgettracker.httpsgithub.budgettracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddIncome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);
    }

    public void submitIncome(View view) {
        //Screen Elements
        EditText salaryEdit = (EditText)findViewById(R.id.txtSalary);
        EditText otherEdit = (EditText)findViewById(R.id.txtOther);

        //Get text from text boxes
        String salaryIncomeIn = isEntered(salaryEdit.getText().toString());
        String otherIncomeIn = isEntered(otherEdit.getText().toString());

        //Send variables
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Salary_Income", salaryIncomeIn);
        intent.putExtra("Other_Income", otherIncomeIn);
        startActivity(intent);
    }

    //This method will replace any null values entered with "0", this is needed for calculations used further in the process
    public String isEntered(String expense) {
        if (expense.matches("")) {
            expense = "0";
        }
        return expense;
    }
}
