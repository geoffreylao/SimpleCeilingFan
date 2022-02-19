import java.util.Scanner;

public class CeilingFanApp {

  public static void main(String[] args) {
    CeilingFan ceilingFan = new CeilingFan();
    Scanner myScanner = new Scanner(System.in);

    String fanArt = """

            @@@@@@
         @@@@@@@@@@@&
            @@@@@@@@@@@
              %@@@@@@@@@@
                 @@@@@@@@@@          @@@@@@@#
                    @@@@@@@@@&       @@@@@@@*
                       @@@@@@@@@       @@@
                         &@@@@@@@@      @
                            @@@@@@@@,   @
                               @@@@@@@@@@@,                     .#@@@@@@@@@@@@@@@%
                                  @@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&,
                                 @@@@@@@@@@@@@@@%..
                                  @@@@@@@@@@@.@
                                @@@@@@&       @
                             @@@@@@@.         @
                           @@@@@@@@           @@
                         @@@@@@@  @
                          .@@@    @@
                                  @@
        """;

    System.out.print(fanArt);

    System.out.println(
        "\nVrrr I'm a fan. ┌|.o.|┘ Press '1' to adjust my speed. Press '2' to switch my spin direction.");

    while (true) {

      String pullingCord = myScanner.next();

      switch (pullingCord) {
        case "1":
          ceilingFan.pullCord(Integer.parseInt(pullingCord));
          System.out.println("You pulled cord " + pullingCord + "! Changing speed.\n" + ceilingFan.toString() + "\n");
          break;
        case "2":
          ceilingFan.pullCord(Integer.parseInt(pullingCord));

          switch (ceilingFan.speed) {
            case 0:
              System.out
                  .println("You pulled cord " + pullingCord + "! Nothing happened.. \n" + ceilingFan.toString()
                      + "\n");
              break;
            default:
              System.out
                  .println("You pulled cord " + pullingCord + "! Changing spin direction. \n" + ceilingFan.toString()
                      + "\n");
              break;
          }

          break;
        default:
          System.out.println(pullingCord + " is not a valid cord to pull! Please try again");
          break;
      }
    }

  }

  static class CeilingFan {
    public int speed;
    public String direction;
    public String lastDirection;

    public CeilingFan() {
      speed = 0;
      direction = "Off";
      lastDirection = "Right";
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
              direction = lastDirection;
              break;

            case 1:
              speed++;
              break;

            case 2:
              speed++;
              break;

            case 3:
              speed = 0;
              direction = "Off";
              break;

          }
          break;

        // Direction cord
        case 2:
          // Reverses the direction of the fan at the current speed setting.
          // Once the direction has been reversed, it remains reversed as we
          // cycle through the speed settings, until reversed again.
          // Assuming that direction cord does nothing when speed is 0 ("off")
          if (speed != 0) {
            switch (lastDirection) {
              case "Right":
                lastDirection = "Left";
                direction = "Left";
                break;

              case "Left":
                lastDirection = "Right";
                direction = "Right";
                break;

            }
          }

          break;
      }
    }// end of pullCord

    public String toString() {
      return ("Speed: " + this.speed + " \nDirection: " + this.direction);
    }
  }

}