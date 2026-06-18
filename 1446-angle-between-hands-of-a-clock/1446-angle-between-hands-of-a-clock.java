class Solution {
    public double angleClock(int hour, int minutes) {
        if (hour == 12)
            hour = 0;

        double hr = hour;
        double mn = minutes;

        double h = hr * 30;
        h += mn / 2;

        double m = mn * 6;

        double angle = Math.abs(h - m);

        if (angle > 180)
            return 360 - (angle % 360);
        return angle;
    }
}