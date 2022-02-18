import javax.swing.SpinnerDateModel;

public class CeilingFanApp {

  public static void main(String[] args) {
    CeilingFan ceilingFan = new CeilingFan(0, "Right");

    System.out.println(ceilingFan.toString());

    ceilingFan.pullCord(1);

    System.out.println(ceilingFan.toString());

    ceilingFan.pullCord(2);

    System.out.println(ceilingFan.toString());

    ceilingFan.pullCord(1);

    System.out.println(ceilingFan.toString());

    ceilingFan.pullCord(1);

    System.out.println(ceilingFan.toString());

    ceilingFan.pullCord(1);

    System.out.println(ceilingFan.toString());
  }

  static class CeilingFan {
    public int speed;
    public String direction;

    public CeilingFan(int initialSpeed, String initialDirection) {
      speed = initialSpeed;
      direction = initialDirection;
    }

    public int getSpeed() {
      return speed;
    }

    public String getDirection() {
      return direction;
    }

    public void pullCord(int cordPulled) {

      switch (cordPulled) {

        // Speed cord
        case 1:
          // There are 3 speed settings, and an “off” (speed 0) setting.
          // If the cord is pulled on speed 3, the fan returns to the “off” setting.
          switch (speed) {
            case 0:
              speed++;
              break;
            case 1:
              speed++;
              break;
            case 2:
              speed++;
              break;
            case 3:
              speed = 0;
              break;
          }
          break;

        // Direction cord
        case 2:
          // Reverses the direction of the fan at the current speed setting.
          // Once the direction has been reversed, it remains reversed as we
          // cycle through the speed settings, until reversed again.
          switch (direction) {
            case "Right":
              direction = "Left";
              break;
            case "Left":
              direction = "Right";
              break;
          }
          break;
      }
    }// end of pullCord

    public String toString() {
      return ("Speed: " + this.speed + " \nDirection: " + this.direction);
    }
  }

}