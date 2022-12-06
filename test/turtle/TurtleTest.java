package turtle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static turtle.Direction. * ;
import static turtle.PenPosition. * ;

import static org.junit.jupiter.api.Assertions.*;

    class TurtleTest {
        turtle.TurtleTest ijapa = new turtle.TurtleTest();
        Pen pen = ijapa.getPen();

        @BeforeEach
        public void StartWithThisBeforeEachTest(){
            turtle.TurtleTest ijapa = new turtle.TurtleTest();
            Pen pen = ijapa.getPen();
        }

        @Test
        public void testThatTurtleHasPen(){
            //assert
            assertNotNull(pen);
        }

        @Test
        public void testThatPenIsUpByDefault(){
            //assert
            assertSame(UP, pen.getPosition());

        }

        @Test
        public void testThatTurtleCanMovePenDown(){
            //given
            assertSame(UP, pen.getPosition());
            //when
            ijapa.penDown();
            //assert
            assertSame(DOWN, ijapa.getPen().getPosition());

        }

        @Test
        public void testThatTurtleCanMovePenUp(){
            //given
            assertSame(PenPosition.UP, pen.getPosition());
            ijapa.penDown();
            //when
            ijapa.penUp();
            //assert
            assertSame(UP, ijapa.getPen().getPosition());

        }
        @Test
        public void testThatTurtleCanMovePenBackUp() {
            //given
            ijapa.penDown();
            assertSame(DOWN, ijapa. getPen().getPosition());
            //assert
            ijapa.penUp();
            assertSame(UP, pen.getPosition());

        }

        @Test
        @DisplayName("TurtleTest can turn right while facing eat test")
        public void testThatTurtleCanTurnRight(){
            //given
            assertSame(EAST, ijapa.getCurrentDirection());
            //when
            ijapa.turnRight();
            //assert
            assertSame(SOUTH, ijapa.getCurrentDirection());
        }

        @Test
        public void testThatTurtleCanTurnRight2(){
            //given
            ijapa.turnRight();
            ijapa.turnRight();
            //assert
            assertSame(WEST, ijapa.getCurrentDirection());
        }

        @Test
        public void testThatTurtleCanTurnRight3(){
            //given
            ijapa.turnRight();
            ijapa.turnRight();
            ijapa.turnRight();
            //assert
            assertSame(NORTH, ijapa.getCurrentDirection());
        }

        //todo add turn right while facing north test

        @Test
        public void testThatTurtleCanTurnLeft(){
            //given
            assertSame(EAST, ijapa.getCurrentDirection());
            //when
            ijapa.turnLeft();
            //assert
            assertSame(NORTH, ijapa.getCurrentDirection());
        }

        @Test
        public void testThatTurtleCanTurnLeft2() {
            //given
            ijapa.turnLeft();
            ijapa.turnLeft();
            //assert
            assertSame(WEST, ijapa.getCurrentDirection());
        }

        @Test
        public void testThatTurtleCanTurnLeft3(){
            //given
            ijapa.turnLeft();
            ijapa.turnLeft();
            ijapa.turnLeft();
            //assert
            assertSame(SOUTH, ijapa.getCurrentDirection());
        }

        @Test
        public void testThatTurtleCanMoveForwardWhileFacingEast(){
            //given
            assertSame(EAST, ijapa.getCurrentDirection());
//        assertEquals(new Position(0,0), ijapa.getCurrentPosition());
            //when
            ijapa.moveForward(5);
            //assert
            assertEquals(new Position(0,4), ijapa.getCurrentPosition());
        }

        @Test
        public void testThatTurtleCanMoveForwardWhileFacingSouth(){
            //given
            assertSame(EAST, ijapa.getCurrentDirection());
            assertEquals(new Position(0,0), ijapa.getCurrentPosition());
            //when
            ijapa.turnRight();
            ijapa.moveForward(5);
            //assert
            assertEquals(new Position(4,0), ijapa.getCurrentPosition());
        }

        @Test
        public void testThatTurtleCanMoveForwardWhileFacingWest(){
            //given
//
            //when
//        ijapa.turnLeft();
            ijapa.turnRight();
            ijapa.turnRight();
            assertSame(WEST, ijapa.getCurrentDirection());
            ijapa.moveForward(4);
            //assert
            assertEquals(new Position(0, -3), ijapa.getCurrentPosition());
        }

        @Test
        public void testThatTurtleCanMoveForwardWhileFacingNorth(){
            ijapa.turnRight();
            ijapa.turnRight();
            ijapa.turnRight();
            ijapa.moveForward(4);
            //assert
            assertEquals(new Position(-3, 0), ijapa.getCurrentPosition());
        }

        @Test
        public void turtleCanWriteOnSketchPadWhileFAcingEastTest(){
            //given
            ijapa.penDown();
            assertSame(EAST, ijapa.getCurrentDirection());
            SketchPad sketchPad = new SketchPad(5,5);
            //when
            ijapa.writeOn(sketchPad, 3);
            //assert
            int[][] floor = sketchPad.getFloor();
            assertEquals(1, floor[0][0]);
            assertEquals(1, floor[0][1]);
            assertEquals(1, floor[0][2]);
            assertEquals(0, sketchPad.getFloor()[0][3]);
            assertEquals(new Position(0,2), ijapa.getCurrentPosition());
            sketchPad.displayFloor();
        }

        @Test
        public void turtleCanWriteOnSketchPadWhileFacingSouthTest(){
            //given
            SketchPad sketchPad = new SketchPad(5,5);
            ijapa.penDown();
            ijapa.writeOn(sketchPad, 3);

            //when
            ijapa.turnRight();
            assertSame(SOUTH, ijapa.getCurrentDirection());
            ijapa.writeOn(sketchPad, 3);
            //assert
            int[][] floor = sketchPad.getFloor();
            assertEquals(1, floor[0][2]);
            assertEquals(1, floor[1][2]);
            assertEquals(1, floor[2][2]);
            assertEquals(0, floor[3][2]);
            assertEquals(new Position(2,2), ijapa.getCurrentPosition());
            sketchPad.displayFloor();
        }

        @Test
        public void turtleCanWriteOnSketchPadWhileFAcingWestTest(){
            //given
            SketchPad sketchPad = new SketchPad(5,5);
            ijapa.penDown();
            ijapa.writeOn(sketchPad, 3);

            ijapa.turnRight();
            ijapa.writeOn(sketchPad,3);
            assertEquals(new Position(2,2), ijapa.getCurrentPosition());

            //when
            ijapa.turnRight();
            ijapa.writeOn(sketchPad, 3);
            //assert
            int[][] floor = sketchPad.getFloor();
            assertEquals(1, floor[2][2]);
            assertEquals(1, floor[2][1]);
            assertEquals(1, floor[2][0]);
            assertEquals(new Position(2,0), ijapa.getCurrentPosition());
            sketchPad.displayFloor();
        }

        @Test
        public void turtleCanWriteOnSketchPadWhileFAcingNorthTest(){
            //given
            SketchPad sketchPad = new SketchPad(5,5);
            ijapa.penDown();
            ijapa.writeOn(sketchPad, 3);

            ijapa.turnRight();
            ijapa.writeOn(sketchPad,3);

            ijapa.turnRight();
            ijapa.writeOn(sketchPad,3);

            //when
            ijapa.turnRight();
            assertSame(NORTH, ijapa.getCurrentDirection());
            ijapa.writeOn(sketchPad, 3);
            //assert
            int[][] floor = sketchPad.getFloor();
            for (int i = 0; i < 3; i++) {
                assertEquals(1, floor[2][0]);
            }
//        assertEquals(1, floor[2][0]);
//        assertEquals(1, floor[1][0]);
            assertEquals(1, floor[0][0]);
            assertEquals(new Position(0,0), ijapa.getCurrentPosition());
            sketchPad.displayFloor();
        }

        @Test
        public void turtleCanWriteOnSketchPadWhileFAcingNorthAndTurnLeftTest(){
            //given
            SketchPad sketchPad = new SketchPad(5,5);

            //when
            ijapa.turnLeft();
            ijapa.writeOn(sketchPad, 2);
            assertSame(NORTH, ijapa.getCurrentDirection());
            ijapa.writeOn(sketchPad, 2);
            //assert
            int[][] floor = sketchPad.getFloor();
            for (int i = 0; i < 2; i++) {
                assertEquals(0, floor[i][1]);
            }
            assertEquals(0, floor[0][1]);
//        assertEquals(new Position(0,0), ijapa.getCurrentPosition());
            sketchPad.displayFloor();
        }


}