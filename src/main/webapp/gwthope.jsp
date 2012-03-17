
<%

 out.println("<ul>");

 java.util.Enumeration names = request.getHeaderNames();
 while (names.hasMoreElements()) {
   String name = (String) names.nextElement();
   String value = request.getHeader(name);
   out.println(" <li>     <b>" + name + "=</b>" + value +"</li>");
 }
 out.println("</ul>");

 %>
 
 <!doctype html>
<!-- The DOCTYPE declaration above will set the    -->
<!-- browser's rendering engine into               -->
<!-- "Standards Mode". Replacing this declaration  -->
<!-- with a "Quirks Mode" doctype may lead to some -->
<!-- differences in layout.                        -->

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <!--                                                               -->
    <!-- Consider inlining CSS to reduce the number of requested files -->
    <!--                                                               -->
    <link type="text/css" rel="stylesheet" href="gwthope.css">

    <!--                                           -->
    <!-- Any title is fine                         -->
    <!--                                           -->
    <title>Hope</title>

    <!--                                           -->
    <!-- This script loads your compiled module.   -->
    <!-- If you add any GWT meta tags, they must   -->
    <!-- be added before this line.                -->
    <!--                                           -->
    <script type="text/javascript" language="javascript" src="gwthope/gwthope.nocache.js"></script>
  </head>

  <!--                                           -->
  <!-- The body can have arbitrary html, or      -->
  <!-- you can leave the body empty if you want  -->
  <!-- to create a completely dynamic UI.        -->
  <!--                                           -->
  <body>

    <!-- OPTIONAL: include this if you want history support -->
    <iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1' style="position:absolute;width:0;height:0;border:0"></iframe>

    <!-- RECOMMENDED if your web app will not function without JavaScript enabled -->
    <noscript>
      <div style="width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif">
        Your web browser must have JavaScript enabled
        in order for this application to display correctly.
      </div>
    </noscript>

<div id="top">
	<p id="skiplinks">Skip to: <a href="#content">content</a> | <a href="#sidebar">sidebar</a></p>
	<div id="sitetitle">
		<h1><a href="#">Business Logo v.1.0</a></h1>
		<p>There is always room for more...</p>
	</div>
	<hr class="clear" />
</div>

<div id="wrap"></div>
	
<div id="footer">
	<div class="left">
		<p>&copy; 2010 <a href="#">Your Name</a> | Template design by <a href="http://andreasviklund.com/">Andreas Viklund</a></p>
	</div>
	<div class="right textright">
		<p>Sample footer menu: <a href="#">Link 1</a> | <a href="#">Link 2</a> | <a href="#">Link 3</a></p>
		<p class="hide"><a href="#top">Return to top</a></p>
	</div>
</div>
  </body>
</html>
 
