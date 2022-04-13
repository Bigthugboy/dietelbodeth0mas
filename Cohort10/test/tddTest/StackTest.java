package tddTest;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTest {

    @Test
    public void stackCanBeCreated(){
        Stack stack =  new Stack();
        assertNotNull(stack);
    }
    @Test
    public void stackIsEmpty(){
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
    }
}
