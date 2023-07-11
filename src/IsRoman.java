public enum IsRoman {
    I(1),II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);

    private int number;

    IsRoman(int num){
        this.number = num;
    }

    public int getNumber() {
        return number;
    }


    public static IsRoman toRoman(int num){
        return values()[num-1];
    }
    public static IsRoman toRoman(String str){
        return IsRoman.valueOf(str);
    }


    public boolean moreThen(IsRoman rhs){
        return this.getNumber() > rhs.getNumber();
    }
    public boolean lessThen(IsRoman rhs){
        return this.getNumber() < rhs.getNumber();
    }
    public boolean equal(IsRoman rhs){
        return this.getNumber() == rhs.getNumber();
    }

    
    public static IsRoman sum(IsRoman lhs, IsRoman rhs){
        return toRoman(lhs.getNumber() + rhs.getNumber());
    }
    public static IsRoman sub(IsRoman lhs, IsRoman rhs){
        return toRoman(lhs.getNumber() - rhs.getNumber());
    }
    public static IsRoman mult(IsRoman lhs, IsRoman rhs){
        return toRoman(lhs.getNumber() * rhs.getNumber());
    }
    public static IsRoman div(IsRoman lhs, IsRoman rhs){
        return toRoman(lhs.getNumber() / rhs.getNumber());
    }
}
