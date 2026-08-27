import java.time.LocalDate;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);

        String[] days = {
            "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"
        };

        return days[date.getDayOfWeek().getValue() - 1];
    }
}

OUTPUT:
Input
day =
31
month =
8
year =
2019
Output
"Saturday"
Expected
"Saturday"
