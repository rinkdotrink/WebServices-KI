package de.ki.cal2.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.ki.KIModule;
import de.ki.PropertyAndConcept;
import de.ki.PropertyConverter;
import de.ki.server.learn.cal2.DecisionTree;

public class DecisionTreeTest {

   DecisionTree decisionTree;
   PropertyAndConcept propAndCon;
   private Injector injector;

   @BeforeClass
   public static void setUpBeforeClass()
      throws Exception {
   }

   @AfterClass
   public static void tearDownAfterClass()
      throws Exception {
   }

   @Before
   public void setUp()
      throws Exception {
      injector = Guice.createInjector(new KIModule());
      decisionTree = injector.getInstance(DecisionTree.class);
   }

   @After
   public void tearDown()
      throws Exception {
   }

   @Test
   public final void testDoConceptUnknown() {
      DecisionTree rootExpected = decisionTree.getRoot();
      List<DecisionTree> nextsExpected = decisionTree.getNexts();
      test1();

      assertEquals(rootExpected, decisionTree.getRoot());
      assertEquals(0, decisionTree.getPropertyIndex());
      assertEquals(nextsExpected, decisionTree.getNexts());
      assertEquals(new ArrayList<Integer>(), decisionTree.getValues());
      assertEquals("Vorfahrt von Rechts", decisionTree.getConcept());
      assertEquals(true, decisionTree.isLeaf());
   }

   @Test
   public final void testDoConceptDoNotMatches() {
      DecisionTree rootExpected = decisionTree.getRoot();

      test2();

      assertEquals(rootExpected, decisionTree.getRoot());
      assertEquals(0, decisionTree.getPropertyIndex());
      assertEquals((long) 90, (long) decisionTree.getValues().get(0));
      assertEquals(false, decisionTree.isLeaf());
      assertEquals("node", decisionTree.getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(0).getRoot());
      assertEquals(1, decisionTree.getNexts().get(0).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());

   }

