package org.launchcode.techjobs_oo.tests;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1 = new Job();
    Job job2 = new Job();
    Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job job5 = new Job("Product tester", new Employer(), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
    @Before

    @Test
    public void testSettingJobIDnotEqual() {
        assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void testSettingJobIDplusOne() {
        int job1IDplus = job1.getId() + 1;
        assertTrue(job2.getId() == job1IDplus);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getName() == "Product tester");
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job3.equals(job4));
    }

    @Test
    public void testJobToString() {
        String testString = "ID: " + job3.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence";

        assertEquals(testString, job3.toString());
    }

    @Test
    public void testJobToStringMissingData() {
        String testString = "ID: " + job5.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Data not available";

        assertEquals(testString, job5.toString());
    }

    @Test
    public void testJobEmptyConstructorToString() {
        String testString = "OOPS! This job does not seem to exist.";

        assertEquals(testString, job2.toString());
    }

}
