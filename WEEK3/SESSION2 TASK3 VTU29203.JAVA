class Solution {
    public int dayOfYear(String date) {
        String[] parts = date.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            daysInMonth[1] = 29;
        }

        int dayNumber = day;

        for (int i = 0; i < month - 1; i++) {
            dayNumber += daysInMonth[i];
        }

        return dayNumber;
    }
}

OUTPUT:
Input
date =
"2019-01-09"
Output
9
Expected
9
