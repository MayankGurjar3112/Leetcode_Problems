class Solution {
    public double angleClock(int hour, int minutes) {
        double angle = Math.abs(((hour == 12 ? 0 : hour * 30.0) + (minutes / 2.0)) - (minutes * 6.0));
        return angle > 180 ? 360 - (angle % 360) : angle;
    }
}