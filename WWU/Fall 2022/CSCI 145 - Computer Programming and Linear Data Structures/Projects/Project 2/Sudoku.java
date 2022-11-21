public class Sudoku {
    // Validity Check
    public static boolean check(char[][] puzzle) {
        // Vertical and Horizontal Check
        // Check every value on the board
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                // The amount of times that the number we currently are on appears along the x
                // axis
                int occurX = 0;
                // The amount of times that the number we currently are on appears along the y
                // axis
                int occurY = 0;

                // Check every value in both the x and y axis. The "i" variable is the running
                // index that we are going to be on
                for (int i = 0; i < 9; i++) {
                    // Check if the value that we are checking (x, y) is the same as the values that
                    // we are currently on (x, i) and (i, y) and that it is also not '.' (empty)
                    if (puzzle[y][x] == puzzle[y][i] && puzzle[y][x] != '.')
                        occurX++;

                    if (puzzle[y][x] == puzzle[i][x] && puzzle[y][x] != '.')
                        occurY++;
                }
                // If the amount of times that there is an occurrence of the value that we are
                // checking is greater than one return false. There should be one occurrence if
                // the value isn't '.' (empty) because we check against every value in both
                // axiis, even itself
                if (occurX > 1 || occurY > 1) {
                    return false;
                }
            }
        }

        // Group Check
        // Check every group on the board (3x3 sections)
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                // Get the starting position (upper left) of the group
                int g_X = x * 3;
                int g_Y = y * 3;

                // Check every value within the group
                for (int i = g_X; i < g_X + 3; i++) {
                    for (int j = g_Y; j < g_Y + 3; j++) {
                        // The counter for the amount of times that the value tha we are currently on
                        // appears inside of the group
                        int occur = 0;

                        // Check everything within 3 to the right and down from the "anchor" point
                        // (upper left corner) of the group
                        for (int a = g_X; a < g_X + 3; a++) {
                            for (int b = g_Y; b < g_Y + 3; b++) {
                                // Check to see if the value that we are checking (j(x), i(y)) is the same as
                                // the value that we are currently on (b, a) and the value we are checking isn't
                                // '.' (empty)
                                if (puzzle[i][j] == puzzle[a][b] && puzzle[i][j] != '.')
                                    // If the value we are checking is the same as the value we currently are on
                                    // increase the number of occurrences
                                    occur++;
                            }
                        }
                        // If the amount of times that there is an occurrence of the value that we are
                        // checking is greater than one return false. There should be one occurrence if
                        // the value isn't '.' (empty) because we check every against every value in the
                        // group, even itself
                        if (occur > 1) {
                            return false;
                        }
                    }
                }
            }
        }
        // If we get through all of the checks and none of them have returned false,
        // return true
        return true;
    }

    // Print out the board
    public static void print(char[][] puzzle) {
        // Loop through every element in the sudoku board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Print out every element surrounded in | bars |
                System.out.print(" | " + puzzle[i][j] + " | ");

                // Every third element add a tab to separate the groups vertically
                if ((j + 1) % 3 == 0)
                    System.out.print("\t");
            }
            System.out.println();

            // Ever third line add an extra new line to separate the groups horizontally
            if ((i + 1) % 3 == 0)
                System.out.println();
        }
    }

    // Solves for a valid solution to the given sudoku puzzle
    public static boolean solve(char[][] puzzle) {

        // hasChanged equals false when there has been no modification to the puzzle
        // variable (no empty square has been filled in) and is true when there has been
        boolean hasChanged = false;
        // This will always loop once, but keeps looping as long as the puzzle keeps
        // getting changed (It will stop either because the puzzle is finished or it is
        // impossible to finish without making a guess)
        do {
            hasChanged = false;
            // Check to see if the puzzle is valid before solving
            if (!check(puzzle)) {
                // If the puzzle is not valid return false
                System.out.println("The given sudoku puzzle is invalid");
                return false;
            }

            // Loop through every element in the puzzle
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    if (puzzle[y][x] == '.') {
                        // Count the amount of empty elements in the x axis, y axis, and the group we
                        // are currently in
                        int emptyX = 0;
                        int emptyY = 0;
                        int emptyG = 0;

                        // Check every value in the x and y axis
                        for (int i = 0; i < 9; i++) {
                            if (puzzle[y][i] == '.')
                                // If there is an element in the x axis that equals '.' (empty) increase the
                                // emptyX counter
                                emptyX++;

                            if (puzzle[i][x] == '.')
                                // If there is an element in the y axis that equals '.' (empty) increase the
                                // emptyY counter
                                emptyY++;
                        }

                        // g_X and g_Y are the coordinates to the upper left corner of the group that we
                        // are currently in
                        int g_X = x % 3;
                        int g_Y = y % 3;

                        // Check ever element within the group that we are currently in
                        for (int i = x - g_X; i < x - g_X + 3; i++) {
                            for (int j = y - g_Y; j < y - g_Y + 3; j++) {
                                // If the element that we are currently on is equal to '.' (empty) increment the
                                // emptyG counter
                                if (puzzle[j][i] == '.')
                                    emptyG++;
                            }
                        }

                        // Check Horizontal (Single)
                        // If, from the value we were checking and now solving for, there is only one
                        // variable on the x axis
                        // that is empty, solve for it
                        if (emptyX == 1) {
                            // i is the variable that we are using to find the missing value with
                            for (int i = 1; i <= 9; i++) {
                                // isMissing will be changed to false if the value exists within the x axis
                                boolean isMissing = true;
                                // "run" along the x axis, checking every value to see if it is equal to i
                                for (int j = 0; j < 9; j++) {
                                    // If a value equals i along the x axis, set isMissing equal to false and stop
                                    // checking the rest of the values
                                    if (puzzle[y][j] == (char) (i + '0')) {
                                        isMissing = false;
                                        break;
                                    }
                                }
                                // If isMissing is still true after every value has been checked along the x
                                // axis, this means that i is the value that is missing
                                if (isMissing) {
                                    // Set the element that we are trying to solve for equal to i, change hasChanged
                                    // to true, and break out of the current loop
                                    puzzle[y][x] = (char) (i + '0');
                                    hasChanged = true;
                                    break;
                                }
                            }
                        }

                        // Check Vertical (Single)
                        // If, from the value we were checking and now solving for, there is only one
                        // variable on the y axis that is empty, solve for it
                        if (emptyY == 1) {
                            // i is the variable that we are using to find the missing value with
                            for (int i = 1; i <= 9; i++) {
                                // isMissing will be changed to false if the value exists within the x axis
                                boolean isMissing = true;
                                // "run" along the y axis, checking every value to see if it is equal to i
                                for (int j = 0; j < 9; j++) {
                                    // If a value equals i along the y axis, set isMissing equal to false and stop
                                    // checking the rest of the values
                                    if (puzzle[j][x] == (char) (i + '0')) {
                                        isMissing = false;
                                        break;
                                    }
                                }
                                // if isMissing is still true after every value has been checked along the y
                                // axis, this means that i is the value that is missing
                                if (isMissing) {
                                    // Set the element that we are trying to solve for equal to i, change hasChanged
                                    // to true, and break out of the current loop
                                    puzzle[y][x] = (char) (i + '0');
                                    hasChanged = true;
                                    break;
                                }
                            }
                        }

                        // Check Group (Single)
                        // If the group that we are in only has one missing element, solve for it
                        if (emptyG == 1) {
                            // i is going to be the variable that we are using to solve for the missing
                            // value
                            for (int i = 1; i <= 9; i++) {
                                // isMissing will equal false if i equals any value within the group
                                boolean isMissing = true;
                                // Loop through every value that is within the group
                                singleGroupCheck: // This gives us the ability to break out of the loop that checks the
                                                  // group
                                for (int k = x - g_X; k < x - g_X + 3; k++) {
                                    for (int j = y - g_Y; j < y - g_Y + 3; j++) {
                                        // if i equals the value that we are currently on set isMissing to false and
                                        // break out of the loop
                                        if (puzzle[j][k] == (char) (i + '0')) {
                                            isMissing = false;
                                            break singleGroupCheck;
                                        }
                                    }
                                }
                                // if isMissing is equal to true after checking every variable in the group,
                                // this means that i is the variable that is missing
                                if (isMissing) {
                                    // Set the element that we are trying to solve for equal to i, change hasChanged
                                    // to true, and break out of the current loop
                                    puzzle[y][x] = (char) (i + '0');
                                    hasChanged = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            // Check Group (Multiple)
            // Check the groups that have more than one missing variable and solve for them
            final int[] gCord = { 0, 3, 6 }; // The coordinates of the upper left corners of the groups
            // Loop through every group
            for (int y_Start : gCord) {
                for (int x_Start : gCord) {
                    // Make an array of the missing number and the coordinates to the missing
                    // numbers
                    int[] missingNum = new int[0];
                    int[][] emptyCord = new int[0][2];

                    // Check every element in the group to find the empty ones
                    for (int y = y_Start; y < y_Start + 3; y++) {
                        for (int x = x_Start; x < x_Start + 3; x++) {
                            // If the value that we are currently on is equal to '.' (empty) add it to the
                            // emptyCord array
                            if (puzzle[y][x] == '.') {
                                // First we need to resize the array so we need to make a temp array that has
                                // the length of the emptyCord array plus one and the width of 2
                                int[][] temp = new int[(emptyCord.length + 1)][2];

                                // Move every element from the emptyCord array to the new temp array
                                for (int i = 0; i < emptyCord.length; i++)
                                    temp[i] = emptyCord[i];

                                // Set emptyCord equal to a new array with the length of the temp array (which
                                // is one longer than the original) and a width of 2
                                emptyCord = new int[(temp.length)][2];

                                // Move every from the temp array over to the emptyCord array
                                for (int i = 0; i < temp.length; i++)
                                    emptyCord[i] = temp[i];

                                // Add the current cords to the end of the emptyCord array
                                emptyCord[(emptyCord.length - 1)][0] = y;
                                emptyCord[(emptyCord.length - 1)][1] = x;
                            }
                        }
                    }

                    // Find what value is missing in the group
                    // i is going to be the variable that helps us find the missing value
                    for (int i = 1; i <= 9; i++) {
                        // isMissing will be set to false if the value of i is within the group
                        boolean isMissing = true;

                        // Loop through every value in the group
                        groupCheckingLoop: // This allows us to stop checking the group early if we find that the value
                                           // of i is in the group
                        for (int y = y_Start; y < y_Start + 3; y++) {
                            for (int x = x_Start; x < x_Start + 3; x++) {
                                // If the current variable is the same as the value of i set isMissing to false
                                // and break out of the loop so we don't check the rest
                                if (puzzle[y][x] == (char) (i + '0')) {
                                    isMissing = false;
                                    break groupCheckingLoop;
                                }
                            }
                        }
                        // If isMissing is true that means that the value of i one of the missing
                        // values. This means that we need to add it to the missingNum array and NOT
                        // break out of the loop because there could still be more elements missing
                        if (isMissing) {
                            // Create a temp array that is the size of missingNum plus one
                            int[] temp = new int[(missingNum.length + 1)];

                            // Add everything from the missingNum array ot the temp array
                            for (int j = 0; j < missingNum.length; j++)
                                temp[j] = missingNum[j];

                            // Set the missingNum array to a new int array that is the size of temp (because
                            // temp is the size of missingNum + 1)
                            missingNum = new int[temp.length];

                            // Add everything back to the missingNum array
                            for (int j = 0; j < temp.length; j++)
                                missingNum[j] = temp[j];

                            // Add i to the end of the missingNum array
                            missingNum[missingNum.length - 1] = i;
                        }
                    }

                    // Loop through every missing number in the group
                    for (int num : missingNum) {
                        // validSpots counts the amount of spots that would be valid for the 'num' to be
                        // placed
                        int validSpots = 0;

                        checkDifferentSpot: // Break to here when num has been found on one of the x or y axiis
                        // Check every empty spot to see if 'num' would be valid there
                        for (int i = 0; i < emptyCord.length; i++) {
                            // isMissing is set to false when num has been found on either the x or y axis
                            boolean isMissing = true;

                            // Check the x axis to see if num is valid
                            for (int x = 0; x < 9; x++) {
                                // Set y to whatever the y value is for the current empty cord we are on
                                int y = emptyCord[i][0];

                                // If any value on the x axis equals num
                                if (puzzle[y][x] == (char) (num + '0')) {
                                    // Set isMissing to false and stop checking this cord
                                    isMissing = false;
                                    break checkDifferentSpot;
                                }
                            }

                            // Check the y axis to see if num is valid
                            for (int y = 0; y < 9; y++) {
                                // Set x to whatever the x value is for the current empty cord we are on
                                int x = emptyCord[i][1];

                                // If any value on the y axis equals num
                                if (puzzle[y][x] == (char) (num + '0')) {
                                    // Set isMissing to false and stop checking this cord
                                    isMissing = false;
                                    break checkDifferentSpot;
                                }
                            }

                            // If isMissing is equal to true increase the validSpots counter
                            if (isMissing)
                                validSpots++;
                        }

                        // If there is only one valid spot for num, then solve for it
                        if (validSpots == 1) {
                            checkDifferentSpot: // Break to here when the position is invalid for num
                            for (int i = 0; i < emptyCord.length; i++) {
                                // isMissing will be set to false when the spot that we are checking is invalid
                                // for num
                                boolean isMissing = true;

                                // Check the x axis to see if num is valid
                                for (int x = 0; x < 9; x++) {
                                    // Set y equal to the y for the empty cord that we are currently checking
                                    int y = emptyCord[i][0];

                                    // If any value on the x axis is equal to num, set isMissing to false and stop
                                    // checking this cord
                                    if (puzzle[y][x] == (char) (num + '0')) {
                                        isMissing = false;
                                        break checkDifferentSpot;
                                    }
                                }

                                // Check the y axis to see if num is valid
                                for (int y = 0; y < 9; y++) {
                                    // set x equal to the x for the empty cord that we are currently checking
                                    int x = emptyCord[i][1];

                                    // If any value on the x axis is equal to num, set isMissing to false and stop
                                    // checking this cord
                                    if (puzzle[y][x] == (char) (num + '0')) {
                                        isMissing = false;
                                        break checkDifferentSpot;
                                    }
                                }

                                // If isMissing is true that means that this is the valid spot for num
                                if (isMissing) {
                                    // Set the current cord of puzzle equal to num, set hasChanged to true, and
                                    // break out of this loop
                                    puzzle[emptyCord[i][0]][emptyCord[i][1]] = (char) (num + '0');
                                    hasChanged = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

        } while (hasChanged == true);

        // Check to make sure that after the puzzle hasn't had any changes that there
        // are no empty spots. If there are that means that it is unsolvable
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (puzzle[y][x] == '.') {
                    System.out.println("This puzzle is unsolvable");
                    return false;
                }
            }
        }

        // Check again to make sure that the puzzle is valid
        if (!check(puzzle)) {
            System.out.println("The given sudoku puzzle is invalid");
            return false;
        }

        // If the puzzle is valid and complete, print it out and return true
        print(puzzle);
        return true;
    }
}