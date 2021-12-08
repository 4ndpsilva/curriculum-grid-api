package com.rasmoo.curriculumgrid.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatterTest {
    @Test
    public void shouldCreateMatterObject(){
        final Matter matter = new Matter();
        matter.setId(1L);
        matter.setCode("PRD001");
        matter.setName("Programação em java");
        matter.setHours(30);
        matter.setFrequency(75);

        Assertions.assertNotNull(matter);
    }

    @Test
    public void shouldHasFrequencyValue(){
        final Matter matter = new Matter();
        matter.setFrequency(75);

        Assertions.assertEquals(75, matter.getFrequency());
    }
}