   @Test
   public final void testNr3() {
      DecisionTree rootExpected = decisionTree.getRoot();

      test3();

      assertEquals(rootExpected, decisionTree.getRoot());
      assertEquals(0, decisionTree.getPropertyIndex());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());
      assertEquals((long) 90, (long) decisionTree.getValues().get(0));
      assertEquals(false, decisionTree.isLeaf());
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals("node", decisionTree.getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(0).getRoot());
      assertEquals(1, decisionTree.getNexts().get(0).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(1).getRoot());
      assertEquals(1, decisionTree.getNexts().get(1).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(1).isLeaf());
      assertEquals("Vorfahrt von Rechts",
                   decisionTree.getNexts().get(1).getConcept());
   }

   @Test
   public final void testNr4() {
      DecisionTree rootExpected = decisionTree.getRoot();

      test4();

      assertEquals(rootExpected, decisionTree.getRoot());
      assertEquals(0, decisionTree.getPropertyIndex());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());
      assertEquals((long) 90, (long) decisionTree.getValues().get(0));
      assertEquals(false, decisionTree.isLeaf());
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals("node", decisionTree.getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(0).getRoot());
      assertEquals(1, decisionTree.getNexts().get(0).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(1).getRoot());
      assertEquals(1, decisionTree.getNexts().get(1).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(1).isLeaf());
      assertEquals("Vorfahrt von Rechts",
                   decisionTree.getNexts().get(1).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(2).getRoot());
      assertEquals(1, decisionTree.getNexts().get(2).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(2).isLeaf());
      assertEquals("Stop", decisionTree.getNexts().get(2).getConcept());
   }

   @Test
   public final void testNr5() {
      DecisionTree rootExpected = decisionTree.getRoot();

      test5();

      assertEquals(rootExpected, decisionTree.getRoot());
      assertEquals(0, decisionTree.getPropertyIndex());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());
      assertEquals((long) 90, (long) decisionTree.getValues().get(0));
      assertEquals(false, decisionTree.isLeaf());
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals("node", decisionTree.getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(0).getRoot());
      assertEquals(1, decisionTree.getNexts().get(0).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(1).getRoot());
      assertEquals(1, decisionTree.getNexts().get(1).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(1).isLeaf());
      assertEquals("Vorfahrt von Rechts",
                   decisionTree.getNexts().get(1).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(2).getRoot());
      assertEquals(1, decisionTree.getNexts().get(2).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(2).isLeaf());
      assertEquals("Stop", decisionTree.getNexts().get(2).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(3).getRoot());
      assertEquals(1, decisionTree.getNexts().get(3).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(3).isLeaf());
      assertEquals("Fahrtrichtung links",
                   decisionTree.getNexts().get(3).getConcept());
   }

   @Test
   public final void testNr6() {
      DecisionTree rootExpected = decisionTree.getRoot();

      test6();

      assertEquals(rootExpected, decisionTree.getRoot());
      assertEquals(0, decisionTree.getPropertyIndex());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());
      assertEquals((long) 90, (long) decisionTree.getValues().get(0));
      assertEquals(false, decisionTree.isLeaf());
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals("node", decisionTree.getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(0).getRoot());
      assertEquals(1, decisionTree.getNexts().get(0).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(1).getRoot());
      assertEquals(1, decisionTree.getNexts().get(1).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(1).isLeaf());
      assertEquals("Vorfahrt von Rechts",
                   decisionTree.getNexts().get(1).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(2).getRoot());
      assertEquals(1, decisionTree.getNexts().get(2).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(2).isLeaf());
      assertEquals("Stop", decisionTree.getNexts().get(2).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(3).getRoot());
      assertEquals(1, decisionTree.getNexts().get(3).getPropertyIndex());
      assertEquals(false, decisionTree.getNexts().get(3).isLeaf());
      assertEquals((long) 10,
                   (long) decisionTree.getNexts().get(3).getValues().get(0));
      assertEquals("node", decisionTree.getNexts().get(3).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getRoot());
      assertEquals(2,
                   decisionTree.getNexts().get(3).getNexts().get(0).getPropertyIndex());
      assertEquals(true,
                   decisionTree.getNexts().get(3).getNexts().get(0).isLeaf());
      assertEquals("Fahrtrichtung rechts",
                   decisionTree.getNexts().get(3).getNexts().get(0).getConcept());
   }

   @Test
   public final void testNr7() {
      DecisionTree rootExpected = decisionTree.getRoot();

      test7();

      assertEquals(rootExpected, decisionTree.getRoot());
      assertEquals(0, decisionTree.getPropertyIndex());
      assertEquals(false, decisionTree.isLeaf());
      assertEquals("node", decisionTree.getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(0).getRoot());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());
      assertEquals((long) 90, (long) decisionTree.getValues().get(0));
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals(1, decisionTree.getNexts().get(0).getPropertyIndex());

      assertEquals(rootExpected, decisionTree.getNexts().get(1).getRoot());
      assertEquals(1, decisionTree.getNexts().get(1).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(1).isLeaf());
      assertEquals("Vorfahrt von Rechts",
                   decisionTree.getNexts().get(1).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(2).getRoot());
      assertEquals(1, decisionTree.getNexts().get(2).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(2).isLeaf());
      assertEquals("Stop", decisionTree.getNexts().get(2).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(3).getRoot());
      assertEquals(1, decisionTree.getNexts().get(3).getPropertyIndex());
      assertEquals(false, decisionTree.getNexts().get(3).isLeaf());
      assertEquals((long) 10,
                   (long) decisionTree.getNexts().get(3).getValues().get(0));
      assertEquals("node", decisionTree.getNexts().get(3).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getRoot());
      assertEquals(2,
                   decisionTree.getNexts().get(3).getNexts().get(0).getPropertyIndex());
      assertEquals(false,
                   decisionTree.getNexts().get(3).getNexts().get(0).isLeaf());
      assertEquals((long) 0,
                   (long) decisionTree.getNexts().get(3).getNexts().get(0).getValues().get(0));
      assertEquals("node",
                   decisionTree.getNexts().get(3).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getRoot());
      assertEquals(3,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getPropertyIndex());
      assertEquals(true,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).isLeaf());
      assertEquals("Fahrtrichtung links",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getConcept());
   }

   @Test
   public final void testNr8() {
      DecisionTree rootExpected = decisionTree.getRoot();

      test8();

      assertEquals(rootExpected, decisionTree.getRoot());
      assertEquals(0, decisionTree.getPropertyIndex());
      assertEquals(false, decisionTree.isLeaf());
      assertEquals("node", decisionTree.getConcept());

      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());
      assertEquals((long) 90, (long) decisionTree.getValues().get(0));
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());

      assertEquals(rootExpected, decisionTree.getNexts().get(0).getRoot());
      assertEquals(1, decisionTree.getNexts().get(0).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(1).getRoot());
      assertEquals(1, decisionTree.getNexts().get(1).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(1).isLeaf());
      assertEquals("Vorfahrt von Rechts",
                   decisionTree.getNexts().get(1).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(2).getRoot());
      assertEquals(1, decisionTree.getNexts().get(2).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(2).isLeaf());
      assertEquals("Stop", decisionTree.getNexts().get(2).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(3).getRoot());
      assertEquals(1, decisionTree.getNexts().get(3).getPropertyIndex());
      assertEquals(false, decisionTree.getNexts().get(3).isLeaf());
      assertEquals((long) 10,
                   (long) decisionTree.getNexts().get(3).getValues().get(0));
      assertEquals("node", decisionTree.getNexts().get(3).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getRoot());
      assertEquals(2,
                   decisionTree.getNexts().get(3).getNexts().get(0).getPropertyIndex());
      assertEquals(false,
                   decisionTree.getNexts().get(3).getNexts().get(0).isLeaf());
      assertEquals((long) 0,
                   (long) decisionTree.getNexts().get(3).getNexts().get(0).getValues().get(0));
      assertEquals("node",
                   decisionTree.getNexts().get(3).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getRoot());
      assertEquals(3,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getPropertyIndex());
      assertEquals(false,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).isLeaf());
      assertEquals((long) 30,
                   (long) decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getValues().get(0));
      assertEquals("node",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getRoot());
      assertEquals(4,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getPropertyIndex());
      assertEquals(true,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).isLeaf());
      assertEquals("Fahrtrichtung rechts",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getConcept());
   }

   @Test
   public final void testNr9() {
      DecisionTree rootExpected = decisionTree.getRoot();

      test9();

      assertEquals(rootExpected, decisionTree.getRoot());
      assertEquals(0, decisionTree.getPropertyIndex());
      assertEquals(false, decisionTree.isLeaf());
      assertEquals("node", decisionTree.getConcept());

      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());
      assertEquals((long) 90, (long) decisionTree.getValues().get(0));
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());

      assertEquals(rootExpected, decisionTree.getNexts().get(0).getRoot());
      assertEquals(1, decisionTree.getNexts().get(0).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(1).getRoot());
      assertEquals(1, decisionTree.getNexts().get(1).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(1).isLeaf());
      assertEquals("Vorfahrt von Rechts",
                   decisionTree.getNexts().get(1).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(2).getRoot());
      assertEquals(1, decisionTree.getNexts().get(2).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(2).isLeaf());
      assertEquals("Stop", decisionTree.getNexts().get(2).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(3).getRoot());
      assertEquals(1, decisionTree.getNexts().get(3).getPropertyIndex());
      assertEquals(false, decisionTree.getNexts().get(3).isLeaf());
      assertEquals((long) 10,
                   (long) decisionTree.getNexts().get(3).getValues().get(0));
      assertEquals("node", decisionTree.getNexts().get(3).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getRoot());
      assertEquals(2,
                   decisionTree.getNexts().get(3).getNexts().get(0).getPropertyIndex());
      assertEquals(false,
                   decisionTree.getNexts().get(3).getNexts().get(0).isLeaf());
      assertEquals((long) 10,
                   (long) decisionTree.getNexts().get(3).getValues().get(0));
      assertEquals((long) 0,
                   (long) decisionTree.getNexts().get(3).getNexts().get(0).getValues().get(0));
      assertEquals("node",
                   decisionTree.getNexts().get(3).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getRoot());
      assertEquals(3,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getPropertyIndex());
      assertEquals(false,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).isLeaf());
      assertEquals((long) 0,
                   (long) decisionTree.getNexts().get(3).getNexts().get(0).getValues().get(0));
      assertEquals((long) 30,
                   (long) decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getValues().get(0));
      assertEquals("node",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getRoot());
      assertEquals(4,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getPropertyIndex());
      assertEquals(false,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).isLeaf());
      assertEquals((long) 40,
                   (long) decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getValues().get(0));
      assertEquals("node",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(0).getRoot());
      assertEquals(5,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(0).getPropertyIndex());
      assertEquals(true,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(0).isLeaf());
      assertEquals("Fahrtrichtung links",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(0).getConcept());
   }

   @Test
   public final void testNr10() {
      DecisionTree rootExpected = decisionTree.getRoot();

      test10();

      assertEquals(rootExpected, decisionTree.getRoot());
      assertEquals(0, decisionTree.getPropertyIndex());
      assertEquals(false, decisionTree.isLeaf());
      assertEquals("node", decisionTree.getConcept());

      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());
      assertEquals((long) 90, (long) decisionTree.getValues().get(0));
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());

      assertEquals(rootExpected, decisionTree.getNexts().get(0).getRoot());
      assertEquals(1, decisionTree.getNexts().get(0).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(1).getRoot());
      assertEquals(1, decisionTree.getNexts().get(1).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(1).isLeaf());
      assertEquals("Vorfahrt von Rechts",
                   decisionTree.getNexts().get(1).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(2).getRoot());
      assertEquals(1, decisionTree.getNexts().get(2).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(2).isLeaf());
      assertEquals("Stop", decisionTree.getNexts().get(2).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(3).getRoot());
      assertEquals(1, decisionTree.getNexts().get(3).getPropertyIndex());
      assertEquals(false, decisionTree.getNexts().get(3).isLeaf());
      assertEquals("node", decisionTree.getNexts().get(3).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getRoot());
      assertEquals(2,
                   decisionTree.getNexts().get(3).getNexts().get(0).getPropertyIndex());
      assertEquals(false,
                   decisionTree.getNexts().get(3).getNexts().get(0).isLeaf());
      assertEquals("node",
                   decisionTree.getNexts().get(3).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getRoot());
      assertEquals(3,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getPropertyIndex());
      assertEquals(false,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).isLeaf());
      assertEquals("node",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getRoot());
      assertEquals(4,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getPropertyIndex());
      assertEquals(false,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).isLeaf());
      assertEquals("node",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(0).getRoot());
      assertEquals(5,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(0).getPropertyIndex());
      assertEquals(true,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(0).isLeaf());
      assertEquals("Fahrtrichtung links",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(1).getRoot());
      assertEquals(5,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(1).getPropertyIndex());
      assertEquals(true,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(1).isLeaf());
      assertEquals("Fahrtrichtung rechts",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(1).getConcept());
   }

   @Test
   public final void testNr11() {
      DecisionTree rootExpected = decisionTree.getRoot();

      test11();

      assertEquals(rootExpected, decisionTree.getRoot());
      assertEquals(0, decisionTree.getPropertyIndex());
      assertEquals(false, decisionTree.isLeaf());
      assertEquals("node", decisionTree.getConcept());

      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());
      assertEquals((long) 90, (long) decisionTree.getValues().get(0));
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());

      assertEquals(rootExpected, decisionTree.getNexts().get(0).getRoot());
      assertEquals(1, decisionTree.getNexts().get(0).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(0).isLeaf());
      assertEquals("Vorfahrt gewähren",
                   decisionTree.getNexts().get(0).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(1).getRoot());
      assertEquals(1, decisionTree.getNexts().get(1).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(1).isLeaf());
      assertEquals("Vorfahrt von Rechts",
                   decisionTree.getNexts().get(1).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(2).getRoot());
      assertEquals(1, decisionTree.getNexts().get(2).getPropertyIndex());
      assertEquals(true, decisionTree.getNexts().get(2).isLeaf());
      assertEquals("Stop", decisionTree.getNexts().get(2).getConcept());

      assertEquals(rootExpected, decisionTree.getNexts().get(3).getRoot());
      assertEquals(1, decisionTree.getNexts().get(3).getPropertyIndex());
      assertEquals(false, decisionTree.getNexts().get(3).isLeaf());
      assertEquals("node", decisionTree.getNexts().get(3).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(1).getRoot());
      assertEquals(2,
                   decisionTree.getNexts().get(3).getNexts().get(1).getPropertyIndex());
      assertEquals(true,
                   decisionTree.getNexts().get(3).getNexts().get(1).isLeaf());
      assertEquals("Vorfahrtsstraße",
                   decisionTree.getNexts().get(3).getNexts().get(1).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getRoot());
      assertEquals(2,
                   decisionTree.getNexts().get(3).getNexts().get(0).getPropertyIndex());
      assertEquals(false,
                   decisionTree.getNexts().get(3).getNexts().get(0).isLeaf());
      assertEquals("node",
                   decisionTree.getNexts().get(3).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getRoot());
      assertEquals(3,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getPropertyIndex());
      assertEquals(false,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).isLeaf());
      assertEquals("node",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getRoot());
      assertEquals(4,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getPropertyIndex());
      assertEquals(false,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).isLeaf());
      assertEquals("node",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(0).getRoot());
      assertEquals(5,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(0).getPropertyIndex());
      assertEquals(true,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(0).isLeaf());
      assertEquals("Fahrtrichtung links",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(0).getConcept());

      assertEquals(rootExpected,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(1).getRoot());
      assertEquals(5,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(1).getPropertyIndex());
      assertEquals(true,
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(1).isLeaf());
      assertEquals("Fahrtrichtung rechts",
                   decisionTree.getNexts().get(3).getNexts().get(0).getNexts().get(0).getNexts().get(0).getNexts().get(1).getConcept());
   }

   //
   private void test1() {
      createVorfahrtVonRechts();
      decisionTree.doConceptUnknown(propAndCon);
   }

   @Test
   public void test1_classify() {
      // propertyVector und root übergeben und Rückgabe soll blatt sein mit
      // concept == ? für unknown concept
      // oder concept == richtiges concept für wenn richtig erkannt
      // oder concept == falsches concept, für nicht richtig erkannt
      test1();
      DecisionTree decTreeResult =
         decisionTree.classify(decisionTree, propAndCon);
      assertEquals("Vorfahrt von Rechts", decTreeResult.getConcept());
   }

   //
   private void test2() {
      test1();
      createVorfahrtGewaehren();
      decisionTree.doConceptDoNotMatches(propAndCon);
   }

   @Test
   public void test2_classify() {
      test2();
      DecisionTree decTreeResult =
         decisionTree.classify(decisionTree, propAndCon);
      assertEquals("Vorfahrt gewähren", decTreeResult.getConcept());
   }

   private void test3() {
      test2();
      createVorfahrtVonRechts();
      decisionTree.doConceptUnknown(propAndCon);
   }

   @Test
   public void test3_classify() {
      test3();
      DecisionTree decTreeResult =
         decisionTree.classify(decisionTree, propAndCon);
      assertEquals("Vorfahrt von Rechts", decTreeResult.getConcept());
   }

   private void test4() {
      test3();
      createStop();
      decisionTree.doConceptUnknown(propAndCon);
   }

   @Test
   public void test4_classify() {
      test4();
      DecisionTree decTreeResult =
         decisionTree.classify(decisionTree, propAndCon);
      assertEquals("Stop", decTreeResult.getConcept());
   }

   private void test5() {
      test4();
      createFahrrichtungLinks();
      decisionTree.doConceptUnknown(propAndCon);
   }

   @Test
   public void test5_classify() {
      test5();
      DecisionTree decTreeResult =
         decisionTree.classify(decisionTree, propAndCon);
      assertEquals("Fahrtrichtung links", decTreeResult.getConcept());
   }

   private void test6() {
      test5();
      createFahrrichtungRechts();
      decisionTree.doConceptDoNotMatches(propAndCon);
   }

   @Test
   public void test6_classify() {
      test6();
      DecisionTree decTreeResult =
         decisionTree.classify(decisionTree, propAndCon);
      assertEquals("Fahrtrichtung rechts", decTreeResult.getConcept());
   }

   private void test7() {
      test6();
      createFahrrichtungLinks();
      decisionTree.doConceptDoNotMatches(propAndCon);
   }

   @Test
   public void test7_classify() {
      test7();
      DecisionTree decTreeResult =
         decisionTree.classify(decisionTree, propAndCon);
      assertEquals("Fahrtrichtung links", decTreeResult.getConcept());
   }

   private void test8() {
      test7();
      createFahrrichtungRechts();
      decisionTree.doConceptDoNotMatches(propAndCon);
   }

   @Test
   public void test8_classify() {
      test8();
      DecisionTree decTreeResult =
         decisionTree.classify(decisionTree, propAndCon);
      assertEquals("Fahrtrichtung rechts", decTreeResult.getConcept());
   }

   private void test9() {
      test8();
      createFahrrichtungLinks();
      decisionTree.doConceptDoNotMatches(propAndCon);
   }

   @Test
   public void test9_classify() {
      test9();
      DecisionTree decTreeResult =
         decisionTree.classify(decisionTree, propAndCon);
      assertEquals("Fahrtrichtung links", decTreeResult.getConcept());
   }

   private void test10() {
      test9();
      createFahrrichtungRechts();
      decisionTree.doConceptUnknown(propAndCon);
   }

   @Test
   public void test10_classify() {
      test10();
      DecisionTree decTreeResult =
         decisionTree.classify(decisionTree, propAndCon);
      assertEquals("Fahrtrichtung rechts", decTreeResult.getConcept());
   }

   private void test11() {
      test10();
      createVorfahrtsstrasse();
      decisionTree.doConceptUnknown(propAndCon);
   }

   @Test
   public void test11_classify() {
      test11();
      DecisionTree decTreeResult =
         decisionTree.classify(decisionTree, propAndCon);
      assertEquals("Vorfahrtsstraße", decTreeResult.getConcept());
   }

   @Test
   public void testUnknown_classify() {
      test11();
      createUnknown();
      // decisionTree.doConceptUnknown(propAndCon);
      DecisionTree decTreeResult =
         decisionTree.classify(decisionTree, propAndCon);
      assertEquals("?", decTreeResult.getConcept());
   }

   private void createUnknown() {
      String properties = "((40,0,0,0,10),unbekanntes Schild)";
      PropertyConverter propertyConverter = new PropertyConverter();
      propAndCon = propertyConverter.getPropertyVector(properties);
   }

   @Test
   public void testUndecisionable_classify() {
      test11();
      createUndecisionableOne();
      decisionTree.doConceptDoNotMatches(propAndCon);

      DecisionTree decTreeResult =
         decisionTree.classify(decisionTree, propAndCon);
      assertEquals("undecisionableOne", decTreeResult.getConcept());

      createUndecisionableTwo();
      decisionTree.doConceptDoNotMatches(propAndCon);

      decTreeResult = decisionTree.classify(decisionTree, propAndCon);
      assertEquals("undecisionableTwo", decTreeResult.getConcept());

      createUndecisionableOne();
      decisionTree.doConceptDoNotMatches(propAndCon);

      createUndecisionableTwo();
      decisionTree.doConceptDoNotMatches(propAndCon);

      createUndecisionableOne();
      decisionTree.doConceptDoNotMatches(propAndCon);

      createUndecisionableTwo();
      decisionTree.doConceptDoNotMatches(propAndCon);

      createUndecisionableOne();
      decisionTree.doConceptDoNotMatches(propAndCon);

      createUndecisionableTwo();
      decisionTree.doConceptDoNotMatches(propAndCon);

      decTreeResult = decisionTree.classify(decisionTree, propAndCon);
      assertEquals("undecisionableOne", decTreeResult.getConcept());
   }

   private void createUndecisionableOne() {
      String properties = "((40,0,0,0,10),undecisionableOne)";
      PropertyConverter propertyConverter = new PropertyConverter();
      propAndCon = propertyConverter.getPropertyVector(properties);
   }

   private void createUndecisionableTwo() {
      String properties = "((40,0,0,0,10),undecisionableTwo)";
      PropertyConverter propertyConverter = new PropertyConverter();
      propAndCon = propertyConverter.getPropertyVector(properties);
   }

   private void createVorfahrtVonRechts() {
      String properties = "((70,0,0,0,10),Vorfahrt von Rechts)";
      PropertyConverter propertyConverter = new PropertyConverter();
      propAndCon = propertyConverter.getPropertyVector(properties);
   }

   private void createVorfahrtGewaehren() {
      String properties = "((90,0,0,0,0),Vorfahrt gewähren)";
      PropertyConverter propertyConverter = new PropertyConverter();
      propAndCon = propertyConverter.getPropertyVector(properties);
   }

   private void createStop() {
      String properties = "((80,0,0,0,0),Stop)";
      PropertyConverter propertyConverter = new PropertyConverter();
      propAndCon = propertyConverter.getPropertyVector(properties);
   }

   private void createFahrrichtungLinks() {
      String properties = "((0,10,0,30,40),Fahrtrichtung links)";
      PropertyConverter propertyConverter = new PropertyConverter();
      propAndCon = propertyConverter.getPropertyVector(properties);
   }

   private void createFahrrichtungRechts() {
      String properties = "((0,10,0,30,50),Fahrtrichtung rechts)";
      PropertyConverter propertyConverter = new PropertyConverter();
      propAndCon = propertyConverter.getPropertyVector(properties);
   }

   private void createVorfahrtsstrasse() {
      String properties = "((0,60,0,0,10),Vorfahrtsstraße)";
      PropertyConverter propertyConverter = new PropertyConverter();
      propAndCon = propertyConverter.getPropertyVector(properties);
   }

   // @Test
   // public void testDoCal2(){
   // createVorfahrtVonRechts();
   // assertEquals(false, decisionTree.doCal2Internal(propAndCon));
   // createFahrrichtungLinks();
   // assertEquals(true, decisionTree.doCal2Internal(propAndCon));
   // }

}
