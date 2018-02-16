package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    public static boolean search(int[] arr1, int[] arr2, int i1, int i2) {
      System.out.println("Search array 1");
      if (arr1 == null || arr2 == null) return false;

      for (int elt : arr1) {
        if (elt == (i1*i2)) {
		 for (int elt2 : arr2)
        		if (elt2 == (i1*i2)) return false;
		return true;
      	}
      }
      for (int elt2 : arr2)
       		if (elt2 == (i1*i2)) return true;
      return false;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          int[] arr1 = new int[input1.length()];
	  int i= 0;
          while (sc1.hasNext())
          {
            int value1 = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            arr1[i]= value1;
	    i++;
          }
		
	  String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          int[] arr2 = new int[input2.length()];
	  i= 0;
          while (sc2.hasNext())
          {
            int value2 = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            arr2[i]= value2;
	    i++;
          }

          String input3 = req.queryParams("input3").replaceAll("\\s","");
          int int1 = Integer.parseInt(input3);

          String input4 = req.queryParams("input4").replaceAll("\\s","");
          int int2 = Integer.parseInt(input4);

          boolean result = App.search(arr1, arr2, int1, int2);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

