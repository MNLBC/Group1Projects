<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>Book Store</h2>
  <table border="1">
    <tr bgcolor="#eeeeee">
		<h3>1. Select all the text from price nodes </h3>
      <th>Price</th>
    </tr>
    <xsl:for-each select="bookstore/book">
	<xsl:sort select="title"/>
    <tr>
      <td><xsl:value-of select="price"/></td>
    </tr>
    </xsl:for-each>
  </table>
  
  <table border="1">
    <tr bgcolor="#eeeeee">
		<h3>2. Select all the price nodes and their price is higher than 35 </h3>
      <th>Price</th>
    </tr>
    <xsl:for-each select="bookstore/book">
	<xsl:sort select="title"/>
	<xsl:if test="price &gt; 35">
    <tr>
      <td><xsl:value-of select="price"/></td>
    </tr>
	</xsl:if>
    </xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>