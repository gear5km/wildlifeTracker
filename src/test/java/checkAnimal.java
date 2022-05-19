import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkAnimal {
    @Test
    void checkIfEndangered(){
        endangeredAnimals testanimal= new endangeredAnimals(1,"testAnimal",3,4,"healthy");
        assertEquals(true, testanimal.isEndangered);
    }

    @Test
    void checkSpeciesList(){
        assertEquals(2 ,Animals.getSpecies().size());
    }
}
