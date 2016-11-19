/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportsimulation;

/**
 *
 * @author survi
 */
public class AirportSimulation {

  public static void main(String[] args) {

    Queue a = new Queue();
    //a.push("something");
    //a.push("hi");
    //System.out.println(a.length());
//    a.pop();
//    System.out.println(a.length());
//    System.out.println(a.pop());
//    System.out.println(a.pop());
//    System.out.println(a.empty());
    //System.out.println(AirportSimulation.requestGenerator());
    
    //two Queue for the landing and take off
    Queue landing = new Queue();
    Queue takeoff = new Queue();
    
    String request;
    
//    initilizing the timeInLandingQ ,
//    timeInTakeoffQ,numberOfLanding,
//    numberOfTakeoff,landingRequest,takeoffRequest 
    int timeInLandingQ = 0;
    int timeInTakeoffQ = 0;
    int numberOfLanding = 0;
    int numberOfTakeoff = 0;
    int landingRequest = 0;
    int takeoffRequest = 0;
    
    //for loop which loops for number of flights
    for (int i = 1; i < 25; i++) {
      request = AirportSimulation.requestGenerator();//takeoff and landing reuests are generated
      //if generated request is landing the it is pushed in queue or else if its
      //takeoff then it is pushed in takeoff queue 
      // the landing requests is incremented else the take off is increamented
      if (request.equals("landing")) {
        landing.push(i);
        landingRequest += 1;
        System.out.println("Landing Request");
      } else if (request.equals("takeoff")) {
        takeoff.push(i);
        takeoffRequest += 1;
        System.out.println("Takeoff request");
      }
      //total number of planes that can be 
      //landing queue is given more prority 
      //if there are more flights in the landing queue it is given the prority
      //landig time is calculated by multiplying it with the 
      int planeNum;
      if (i % 3 == 0) {
        if (landing.length() >= takeoff.length()) {
          planeNum = (int)landing.pop();
          timeInLandingQ += (i - planeNum) * 5;
          numberOfLanding += 1;
        } else {
          planeNum = (int)takeoff.pop();
          timeInTakeoffQ += (i - planeNum) * 5;
          numberOfTakeoff += 1;
        }
      }
//      try {
//        Thread.sleep(50);
//      } catch (InterruptedException e) {
//        System.out.println("interrupted.");
//      }
    }
    System.out.println("Number of landing request is:" + landingRequest);
    System.out.println("Number of takeoff request is:" + takeoffRequest);
    System.out.println("Number of landing completed:" + numberOfLanding);
    System.out.println("Number of takeoff completed:" + numberOfTakeoff);
    System.out.println("Average time spent in landing queue:" + (timeInLandingQ / numberOfLanding) + "mins");
    System.out.println("Average time spent in takeoff queue:" + (timeInTakeoffQ / numberOfTakeoff) + "mins");
    System.out.println("Printing Landing Queue:" + landing.toString());
    System.out.println("Printing takeoff Queue:" + takeoff.toString());
  }

  // randomly generates request 
  static public String requestGenerator() {
    if (Math.random() > 0.5) {
      return "takeoff";
    } else {
      return "landing";
    }
  }
}


