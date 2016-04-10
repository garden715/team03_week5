package com.team03.week5;
import static org.junit.Assert.*;


import org.junit.*;

public class AppTest 
{
   User user;
   PlanType planType;
   TotalRate totalRate;
   App app;
   
   @Before
    public void setUp()
    {
	   	app = new App();
        user = new User();
        totalRate = new TotalRate();
    }
   
   @Test
   public void testAppInputSmallGold()
   {
       
      user.setPlanTypeName("gold");
      assertEquals("gold", user.getPlanTypeName());
   }
   @Test
   public void testAppInputBigGold()
   {
       
       user.setPlanTypeName("Gold");
       assertEquals("Gold", user.getPlanTypeName());
   }
   @Test
   public void testAppInputSmallSilver()
   {
       
      user.setPlanTypeName("silver");
      assertEquals("silver", user.getPlanTypeName());
   }
   @Test
   public void testAppInputBigSilver()
   {
       
      user.setPlanTypeName("Silver");
      assertEquals("Silver", user.getPlanTypeName());
   }
   @Test
   public void testAppInputIncorrectlyPlanName()
   {
       
      user.setPlanTypeName("gollld");
   }
   @Test
   public void testAppInputLine()
   {
       
       user.setNumberOfLines(1);
       assertEquals(1, user.getNumberOfLines());
   }
   @Test
   public void testAppInputZeroLine()
   {
       
       user.setNumberOfLines(0);
   }
   @Test
   public void testAppInputUsedTime()
   {
       
       user.setMinutesUsed(500);
       assertEquals(500, user.getMinutesUsed());
   }
   @Test
   public void testAppInputZeroUsedTime()
   {
       
       user.setMinutesUsed(0);
   }
   
   @Test
   public void testUserGoldBill()
   {
       
       user.setPlanTypeName("Gold");
       user.setNumberOfLines(1);
       user.setMinutesUsed(500);
       planType = new Gold();
       totalRate.calTotalRate(user, planType);
       assertEquals(49.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserGoldAddLine()
   {
      setUp();
       user.setPlanTypeName("Gold");
       user.setNumberOfLines(2);
       user.setMinutesUsed(500);
       planType = new Gold();
       totalRate.calTotalRate(user, planType);
       assertEquals(64.45, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserGoldAddLines()
   {
       
       user.setPlanTypeName("Gold");
       user.setNumberOfLines(4);
       user.setMinutesUsed(500);
       planType = new Gold();
       totalRate.calTotalRate(user, planType);
       assertEquals(83.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserGoldOverTime()
   {
       
       user.setPlanTypeName("Gold");
       user.setNumberOfLines(1);
       user.setMinutesUsed(1300);
       planType = new Gold();
       totalRate.calTotalRate(user, planType);
       assertEquals(184.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserSilverBill()
   {
       
       user.setPlanTypeName("Silver");
       user.setNumberOfLines(1);
       user.setMinutesUsed(250);
       planType = new Silver();
       totalRate.calTotalRate(user, planType);
       assertEquals(29.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserSilverAddLine()
   {
       
       user.setPlanTypeName("Silver");
       user.setNumberOfLines(2);
       user.setMinutesUsed(250);
       planType = new Silver();
       totalRate.calTotalRate(user, planType);
       assertEquals(51.45, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserSilverAddLines()
   {
       
       user.setPlanTypeName("Silver");
       user.setNumberOfLines(4);
       user.setMinutesUsed(250);
       planType = new Silver();
       totalRate.calTotalRate(user, planType);
       assertEquals(77.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserSilverOverTime()
   {
       
       user.setPlanTypeName("Silver");
       user.setNumberOfLines(1);
       user.setMinutesUsed(1000);
       planType = new Silver();
       totalRate.calTotalRate(user, planType);
       assertEquals(299.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testGoldApp(){
	   App.main(new String[]{"Gold"});
	   assertEquals(true, true);
   }
   @Test
   public void testSilverApp(){
	   App.main(new String[]{"Silver","Silver"});
	   assertEquals(true, true);
   }
}