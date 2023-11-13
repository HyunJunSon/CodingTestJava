package org.example.bj10158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainBackup {

    public static class AntCoordinate{
        private int x;
        private int y;

        AntCoordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }
        public void setY(int y) {
            this.y = y;
        }
        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public enum Direction {
        NORTHEAST {
            public void apply() {
                currentCoordinate.setX(currentCoordinate.getX() + 1);
                currentCoordinate.setY(currentCoordinate.getY() + 1);
            }
        },

        NORTHWEST {
            public void apply() {
                currentCoordinate.setX(currentCoordinate.getX() - 1);
                currentCoordinate.setY(currentCoordinate.getY() + 1);
            }
        },

        SOUTHEAST {
            public void apply() {
                currentCoordinate.setX(currentCoordinate.getX() + 1);
                currentCoordinate.setY(currentCoordinate.getY() - 1);
            }
        },

        SOUTHWEST {
            public void apply() {
                currentCoordinate.setX(currentCoordinate.getX() - 1);
                currentCoordinate.setY(currentCoordinate.getY() - 1);
            }
        };

        public abstract void apply();
    }

    static Direction currentDirection = Direction.NORTHEAST;

    static AntCoordinate currentCoordinate;

    static int horizontalBoard;

    static int verticalBoard;

    public static void inspectDirection() {
        // 4 Cases in the corners
        if (currentCoordinate.getX() == horizontalBoard && currentCoordinate.getY() == verticalBoard) {
            currentDirection = Direction.SOUTHWEST;
            return;
        }

        if (currentCoordinate.getX() == horizontalBoard && currentCoordinate.getY() == 0) {
            currentDirection = Direction.NORTHWEST;
            return;
        }

        if (currentCoordinate.getX() == 0 && currentCoordinate.getY() == verticalBoard) {
            currentDirection = Direction.SOUTHEAST;
            return;
        }

        if (currentCoordinate.getX() == 0 && currentCoordinate.getY() == 0) {
            currentDirection = Direction.NORTHEAST;
            return;
        }

        // 8 Cases in the boards
        if (currentCoordinate.getX() == horizontalBoard && currentDirection == Direction.NORTHEAST) {
            currentDirection = Direction.NORTHWEST;
            return;
        }

        if (currentCoordinate.getX() == horizontalBoard && currentDirection == Direction.SOUTHEAST) {
            currentDirection = Direction.SOUTHWEST;
            return;
        }

        if (currentCoordinate.getX() == 0 && currentDirection == Direction.NORTHWEST) {
            currentDirection = Direction.NORTHEAST;
            return;
        }

        if (currentCoordinate.getX() == 0 && currentDirection == Direction.SOUTHWEST) {
            currentDirection = Direction.SOUTHEAST;
            return;
        }

        if (currentCoordinate.getY() == verticalBoard && currentDirection == Direction.NORTHEAST) {
            currentDirection = Direction.SOUTHEAST;
            return;
        }

        if (currentCoordinate.getY() == verticalBoard && currentDirection == Direction.NORTHWEST) {
            currentDirection = Direction.SOUTHWEST;
            return;
        }

        if (currentCoordinate.getY() == 0 && currentDirection == Direction.SOUTHWEST) {
            currentDirection = Direction.NORTHWEST;
            return;
        }

        if (currentCoordinate.getY() == 0 && currentDirection == Direction.SOUTHEAST) {
            currentDirection = Direction.NORTHEAST;
        }

    }

    public static void parseStringToCoordinate(String input) {
        String[] splitList = input.split(" ");
        currentCoordinate = new AntCoordinate(
                Integer.parseInt(splitList[0]),
                Integer.parseInt(splitList[1])
        );
    }

    public static void parseStringToBoard(String input) {
        String[] splitList = input.split(" ");
        horizontalBoard = Integer.parseInt(splitList[0]);
        verticalBoard = Integer.parseInt(splitList[1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        parseStringToBoard(br.readLine());
        parseStringToCoordinate(br.readLine());
        int iteration = Integer.parseInt(br.readLine());
        while (iteration > 0) {
            inspectDirection();
            currentDirection.apply();
            iteration--;
        }
        System.out.println(currentCoordinate.getX() + " " + currentCoordinate.getY());
    }
}
