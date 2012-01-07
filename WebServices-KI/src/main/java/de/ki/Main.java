package de.ki;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

   public static void main(final String[] args) {
      Injector injector = Guice.createInjector(new KIModule());
      KI ki = injector.getInstance(KI.class);
      ki.doKI();
   }

}
