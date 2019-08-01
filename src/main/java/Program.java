import java.io.Reader;
import java.util.Scanner;

public class Program {

    public static String StringInput()
    {
        Scanner Read = new Scanner(System.in);
        try {
            return Read.nextLine();
        }
        catch (Exception e)
        {
            System.out.println("Error! Incorrect input, try again!");
        }
        return StringInput();
    }

    public static Integer IntegerInput()
    {
        Scanner Read = new Scanner(System.in);
        try {
            return Read.nextInt();
        }
        catch (Exception e)
        {
            System.out.println("Error! Incorrect input, try again!");
        }
        return IntegerInput();
    }

    public static String MonthInput()
    {
        Scanner Read = new Scanner(System.in);
        String Input = StringInput();

        String Checker = Input.split(" ")[1].toUpperCase();
        Integer Day = Integer.parseInt(Input.split(" ")[0]);

        if ((Checker == "FEBRUARY" || Checker == "MARCH" || Checker == "MAY" || Checker == "JULY" || Checker == "AUGUST" || Checker == "OCTOBER" || Checker == "DECEMBER"
            || Checker == "APRIL" || Checker == "JUNE" || Checker == "SEPTEMBER" || Checker == "NOVEMBER" || Checker == "JANUARY")
                && (Day > 0 && Day < 32))
            {
                return Input;
            }
        return MonthInput();
    }

    public static void main(String[] args) {
        EmployeeData TestSubject = new EmployeeData();
        Scanner Read = new Scanner(System.in);
        String tempString;
        Integer tempInt;

        System.out.println("Enter your name: ");
        tempString = StringInput();
        TestSubject.setEmployeeFirstName(tempString);

        System.out.println("Enter your surname: ");
        tempString = StringInput();
        TestSubject.setEmployeeSurname(tempString);

        System.out.println("Enter your annual salary: ");
        tempInt = IntegerInput();
        TestSubject.setSalary(tempInt);

        System.out.println("Enter your super rate: ");
        tempInt = IntegerInput();
        TestSubject.setSuperRate(tempInt);

        System.out.println("Enter your payment start date: ");
        tempString = MonthInput();
        TestSubject.setStartDate(tempString);

        System.out.println("Enter your payment end date: ");
        tempString = MonthInput();
        TestSubject.setEndDate(tempString);

        System.out.println(System.lineSeparator() + "Your payslip has been generated: " + System.lineSeparator());

        System.out.println("Name: " + TestSubject.getEmployeeFirstName() + " " + TestSubject.getEmployeeSurname());
        System.out.println("Pay Period: " + TestSubject.CalculatePayMonth());
        System.out.println("Gross Income: " + TestSubject.CalculateGrossPay());
        System.out.println("Income Tax: " + TestSubject.CalculateIncomeTax());
        System.out.println("Net Income: " + TestSubject.CalculateNetIncome());
        System.out.println("Super: " + TestSubject.CalculateSuper());

        System.out.println("Thank you for using MYOB!");
    }
}
