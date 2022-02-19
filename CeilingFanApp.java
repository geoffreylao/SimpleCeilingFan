import java.util.Scanner;

/*
  CeilingFanApp --- simple ceiling fan with these characteristics:
   •    The unit has 2 pull cords:   One increases the speed each time it is pulled.  
   There are 3 speed settings, and an “off” (speed 0) setting.   
   If the cord is pulled on speed 3, the fan returns to the “off” setting. 
   One reverses the direction of the fan at the current speed setting. 
   Once the direction has been reversed, it remains reversed as we cycle through the speed settings,
   until reversed again. Assuming that direction cord does nothing when speed is 0 ("off").

   •    You can assume the unit is always powered (no wall switch)

   @author Geoffrey Lao
*/

public class CeilingFanApp {
  /*
   * Asks for user input to control the ceiling fan
   * and the command line arguments.
   * 
   * @param arg A string array containing
   * the command line arguments.
   * 
   * @exception Any exception
   * 
   * @return No return value.
   */
  public static void main(String[] args) {
    CeilingFan ceilingFan = new CeilingFan();
    try (Scanner myScanner = new Scanner(System.in)) {
      String FANART = """

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

      System.out.print(FANART);

      System.out.println(
          "\nVrrr I'm a fan. ┌|.o.|┘ Press '1' to adjust my speed. Press '2' to switch my spin direction. Press 'u' to unplug me.");

      // USer input loop
      while (true) {

        String pullingCord = myScanner.next();

        switch (pullingCord.toLowerCase()) {
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

          case "u":
            System.out
                .println("You unplugged me! ┌|x_x|┘");
            System.exit(0);
          default:
            System.out.println(pullingCord + " is not a valid cord to pull! Please try again");
            break;
        }
      }
    }

  }

  /*
   * The CeilingFan class to create the ceilingFan object
   */
  static class CeilingFan {
    public int speed;
    public String direction;
    public String lastDirection;

    // Constructor
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