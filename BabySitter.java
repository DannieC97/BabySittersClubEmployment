package babysitterClub;
import java.util.stream.Stream;
import java.lang.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class BabySitter {
   //To store employee number
    private String employee_no;
    //To store lastName
    private String lastName;
    //To store firstName
    private String firstName;
    //To store street address
    private String address;
    //To store city
    private String city;
    //To store state
    private String state;
    //To store zipcode;
    private String zipcode;
    private double fees;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    //To store number of days employed
    private int days;

    //To store the timings employed
    private String[] hours;
    //To store the rates
    private String rateChart;
    //Constructor to create a new class object with all the fields populated
    public BabySitter(String employee_no, String lastName, String firstName, String address, String city, String state,
                      String zipcode,String rateChart) {
        this.employee_no = employee_no;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.rateChart = rateChart;
    }

    //Getters and Setters[START]
    public String getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String[] getHours() {
        return hours;
    }

    public void setHours(String[] hours) {
        this.hours = hours;
    }

    public String getRateChart() {
        return rateChart;
    }

    public void setRateChart(String rateChart) {
        this.rateChart = rateChart;
    }

    public double getFees() {
        return fees;
    }



    public String toString() {
        String output;
        output = getLastName() + ", " + getFirstName() + ": $" + computeFees();

        return output;
    }
    //Getters and Setters[END]

    public double computeFees() {
        double startHour = 0,endHour = 0;
        String[] temp;
        String[] temp_time;
        double[] rates;
        double hr;
        double fees = 0.0;



        rates = Stream.of(rateChart.split("\\s")).mapToDouble(r -> Double.parseDouble(r)).toArray();

        for (String h:this.hours)
        {
            temp = h.split(" ");
            temp_time = temp[0].split(":");
            startHour = Double.parseDouble(temp_time[0]);
            startHour = startHour + Integer.parseInt(temp_time[1])/60.00;
            temp_time = temp[1].split(":");
            endHour = Double.parseDouble(temp_time[0]);
            endHour = endHour + Integer.parseInt(temp_time[1])/60.00;

            if (endHour <= startHour)
                endHour = endHour + 12;
            if (startHour <= 9.5 && endHour >= 12)
            {
                hr = 9 - startHour;

                //Computing fees before 9 pm
                fees = fees + hr * rates[0];
                //Computing fees from 9pm to 12 am
                fees = fees + 3* rates[1];
                //Computing fees after 12 am
                fees = fees + (endHour - 12)*rates[2];

            }
            else if(startHour <= 9.5 && endHour >= 9 && endHour < 12)
            {
                hr = 9 - startHour;
                //Computing fees before 9 pm
                fees = fees + hr * rates[0];
                //Computing fees from 9pm to 12 am
                fees = fees + (endHour - 9)* rates[1];
            }
            else if(startHour <= 9.5 && endHour <= 9) {
                hr = endHour - startHour;
                //Computing fees before 9 pm
                fees = fees + hr * rates[0];
            }
        }
        fees = Math.round(fees * 100.0)/100.0;
        return fees;
    }

}
