# SpringMvcExample

This is an example on how to use pure Java config for a Spring WebMVC Project.

All the XML files have been completely deleted. The main files to look at are:
  1. WebAppInitializer.java
  2. WebMvcConfig.java
  3. pom.xml - you must add the <failOnMissingContextXml> property to false, and add the maven war plugin
  4. HomeController.java
  4. WEB-INF/pages/hello.jsp - Our view resolver takes "home" from our controller, and prepends WEB-INF/pages/, as well as the suffix of jsp to render our page for us. Homecontroller also adds some attributes to display in the jsp using ${} notation.
