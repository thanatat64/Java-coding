public class Circle extends GeometricObject   {
    private double radius;

    public Circle() {

    }

    public Circle(double radius){
        if (radius > 0) {
            this.radius = radius;
        }
        else{
            System.out.println("Error you must input number above zero");
            System.exit(1);
        }
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDiameter() {
        return radius * 2;
    }

    @Override
    public double getArea() {
        return (radius * radius) * 3.14;
    }

    @Override
    public double getPerimeter() {
        return 6.28 * radius;
    }

    @Override
    public String toString() {
        return super.toString() + "\nArea :" + getArea() + "\nDiameter : " + getPerimeter();
    }

    @Override
    public int compareTo(GeometricObject o) {
        if (getArea() > o.getArea())
            return 1;
        else if (getArea() < o.getArea())
            return -1;
        else
            return 0;
    }
}
