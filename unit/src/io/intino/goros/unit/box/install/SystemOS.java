package io.intino.goros.unit.box.install;

public class SystemOS {

	public static final boolean isWindows()  { return System.getProperty("os.name").startsWith("Windows"); }
  public static final boolean isMacOS() { return System.getProperty("os.name").startsWith("Mac OS X"); }

}
